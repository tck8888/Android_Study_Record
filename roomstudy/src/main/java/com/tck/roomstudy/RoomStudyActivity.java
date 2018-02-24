package com.tck.roomstudy;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tck.roomstudy.controller.RoomDataBaseController;
import com.tck.roomstudy.dao.UserDao;
import com.tck.roomstudy.entity.User;

import java.util.List;

public class RoomStudyActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtUsername;
    private EditText mEtPassword;
    private TextView mTvQueryResult;
    private UserDao mUserDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_study);
        initView();

        initDb();
    }

    private void initDb() {
        RoomDataBaseController db = Room.databaseBuilder(this, RoomDataBaseController.class, "room_study_db").build();
        mUserDao = db.getUserDao();
    }

    private void initView() {

        mEtUsername = findViewById(R.id.et_username);
        mEtPassword = findViewById(R.id.et_password);
        mTvQueryResult = findViewById(R.id.tv_query_result);

        findViewById(R.id.btn_save).setOnClickListener(this);
        findViewById(R.id.btn_query).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                String username = mEtUsername.getText().toString().trim();
                String password = mEtPassword.getText().toString().trim();
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                Long effectedNum = mUserDao.insertUsers(user);
                Toast.makeText(this, "" + effectedNum, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_query:
                List<User> users = mUserDao.searchAllUsers();
                StringBuilder sb = new StringBuilder();
                for (User user1 : users) {
                    sb.append(user1.toString()).append("\"n");
                }
                mTvQueryResult.setText(sb.toString());
                break;
        }
    }
}
