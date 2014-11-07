package com.lidroid.xutils.util;

import android.os.Handler;

public class UIThreadUtils {

	private static Handler sHandler;

	/**
	 * 必须在主线程中调用。
	 */
	public static void create() {
		if (sHandler == null) {
			sHandler = new Handler();
		}
	}

	public static void run(Runnable action) {
		sHandler.post(action);
	}

	public static void runDelay(int delayMillis, Runnable action) {
		sHandler.postDelayed(action, delayMillis);
	}
}
