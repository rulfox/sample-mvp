package com.mobotechnology.bipinpandey.retrofit_handdirty;

public class LoginContractImpl implements LoginContract.Presenter, LoginContract.GetLoginInteractor.LoginFinishedListener {

    private LoginContract.LoginView loginView;
    private LoginContract.GetLoginInteractor loginInteractor;

    public LoginContractImpl(LoginContract.LoginView loginView, LoginContract.GetLoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    @Override
    public void performLogin(LoginModel loginModel) {
        boolean isValid = true;
        if (loginModel.userName.trim().length() == 0) {
            loginView.onUserEmpty();
            isValid = false;
        }
        if (loginModel.password.trim().length() == 0) {
            loginView.onPasswordEmpty();
            isValid = false;
        }
        if (isValid) {
            loginInteractor.getLogin(this, loginModel);
        }
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onSuccess() {
        if (loginView == null)
            return;
        loginView.onLoginSuccess();
    }

    @Override
    public void onFailure(String reason) {
        if (loginView == null)
            return;
        loginView.onLoginFailed(reason);
    }
}
