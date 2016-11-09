package com.fndroid.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    // 这里不能写localhost，因为模拟器和服务器ip不同
    private static final String URL = "http:192.168.1.181:8080/WebDemo/";
    private ArrayList<Blogs.BlogsBean> mBlogsArrayList;
    private MyAdapter mMyAdapter;

    @BindView(R.id.main_rv)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 传入空数据源
        mBlogsArrayList = new ArrayList<>();
        mMyAdapter = new MyAdapter(this, mBlogsArrayList);
        mRecyclerView.setAdapter(mMyAdapter);

        // 使用Gson解析数据，用RxJava2封装请求
        Retrofit ret = new Retrofit.Builder().baseUrl(URL).addConverterFactory
                (GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory
                .create()).build();
        IdentifyService identifyService = ret.create(IdentifyService.class);
        Observable<Blogs> blogs = identifyService.getBlogs();
        blogs.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(b -> {
                    mBlogsArrayList.addAll(b.getBlogs());
                    mMyAdapter.notifyDataSetChanged();
                });
    }
}
