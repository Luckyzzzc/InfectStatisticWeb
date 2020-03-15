package com.example.infectsystem.service;

import com.example.infectsystem.mapper.ProvinceMapper;
import com.example.infectsystem.pojo.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceImplService implements ProvinceService{
    @Autowired
    ProvinceMapper provinceMapper;

    @Override
    public List<Province> findAll() {
        return provinceMapper.findAll();
    }
}
