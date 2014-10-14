package com.project.app;

import com.baidu.frontia.FrontiaApplication;

public class Global extends FrontiaApplication {

	public static String token;
	public static String phoneCode;
	public static String userId = "";
	public static String channelId = "";
	public static Boolean isActive = true;
	public static int screenWidth;
	public static int screenHeight;

	@Override
	public void onCreate() {
		super.onCreate();
		FrontiaApplication.initFrontiaApplication(this);
	}
}
