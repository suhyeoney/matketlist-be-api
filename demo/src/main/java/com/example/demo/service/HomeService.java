package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.HomeDao;
import com.example.demo.entity.Home;

@Service
public class HomeService {
    
    @Autowired
    HomeDao homeDao;

    public Home getHomeInfo(Integer id) {
      Home homeInfo = homeDao.getHomeInfo(id);
      return homeInfo;
    }

}
