package com.example.infectsystem.service;

import com.example.infectsystem.pojo.Data;

import java.util.List;

public interface DataService {
    List<Data> findByDate(String date);
    List<Data> findByProvince(String provinceName);
    List<Data> findByProvinceAndDate(String provinceName, String date);
    String getInfectDate(String provinceName, String date);
    String getDoubtDate(String provinceName, String date);
    String getCureDate(String provinceName, String date);
    String getDeadDate(String provinceName, String date);
}
