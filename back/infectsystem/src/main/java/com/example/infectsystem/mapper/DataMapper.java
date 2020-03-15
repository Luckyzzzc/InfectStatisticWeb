package com.example.infectsystem.mapper;

import com.example.infectsystem.pojo.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DataMapper {
    //查询某日所有信息
    @Select("SELECT * FROM data WHERE date=#{date}")
    List<Data> findByDate(String date);

    //查询某省所有信息
    @Select("SELECT * FROM data WHERE provincename=#{provinceName}")
    List<Data> findByProvince(String provinceName);

    //查询某省某日所有信息
    @Select("SELECT * FROM data WHERE provincename=#{provinceName} AND date=#{date} ")
    List<Data> findByDateAndProvince(@Param("provinceName") String provinceName, @Param("date") String date);

    //查询某省某日感染人数
    @Select("SELECT infect From data WHERE provincename=#{provinceName} AND date=#{date}")
    String getInfectData(@Param("provinceName") String provinceName, @Param("date") String date);

    //查询某省某日疑似人数
    @Select("SELECT doubt From data WHERE provincename=#{provinceName} AND date=#{date}")
    String getDoubtData(@Param("provinceName") String provinceName, @Param("date") String date);

    //查询某省某日治愈人数
    @Select("SELECT cure From data WHERE provincename=#{provinceName} AND date=#{date}")
    String getCureData(@Param("provinceName") String provinceName, @Param("date") String date);

    //查询某省某日死亡人数
    @Select("SELECT dead From data WHERE provincename=#{provinceName} AND date=#{date}")
    String getDeadData(@Param("provinceName") String provinceName, @Param("date") String date);
}
