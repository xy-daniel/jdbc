package org.javaboy.jdbc.service;

import org.javaboy.jdbc.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //数据库添加
    public Integer addUser(User user) {
        return jdbcTemplate.update("insert into user (username, address) value (?,?);", user.getUsername(), user.getAddress());
    }

    //数据库修改
    public Integer updateUsernameById(User user) {
        return jdbcTemplate.update("update user set username = ? where id = ?;", user.getUsername(), user.getId());
    }

    //数据库删除
    public Integer deleteUserById(Integer id) {
        return jdbcTemplate.update("delete from user where id=?", id);
    }

    //数据库查询复杂方案
    public List<User> selectAll(){
        return jdbcTemplate.query("select * from user;", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String address = resultSet.getString("address");
                user.setId(id);
                user.setUsername(username);
                user.setAddress(address);
                return user;
            }
        });
    }

    //数据库查询简单方案---->必须属性名一致
    public List<User> selectAllSimple(){
        return jdbcTemplate.query("select * from user;", new BeanPropertyRowMapper<>(User.class));
    }
}
