package com.ucardstore.ai.aip.controller;


import java.util.HashMap;

import javax.servlet.ServletContext;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.aip.imagesearch.AipImageSearch;
import com.ucardstore.ai.aip.utils.AipImageUtils;
import com.ucardstore.ai.aip.utils.ImageBase64utils;

@Controller
public class SimilarImageController {
	
	
	//相似图入库
	/***
	 * image:本地图片路径或者图片二进制数据
	 * brief:	检索时原样带回,最长256B。
	 * tags:1 - 65535范围内的整数，tag间以逗号分隔，最多2个tag。样例："100,11" ；检索时可圈定分类维度进行检索
	 * log_id：uint64	唯一的log id，用于问题定位
	 * cont_sign：string	输入图片签名，可用于删除
	 * 
	 */
	@RequestMapping("/similarImage/in")
	@ResponseBody
	public  String similarImageInStore(String filePath,String brief,String tags){
		 AipImageSearch client = AipImageUtils.getInstance();
		 String image = ImageBase64utils.GetImageStr(filePath);
		 HashMap<String, String> options = new HashMap<String, String>();
		 options.put("brief", brief);
		 options.put("tags", tags);
		 JSONObject res = client.similarAdd(image, options); 
	     return res.toString(2);
	}
	//相似图检索
	/**
	 * tags		String	1 - 65535范围内的整数，tag间以逗号分隔，最多2个tag。样例："100,11" ；检索时可圈定分类维度进行检索
	 * tag_logic String	检索时tag之间的逻辑， 0：逻辑and，1：逻辑or
	 * pn：起始
	 * rn：条数
	 * log_id	是	uint64	唯一的log id，用于问题定位
	 * result_num	是	uint32	检索结果数
	 * result	是	object[]	结果数组
	   +cont_sign	是	string	图片签名，可以用来删除图片或定位问题
		+score	是	float	图片相关性，0-1
		+brief	是	string	调用add接口添加的brief信息，为保证该结果有效性，请入库是填写有效可关联至本地图片库的有效id信息
		has_more	是	bool	是否还有下一页，返回值：true、false；如果不分页，不用关注该字段
	 * @return
	 */
	@RequestMapping("/similarImage/index")
	@ResponseBody
	public  String similarImageIndex(String filePath,String brief,String tags,String tag_logic,String pn,String rn){
		AipImageSearch client = AipImageUtils.getInstance();
		String image = ImageBase64utils.GetImageStr(filePath);
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("tags", tags);
	    options.put("tag_logic", tag_logic);
	    options.put("pn", pn);
	    options.put("rn", rn);  
	    JSONObject res = client.similarSearch(image, options);
	    return res.toString(2);
	}
	
	//相似图删除：
	/**
	 * image	是	mixed	本地图片路径或者图片二进制数据
      cont_sign	是	String	图片签名
	 * @return
	 */
	@RequestMapping("/similarImage/del")
	@ResponseBody
	public  String similarImageDel(String filePath){
		AipImageSearch client = AipImageUtils.getInstance();
		//生成base64
		String image = ImageBase64utils.GetImageStr(filePath);
		HashMap<String, String> options = new HashMap<String, String>();
	    JSONObject res = client.similarDeleteByImage(image, options);
	    return res.toString(2);
	}
	
	
	
	
	
	
}
