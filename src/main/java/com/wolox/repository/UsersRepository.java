package com.wolox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wolox.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}