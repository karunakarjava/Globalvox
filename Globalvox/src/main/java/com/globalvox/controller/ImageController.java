package com.globalvox.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.globalvox.iservice.IImageService;
import com.globalvox.model.Image;

@Controller
@RequestMapping("/globalvox")
public class ImageController {

	@Autowired
	private IImageService imageService;
	
	@RequestMapping("/upload")
	public String uploadImage(@RequestParam("files") MultipartFile user) throws IOException {
		Image image=new Image();
		byte[] bytes=user.getBytes();
		image.setImage(bytes);
		imageService.saveImage(image);
		return "done";
	}
	
	@RequestMapping(value = "/image/{imageid}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable Integer imageid) {
		byte[]  image=imageService.findImageById(imageid);	
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
		
	}
	
	@RequestMapping(value="/decimalnumber/{number}",method=RequestMethod.GET)
	public ResponseEntity<String> decimalToBinary(@PathVariable Integer number) {
		String binarynumber = "";
		while (number > 0) {
			binarynumber = (number % 2) + binarynumber;
			number = number / 2;
		}
		System.out.println(binarynumber);
		return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(binarynumber);
		
	}
	
}
