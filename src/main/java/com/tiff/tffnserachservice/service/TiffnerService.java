package com.tiff.tffnserachservice.service;

import com.tiff.tffnserachservice.model.Tiffner;
import com.tiff.tffnserachservice.repository.TiffnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiffnerService {

    @Autowired
    private TiffnerRepository tiffnerRepository;

    public Optional<Tiffner> findByTiffnerId(Long id){
        return tiffnerRepository.findByTiffnerId(id);
    }

    public Optional<Tiffner> findByTiffnerName(String name){
        return tiffnerRepository.findByName(name);
    }

}
