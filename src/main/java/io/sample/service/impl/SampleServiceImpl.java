package io.sample.service.impl;

import io.sample.bean.SampleBean;
import io.sample.bean.para.SamplePara;
import io.sample.service.SampleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {

	final Logger logger = LoggerFactory.getLogger(SampleServiceImpl.class);

	@Override
	public SampleBean getSampleData(SamplePara samplePara) throws Exception {
		
		SampleBean sampleBean = new SampleBean();
		sampleBean.setName("Joon");
		sampleBean.setPara(samplePara.getSampleId());

		logger.info("SampleId >> " + sampleBean.getPara());
		
		return sampleBean;
	}

}