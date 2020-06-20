package com.globalvox.iservice;

import com.globalvox.model.Image;

public interface IImageService {

 public String saveImage(Image image);
 public byte[] findImageById(Integer imageid);
}
