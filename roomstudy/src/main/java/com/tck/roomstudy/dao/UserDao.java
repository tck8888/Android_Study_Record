package com.tck.roomstudy.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.tck.roomstudy.entity.User;

import java.util.List;

/**
 * Created by tck
 * Date: 2018/02/24 15：32
 */
@Dao
public interface UserDao {
    @Insert
    Long insertUsers(User user);

    @Insert
    void insertUserList(List<User> users);

    @Update
    void updateUsers(User... users);

    @Delete
    void deleteUsers(User... users);

    @Query("select * from User")
    List<User> searchAllUsers();

    @Query("select * from User where :age > 18")
    List<User> searchUsersByAge(int age);

    @Query("select * from User where firstName like :name limit 1")
    User searchUserByName(String name);
}
