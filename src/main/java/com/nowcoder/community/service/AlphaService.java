package com.nowcoder.community.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AlphaService {

    public AlphaService(){
        System.out.println("实例化AlphaService");
    }

    @PostConstruct // 构造器之后调用
    public void init(){
        System.out.println("初始化AlphaService");
    }

    @PreDestroy // 销毁对象之前调用
    public void destory(){
        System.out.println("销毁AlphaService");
    }
}
