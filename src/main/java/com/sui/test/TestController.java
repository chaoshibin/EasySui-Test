package com.sui.test;

import com.easysui.common.util.Result;
import com.easysui.distribute.lock.annotation.EasyLock;
import com.easysui.log.annotation.EasyLog;
import com.easysui.web.annotation.EasyValidate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CHAO 2019/5/15 0:30
 */
@Controller
@RequestMapping("")
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(Student student){
        return "";
    }

    @RequestMapping("/testLog")
    @ResponseBody
    @EasyLog(title = "测试EasyLog")
    @EasyValidate
    public Result<Student> testLog(Student student){
        student.setAddress("在哪里");
        return Result.ok(student);
    }

    @RequestMapping("/testComponent")
    @ResponseBody
    @EasyLog(title = "测试日志")
    @EasyValidate
    @EasyLock(prefix = "test", key = {"#s.age","#s.address"})
    public Result<Student> testComponent(Student s){
        s.setAddress("在哪里");
        return Result.ok(s);
    }
}
