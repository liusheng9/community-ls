package com.nowcoder.community.entity;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.Data;

import java.util.Date;

/**
 * @version v1.0
 * @ClassName:
 * @Description（一句话描述该类的功能）：
 * @Author:刘胜
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private int type;
    private int status;
    private String activationCode;
    private String headerUrl;
    private Date createTime;
}
