package com.fndroid.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.fndroid.dao.BlogDao;
import com.fndroid.entity.Blog;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

public class BooksAction extends ActionSupport {
	
	@Override
	public String execute() throws Exception {
		BlogDao dao = new BlogDao();
		List<Blog> blogs = dao.getBlogs();
		String result = createJsonString(!blogs.isEmpty(), blogs);
		HttpServletRequest request = ServletActionContext.getRequest();
		// ��������������ö���request�У�������jsp�п��Ի�ȡ�õ�
		request.setAttribute("json", createJsonString(!blogs.isEmpty(), blogs));
		return "success";
	}
	
	/**
	 * ͨ�����ݼ�����JSON��ʽ������
	 * @param res ���ݼ��Ƿ�Ϊ��
	 * @param blogs ���ݼ�
	 * @return
	 */
	private String createJsonString(boolean res, List<Blog> blogs) {
		JsonObject resultJson = new JsonObject();
		JsonArray array = new JsonArray();
		resultJson.addProperty("result", res? 1:0);
		resultJson.addProperty("err_msg", res? "�������ɹ���������":"����������");
		if (res){
			for (Blog blog : blogs) {
				JsonObject bObject = new JsonObject();
				bObject.addProperty("id", blog.getId());
				bObject.addProperty("title", blog.getTitle());
				bObject.addProperty("desc", blog.getDescription());
				bObject.addProperty("post_date", blog.getPostDate());
				bObject.addProperty("status", blog.getPostStatus());
				array.add(bObject);
			}
		}
		resultJson.add("blogs", array);
		return resultJson.toString();
	}
}
