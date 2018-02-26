package com.suriya.ms.client.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * This class read the input file as a multipart file, validates them and
 * redirects it to the corresponding services
 * 
 * @author suriya
 * @version 1.0
 */
@RefreshScope
@RestController
public class FileUploadController {
	private static final Logger logger = LogManager.getLogger(FileUploadController.class);

	// @Value("${message:same class}")
	@Value("${message}")
	private String message;

	@GetMapping("/start")
	public String start() {
		logger.debug("Debugging log");
		logger.info("Info log");
		logger.warn("Hey, This is a warning!");
		logger.error("Oops! We have an Error. OK");
		logger.fatal("Damn! Fatal error. Please fix me.");
		return "ready suriya : data from " + message;
	}

	/**
	 * This method accepts the text file input as a multipart file, reads the file
	 * line by line and processes it. Once the lines are sent for processing it
	 * returns "true". "false" is returned if the file is empty or is not a text
	 * file
	 * 
	 * @param inputfile
	 * @return isUploadSucess
	 */
	@PostMapping(value = "/uploadfile")
	public String fileUpload(@RequestParam("inputfile") MultipartFile inputfile) {
		InputStream is;
		BufferedReader bfReader;
		List<String> inputLines = new ArrayList<String>();
		boolean isUploadSucess = false;

		// checking if file exists and is text file
		if (!inputfile.isEmpty() && inputfile.getOriginalFilename().endsWith(".txt")) {
			byte[] bytes = null;
			try {
				bytes = inputfile.getBytes();
				is = new ByteArrayInputStream(bytes);
				bfReader = new BufferedReader(new InputStreamReader(is));
				String inputLine = null;
				while ((inputLine = bfReader.readLine()) != null) {
					inputLines.add(inputLine);
					logger.info(inputLine);
				}
				isUploadSucess = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return String.valueOf(isUploadSucess);
	}
}
