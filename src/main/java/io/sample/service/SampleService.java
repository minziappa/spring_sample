package io.sample.service;

import io.sample.bean.SampleBean;
import io.sample.bean.para.SamplePara;

public interface SampleService {

	public SampleBean getSampleData(SamplePara samplePara) throws Exception;

}