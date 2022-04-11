package com.nowcoder.community.entity;

import lombok.Data;

import java.util.Date;

@Data
public class DiscussPost {
    private int id;  //帖子的id
    private int userId;  //帖子对应用户的id
    private String title;  //帖子的标题
    private String content;  //帖子内容
    private int type;   //帖子是否置顶
    private int status;  //帖子是否是精华
    private Date createTime;
    private int commentCount;
    private double score;
}
