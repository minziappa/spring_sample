package io.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import io.sample.bean.SampleBean;
import io.sample.bean.model.SampleModel;
import io.sample.bean.para.SamplePara;
import io.sample.service.SampleService;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/***
 * The <code>TestTblController</code> class represents action controller.
 * 1. Explain for a method .....
 * 
 * @author  Woong-joon Kim
 * @version 0.1, 12/05/15
 * @see     io.sample.controller.SampleController#index()
 * @see     io.sample.controller.SampleController#sample()
 * @since   JDK1.7
 */
@Controller
@RequestMapping("/service")
public class SampleController extends AbstractBaseController {

	final Logger logger = LoggerFactory.getLogger(SampleController.class);

	@Autowired
	private MessageSource message;
	@Autowired
    private Configuration configuration;
	@Autowired
    private SampleService sampleService;

    /**
     * Index for ......
     * 
     * @param  ModelMap 
     *         model
     *         
     * @throws  Exception
     *          If a error occur, ...
     *
     * @return String
     * 		   a file name of FTL.
     * 
     * @since  1.7
     */
    @RequestMapping(value = {"/", "", "index.do"}, method=RequestMethod.GET)
	public String index(ModelMap model) throws Exception {
    	
		SampleModel sampleModel = new SampleModel();

		// Execute the transaction
		SampleBean sample = new SampleBean();
		sample.setName("testName");
		sample.setPara("para");
		sampleModel.setSample(sample);
		model.addAttribute("model", sampleModel);

		return "index";
	}

    /**
     * Select some data into the server.
     * 
     * @param  InsertTblPara 
     *         insertTblPara
     * @param  BindingResult 
     *         bindingResult
     * @param  ModelMap 
     *         model
     * @param  HttpServletResponse 
     *         response
     * @param  HttpServletRequest 
     *         request
     *         
     * @throws  Exception
     *          If a error occur, ...
     *
     * @return String
     * 		   a file name of FTL.
     * 
     * @since  1.7
     */
	@RequestMapping(value = {"sample.do"})
	public String select(@Valid SamplePara samplePara, 
			BindingResult bindingResult, ModelMap model, 
			HttpServletResponse response, HttpServletRequest request) throws Exception {

		SampleModel sampleModel = new SampleModel();

		// If it occurs a error, set the default value.
		if (bindingResult.hasErrors()) {
			logger.error("insertTestTbl.sp - it is occured a parameter error.");
			response.setStatus(400);
			model.addAttribute("errorMessage", message.getMessage("test.error.400.message", null, LOCALE));
			return "error/error";
		}

		// Execute the transaction
		SampleBean sample = sampleService.getSampleData(samplePara);
		sampleModel.setSample(sample);
		model.addAttribute("model", sampleModel);

		return "sample/sample";
	}

}