package com.tiff.tffnserachservice.repository;

import com.tiff.tffnserachservice.model.Tiffner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TiffnerRepository extends JpaRepository<Tiffner,Long> {

    Optional<Tiffner> findTiffnerById(long id);
    Optional<Tiffner> findTiffnerByName(String name);
}
