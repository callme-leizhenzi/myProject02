package com.testdubbo.demo.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.testdubbo.demo.api.StudentService;
import com.testdubbo.demo.entity.StudentInfo;

/**
 * Created by xulei on 2019/6/19.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public StudentInfo getName() {
        StudentInfo s = new StudentInfo();
        s.setAddress("湖北");
        s.setName("华华");
        return s;
    }

    @Override
    public Integer getId() {
        return new Integer(123);
    }
}
