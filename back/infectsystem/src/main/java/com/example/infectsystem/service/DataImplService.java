package com.example.infectsystem.service;

import com.example.infectsystem.mapper.DataMapper;
import com.example.infectsystem.pojo.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataImplService implements DataService {
    @Autowired
    DataMapper dataMapper;

    @Override
    public List<Data> findByDate(String date) {
        return dataMapper.findByDate(date);
    }

    @Override
    public List<Data> findByProvince(String provinceName) {
        return dataMapper.findByProvince(provinceName);
    }

    @Override
    public List<Data> findByProvinceAndDate(String provinceName, String date) {
        return dataMapper.findByDateAndProvince(provinceName,date);
    }

    @Override
    public String getInfectDate(String provinceName, String date) {
        return dataMapper.getInfectData(provinceName, date);
    }

    @Override
    public String getDoubtDate(String provinceName, String date) {
        return dataMapper.getDoubtData(provinceName, date);
    }

    @Override
    public String getCureDate(String provinceName, String date) {
        return dataMapper.getCureData(provinceName, date);
    }

    @Override
    public String getDeadDate(String provinceName, String date) {
        return dataMapper.getDeadData(provinceName, date);
    }
}
