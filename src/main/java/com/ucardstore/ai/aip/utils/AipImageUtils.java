package com.ucardstore.ai.aip.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import com.baidu.aip.imagesearch.AipImageSearch;

/**
 * @author Lu
 *
 */
public class AipImageUtils {
	
	private static HashMap<String,String> map=new HashMap();
	private static volatile AipImageSearch client=null;
	static {
		InputStream in =AipImageUtils.class.getClassLoader().getResourceAsStream("mybaidu.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
			String AppID = (String) pro.get("AppID");
			String APIKey= (String) pro.get("APIKey");
			String SecretKey=(String) pro.get("SecretKey");
			String connectionTimeout = (String) pro.get("ConnectionTimeout");
			String socketTimeout = (String) pro.get("ConnectionTimeout");			
			map.put("AppID",AppID);
			map.put("APIKey",APIKey);
			map.put("SecretKey",SecretKey);
			map.put("connectionTimeout",connectionTimeout);
			map.put("socketTimeout",socketTimeout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static HashMap<String, String> getMap() {
		return map;
	}
	public static void setMap(HashMap<String, String> map) {
		AipImageUtils.map = map;
	}
	
	public static AipImageSearch getInstance(){
		if (client== null) {    
			synchronized(AipImageUtils.class){
				if(client==null){
					client=initializeInstance();
				}
			}
		}
		
		return client;
	}
	private static  AipImageSearch initializeInstance() {
		
		HashMap<String, String> map = AipImageUtils.getMap();
		String APP_ID = map.get("AppID");
		String API_KEY = map.get("APIKey");
		String SECRET_KEY = map.get("SecretKey");
		String connTimeout = map.get("connectionTimeout");
		String sockTimeout = map.get("socketTimeout");
		client=new AipImageSearch(APP_ID, API_KEY, SECRET_KEY);
		int conectionTimeout=2000;
		int socketTimeout =6000;
		try {
			conectionTimeout = Integer.parseInt(connTimeout);
			socketTimeout = Integer.parseInt(sockTimeout);
			
		} catch (Exception e) {
			conectionTimeout=2000;
			socketTimeout =6000;
		}
		client.setConnectionTimeoutInMillis(conectionTimeout);
		client.setSocketTimeoutInMillis(socketTimeout);
		return client;
		
		
	}
	
	
	
	
	
	
	
	
}
