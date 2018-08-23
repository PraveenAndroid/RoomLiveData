package com.example.pc.roomlivedata;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by pc on 8/22/2018.
 */

@Entity(tableName = "user_detail")
public class UserDetail {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "user_id")
    private int user_id;

    @ColumnInfo(name = "user_name")
    private String userName;
    @ColumnInfo(name = "user_email")
    private String userEmail;
    @ColumnInfo(name = "user_mobile")
    private String userMobile;


    public int getUser_id() {
        return user_id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }
}
