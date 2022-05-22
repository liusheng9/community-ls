package com.nowcoder.community.util;


import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

public class CommunityUtil {
    //生成随机字符串
    /**
     * 全局唯一标识符,是指在一台机器上生成的数字，它保证对在同一时空中的所有机器都是唯一的，
     * 是由一个十六位的数字组成,表现出来的形式。由以下几部分的组合：
     * 当前日期和时间(UUID的第一个部分与时间有关，如果你在生成一个UUID之后，过几秒又生成一个UUID，则第一个部分不同，
     * 其余相同)，时钟序列，全局唯一的IEEE机器识别号（如果有网卡，从网卡获得，没有网卡以其他方式获得），
     * UUID的唯一缺陷在于生成的结果串会比较长。  91c606f6-d87f-4dd1-80b2-414b6ac38ad0
     * */
    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    //MD5加密
    // hello->abc123def456
    // hello+3e4a8->abc123def456abc
    public static String md5(String key){
        if(StringUtils.isBlank(key)){
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
