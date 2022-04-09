package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.text.SimpleDateFormat;

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
    @Autowired
    private AlphaDao alphaDao;

    @Autowired
    private AlphaService alphaService;

    @Autowired
    private SimpleDateFormat simpleDateFormat;

    @Test
    public void testDI(){
        System.out.println(alphaDao);
        System.out.println(alphaService);
        System.out.println(simpleDateFormat);
    }
}
