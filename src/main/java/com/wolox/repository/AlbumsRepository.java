package com.wolox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wolox.model.Albums;

@Repository
public interface AlbumsRepository extends JpaRepository<Albums, Long> {
}