package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// @RequiredArgsConstructor
// @NoArgsConstructor
public class Location {
    Integer id;
    String placeId;
    String name;
    String address;
    String iconUrl;
    Double latitude;
    Double longitude;
    String phoneNumber;
    String website;
    String userRegisterDate;
    String compoundCode;
    String registerUser;
    String regionCode;
}
