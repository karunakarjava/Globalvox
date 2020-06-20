package com.globalvox.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalvox.iservice.IImageService;
import com.globalvox.model.Image;
import com.globalvox.repo.ImageRepository;

@Service
public class ImageServiceImpl implements IImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	public String saveImage(Image image) {
		imageRepository.save(image);
		return "image saved successfully";
	}

	@Override
	public byte[] findImageById(Integer imageid) {
		Optional<Image> image=imageRepository.findById(imageid);
		return image.get().getImage();
	}

}
