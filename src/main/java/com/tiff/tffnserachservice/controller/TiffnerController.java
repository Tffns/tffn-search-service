package com.tiff.tffnserachservice.controller;


import com.tiff.tffnserachservice.dto.TiffnerDTO;
import com.tiff.tffnserachservice.model.Tiffner;
import com.tiff.tffnserachservice.repository.TiffnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tffn-search")
public class TiffnerController {

    @Autowired
    private TiffnerRepository tiffnerRepository;

    @GetMapping
    public List<Tiffner> findTiffns() {
        return tiffnerRepository.findAll();
    }

    @GetMapping("/api/find-tiffn/{id}")
    public ResponseEntity<Tiffner> findTffn(@PathVariable Long id) {
        return tiffnerRepository.findByTiffnerId(id).map(ResponseEntity::ok).orElseThrow();
    }


    @DeleteMapping("/api/delete-tiffn/{id")
    public Boolean deleteTffn(Long id) {

        if (tiffnerRepository.findByTiffnerId(id).isPresent()) {
            tiffnerRepository.delete(tiffnerRepository.findByTiffnerId(id).orElseThrow());
            return true;
        }
        return false;
    }

    @PostMapping()
    public void addTffn(Tiffner tiffner){
         tiffnerRepository.save(tiffner);
    }

    @PutMapping("/api/update-tiffn/{id}")
    public ResponseEntity<Tiffner> updateTffn(@RequestBody TiffnerDTO tiffnerDTO, Long id){
        Tiffner tiffner = tiffnerRepository.findByTiffnerId(id).orElseThrow();

        tiffner.setName(tiffnerDTO.getName());
        tiffner.setAddress(tiffnerDTO.getAddress());
        tiffner.setTags(tiffnerDTO.getTags());
        tiffner.setContactInformation(tiffnerDTO.getContactInformation());
        //DO WE NEED TO SET REVIEWS
        tiffner.setReviews(tiffnerDTO.getReviews());
        tiffner.setBusinessHours(tiffnerDTO.getBusinessHours());
        tiffner.setDescription(tiffnerDTO.getDescription());
        tiffner.setPrice(tiffnerDTO.getPrice());

        Tiffner finalTiffner = tiffnerRepository.save(tiffner);
        return ResponseEntity.ok(finalTiffner);
        }
    }

