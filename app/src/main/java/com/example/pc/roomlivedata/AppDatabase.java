package com.example.pc.roomlivedata;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

/**
 * Created by pc on 8/22/2018.
 */

@Database(entities = {UserDetail.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase instance;
    public abstract UserDetailDao userDetailDao();


    static AppDatabase getDatabase(Context context)
    {
        if(instance==null)
        {
            synchronized (AppDatabase.class)
            {
                if(instance==null)
                {
                    instance= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"user_detail_db")
                            .fallbackToDestructiveMigration()
                            .addCallback(callback)
                            .build();
                }
            }
        }
        return instance;
    }

    public static  RoomDatabase.Callback callback=new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            new PopulateData(instance).execute();
        }
    };

    private static class PopulateData extends AsyncTask<Void,Void,Void> {

        UserDetailDao userDetailDao;

        public PopulateData(AppDatabase instance) {

            userDetailDao=instance.userDetailDao();


        }

        @Override
        protected Void doInBackground(Void... voids) {

            userDetailDao.getAllUser();

            UserDetail userDetail=new UserDetail();
            userDetail.setUserName("praveen");
            userDetail.setUserEmail("praveenkumar046@gmail.com");
            userDetail.setUserMobile("8800166863");

            userDetailDao.insert(userDetail);
            return null;
        }
    }
}
