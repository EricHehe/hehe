package com.hehe.mvp;

import android.os.Handler;
import android.os.Looper;

public class LoginPresenter implements ILoginPresenter {
	// private volatile static LoginPresenter loginPresenter;
	private UserModel usermodel;
	private ILoginView iLoginView;

	public LoginPresenter(ILoginView iLoginView) {
		this.iLoginView = iLoginView;
		initUserModel();
	}

	private void initUserModel() {
		// TODO Auto-generated method stub
		usermodel = new UserModel(iLoginView.getUsername(),
				iLoginView.getPassword());
	}

	// public static LoginPresenter getInstance(ILoginView iLoginView) {
	// if (loginPresenter == null) {
	// synchronized (LoginPresenter.class) {
	// if (loginPresenter == null) {
	// loginPresenter = new LoginPresenter(iLoginView);
	// }
	// }
	// }
	// return loginPresenter;
	// }

	@Override
	public void login() {
		// TODO Auto-generated method stub
		iLoginView.showProgress();
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				iLoginView.hideProgress();
				// int code = usermodel.checkUserValidity(usermodel);
				int code = usermodel.check();
				switch (code) {
				case 1:
					iLoginView.loginSuccess();
					break;
				case 0:
					iLoginView.passwordError();
					break;
				case -1:
					iLoginView.loginFornull();
					break;
				default:
					break;
				}
			}
		}, 2000);
	}

	// 不予采用 m层出现在v层
	@Override
	public void login(final UserModel userModel) {
		// TODO Auto-generated method stub
		iLoginView.showProgress();
		new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				iLoginView.hideProgress();
				int code = usermodel.checkUserValidity(userModel);
				switch (code) {
				case 1:
					iLoginView.loginSuccess();
					break;
				case 0:
					iLoginView.passwordError();
					break;
				case -1:
					iLoginView.loginFornull();
					break;
				default:
					break;
				}
			}
		}, 2000);
	}

}
