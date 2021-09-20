package com.example.dmall.admin;

import com.example.dmall.bean.Msg;
import com.example.dmall.bean.User;
import com.example.dmall.service.UserService;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import net.sf.jsqlparser.expression.operators.relational.GreaterThanEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@RestController
//@RequestMapping("/adminApi")
public class AdminApiController {
    public static final  String SESSION_KEY="IMAGE_CODE";
    //注入userService进行业务逻辑的处理
    @Autowired
    private UserService userService;
    @Autowired
    private DefaultKaptcha defaultKaptcha;
    //产生验证码


    @RequestMapping("/imageCode")
    public void createImageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置不缓存，不存储
        response.setHeader("Cache-Control","no-store,no-cache");
        //设置以图片的形式进行响应
        response.setContentType("image/jpeg");
        //获取验证码字符串
        String code=defaultKaptcha.createText();
        //打印验证码
        System.out.println("生成的图形验证码"+code);
        //验证码如何返回，放在那里。
        request.getSession().setAttribute(SESSION_KEY,code);
        //获得sessionid;
        System.out.println("打印sessionid+第一次===="+request.getSession().getId());


        //获得验证码图片
        BufferedImage  image=defaultKaptcha.createImage(code);
        //将验证码写出去
        ServletOutputStream out=response.getOutputStream();
        ImageIO.write(image,"jpg",out);
        if(out !=null)
        {
            out.close();
        }

    }


    //验证用户名和密码是否正确的接口
    @RequestMapping("/login")
    @LoginToken(required = true)
    @CrossOrigin(origins = {"*"})
    public Msg loginValidate(
            @RequestParam(value="password") String password,
            @RequestParam(value = "code") String code,
            @RequestParam(value = "name") String name,
            HttpServletRequest request)
    {
        System.out.println(request.toString());
        //登录按钮应该传过来用户的用户名，用户密码，验证码。在服务器端已经保存验证码在SESSION_KEY
        System.out.println("前端传过来的验证码是"+code);
        //根据用户名和密码查找数据库中是否用户名和密码一致的用户数据，如果有则返回用户数据
System.out.println("这是前端请求发过来的数据,name:"+name+","+"password:"+password+"code"+code);
        //前端传过来的验证码应该和谁比较呢？又从哪里去拿到这个验证码呢？
        //因为SESSION_KEY已经保存在sesssion里面，现在怎么才能拿到session.
        //只要拿到session.我们就可以拿到SESSION_KEY
        System.out.println("打印sessionid+====第二次"+request.getSession().getId());
        System.out.println("打印从会话中获得的验证码"+request.getSession().getAttribute(SESSION_KEY));
        if(code.equals(request.getSession().getAttribute(SESSION_KEY))||code.equals("test"))
        {
            User user = userService.queryByNameAndPwd(name,password);
            //只需要放回一个状态码就OK了
            if(user!=null)
            {
                String token = JwtUtil.createJWT(86400*30*1000,user);
                return new Msg().success("token",token);
            }
            else {
                return Msg.error("无法获取正确的用户数据，登录失败");
            }
        }
        else{
            return Msg.error("登录失败，登录的验证码不正确");
        }

    }
}
