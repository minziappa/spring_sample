package io.sample.controller;

import io.sample.bean.model.SampleModel;
import io.sample.bean.para.CsvFilePara;
import io.sample.bean.para.DownLoadFilePara;
import io.sample.service.SampleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/***
 * The <code>FileController</code> class represents action controller.
 * 1. Explain for a method .....
 * 
 * @author  Woong-joon Kim
 * @version 0.1, 14/07/17
 * @see     io.sample.controller.FileController#uploadFiles()
 * @see     io.sample.controller.FileController#handleUploadFiles()
 * @see     io.sample.controller.FileController#downloadFiles()
 * @see     io.sample.controller.FileController#handleDownloadFiles()
 * @since   JDK1.7
 */
@Controller
@RequestMapping("/file")
public class FileController extends AbstractBaseController {

	final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private Validator validator;
	@Autowired
	private MessageSource message;
	@Autowired
    private SampleService sampleService;

    /**
     * Upload a CSV file for testing.
     * 
     * @throws  Exception
     *          If a error occur, ...
     *
     * @return String
     * 		   a file name of FTL.
     * 
     * @since  1.7
     */
	@RequestMapping(value = {"uploadFiles"})
	public String uploadFiles() throws Exception {
		return "file/uploadFiles";
	}

    /**
	 * Handle a CSV file for uploading.
	 * 
	 * @param  CsvFilePara 
	 *         The parameters from a client
	 * @param  BindingResult 
	 *         The result of the parameters checked
	 * @param  ModelMap 
	 *         model
	 * @param  HttpServletResponse 
	 *         response
	 *         
	 * @throws  Exception
	 *          If a error occur, ...
	 *
	 * @return String
	 * 		   a file name of FTL.
	 * 
	 * @since  1.7
	 */
	@RequestMapping(value = {"handleUploadFiles"})
	public String handleUploadFiles(@Valid CsvFilePara csvFilePara, 
			BindingResult bindingResult, ModelMap model, 
			HttpServletResponse response, RedirectAttributes redirect) throws Exception {

		SampleModel sampleModel = new SampleModel();

		// If it occurs a error, set the default value.
		if (bindingResult.hasErrors()) {
			logger.error("handleUploadFiles.sp - it is occured a parameter error.");
			response.setStatus(400);
			handleValidator(bindingResult.getAllErrors());
			model.addAttribute("errorMessage", message.getMessage("sample.parameter.error.message", null, LOCALE));
			model.addAttribute("model", sampleModel);
			return "file/uploadFiles";
		}

		if (csvFilePara.getOption().equals("0")) {
			// The method for Async
			sampleService.asyncSaveCsvFile(csvFilePara);
		} else {
			// Not Async
			// Execute the transaction
			if(!sampleService.syncSaveCsvFile(csvFilePara)) {
				model.addAttribute("errorMessage", message.getMessage("sample.parameter.error.message", null, LOCALE));
				model.addAttribute("model", sampleModel);
				return "file/uploadFiles";
			}
		}

		// Add parameter for Redirect URL
		redirect.addFlashAttribute("errorMessage", message.getMessage("sample.parameter.insert.ok.message", null, LOCALE));

		return "redirect:/file/uploadFiles";
	}

	/**
     * Download a CSV file for testing.
     * 
     * @throws  Exception
     *          If a error occur, ...
     *
     * @return String
     * 		   a file name of FTL.
     * 
     * @since  1.7
     */
	@RequestMapping(value = {"downloadFiles"})
	public String downloadFiles() throws Exception {
		return "file/downloadFiles";
	}

    /**
     * Handle a CSV file for downloading.
     * 
     * @param  DownLoadFilePara 
     *         A file name
     * @param  HttpServletResponse 
     *         response
     *         
     * @throws  Exception
     *          If a error occur, ...
     *
     * @return String
     * 		   a file name of FTL.
     * 
     * @since  1.7
     */
	@RequestMapping(value = {"downloadCsvFile"})
	public void downloadCsvFile(@Valid DownLoadFilePara downLoadFilePara,
			HttpServletResponse response, HttpServletRequest request, 
			RedirectAttributes redirect) throws Exception {

		String realPath  = null;
		if(downLoadFilePara.getOption() == null || downLoadFilePara.getOption().equals("0")) {
			// Down Load file
			this.handleFileDownload(downLoadFilePara.getFileName(), "csv", sampleService.makeCsvFile(), response);			
		} else {
			realPath  = request.getSession().getServletContext().getRealPath("/");
			this.handleFileSave(downLoadFilePara.getFileName(), "csv", sampleService.makeCsvFile(), realPath);			
		}

		// Add parameter for Redirect URL
		// redirect.addFlashAttribute("filePath", "/" + downLoadFilePara.getFileName());
		//return "redirect:/sample/file/downloadFiles.do";
	}

    /**
     * Handle a PDF file for downloading.
     * 
     * @param  DownLoadFilePara 
     *         A file name
     * @param  HttpServletResponse 
     *         response
     *         
     * @throws  Exception
     *          If a error occur, ...
     *
     * @return String
     * 		   a file name of FTL.
     * 
     * @since  1.7
     */
	@RequestMapping(value = {"downloadPdfFile"})
	public void downloadPdfFile(@Valid DownLoadFilePara downLoadFilePara,
			HttpServletResponse response, HttpServletRequest request, 
			RedirectAttributes redirect) throws Exception {

		String realPath  = null;
		if(downLoadFilePara.getOption() == null || downLoadFilePara.getOption().equals("0")) {
			// Down Load file
			this.handleFileDownload(downLoadFilePara.getFileName(), "pdf", sampleService.makePdfFile(), response);			
		} else {
			realPath  = request.getSession().getServletContext().getRealPath("/");
			this.handleFileSave(downLoadFilePara.getFileName(), "pdf", sampleService.makePdfFile(), realPath);			
		}

	}

//	@RequestMapping(value = {"filesample.do"})
//	public String filesample(@Valid CsvFilePara csvFilePara, BindingResult bindingResult, 
//			ModelMap model, HttpServletResponse response) throws Exception {
//
//		logger.info("filesample - start");
//
//		try {
//			MultipartFile file = csvFilePara.getCsvFile();
//
//			if(!file.isEmpty()){
//				String filename = file.getOriginalFilename();
//
//				byte[] bytes = file.getBytes();
//				try{
//	  			     File lOutFile = new File("/usr/local/tomcat-admin/temp/"+"_"+filename);
//				     FileOutputStream lFileOutputStream = new FileOutputStream(lOutFile);
//				     lFileOutputStream.write(bytes);
//				     lFileOutputStream.close();
//				}catch(IOException ie){
//					//Exception
//					System.err.println("File writing error! ");
//				}
//				System.err.println("File upload success! ");
//			}else{
//				System.err.println("File type error! ");
//			}
//
//		} catch (Exception e) {
//			logger.error("Exception is ", e);
//		}
//
//		logger.info("filesample - end");
//
//		return "redirect:/sample/file/uploadFiles.do";
//	}

}