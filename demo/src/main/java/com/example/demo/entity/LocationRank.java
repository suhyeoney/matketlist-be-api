package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class LocationRank {
    String rankNum;
    String name;
    String placeId;
    Double latitude;
    Double longitude;
    Integer cnt; // 맛집 당 집계 횟수
}
