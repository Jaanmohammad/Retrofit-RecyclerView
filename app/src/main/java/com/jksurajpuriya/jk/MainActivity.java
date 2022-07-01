package com.jksurajpuriya.jk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.jksurajpuriya.jk.Api.ApiInterface;
import com.jksurajpuriya.jk.Api.RetrofitClient;
import com.jksurajpuriya.jk.Api.MyViewModel;
import com.jksurajpuriya.jk.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MyAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fetchData();
        layoutManager= new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
    }

    private void fetchData() {
        ApiInterface apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);
        Call<MyViewModel> data=apiInterface.getData();
        data.enqueue(new Callback<MyViewModel>() {
            @Override
            public void onResponse(Call<MyViewModel> call, Response<MyViewModel> response) {
                if (response.isSuccessful()){
                    adapter=new MyAdapter(response.body().getData());
                    binding.recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<MyViewModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}