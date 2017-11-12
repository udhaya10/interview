package com.splitwise.user;

import java.util.ArrayList;
import java.util.HashMap;

public class UserStore implements Users {

    private ArrayList<String> users = null;
    private HashMap<String, Integer> userIdMapping = null;

    public UserStore() {
        this.users = new ArrayList<String>();
        this.userIdMapping = new HashMap<String, Integer>();
    }

    public UserStore(ArrayList<String> users, HashMap<String, Integer> userIdMapping) {
        this.users = users;
        this.userIdMapping = userIdMapping;
    }

    public boolean isNew(String userName) {
        return !users.contains(userName);
    }

    public Integer numberOfUsers() {
        return users.size();
    }

    public Integer getUserId(String userName) {
        return users.indexOf(userName);
    }

    public Integer addNewUser(String userName) {

        if (isNew(userName)) {
            users.add(userName);
        }
        return getUserId(userName);
    }

    public String getUserName(Integer userId) {
        return users.size() > userId ? users.get(userId) : "";
    }


}
