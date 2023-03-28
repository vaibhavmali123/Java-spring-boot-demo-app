package com.demo.demo.dto.UploadResponseDTO;

public class UploadResponseDTO {

	String fileNameString;
	String message;
	
	public UploadResponseDTO(String fileNameString, String message) {
		super();
		this.fileNameString = fileNameString;
		this.message = message;
	}

	public UploadResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFileNameString() {
		return fileNameString;
	}

	public void setFileNameString(String fileNameString) {
		this.fileNameString = fileNameString;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
