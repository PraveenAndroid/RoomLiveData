package com.example.pc.roomlivedata;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import java.util.List;

/**
 * Created by pc on 8/22/2018.
 */

public class UserDetailViewModel extends AndroidViewModel {

    public UserRepositiory userRepositiory;
    public LiveData<List<UserDetail>> getUserDetail;

    public UserDetailViewModel(@NonNull Application application) {
        super(application);

        userRepositiory=new UserRepositiory(application);
        getUserDetail=userRepositiory.getAllData();
    }

    public  LiveData<List<UserDetail>> getUserData()
    {
        return getUserDetail;
    }

    public void insert(UserDetail userDetail)
    {
        userRepositiory.insert(userDetail);
    }
}
