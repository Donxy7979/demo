package com.zdx.demo.controller;


import com.zdx.demo.dao.UserDao;
import com.zdx.demo.domain.User;
import com.zdx.demo.dto.loginRequestDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping(value="/")
public class pageController {
    @Resource
    UserDao userDao;

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping(value="/login")
    public ModelAndView login(ModelAndView modelAndView,@Valid loginRequestDto input) {
        User user=new User();
        user.setUserName(input.getUserName());
        user.setPassWord(input.getPassWord());
        if (userDao.selectUserByName(user.getUserName()) == null) {
            modelAndView.addObject("error","用户不存在");
            modelAndView.setViewName("login");
            return modelAndView;
        }else if (userDao.selectUserByNameAndPassword(user) == null) {
            modelAndView.addObject("error","密码错误");
            modelAndView.setViewName("login");
            return modelAndView;
        }else {
            modelAndView.addObject("userName",user.getUserName());
            modelAndView.setViewName("login");
            return modelAndView;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String URL="jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        String USER="root";
        String PASSWORD="zdx11177979";
        //1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获得数据库链接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from user");
        //4.处理数据库的返回结果(使用ResultSet类)
        while(rs.next()){
            System.out.println(rs.getString("user_name")+" "
                    +rs.getString("user_password"));
        }
        //关闭资源
        rs.close();
        st.close();
        conn.close();
    }
}
