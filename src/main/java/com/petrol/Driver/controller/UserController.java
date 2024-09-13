package com.petrol.Driver.controller;

import com.petrol.Driver.entity.Location;
import com.petrol.Driver.entity.UserEntity;
import com.petrol.Driver.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private RestTemplate restTemplate;

    String url = "http://localhost:8081/station";

    @PostMapping("/getStatus")
    public String saveAndReturnLocation(@RequestBody UserEntity user){
        Integer locationId=userServiceImp.saveAndReturnLocation(user);
        return restTemplate.getForObject(
                UriComponentsBuilder.fromHttpUrl(url)
                        .path("/get/{locationId}")
                            .buildAndExpand(locationId)
                        .toUri(),
                String.class);
    }

    //save

    //find charger assossciated to a location name
    //locationName se find locationId from location table
    //if location name which has no id there is no charger at your location
//    public List<StationDto> getAllStationByLocationName(String locationName){
//        Location location = locationRepo.findByLocationName(locationName);
//        if(location.isEmpty){
//            throw
//        }
//    }
}
