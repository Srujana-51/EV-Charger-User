package com.petrol.Driver.repo;

import com.petrol.Driver.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends JpaRepository<Location,Integer> {
    Location findByLocationName(String loaction);
}
