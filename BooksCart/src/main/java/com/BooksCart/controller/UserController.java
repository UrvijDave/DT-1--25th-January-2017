package com.BooksCart.controller;




import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BooksCart.dao.UserDAO;
import com.BooksCart.model.User;




@Controller
@RequestMapping("/user")
public class UserController  {

    @Autowired
    private UserDAO userDao;

    @RequestMapping("/userList/all")
    public String getUsers(Model model) {
        List<User> users = userDao.getUserList();
        model.addAttribute("users", users);

        return "userList";
    }
    
    @RequestMapping("/viewUser/{userId}")
    public String viewUser(@PathVariable int userId, Model model) throws IOException {
        User user=userDao.getUserById(userId);
        model.addAttribute("user", user);

        return "viewUser";
    }

    @RequestMapping("/userList")
    public String getUserByCategory(@RequestParam("searchCondition") String searchCondition, Model model) {
        List<User> users = userDao.getUserList();
        model.addAttribute("users", users);
        model.addAttribute("searchCondition", searchCondition);

        return "userList";
    }
}
