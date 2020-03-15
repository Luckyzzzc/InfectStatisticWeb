package com.example.infectsystem.pojo;

public class Data {
    private Integer infect;
    private Integer doubt;
    private Integer cure;
    private Integer dead;
    private String provinceName;
    private String date;

    public Data(){}
    public Data(String name, Integer infect, Integer doubt, Integer cure, Integer dead, String date){
        this.setProvinceName(name);
        this.setInfect(infect);
        this.setDoubt(doubt);
        this.setCure(cure);
        this.setDead(dead);
        this.setDate(date);
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public Integer getInfect() {
        return infect;
    }

    public void setInfect(Integer infect) {
        this.infect = infect;
    }

    public Integer getDoubt() {
        return doubt;
    }

    public void setDoubt(Integer doubt) {
        this.doubt = doubt;
    }

    public Integer getCure() {
        return cure;
    }

    public void setCure(Integer cure) {
        this.cure = cure;
    }

    public Integer getDead() {
        return dead;
    }

    public void setDead(Integer dead) {
        this.dead = dead;
    }

    public String  getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
