package com.mobotechnology.bipinpandey.retrofit_handdirty;

public interface LoginContract {

    interface Presenter {
        void performLogin(LoginModel loginModel);
        void onDestroy();
    }

    interface LoginView {
        void onPasswordEmpty();

        void onUserEmpty();

        void onLoginFailed(String reason);

        void onLoginSuccess();
    }

    interface GetLoginInteractor {
        interface LoginFinishedListener {
            void onSuccess();

            void onFailure(String reason);
        }

        void getLogin(LoginFinishedListener listener, LoginModel loginModel);
    }
}
