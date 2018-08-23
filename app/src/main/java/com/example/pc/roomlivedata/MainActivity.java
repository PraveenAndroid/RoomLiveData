package com.example.pc.roomlivedata;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

/**
 * Created by pc on 8/22/2018.
 */

public class MainActivity extends AppCompatActivity  {

    public RecyclerView recycle_list;
    public LinearLayoutManager linearLayoutManager;
    public MainActivityAdapter mainActivityAdapter;
    public UserDetailViewModel userDetailViewModel;

    public Button button_add;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycle_list=findViewById(R.id.recycle_list);

        button_add=findViewById(R.id.button_add);


        linearLayoutManager=new LinearLayoutManager(this);
        recycle_list.setLayoutManager(linearLayoutManager);
        mainActivityAdapter=new MainActivityAdapter(this);
        recycle_list.setAdapter(mainActivityAdapter);

        userDetailViewModel= ViewModelProviders.of(this).get(UserDetailViewModel.class);

        userDetailViewModel.getUserData().observe(this, new Observer<List<UserDetail>>() {
            @Override
            public void onChanged(@Nullable List<UserDetail> userDetails) {

                mainActivityAdapter.setUser(userDetails);
            }
        });


        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserDetail userDetail=new UserDetail();
                userDetail.setUserName("praveen New Entry");
                userDetail.setUserEmail("praveenkumar046@gmail.com");
                userDetail.setUserMobile("8800166863");
                userDetailViewModel.insert(userDetail);

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
