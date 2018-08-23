package com.example.pc.roomlivedata;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

/**
 * Created by pc on 8/22/2018.
 */
@Dao
public interface UserDetailDao {

    @Query("SELECT * from user_detail ORDER BY user_name ASC ")
    LiveData<List<UserDetail>> getAllUser();

    @Insert
    void insert(UserDetail userDetail);

    @Delete
    void delete(UserDetail userDetail);
}
