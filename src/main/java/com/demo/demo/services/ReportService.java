package com.demo.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.demo.controllers.ReportsController;
import com.demo.demo.dao.CategoryRepository;
import com.demo.demo.dao.OrderItemRepository;
import com.demo.demo.dao.ProductRepository;
import com.demo.demo.dao.ReportByCategoryCount;
import com.demo.demo.dao.ReportProductsCount;
import com.demo.demo.dao.ReportSubCategoryCount;
import com.demo.demo.dto.ResponseDTO.CategoryResponseDTO;
import com.demo.demo.dto.reports.ReportsRequestDTO;
import com.demo.demo.dto.reports.ReportsResponseDTO;
import com.demo.demo.entities.Category;
import com.demo.demo.entities.OrderItem;
import com.demo.demo.entities.Product;

@Component
public class ReportService {

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	OrderItemRepository orderItemRepository;
	private static final Logger logger = LogManager.getLogger(ReportsController.class);

	public List<ReportByCategoryCount> dateAndcategoryWiseReport(Date fromDate, Date toDate) {
		

		logger.info("**********  categoryWiseReport ******** Start");

		List<Category>listCategoryCategories=(List<Category>) categoryRepository.findAll();
		List<ReportByCategoryCount>categoryListResponseDTO=new ArrayList<ReportByCategoryCount>();
		
		if (fromDate!=null || toDate!=null) {
			categoryListResponseDTO=orderItemRepository.findReportsByCategoryAndDate(fromDate,toDate);
			logger.info("********** categoryWiseReport with date ******** Start");
		}
		else {
			categoryListResponseDTO=orderItemRepository.findReportsByCategory();
			logger.info("********** categoryWiseReport without date ******** Start");
		}
		logger.info("**********  categoryWiseReport ******** END"+categoryListResponseDTO.size());
		
			
		return categoryListResponseDTO;
	}

	public List<ReportSubCategoryCount> subCategoryWiseReport(int categoryId, Date fromDate, Date toDate) {
		

		logger.info("**********  subCategoryWiseReport ******** Start"+categoryId);

		List<Category>listCategoryCategories=(List<Category>) categoryRepository.findAll();
		List<ReportSubCategoryCount>categoryListResponseDTO=new ArrayList<ReportSubCategoryCount>();
		
		if (fromDate!=null || toDate!=null) {
			categoryListResponseDTO=orderItemRepository.findReportsBySubCategoryAndDate(categoryId,fromDate,toDate);
			logger.info("********** categoryWiseReport with date ******** Start");
		}
		else {
			categoryListResponseDTO=orderItemRepository.findReportsBySubCategory(categoryId);
			logger.info("********** categoryWiseReport without date ******** Start");
		}
		
		
		logger.info("**********  subCategoryWiseReport ******** END"+categoryListResponseDTO.size());
		
			
		return categoryListResponseDTO;
	}

public List<ReportProductsCount> productWiseReport(int categoryId,int subCategoryId, Date fromDate, Date toDate) {
		

		logger.info("**********  productWiseReport ******** Start"+categoryId);

		List<Category>listCategoryCategories=(List<Category>) categoryRepository.findAll();
		List<ReportProductsCount>categoryListResponseDTO=new ArrayList<ReportProductsCount>();
				
		if (fromDate!=null || toDate!=null) {
			if(subCategoryId!=0) {
			categoryListResponseDTO=orderItemRepository.findReportsByProductAndDate(categoryId,subCategoryId,fromDate,toDate);
			logger.info("********** categoryWiseReport with date ******** Start");
			}
			else {
				categoryListResponseDTO=orderItemRepository.findReportsByProductAndDateExcludeSubCategory(categoryId,fromDate,toDate);
				logger.info("********** categoryWiseReport with date without sub category ******** Start");
			}
		}
		else {
			if(subCategoryId!=0) {
			categoryListResponseDTO=orderItemRepository.findReportsByProduct(categoryId,subCategoryId);
			logger.info("********** categoryWiseReport without date ******** Start");
			}
			else {
				categoryListResponseDTO=orderItemRepository.findReportsByProductExcludeSubCategoryId(categoryId);
				logger.info("********** categoryWiseReport findReportsByProductExcludeSubCategoryIdand date ******** Start");

			}
			}
		
		logger.info("**********  subCategoryWiseReport ******** END"+categoryListResponseDTO.size());
		
			
		return categoryListResponseDTO;
	}

}
