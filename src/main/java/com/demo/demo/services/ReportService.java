package com.demo.demo.services;

import java.util.ArrayList;
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

	public List<ReportByCategoryCount> categoryWiseReport(ReportsRequestDTO reportsRequestDTO) {
		

		logger.info("**********  categoryWiseReport ******** Start");

		List<Category>listCategoryCategories=(List<Category>) categoryRepository.findAll();
		List<ReportByCategoryCount>categoryListResponseDTO=new ArrayList<ReportByCategoryCount>();
		
		categoryListResponseDTO=orderItemRepository.findReportsByCategory();
		
		logger.info("**********  categoryWiseReport ******** END"+categoryListResponseDTO.size());
		
			
		return categoryListResponseDTO;
	}

	public List<ReportSubCategoryCount> subCategoryWiseReport(int categoryId) {
		

		logger.info("**********  subCategoryWiseReport ******** Start"+categoryId);

		List<Category>listCategoryCategories=(List<Category>) categoryRepository.findAll();
		List<ReportSubCategoryCount>categoryListResponseDTO=new ArrayList<ReportSubCategoryCount>();
		
		categoryListResponseDTO=orderItemRepository.findReportsBySubCategory(categoryId);
		
		logger.info("**********  subCategoryWiseReport ******** END"+categoryListResponseDTO.size());
		
			
		return categoryListResponseDTO;
	}

public List<ReportProductsCount> productWiseReport(int categoryId,int subCategoryId) {
		

		logger.info("**********  productWiseReport ******** Start"+categoryId);

		List<Category>listCategoryCategories=(List<Category>) categoryRepository.findAll();
		List<ReportProductsCount>categoryListResponseDTO=new ArrayList<ReportProductsCount>();
		
		categoryListResponseDTO=orderItemRepository.findReportsByProduct(categoryId,subCategoryId);
		
		logger.info("**********  subCategoryWiseReport ******** END"+categoryListResponseDTO.size());
		
			
		return categoryListResponseDTO;
	}

}
