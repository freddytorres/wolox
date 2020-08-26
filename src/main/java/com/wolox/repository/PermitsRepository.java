package com.wolox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wolox.model.Permits;

@Repository
public interface PermitsRepository extends JpaRepository<Permits, Long> {
	@Query("select c from Permits c, Users d where d.id=c.users.id   and c.users.id = ?1")
	List<Permits> findByIdUserPermits(Long id);
}