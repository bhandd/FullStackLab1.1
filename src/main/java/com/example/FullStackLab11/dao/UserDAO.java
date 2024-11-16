package com.example.FullStackLab11.dao;

import com.example.FullStackLab11.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public static User FromDBtoBO(UserDB userDB) {
        return new User(
                userDB.getId(),
                userDB.getName(),
                userDB.getSocial_number(),
                userDB.getRole());
    }

    public static List<User> FromDBtoBO(List<UserDB> users) {
        List<User> newUsers = new ArrayList<>();
        for (UserDB user : users) {
            newUsers.add(FromDBtoBO(user));
        }
        return newUsers;
    }

    public static UserDB FromBOtoDB(User user) {
        return new UserDB(
                user.getId(),
                user.getName(),
                user.getSocial_number(),
                user.getRole());
    }

    public static List<UserDB> FromBOtoDB(List<User> users) {
        List<UserDB> newUsers = new ArrayList<>();
        for (User user : users) {
            newUsers.add(FromBOtoDB(user));
        }
        return newUsers;
    }
}
