package com.hehe.baseactivity_demo;

import com.example.baseactivity_demo.R;
import com.hehe.mvp.ILoginView;
import com.hehe.mvp.LoginPresenter;
import com.hehe.netnew.LoadingActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity implements ILoginView {

	private EditText et_name;
	private EditText et_pass;
	private Button btn_login;
	private LayoutInflater inflater;
	private ProgressDialog pd;
	private LoginPresenter loginPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initView();
		initEvent();
		initHeader();
	}

	private void initView() {
		// TODO Auto-generated method stub
		et_name = (EditText) findViewById(R.id.et_name);
		et_pass = (EditText) findViewById(R.id.et_pass);
		btn_login = (Button) findViewById(R.id.btn_login);
	}

	private void initEvent() {
		// TODO Auto-generated method stub
		pd = new ProgressDialog(this);
		inflater = LayoutInflater.from(this);
		btn_login.setOnClickListener(this);
		// this.setOnILoginView(this);

	}

	private void initHeader() {
		// TODO Auto-generated method stub
		View login_header = inflater.inflate(R.layout.login_header, null);
		addHeaderView(login_header);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		super.onClick(v);
		loginPresenter = new LoginPresenter(this);
		loginPresenter.login();
	}

	@Override
	public void showProgress() {
		// TODO Auto-generated method stub
		pd.show();
	}

	@Override
	public void hideProgress() {
		// TODO Auto-generated method stub
		pd.cancel();
	}

	@Override
	public void passwordError() {
		// TODO Auto-generated method stub
		et_pass.setError("password error!");
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return et_name.getText().toString();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return et_pass.getText().toString();
	}

	@Override
	public void loginSuccess() {
		// TODO Auto-generated method stub
		Toast.makeText(this, "login success!", Toast.LENGTH_SHORT).show();
		startActivity(new Intent(this, LoadingActivity.class));
		finish();
	}

	@Override
	public void loginFornull() {
		// TODO Auto-generated method stub
		Toast.makeText(this, "info for null?", Toast.LENGTH_SHORT).show();
	}
}
