package com.hehe.mvp;

public interface ILoginView {
	public abstract void showProgress();

	void hideProgress();

	void passwordError();

	void loginFornull();

	public abstract String getUsername();

	String getPassword();

	void loginSuccess();

}
