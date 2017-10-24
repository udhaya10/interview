package com.sample.design;


public interface Users {
    public boolean isNew(String userName);

    public Integer numberOfUsers();

    public Integer getUserId(String userName);

    public Integer addNewUser(String userName);

    public String getUserName(Integer userId);
}
