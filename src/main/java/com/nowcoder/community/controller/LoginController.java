package com.nowcoder.community.controller;

import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.nowcoder.community.util.CommunityConstant.ACTIVATION_REPEAT;
import static com.nowcoder.community.util.CommunityConstant.ACTIVATION_SUCCESS;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getRegisterPage(){
        return "/site/register";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "/site/login";
    }

    @PostMapping(path = "/register")
    public String register(Model model, User user){
        Map<String,Object> map= userService.register(user);
        if(map==null||map.isEmpty()){
            model.addAttribute("msg","注册成功，已向你的邮箱发送一封邮件，请尽快激活");
            model.addAttribute("target","/index");
            return "/site/operate-result";
        } else{
            model.addAttribute("usernameMsg",map.get("usernameMsg"));
            model.addAttribute("passwordMsg",map.get("passwordMsg"));
            model.addAttribute("emailMsg",map.get("emailMsg"));
            return "/site/register";
        }
    }

    // 邮箱的激活
    @GetMapping(path = "/activation/{userId}/{code}")
    public String activation(Model model, @PathVariable("userId") int userId,@PathVariable("code") String code){
        int result=userService.activation(userId,code);
        if(result==ACTIVATION_SUCCESS){
            model.addAttribute("msg","激活成功，你的账号可以正常使用");
            model.addAttribute("target","/login");
        }else if(result==ACTIVATION_REPEAT){
            model.addAttribute("msg","该账号已被激活");
            model.addAttribute("target","/index");
        }else{
            model.addAttribute("msg","激活失败，提供的激活码不正确");
            model.addAttribute("target","/index");
        }
        return "/site/operate-result";
    }
}
