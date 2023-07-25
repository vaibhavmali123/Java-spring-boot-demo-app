package com.demo.demo.controllers;

import java.util.ArrayList;
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
    ResponseEntity responseEntity=new ResponseEntity();
    
    @Autowired
	ReportService reportService;
	
@PostMapping("categoryWiseReport")    
public ResponseEntity categoryWiseReport(@RequestBody ReportsRequestDTO reportsRequestDTO) {
	
	logger.info("********** API categoryWiseReport ******** Start");

	try {
		List<ReportByCategoryCount>  responseList =reportService.categoryWiseReport(reportsRequestDTO);
		
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
public ResponseEntity subCategoryWiseReport(@RequestParam(value = "categoryId")int categoryId) {
	
	logger.info("********** API subCategoryWiseReport ******** Start"+categoryId);

	try {
		List<ReportSubCategoryCount>  responseList =reportService.subCategoryWiseReport(categoryId);
		
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
public ResponseEntity productWiseReport(@RequestParam(value = "categoryId")int categoryId,@RequestParam(value = "subCategoryId")int subCategoryId) {
	
	logger.info("********** API productWiseReport ******** Start"+categoryId);

	try {
		List<ReportProductsCount>  responseList =reportService.productWiseReport(categoryId,subCategoryId);
		
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
