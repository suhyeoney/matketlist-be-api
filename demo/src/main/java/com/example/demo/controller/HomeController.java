package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HomeService;

@RestController
@RequestMapping(value="/home")
public class HomeController {
  
  private static final String TAG = "HomeController : ";

  @Autowired
  HomeService homeService;

  @GetMapping("/info")
  public ResponseEntity<?> getHomeInfo(@RequestParam Integer id) {
    
    HashMap<String, Object> result = new HashMap<>();
    result.put("data", homeService.getHomeInfo(id));
    System.out.println(">>>>> " + TAG + "getHomeInfo(" + id + ") called");
    
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
