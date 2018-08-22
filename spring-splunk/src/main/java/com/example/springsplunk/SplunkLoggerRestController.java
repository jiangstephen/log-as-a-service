package com.example.springsplunk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SplunkLoggerRestController {
	
	private static Logger LOGGER = LoggerFactory.getLogger("splunk.logger");

	
	@GetMapping(value = "/logit")
	public @ResponseBody String logit() throws InterruptedException{
		
		LOGGER.info("I am logging it for 10 times");
		for(int i=0 ;i<10 ;i++){
			Double randomSecs = Math.random()*10;
			long milliSecs = (long)(randomSecs * 1000);
			Thread.sleep(milliSecs);
			LOGGER.info(" {} log it in the splunk after millisecs {}", SplunkLoggerRestController.class.getName(),  milliSecs);
		}
		return "success";
	}

}
