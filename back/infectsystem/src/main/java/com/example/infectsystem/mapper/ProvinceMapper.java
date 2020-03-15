package com.example.infectsystem.mapper;

import com.example.infectsystem.pojo.Province;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProvinceMapper {
    @Select("SELECT * FROM province")
    List<Province> findAll();

    @Select("SELECT * FROM province where provincename=#{provincename}")
    Province find(String provinceName);
}