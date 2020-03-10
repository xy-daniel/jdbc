package org.javaboy.jdbc;

import org.javaboy.jdbc.bean.User;
import org.javaboy.jdbc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JdbcApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void addUser() {
        User user = new User();
        user.setUsername("ddg");
        user.setAddress("peking");
        System.out.println(userService.addUser(user));
    }

    @Test
    void updateUsernameById() {
        User user = new User();
        user.setId(1);
        user.setUsername("ddgUpdate");
        System.out.println(userService.updateUsernameById(user));
    }

    @Test
    void deleteUserById() {
        System.out.println(userService.deleteUserById(2));
    }

    @Test
    void selectAll() {
        System.out.println(userService.selectAll());
    }

    @Test
    void selectAllSimple() {
        System.out.println(userService.selectAllSimple());
    }

}
