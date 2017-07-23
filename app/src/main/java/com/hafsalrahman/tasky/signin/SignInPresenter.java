package com.hafsalrahman.tasky.signin;

import javax.inject.Inject;
import retrofit2.Retrofit;

/**
 * @author hafsalrahman on 7/19/17.
 */

public class SignInPresenter implements SignInContract.Presenter {

    private static final int MAX_SIGNIN_ATTEMPT = 3;
    Retrofit retrofit;
    SignInContract.View mView;
    private int signInAttempt;

    @Inject
    public SignInPresenter(Retrofit retrofit, SignInContract.View mView) {
        this.retrofit = retrofit;
        this.mView = mView;
    }

    public int incrementSignInAttempt() {
        signInAttempt = signInAttempt + 1;
        return signInAttempt;
    }

    public void resetSignInAttempt() {
        signInAttempt = 0;
    }

    public boolean isSignInAttemptExceeded() {
        return signInAttempt >= MAX_SIGNIN_ATTEMPT;
    }

    @Override
    public void signIn(String username, String password) {

        String errorMesage = null;

        if (isSignInAttemptExceeded()) {

            errorMesage = "Maximum sign in attempt reached";

        } else if (username.length() > 0 && password.length() > 0) {

            if (username.equals("hafsal")) {

                if (password.equals("tasky")) {

                    mView.signInSuccess();
                    resetSignInAttempt();

                    return;

                } else {

                    errorMesage = "Password Error";
                }

            } else {

                errorMesage = "Username Error";

            }

        } else {

            errorMesage = "Input Empty Error";

        }

        incrementSignInAttempt();

        if (errorMesage != null) {

            mView.showError(errorMesage);

        }
    }


}
