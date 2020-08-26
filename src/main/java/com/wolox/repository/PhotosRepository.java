package com.wolox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wolox.model.Photos;

@Repository
public interface PhotosRepository extends JpaRepository<Photos, Long> {
}