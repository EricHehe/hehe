package com.hehe.mvp;

public class UserModel {
	private String username;
	private String password;

	public UserModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int check() {
		if (this.getUsername() == "abc" && this.getPassword() == "123") {
			return 1;
		} else {
			return 0;
		}
	}

	public int checkUserValidity(UserModel userModel) {
		if (userModel.getUsername() == null || userModel.getPassword() == null
				|| userModel.getUsername().isEmpty()
				|| userModel.getPassword().isEmpty()) {
			return -1;
		} else if (userModel.getUsername().equals("abc")
				&& userModel.getPassword().equals("123")) {
			return 1;
		} else
			return 0;
	}
}
