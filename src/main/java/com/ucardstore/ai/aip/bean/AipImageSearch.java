package com.ucardstore.ai.aip.bean;

/**
 * AipImageSearch是图像搜索的Java客户端，为使用图像搜索的开发人员提供了一系列的交互方法
 * @author Lu
 *
 */
public class AipImageSearch {
	
	//public static final String APP_ID;//你的 App ID
	//public static final String API_KEY;//你的 Api Key
	//public static final String SECRET_KEY;//你的 Secret Key

	
	//建立连接的超时时间（单位：毫秒）
	private long connectionTimeoutInMillis;
	//通过打开的连接传输数据的超时时间（单位：毫秒）
	private long SocketTimeoutInMillis;
	//设置http代理服务器
	private String httpProxy;
	//设置socket代理服务器 （http和socket类型代理服务器只能二选一）
	private String socketProxy;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public long getConnectionTimeoutInMillis() {
		return connectionTimeoutInMillis;
	}
	public void setConnectionTimeoutInMillis(long connectionTimeoutInMillis) {
		this.connectionTimeoutInMillis = connectionTimeoutInMillis;
	}
	public long getSocketTimeoutInMillis() {
		return SocketTimeoutInMillis;
	}
	public void setSocketTimeoutInMillis(long socketTimeoutInMillis) {
		SocketTimeoutInMillis = socketTimeoutInMillis;
	}
	public String getHttpProxy() {
		return httpProxy;
	}
	public void setHttpProxy(String httpProxy) {
		this.httpProxy = httpProxy;
	}
	public String getSocketProxy() {
		return socketProxy;
	}
	public void setSocketProxy(String socketProxy) {
		this.socketProxy = socketProxy;
	}
	
	
	
}
