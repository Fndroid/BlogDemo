package com.fndroid.retrofitdemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fndroid.retrofitdemo.databinding.ItemBlogBinding;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/8.
 */
public class MyAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<Blogs.BlogsBean> mBlogsArrayList;
    public MyAdapter(Context context, ArrayList<Blogs.BlogsBean> blogsArrayList) {
        this.mContext = context;
        this.mBlogsArrayList = blogsArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 获取绑定实例，并存储在ViewHolder中
        ItemBlogBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout
                .item_blog, parent, false);
        VH vh = new VH(binding.getRoot());
        vh.binding = binding;
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Blogs.BlogsBean blogsBean = mBlogsArrayList.get(position);
        VH vh = (VH) holder;
        // 设置数据绑定数据源
        vh.binding.setVariable(com.fndroid.retrofitdemo.BR.blog, blogsBean);
    }

    @Override
    public int getItemCount() {
        return mBlogsArrayList.size();
    }

    class VH extends RecyclerView.ViewHolder{
        ItemBlogBinding binding;
        public VH(View itemView) {
            super(itemView);
        }
    }
}
