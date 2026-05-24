package com.rocha82.dao;
import  java.util.List;
public interface IUsers {
    UserModel getByID(int id);
    List<UserModel> getAll();
}
