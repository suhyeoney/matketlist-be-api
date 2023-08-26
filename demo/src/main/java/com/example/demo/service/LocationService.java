package com.example.demo.service;

import com.example.demo.dao.LocationDao;
import com.example.demo.entity.Home;
import com.example.demo.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class LocationService {
    
    @Autowired
    LocationDao locationDao;

    public List<Location> getLocations() {
        return locationDao.getLocations();
    }

    public List<Location> getLocationsByRegisterUserId(String registerUserId) {
        HashMap<String, Object> requestParam = new HashMap<>();
        requestParam.put("registerUserId", registerUserId);
        return locationDao.getLocationsByRegisterUserId(requestParam);
    }

    public Integer insertLocation(Location location) {
        return locationDao.insertLocation(location);
    }

    public Integer deleteLocation(String registerUserId, String placeId) {
        HashMap<String, Object> requestParam = new HashMap<>();
        requestParam.put("registerUserId", registerUserId);
        requestParam.put("placeId", placeId);
        return locationDao.deleteLocation(requestParam);
    }

}
