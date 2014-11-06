package com.lidroid.xutils.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Config {

	private static SharedPreferences sPreferences;
	private static Config sConfig;

	public Config(Context context, String name) {
		sPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
	}

	public static Config create(Context context, String name) {
		synchronized (context) {
			if (sConfig == null) {
				sConfig = new Config(context, name);
			}
		}
		return sConfig;
	}

	/**
	 * 必须先调用create.
	 * 
	 * @return self
	 */
	public static Config getInstance() {
		return sConfig;
	}

	public void config(String key, boolean value) {
		Editor editor = sPreferences.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	public void config(String key, float value) {
		Editor editor = sPreferences.edit();
		editor.putFloat(key, value);
		editor.commit();
	}

	public void config(String key, String value) {
		Editor editor = sPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}

	public void config(String key, long value) {
		Editor editor = sPreferences.edit();
		editor.putLong(key, value);
		editor.commit();
	}

	public void config(String key, int value) {
		Editor editor = sPreferences.edit();
		editor.putInt(key, value);
		editor.commit();
	}

	public boolean getBoolean(String key) {
		return sPreferences.getBoolean(key, false);
	}

	public float getFloat(String key) {
		return sPreferences.getFloat(key, 0.0f);
	}

	public int getInt(String key) {
		return sPreferences.getInt(key, 0);
	}

	public long getLong(String key) {
		return sPreferences.getLong(key, 0);
	}

	public String getString(String key) {
		return sPreferences.getString(key, "");
	}
}
