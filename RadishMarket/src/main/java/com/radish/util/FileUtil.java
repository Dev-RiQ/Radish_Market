package com.radish.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public class FileUtil {
	
	private FileUtil() {
	}

	private static FileUtil instance;

	public static FileUtil getInstance() {
		if (instance == null)
			instance = new FileUtil();
		return instance;
	}
	
	public String[] uploadFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sDirectory = request.getServletContext().getRealPath("/images");
		createDirectoryIfNotExists(sDirectory);
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Collection<Part> parts = request.getParts();
		String[] fileNames = new String[parts.size()];
		int idx = 0;
		for(Part part : parts) {
			fileNames[idx] = getOriginalFileName(part);
			fileNames[idx] = setAndGetSaveFileName(fileNames[idx]);
			Path targetPath = Paths.get(sDirectory, fileNames[idx++]);
			Files.copy(part.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
		}
		return fileNames;
	}
	
	public void deleteFile(HttpServletRequest req, String filename) {
		String sDirectory = req.getServletContext().getRealPath("/images");
		Path filePath = Paths.get(sDirectory, filename);
		try {
			Files.deleteIfExists(filePath);
		} catch (IOException e) {
			System.out.println("deleteFile Fail");
		}
	}

	private void createDirectoryIfNotExists(String directory) {
		Path dirPath = Paths.get(directory);
		if (Files.notExists(dirPath)) {
			try {
				Files.createDirectories(dirPath);
			} catch (IOException e) {
				System.out.println("createDirectoryIfNotExists Fail");
			}
		}
	}
	
	private String getOriginalFileName(Part part) {
		String partHeader = part.getHeader("content-disposition");
		String originalFileName = partHeader.split("filename=")[1].trim().replace("\"", "");
		return originalFileName;
	}
	
	private String setAndGetSaveFileName(String fileName) {
		return System.currentTimeMillis() + "_" + fileName;
	}
	
	public String[] multipleFile(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	    String sDirectory = request.getServletContext().getRealPath("/images");
	    createDirectoryIfNotExists(sDirectory);
	    request.setCharacterEncoding("UTF-8");
	    Collection<Part> parts = request.getParts();
	    List<String> validFileNames = new ArrayList<>();
	    
	    List<String> allowedExtensions = Arrays.asList("jpg", "jpeg", "png", "gif", "pdf");
	    long maxFileSize = 5 * 1024 * 1024;
	    
	    for (Part part : parts) {
	        String originalFileName = getOriginalFileName(part);
	        String fileExtension = getFileExtension(originalFileName);
	        
	        if (!allowedExtensions.contains(fileExtension.toLowerCase())) {
	            System.out.println("업로드 실패: 허용되지 않은 파일 형식 (" + originalFileName + ")");
	            continue;
	        }
	        if (part.getSize() > maxFileSize) {
	            System.out.println("업로드 실패: 파일 크기 초과 (" + originalFileName + ")");
	            continue;
	        }

	        String saveFileName = setAndGetSaveFileName(originalFileName);
	        Path targetPath = Paths.get(sDirectory, saveFileName);
	        Files.copy(part.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
	        validFileNames.add(saveFileName);
	    }
	    return validFileNames.toArray(new String[0]);
	}

	private String getFileExtension(String fileName) {
	    int lastIndex = fileName.lastIndexOf(".");
	    if (lastIndex == -1) {
	        return ""; // 확장자가 없는 경우
	    }
	    return fileName.substring(lastIndex + 1);
	}
	
}
