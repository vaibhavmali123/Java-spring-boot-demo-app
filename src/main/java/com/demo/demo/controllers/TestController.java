package com.demo.demo.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.dto.SubCategoryRequestDTO;



@RestController
public class TestController {

	private static final Logger logger = LogManager.getLogger(CategoryController.class);

	
    @PostMapping("gggg")
    public String sss(@RequestBody SubCategoryRequestDTO categoryReq) {
    
    	logger.info("********** API saveCategory req  ******** "+categoryReq.getSubCategoryName());

    	return "kkkk"+categoryReq.getSubCategoryName();
    }


}
