package com.testdubbo.demo.contrl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.testdubbo.demo.api.StudentService;
import com.testdubbo.demo.entity.StudentInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xulei on 2019/6/21.
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerContrl {

    @Reference
    StudentService studentService;

    @RequestMapping("/dubboTest")
    public StudentInfo getDubboInfo(){
        return studentService.getName();
    }
}
