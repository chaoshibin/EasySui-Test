package com.sui.starter.test.controller;

import com.easysui.cache.annotation.EasyCachePut;
import com.easysui.core.util.Result;
import com.easysui.distribute.lock.annotation.EasyLock;
import com.easysui.log.annotation.EasyLog;
import com.easysui.validation.annotation.EasyValidation;
import com.sui.starter.test.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author Chao Shibin 2019/5/15 0:30
 */
@Controller
@RequestMapping("")
@Slf4j
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(Student student) {
        log.info("/test");
        return "";
    }

    @RequestMapping("/testLog")
    @ResponseBody
    @EasyLog(title = "测试EasyLog")
    @EasyValidation
    public Result<Student> testLog(Student student) {
        student.setAddress("在哪里");
        return Result.ok(student);
    }

    @RequestMapping("/testComponent")
    @ResponseBody
    @EasyLog(title = "测试日志")
    @EasyValidation
    @EasyCachePut(cacheName = "123", key = {"#s.age", "#s.address"})
    public Result<Student> testComponent(Student s) {
        s.setAddress("在哪里");
        return Result.ok(s);
    }

    @RequestMapping("/testLock")
    @ResponseBody
    @EasyLock(name = "test", key = {"#s.age", "#s.address"})
    public Result<Student> testLock(Student s) {
        s.setAddress("在哪里");
        return Result.ok(s);
    }
}
