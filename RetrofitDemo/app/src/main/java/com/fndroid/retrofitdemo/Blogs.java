package com.fndroid.retrofitdemo;

import java.util.List;

/**
 * Created by Administrator on 2016/11/8.
 */

public class Blogs {


    private int result;
    private String err_msg;
    private List<BlogsBean> blogs;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public List<BlogsBean> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<BlogsBean> blogs) {
        this.blogs = blogs;
    }

    public static class BlogsBean {
        private int id;
        private String title;
        private String desc;
        private String post_date;
        private String status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPost_date() {
            return post_date;
        }

        public void setPost_date(String post_date) {
            this.post_date = post_date;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
