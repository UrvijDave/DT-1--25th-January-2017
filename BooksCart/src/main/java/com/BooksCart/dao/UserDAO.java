package com.BooksCart.dao;

import com.BooksCart.model.User;

import java.util.List;


public interface UserDAO {

    List<User> getUserList();

    User getUserById(int id);

    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);
}
