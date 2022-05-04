package com.tiff.tffnserachservice.controller;


import com.tiff.tffnserachservice.dto.TiffnerDTO;
import com.tiff.tffnserachservice.model.Tiffner;
import com.tiff.tffnserachservice.repository.TiffnerRepository;
import com.tiff.tffnserachservice.service.TiffnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tffn-search")
public class TiffnerController {

    @Autowired
    private TiffnerRepository tiffnerRepository;

    @Autowired
    private TiffnerService tiffnerService;

    @GetMapping("/tffns")
    public List<Tiffner> findTiffns() {
        return tiffnerRepository.findAll();
    }

    @GetMapping("/tffns/{id}")
    public Tiffner findTffn(@PathVariable Long id) {
        return tiffnerRepository.findById(id).get();
    }


    @DeleteMapping("/tffns/{id}")
    public ResponseEntity<Tiffner> deleteTffn(@PathVariable Long id) {
        Optional<Tiffner> tiffner = Optional.ofNullable(tiffnerRepository.findByTiffnerId(id).orElseThrow());

        if (tiffner.isPresent()) {
            tiffnerRepository.delete(tiffner.get());
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping(  consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tiffner> addTffn(@RequestBody Tiffner tiffner){
         Tiffner newTiffn = tiffnerRepository.save(tiffner);
         return new ResponseEntity<Tiffner>(newTiffn, HttpStatus.OK);
    }

    @PutMapping("/tffns/{id}")
    public ResponseEntity<Tiffner> updateTffn(@RequestBody TiffnerDTO tiffnerDTO, Long id){
        Tiffner tiffner = tiffnerRepository.findByTiffnerId(id).orElseThrow();

        tiffner.setName(tiffnerDTO.getName());
        tiffner.setAddress(tiffnerDTO.getAddress());
        tiffner.setTags(tiffnerDTO.getTags());
        tiffner.setContactInformation(tiffnerDTO.getContactInformation());
        tiffner.setReviews(tiffnerDTO.getReviews());
        tiffner.setBusinessHours(tiffnerDTO.getBusinessHours());
        tiffner.setDescription(tiffnerDTO.getDescription());
        tiffner.setPrice(tiffnerDTO.getPrice());

        Tiffner finalTiffner = tiffnerRepository.save(tiffner);
        return ResponseEntity.ok(finalTiffner);
        }
    }

