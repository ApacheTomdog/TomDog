package com.brcc.business.util;

public class LatLngGetDistance {
    
   /* private static volatile LatLngGetDistance instance = null;  
	
    public static LatLngGetDistance getInstance(){
    	if(null==instance){
    		synchronized (LatLngGetDistance.class) {
    			if (instance == null) {    
                    instance = new LatLngGetDistance();   
                 }   
			}
    	}
    	return instance;
    }*/
	// 地球半径  
	private static  double r= 6378.137;
	private static double rad(double d)  
	{  
	   return d * Math.PI / 180.0;  
	}  
	  
	public static  double getDistance(double lat1, double lng1, double lat2, double lng2)  
	{  
	   double radLat1 = rad(lat1);  
	   double radLat2 = rad(lat2);  
	   double a = radLat1 - radLat2;  
	   double b = rad(lng1) - rad(lng2);  
	   double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +  
	   Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));  
	   s = s * r;  
	   s = Math.round(s * 10000) / 10000;  
	   return s;  
	}
	
	/** 
     * 补充：计算两点之间真实距离(调用此方法)
     * @return 米 
     */   
    public static double getDistanceActual(double longitude1, double latitude1, double longitude2, double latitude2) {  
        // 纬度
        double lat1 = (Math.PI / 180) * latitude1;  
        double lat2 = (Math.PI / 180) * latitude2;  
        // 经度
        double lon1 = (Math.PI / 180) * longitude1;  
        double lon2 = (Math.PI / 180) * longitude2;  
        // 两点间距离 km，如果想要米的话，结果*1000就可以了  
        double d = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1)) * r;  
        return d ;  
    }  
	
	
	public static void main(String[] args) {
		//System.err.println(getDistance(36.474685,114.190422,39.958953, 116.521695));
		//System.err.println(getDistanceActual(36.474685,114.190422,39.958953, 116.521695));
	}
	
	
}
