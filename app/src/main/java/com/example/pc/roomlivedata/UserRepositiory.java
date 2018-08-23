package com.example.pc.roomlivedata;
import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import java.util.List;
/**
 * Created by pc on 8/22/2018.
 */

public class UserRepositiory {

    public LiveData<List<UserDetail>> userdetailList;
    public UserDetailDao userDetailDao;

    UserRepositiory(Application application)
    {
        AppDatabase database=AppDatabase.getDatabase(application);
        userDetailDao=database.userDetailDao();
        userdetailList =userDetailDao.getAllUser();
    }

    public LiveData<List<UserDetail>> getAllData()
    {
        return  userdetailList;
    }

    public void insert(UserDetail  userDetail)
    {
      new InsertRecod(userDetailDao).execute(userDetail);
    }

    public static class InsertRecod extends AsyncTask<UserDetail,Void,Void>
    {
        public UserDetailDao userDetailDao;

        public InsertRecod(UserDetailDao userDetailDao) {

              this.userDetailDao=userDetailDao;
        }

        @Override
        protected Void doInBackground(UserDetail... userDetails) {

            userDetailDao.insert(userDetails[0]);
            return null;
        }
    }

}
