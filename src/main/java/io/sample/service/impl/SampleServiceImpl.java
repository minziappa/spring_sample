package io.sample.service.impl;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.sample.bean.SampleBean;
import io.sample.bean.model.UserModel;
import io.sample.bean.para.CsvFilePara;
import io.sample.bean.para.InputUserPara;
import io.sample.bean.para.SearchUserPara;
import io.sample.bean.para.UserPara;
import io.sample.dao.MasterDao;
import io.sample.dao.SlaveDao;
import io.sample.service.AbstractService;
import io.sample.service.SampleService;
import io.utility.letter.DateUtility;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.configuration.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SampleServiceImpl extends AbstractService implements SampleService {

	final Logger logger = LoggerFactory.getLogger(SampleServiceImpl.class);

	@Autowired
	private SqlSession masterDao;
	@Autowired
	private SqlSession masterBatchDao;
	@Autowired
	private SqlSession slaveDao;
	@Autowired
    private Configuration configuration;
	@Autowired
	private Md5PasswordEncoder passwordEncoder;

	private String removeQuotes(String source) {
    	if(source.contains("\"")) {
    		source = source.replace("\"", "");
    	}
    	return source;
	}

	private boolean saveCsvFile(CsvFilePara csvFilePara) throws Exception {

		String strReadResult = null;

		MultipartFile file = csvFilePara.getCsvFile();
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader bfReader = null;
		// LineNumberReader lnReader = null;

		if(file == null) {
			return false;
		}
		
		try {
			in = file.getInputStream();
			// For supporting UTF-8
			isr = new InputStreamReader(in,"UTF-8");
			bfReader = new BufferedReader(isr);

			int i=0;
			while((strReadResult = bfReader.readLine()) != null) {

				String [] strCell = strReadResult.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

				Map<String, Object> mapData = new HashMap<String, Object>();

				mapData.put("dataTitle", file.getOriginalFilename());
				mapData.put("dataDummy1", removeQuotes(strCell[0]));
				mapData.put("dataDummy2", removeQuotes(strCell[1]));
				mapData.put("dataDummy3", strCell[2]);

				masterBatchDao.getMapper(MasterDao.class).insertData(mapData);
				logger.info(" count = > " + i);
				i++;
			}

		} catch (IOException e) {
			logger.error("Exception error", e);
		} finally {
			if(bfReader != null) {
				bfReader.close();
			}
			if(isr != null) {
				isr.close();
			}
			if(in != null) {
				in.close();
			}
		}
		
		return true;
	}

	private void encodeImgAsBase64(List<UserModel> userList, List<SampleBean> sampleList) {

		SampleBean sample = null;

		for (UserModel userModel : userList) {
			sample = new SampleBean();
			sample.setUserModel(userModel);
			if(userModel.getUserImg() != null) {
				byte[] imgBytesAsBase64 = Base64.encodeBase64(userModel.getUserImg());
				String imgDataAsBase64 = new String(imgBytesAsBase64);
				String imgAsBase64 = "data:image/png;base64," + imgDataAsBase64;
				sample.setUserImage(imgAsBase64);
			}
			sampleList.add(sample);
		}

	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	@Override
	public boolean insertSample(InputUserPara inputUserPara) throws Exception {

		int intResult = 0;
		byte[] byteName = null;

		MultipartFile file = inputUserPara.getUserImg();

		if(file != null) {
			String strName = file.getOriginalFilename();
			logger.info("Image name >>> " + strName);
			byteName = file.getBytes();			
		}

		String encodedPwd = passwordEncoder.encodePassword(inputUserPara.getUserPwd(), null);

		Map<String, Object> mapSample = new HashMap<String, Object>();
		mapSample.put("userName", inputUserPara.getUserName());
		mapSample.put("userPwd", encodedPwd);
		mapSample.put("userStatus", inputUserPara.getUserStatus());
		mapSample.put("userAge", inputUserPara.getUserAge());
		mapSample.put("userImg", byteName);

		try {
			intResult = masterDao.getMapper(MasterDao.class).insertSample(mapSample);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}
		if(intResult < 1) {
			logger.error("insertSample error, userName={}", inputUserPara.getUserName());
			return false;
		}

		return true;
	}

	@Override
	public int getSampleListSum() throws Exception {

		int sum = 0;

		try {
			sum = slaveDao.getMapper(SlaveDao.class).selectSampleListSum();
		} catch (Exception e) {
			logger.error("Exception error", e);
		}

		return sum;
	}

	@Override
	public List<SampleBean> selectUserList(UserPara userPara) throws Exception {

		List<UserModel> userList = new ArrayList<UserModel>();
		List<SampleBean> sampleList = new ArrayList<SampleBean>();

		int nowPage = userPara.getNowPage();

		// Check a nowPage
		if(nowPage <= 0){
			nowPage = 1;
		}

		Map<String, Object> mapSelect = new HashMap<String, Object>();
		mapSelect.put("nowPage", (nowPage - 1) * configuration.getInt("row.cnt"));
		mapSelect.put("row", configuration.getInt("row.cnt"));

		try {
			sqlSessionSlaveFactory.setDataSource(getDispersionDb());
			userList = slaveDao.getMapper(SlaveDao.class).selectUserList(mapSelect);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}

		this.encodeImgAsBase64(userList, sampleList);

		return sampleList;
	}

	@Override
	public UserModel selectUserByName(String name) throws Exception {

		UserModel user = new UserModel();

		Map<String, Object> mapSelect = new HashMap<String, Object>();
		mapSelect.put("userName", name);

		try {
			sqlSessionSlaveFactory.setDataSource(getDispersionDb());
			user = slaveDao.getMapper(SlaveDao.class).selectUserByName(mapSelect);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}

		return user;
	}

	@Override
	public List<SampleBean> selectUserListByName(SearchUserPara searchUserPara) throws Exception {

		List<UserModel> userList = new ArrayList<UserModel>();
		List<SampleBean> sampleList = new ArrayList<SampleBean>();

		Map<String, Object> mapSelect = new HashMap<String, Object>();
		mapSelect.put("userName", searchUserPara.getUserName());

		try {
			sqlSessionSlaveFactory.setDataSource(getDispersionDb());
			userList = slaveDao.getMapper(SlaveDao.class).selectUserListByName(mapSelect);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}

		this.encodeImgAsBase64(userList, sampleList);

		return sampleList;
	}

	@Override
	public List<SampleBean> selectSampleByDate(SearchUserPara searchUserPara) throws Exception {
		SampleBean sample = null;
		Date userDate = null;
		List<UserModel> userList = new ArrayList<UserModel>();
		List<SampleBean> sampleList = new ArrayList<SampleBean>();

		String [] arrayDate = searchUserPara.getUserData().split("-");
		userDate = DateUtility.getEndToday(Integer.parseInt(arrayDate[0]), 
				Integer.parseInt(arrayDate[1]), Integer.parseInt(arrayDate[2]), 0);

		Map<String, Object> mapSelect = new HashMap<String, Object>();
		mapSelect.put("insertDate", userDate);

		try {
			sqlSessionSlaveFactory.setDataSource(getDispersionDb());
			userList = slaveDao.getMapper(SlaveDao.class).selectSampleListByDate(mapSelect);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}

		this.encodeImgAsBase64(userList, sampleList);

		return sampleList;
	}

	@Override
	public boolean deleteSampleByName(String name) throws Exception {
		int intResult = 0;

		Map<String, Object> mapSample = new HashMap<String, Object>();
		mapSample.put("userName", name);

		try {
			intResult = masterDao.getMapper(MasterDao.class).deleteSampleByName(mapSample);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}
		if(intResult < 1) {
			logger.error("deleteSampleByName error, userName={}", name);
			return false;
		}

		return true;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public boolean syncSaveCsvFile(CsvFilePara csvFilePara) throws Exception {
		return saveCsvFile(csvFilePara);
	}

	@Async
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void asyncSaveCsvFile(CsvFilePara csvFilePara) throws Exception {
		saveCsvFile(csvFilePara);
	}

	@Override
	public byte[] makeCsvFile() throws Exception {
		StringBuffer sb = new StringBuffer();

		for(int i=0; i<10; i++) {
			sb.append(i).append("aaaaaaaaaaaaa,")
				.append(i).append("bbbbbbbbbbbbb,")
				.append(i).append("cccccccccceee")
				.append("\n");
		}

		return sb.toString().getBytes();
	}

	@Override
	public byte[] makePdfFile() throws Exception {

		ByteArrayOutputStream output = new ByteArrayOutputStream(); 

		// Create a document and add a page to it
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage( page );

		// Create a new font object selecting one of the PDF base fonts
		PDFont font = PDType1Font.HELVETICA_BOLD;

		// Start a new content stream which will "hold" the to be created content
		PDPageContentStream contentStream = new PDPageContentStream(document, page);

		// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
		contentStream.beginText();
		contentStream.setFont( font, 12 );
		contentStream.moveTextPositionByAmount( 100, 700 );
		contentStream.drawString( "Hello World" );
		contentStream.endText();

		// Make sure that the content stream is closed:
		contentStream.close();
		//document.

		// Save the results and ensure that the document is properly closed:
		// document.save( "Hello World.pdf");
		// Save the results in memory
		document.save(output);
		document.close();

		return output.toByteArray();
	}

}