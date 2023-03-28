package com.demo.demo.services;




import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.models.Paths;

@Service
public class FileServiceImpl implements FileService{

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {

		//file name
		String name=file.getOriginalFilename();
		
		//full path
		String filePath=path+ File.separator+name; 
		
		//create folder if not created
		File f=new File(path);
		
		if (!f.exists()) {
			f.mkdir();
		}
		
		Files.copy(file.getInputStream(), java.nio.file.Paths.get(filePath));

		
		return name;
	}

	
}
