package com.demo.demo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.demo.dto.UploadResponseDTO.UploadResponseDTO;
import com.demo.demo.entities.ResponseEntity;
import com.demo.demo.services.FileService;

@RestController
public class FileController {
	@Value("${project.image}")
	private String pathString;
	
	private static final Logger logger = LogManager.getLogger(OrderController.class);

	@Autowired
	FileService fileService;
	
	
	@PostMapping("/upload")
	public ResponseEntity uploadFile(@RequestParam("image")MultipartFile image) {

		UploadResponseDTO uploadResponseDTO=new UploadResponseDTO();

		ResponseEntity responseEntity=new ResponseEntity();
			ArrayList<Object>responseList=new ArrayList<Object>();
			try {

				String fileName=this.fileService.uploadImage(pathString, image);
					
				uploadResponseDTO.setFileNameString(fileName);
				uploadResponseDTO.setMessage("Uploaded successfully");
				responseList.add(uploadResponseDTO);
			responseEntity.setList(responseList);
				
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
				uploadResponseDTO.setMessage("Upload failed");
				uploadResponseDTO.setFileNameString(null);
				responseList.add(uploadResponseDTO);
			responseEntity.setList(responseList);
				
			}
		
		responseEntity.setStatusCode("200");
        responseEntity.setMessage("Success");
        
		return responseEntity;
		
	}
}
