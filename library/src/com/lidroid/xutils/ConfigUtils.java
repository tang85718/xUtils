package com.lidroid.xutils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class ConfigUtils {

	private static SharedPreferences sPreferences;
	private static ConfigUtils sConfig;

	public ConfigUtils(Context context, String name) {
		sPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
	}

	public static ConfigUtils create(Context context, String name) {
		synchronized (context) {
			if (sConfig == null) {
				sConfig = new ConfigUtils(context, name);
			}
		}
		return sConfig;
	}

	public static boolean hasKey(String key) {
		return sPreferences.contains(key);
	}

	public static void config(String key, boolean value) {
		Editor editor = sPreferences.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	public static void config(String key, float value) {
		Editor editor = sPreferences.edit();
		editor.putFloat(key, value);
		editor.commit();
	}

	public static void config(String key, String value) {
		Editor editor = sPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}

	public static void config(String key, long value) {
		Editor editor = sPreferences.edit();
		editor.putLong(key, value);
		editor.commit();
	}

	public static void config(String key, int value) {
		Editor editor = sPreferences.edit();
		editor.putInt(key, value);
		editor.commit();
	}

	public static boolean getBoolean(String key) {
		return sPreferences.getBoolean(key, false);
	}

	public static float getFloat(String key) {
		return sPreferences.getFloat(key, 0.0f);
	}

	public static int getInt(String key) {
		return sPreferences.getInt(key, 0);
	}

	public static long getLong(String key) {
		return sPreferences.getLong(key, 0);
	}

	public static String getString(String key) {
		return sPreferences.getString(key, "");
	}
}
