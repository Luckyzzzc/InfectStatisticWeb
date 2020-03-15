package com.example.infectsystem.controller;

import com.example.infectsystem.pojo.Data;
import com.example.infectsystem.pojo.Province;
import com.example.infectsystem.service.DataService;
import com.example.infectsystem.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin
public class DataController {
    @Autowired
    DataService dataService;

    @Autowired
    ProvinceService provinceService;

    @RequestMapping("/find/by/date")
    @ResponseBody
    public List<Data> findByDate(@RequestParam String date){
        return dataService.findByDate(date);
    }

    @RequestMapping("/find/by/province")
    @ResponseBody
    public List<Data> findByProvince(@RequestParam String provinceName){
        return dataService.findByProvince(provinceName);
    }

    @RequestMapping("/find/by/province/and/date")
    @ResponseBody
    public List<Data> findByDateAndProvince(@RequestParam String provinceName, @RequestParam String date){
        return dataService.findByProvinceAndDate(provinceName,date);
    }

    @RequestMapping("/get/sub/province")
    @ResponseBody
    public List<Data> CalTodayData(@RequestParam String provinceName, @RequestParam String date) throws ParseException {
        List<Data> dataList;
        List<Data> dataList1 = new ArrayList<>();
        dataList =  dataService.findByProvince(provinceName);
        for(int i = 0; i < dataList.size() - 1; i++){
            dataList1.add(CalData(dataList.get(i + 1),dataList.get(i)));
        }
        return dataList1;
    }

    @RequestMapping("/get/infect")
    @ResponseBody
    public String getInfect(@RequestParam String provinceName, @RequestParam String date){
        return dataService.getInfectDate(provinceName, date);
    }

    @RequestMapping("/getdoubt")
    @ResponseBody
    public String getDoubt(@RequestParam String provinceName, @RequestParam String date){
        return dataService.getDoubtDate(provinceName, date);
    }

    @RequestMapping("/get/cure")
    @ResponseBody
    public String getCure(@RequestParam String provinceName, @RequestParam String date){
        return dataService.getCureDate(provinceName, date);
    }

    @RequestMapping("/get/dead")
    @ResponseBody
    public String getDead(@RequestParam String provinceName, @RequestParam String date){
        return dataService.getDeadDate(provinceName, date);
    }

    @RequestMapping("/get/all")
    @ResponseBody
    public Data getAll(@RequestParam String date){
        List<Data> dataList = dataService.findByDate(date);
        Integer infect = 0;
        Integer doubt = 0;
        Integer cure = 0;
        Integer dead = 0;
        for(Data data : dataList){
            infect += data.getInfect();
            doubt += data.getDoubt();
            cure += data.getCure();
            dead += data.getDead();
        }
        return new Data("全国", infect, doubt, cure, dead, date);
    }

    @RequestMapping("/get/sub/all")
    @ResponseBody
    public Data getSubAll(@RequestParam String date) throws ParseException {
        String dateTemp = DateProcess(date);
        return CalData(getAll(date),getAll(dateTemp));
    }

    @RequestMapping("/getSum")
    @ResponseBody
    public List<Data> getSum(@RequestParam String date){
        List<Province> provinces = provinceService.findAll();
        List<Data> dataList = new ArrayList<>();
        for(Province province : provinces){
            List<Data> dataList1 = dataService.findByProvince(province.getProvinceName());
            Data datatemp = new Data(province.getProvinceName(),0,0,0,0,date);
            for(Data data : dataList1){
                if(data.getDate().compareTo(date) > 0)
                    continue;
                datatemp.setInfect(datatemp.getInfect() + data.getInfect());
            }
            dataList.add(datatemp);
        }
        return dataList;
    }

    private Data CalData(Data dataToday, Data dataLast){
        Data temp = new Data();
        temp.setProvinceName(dataToday.getProvinceName());
        temp.setInfect(dataToday.getInfect()-dataLast.getInfect());
        temp.setCure(dataToday.getCure()-dataLast.getCure());
        temp.setDoubt(dataToday.getDoubt()-dataLast.getDoubt());
        temp.setDead(dataToday.getDead()-dataLast.getDead());
        temp.setDate(dataToday.getDate());
        return temp;
    }

    private String DateProcess(String date) throws ParseException {
        Date dateTemp = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        Calendar c = Calendar.getInstance();
        c.setTime(dateTemp);
        int day1 = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day1 - 1);
        String dateTemp1 = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dateTemp1;
    }
}

