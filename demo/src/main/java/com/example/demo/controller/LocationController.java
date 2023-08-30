package com.example.demo.controller;

import com.example.demo.entity.Location;
import com.example.demo.service.HomeService;
import com.example.demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/api/v1/locations")
public class LocationController {
  
  private static final String TAG = "LocationController : ";

  @Autowired
  LocationService locationService;

  @GetMapping("/all")
  public ResponseEntity<?> getAllLocations() {

    HashMap<String, Object> result = new HashMap<>();
    result.put("data", locationService.getLocations());
    System.out.println(">>>>> " + TAG + "getLocations() called");

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping("/users")
  public ResponseEntity<?> getLocationsByRegisterUser(@RequestParam(value = "registerUserId") String registerUserId, @RequestParam(value="regionCode") String regionCode) {
    HashMap<String, Object> result = new HashMap<>();
    result.put("data", locationService.getLocationsByRegisterUserId(registerUserId, regionCode));
    System.out.println(">>>>> " + TAG + "getLocationsByRegisterUser(" + registerUserId + ") called");
    
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping(value = "", headers = {"Content-Type=application/json"})
  public ResponseEntity<?> insertLocation(@RequestBody Location location) {

    HashMap<String, Object> result = new HashMap<>();
    Integer row = locationService.insertLocation(location);
    String resultCode = "";
    String resultMessage = "";
    if(row < 1) {
      resultCode = "000";
      resultMessage = "[Fail] Location 삽입에 실패했습니다.";
    } else if(row == 1) {
      resultCode = "001";
      resultMessage = "[Success] Location 삽입에 성공했습니다.";
    } else {
      resultCode = "999";
      resultMessage = "[Fail] Location 삽입이 비정상적으로 수행되었습니다.";
    }
    result.put("resultCode", resultCode);
    result.put("resultMessage", resultMessage);
    System.out.println(">>>>> " + TAG + "insertLocation(" + location + ") called");

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @DeleteMapping("/users/{registerUserId}/{placeId}")
  public ResponseEntity<?> deleteLocation(@PathVariable String registerUserId, @PathVariable String placeId) {
    HashMap<String, Object> result = new HashMap<>();
    Integer row = locationService.deleteLocation(registerUserId, placeId);
    String resultCode = "";
    String resultMessage = "";
    if(row < 1) {
      resultCode = "000";
      resultMessage = "[Fail] Location 삭제에 실패했습니다.";
    } else if(row == 1) {
      resultCode = "001";
      resultMessage = "[Success] Location 삭제에 성공했습니다.";
    } else {
      resultCode = "999";
      resultMessage = "[Fail] Location 삭제가 비정상적으로 수행되었습니다.";
    }
    result.put("resultCode", resultCode);
    result.put("resultMessage", resultMessage);
    System.out.println(">>>>> " + TAG + "deleteLocation(" + registerUserId + ", " + placeId + ") called");

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping("/ranks")
  public ResponseEntity<?> getLocationRanks() {

    HashMap<String, Object> result = new HashMap<>();
    result.put("data", locationService.getLocationRanks());
    result.put("refreshTime", new SimpleDateFormat("yyyy.MM.dd HH:mm").format(new Date()));
    System.out.println(">>>>> " + TAG + "getLocationRanks() called");

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}
