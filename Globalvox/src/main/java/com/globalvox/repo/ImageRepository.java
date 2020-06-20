package com.globalvox.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalvox.model.Image;

public interface ImageRepository  extends JpaRepository<Image, Integer>{

}
