package com.hehe.utils;

public class SingalInstance {
	private static SingalInstance instance;
	private  String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public static SingalInstance getInstance() {
		if (instance == null) {
			synchronized (new Object()) {
				if (instance == null) {
					instance = new SingalInstance();
				}
			}
		}
		return instance;
	}
}
