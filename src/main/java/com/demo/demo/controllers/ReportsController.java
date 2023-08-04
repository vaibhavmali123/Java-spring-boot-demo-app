package com.demo.demo.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.dao.ReportByCategoryCount;
import com.demo.demo.dao.ReportProductsCount;
import com.demo.demo.dao.ReportSubCategoryCount;
import com.demo.demo.dto.reports.ReportsRequestDTO;
import com.demo.demo.dto.reports.ReportsResponseDTO;
import com.demo.demo.entities.ResponseEntity;
import com.demo.demo.services.ReportService;

@RestController
public class ReportsController {

	private static final Logger logger = LogManager.getLogger(ReportsController.class);
    
    @Autowired
	ReportService reportService;
    ResponseEntity responseEntity=new ResponseEntity();

@GetMapping("categoryWiseReport")    
public ResponseEntity categoryWiseReport(@RequestParam(value = "fromDate",required = false)Date fromDate,@RequestParam(value = "toDate",required = false)Date toDate) {

	logger.info("********** API categoryWiseReport ******** Start fromDate"+fromDate+"toDate"+toDate);

	try {
		List<ReportByCategoryCount>  responseList =reportService.dateAndcategoryWiseReport(fromDate,toDate);
		
		if(responseList.size()>0) {
			responseEntity.setStatusCode("200");
			responseEntity.setMessage("Success");
			responseEntity.setList((ArrayList)responseList);						
		}
		else {
			responseEntity.setStatusCode("500");
			responseEntity.setMessage("Category reports not found");
		}
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		responseEntity.setStatusCode("500");
		responseEntity.setMessage("Failed to fetch reports");
	}
	
	return responseEntity;
}
@GetMapping("subCategoryWiseReport")    
public ResponseEntity subCategoryWiseReport(@RequestParam(value = "categoryId")int categoryId,
		@RequestParam(value = "fromDate",required = false)Date fromDate,@RequestParam(value = "toDate",required = false)Date toDate) {
    ResponseEntity responseEntity=new ResponseEntity();

	logger.info("********** API subCategoryWiseReport ******** Start"+categoryId);

	try {
		List<ReportSubCategoryCount>  responseList =reportService.subCategoryWiseReport(categoryId,fromDate,toDate);
		
		if(responseList.size()>0) {
			responseEntity.setStatusCode("200");
			responseEntity.setMessage("Success");
			responseEntity.setList((ArrayList)responseList);						
		}
		else {
			responseEntity.setStatusCode("500");
			responseEntity.setMessage("Subcategory reports not found");
		}			
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		responseEntity.setStatusCode("500");
		responseEntity.setMessage("Failed to fetch reports");
	}
	
	return responseEntity;
}

@GetMapping("productWiseReport")    
public ResponseEntity productWiseReport(@RequestParam(value = "categoryId")int categoryId,@RequestParam(value = "subCategoryId",required = false)Integer subCategoryId,
		@RequestParam(value = "fromDate",required = false)Date fromDate,@RequestParam(value = "toDate",required = false)Date toDate) {
    ResponseEntity responseEntity=new ResponseEntity();

	logger.info("********** API productWiseReport ******** Start"+categoryId);

	try {
		List<ReportProductsCount>  responseList =reportService.productWiseReport(categoryId,subCategoryId,fromDate,toDate);
		
		if(responseList.size()>0) {
			responseEntity.setStatusCode("200");
			responseEntity.setMessage("Success");
			responseEntity.setList((ArrayList)responseList);						
		}
		else {
			responseEntity.setStatusCode("500");
			responseEntity.setMessage("Products report not found");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		responseEntity.setStatusCode("500");
		responseEntity.setMessage("Failed to fetch reports");
		e.printStackTrace();
	}
	
	return responseEntity;
}

}
