package com.gstart.upms.server.controller;

import com.gstart.common.base.BaseController;
import com.gstart.common.bean.Message;
import com.gstart.upms.client.shiro.session.UpmsSessionDao;
import net.bytebuddy.asm.Advice;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yangguangye
 * @Create by gzpykj
 * @Date 2018-05-19 10:28
 */
@CrossOrigin(origins = {"http://localhost:9999"},allowCredentials = "true")
@RestController
@RequestMapping(value = "/sso")
public class SSOController extends BaseController {


    @Autowired
    HttpServletRequest request;

    @Autowired
    SecurityManager securityManager;

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Message login(@RequestBody com.gstart.upms.dao.pojo.User u){
        Message message = new Message();
        message.setSuccess(true);
        message.setMessage("登录成功");
        String account = u.getAccount();
        String password = u.getPassword();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String sessionId = session.getId().toString();
        UsernamePasswordToken token = new UsernamePasswordToken(u.getAccount(), u.getPassword());
        try {
            //4、登录，即身份验证
            subject.login(token);
        } catch (Exception e) {
            //5、身份验证失败
            if (e instanceof IncorrectCredentialsException){
                message.setSuccess(false);
                message.setMessage("帐号/密码错误，请重新登录");
            }else if (e instanceof LockedAccountException){
                message.setSuccess(false);
                message.setMessage("帐号锁定");
            }else if (e instanceof UnknownAccountException){
                message.setSuccess(false);
                message.setMessage("帐号不存在");
            }
            return message;

        }
        //6、退出
        return message;
    }
}
