package com.petrol.Driver.repo;

import com.petrol.Driver.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepo extends JpaRepository<UserEntity,Integer> {
}
