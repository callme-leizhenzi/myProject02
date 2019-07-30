package com.testdubbo.demo.entity;

import java.io.Serializable;

/**
 * Created by xulei on 2019/6/19.
 */
public class StudentInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String name;

    private String phone;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
