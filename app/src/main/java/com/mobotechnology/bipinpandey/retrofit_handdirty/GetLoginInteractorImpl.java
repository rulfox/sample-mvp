package com.mobotechnology.bipinpandey.retrofit_handdirty;

public class GetLoginInteractorImpl implements LoginContract.GetLoginInteractor{

    @Override
    public void getLogin(LoginFinishedListener listener, LoginModel loginModel) {
        if(loginModel.userName.equalsIgnoreCase("a") && loginModel.password.equalsIgnoreCase("a"))
            listener.onSuccess();
        else listener.onFailure("Username or Password Mismatch");

    }
}
