package com.yonyou.cloud.ms.client.web;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class IndexController {
	
	private Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) {
		
		logger.info("welcome to line.html");
		
		return "forward:/line.html";
	}
}