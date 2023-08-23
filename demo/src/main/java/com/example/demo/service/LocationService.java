package com.example.demo.service;

import com.example.demo.dao.LocationDao;
import com.example.demo.entity.Home;
import com.example.demo.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    
    @Autowired
    LocationDao locationDao;

    public List<Location> getLocations() {
        return locationDao.getLocations();
    }

    public List<Location> getLocationsByRegisterUserId(String registerUserId) {
        return locationDao.getLocationsByRegisterUserId(registerUserId);
    }

    public Integer insertLocation(Location location) {
        return locationDao.insertLocation(location);
    }

}
