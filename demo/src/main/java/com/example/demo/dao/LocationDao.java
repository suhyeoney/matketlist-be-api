package com.example.demo.dao;

import com.example.demo.entity.Location;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@Mapper
public interface LocationDao {

    List<Location> getLocations();
    List<Location> getLocationsByRegisterUserId(@PathVariable("registerUserId") String registerUserId);

    Integer insertLocation(@Param("location") Location location);
}
