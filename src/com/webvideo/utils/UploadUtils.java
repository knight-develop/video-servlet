package com.webvideo.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

public class UploadUtils {
	public static String processUploadFile(String fieldName, HttpServletRequest req,String storeFolder, String fileName ) throws IOException, ServletException {
		Part part = req.getPart(fieldName);
		if(part == null || part.getSize() == 0) {
			return "";
		}
		if(storeFolder == null) {
			storeFolder = "/uploads";
		}
		if(fileName == null) {
			fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
		}else {
			fileName += "."+FilenameUtils.getExtension(Path.of(part.getSubmittedFileName()).getFileName().toString());
		}
		String realPart = req.getServletContext().getRealPath(storeFolder);
		Path uploadPath = Paths.get(realPart);
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		part.write(Paths.get(uploadPath.toString(), fileName).toString());
		return fileName;
	}
}
