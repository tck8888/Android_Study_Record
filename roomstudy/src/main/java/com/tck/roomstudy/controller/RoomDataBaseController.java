package com.tck.roomstudy.controller;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.tck.roomstudy.dao.UserDao;
import com.tck.roomstudy.entity.User;

/**
 * Created by tck
 * Date: 2018/02/24 15：36
 */
@Database(entities = {User.class},version = 1)
public abstract class RoomDataBaseController extends RoomDatabase {
    public abstract UserDao getUserDao();


       
}
