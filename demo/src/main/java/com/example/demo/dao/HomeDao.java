package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Home;

@Repository
@Mapper
public interface HomeDao {

    Home getHomeInfo(Integer id);

}
