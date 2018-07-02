package com.baidu.ai.aip.demo;
import java.util.HashMap;
import java.util.Map.Entry;

import com.baidu.aip.imagesearch.AipImageSearch;
import com.ucardstore.ai.aip.auth.AuthService;
import com.ucardstore.ai.aip.utils.AipImageUtils;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;


public class AppMain {
	 private static final String FILE_PATH = "D:\\Desktop\\workspace\\ai-test\\WebContent\\WEB-INF\\pic";
	
	 public static void main(String[] args) {
		 AipImageSearch client = AipImageUtils.getInstance();
		 //sampleIn(client);
		 //sampleIndex(client);
		 //sampleDel(client);
		 
		 //similarIn(client);
		 //similarIndex(client);
		 similarDel(client);
		 
	 }
	 
	 
	 
	 
	 
	 public static void sampleIn(AipImageSearch client) {
	    // 传入可选参数调用接口
	     HashMap<String, String> options = new HashMap<String, String>();
	     //图片1：
	    options.put("brief", "{name:\"java001\", \"id\":\"666\"}");
		options.put("tags", "100,101");
	    String image = "test.jpg";
	    image=FILE_PATH+"\\"+image;
	    JSONObject res01 = client.sameHqAdd(image, options);
	    //图片2:
	    options.put("brief", "{name:\"java002\", \"id\":\"999\"}");
		options.put("tags", "100,101");
	    image="test2.jpg";
	    image=FILE_PATH+"\\"+image;
	    JSONObject res02 = client.sameHqAdd(image, options);
	    JSONArray list=new JSONArray();
	    list.put(res01);
	    list.put(res02);
	    System.out.println(list.toString(2));
	 }
	 
	 public static void similarIn(AipImageSearch client) {
		    // 传入可选参数调用接口
		     HashMap<String, String> options = new HashMap<String, String>();
		     //图片1：
		    options.put("brief", "{name:\"java001\", \"id\":\"666\"}");
			options.put("tags", "100,101");
		    String image = "test.jpg";
		    image=FILE_PATH+"\\"+image;
		    JSONObject res01 = client.similarAdd(image, options);
		    //图片2:
		    options.put("brief", "{name:\"java002\", \"id\":\"999\"}");
			options.put("tags", "100,101");
		    image="test2.jpg";
		    image=FILE_PATH+"\\"+image;
		    JSONObject res02 = client.similarAdd(image, options);
		    JSONArray list=new JSONArray();
		    list.put(res01);
		    list.put(res02);
		    System.out.println(list.toString(2));
		 }
	 
	 public static void sampleIndex(AipImageSearch client) {

	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("tags", "100,101");
	    options.put("tag_logic", "0");
	    options.put("pn", "0");
	    options.put("rn", "250"); 
	    // 参数为本地路径
	    String image = "test2.jpg";
	    image=FILE_PATH+"\\"+image;
	    JSONObject res = client.sameHqSearch(image, options);
	    System.out.println(res.toString(2));
	}
	 
	 public static void similarIndex(AipImageSearch client) {

		    // 传入可选参数调用接口
		    HashMap<String, String> options = new HashMap<String, String>();
		    options.put("tags", "100,101");
		    options.put("tag_logic", "0");
		    options.put("pn", "0");
		    options.put("rn", "250"); 
		    // 参数为本地路径
		    String image = "test2.jpg";
		    image=FILE_PATH+"\\"+image;
		    JSONObject res = client.similarSearch(image, options);
		    System.out.println(res.toString(2));
		}
	 
	 
	 public static void sampleDel(AipImageSearch client) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    
	    // 参数为本地路径
	    String image = "test.jpg";
	    image=FILE_PATH+"\\"+image;
	    JSONObject res = client.sameHqDeleteByImage(image, options);
	    System.out.println(res.toString(2));
	    
	    image = "test2.jpg";
	    image=FILE_PATH+"\\"+image;
	    JSONObject res02 = client.sameHqDeleteByImage(image, options);
	    System.out.println(res02.toString(2));
	    //String contSign="415293130,2419074865";
	    // 删除相同图，传入参数为图片签名
	    //JSONObject res = client.sameHqDeleteBySign(contSign, options);
	    //System.out.println(res.toString(2));
	}
	 
	 public static void similarDel(AipImageSearch client) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    
	    // 参数为本地路径
	    String image = "test.jpg";
	    image=FILE_PATH+"\\"+image;
	    JSONObject res = client.similarDeleteByImage(image, options);
	    System.out.println(res.toString(2));
	    
	    image = "test2.jpg";
	    image=FILE_PATH+"\\"+image;
	    JSONObject res02 = client.similarDeleteByImage(image, options);
	    System.out.println(res02.toString(2));
	    //String contSign="415293130,2419074865";
	    // 删除相同图，传入参数为图片签名
	    //JSONObject res = client.sameHqDeleteBySign(contSign, options);
	    //System.out.println(res.toString(2));
	}
	 

}
