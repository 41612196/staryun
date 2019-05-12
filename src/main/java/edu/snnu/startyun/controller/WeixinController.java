package edu.snnu.startyun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weixin")
public class WeixinController {

    @RequestMapping("/auth")
    public void auth(@RequestParam("code") String code){
        System.out.println("auth方法");
        System.out.println(code);
    }
}
