package com.tiff.tffnserachservice.controller;


import com.tiff.tffnserachservice.dto.TiffnerDTO;
import com.tiff.tffnserachservice.exception.TiffnNotFoundException;
import com.tiff.tffnserachservice.model.Tiffner;
import com.tiff.tffnserachservice.repository.TiffnerRepository;
import com.tiff.tffnserachservice.service.TiffnerService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tffn-search")
@Slf4j
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
    public ResponseEntity<Tiffner> findTffn(@PathVariable Long id) {
        return tiffnerRepository.findByTiffnerId(id).map(ResponseEntity::ok).orElseThrow(() -> new TiffnNotFoundException(id));
    }


    @DeleteMapping("/tffns/{id}")
    public ResponseEntity<Tiffner> deleteTffn(@PathVariable Long id) {
        Optional<Tiffner> tiffner = Optional.ofNullable(tiffnerRepository.findByTiffnerId(id).orElseThrow(() -> new TiffnNotFoundException(id)));

        if (tiffner.isPresent()) {
            tiffnerRepository.delete(tiffner.get());
            log.info(tiffner.toString() + " was deleted");
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        log.error("Tiffin with {}" + id + " does not exist.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tiffner> addTffn(@RequestBody Tiffner tiffner) {
        Tiffner newTiffn = tiffnerRepository.save(tiffner);
        log.info(tiffner.toString() + " has been added successfully.");
        return new ResponseEntity<Tiffner>(newTiffn, HttpStatus.OK);
    }

    @PutMapping("/tffns/{id}")
    public ResponseEntity<?> updateTffn(@PathVariable Long id, @RequestBody TiffnerDTO tiffnerDTO) {
        Optional<Tiffner> tiffn = Optional.ofNullable(tiffnerRepository.findById(id).orElseThrow(() -> new TiffnNotFoundException(id)));

        if(tiffn.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else {
            BeanUtils.copyProperties(tiffnerDTO,tiffn.get());
        }
        final Tiffner updatedTiffn = tiffnerRepository.save(tiffn.get());
        return ResponseEntity.ok(updatedTiffn);

    }

}

