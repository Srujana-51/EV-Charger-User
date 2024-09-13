package com.petrol.Driver.service;

import com.petrol.Driver.entity.Location;
import com.petrol.Driver.entity.UserEntity;
import com.petrol.Driver.repo.LocationRepo;
import com.petrol.Driver.repo.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private Userrepo userrepo;
    @Autowired
    private LocationRepo locRepo;

    public Integer saveAndReturnLocation(UserEntity user){
        String location=user.getLocation();
        userrepo.save(user);
        Location loc_name=locRepo.findByLocationName(location);
        Integer locId=loc_name.getLocationId();
        return locId;
    }
}
