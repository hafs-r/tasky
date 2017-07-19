package com.hafsalrahman.tasky.signin;

/**
 * @author hafsalrahman on 7/19/17.
 */

public class SignInPresenter {

    private static final int MAX_SIGNIN_ATTEMPT = 3;
    private final SignInView signInView;
    private int signInAttempt;

    public SignInPresenter(SignInView signInView) {
        this.signInView = signInView;
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

    public void doSignIn(String userName, String password) {
        if (isSignInAttemptExceeded()) {
            signInView.showMaxLoginAttemptError();
            return;
        }
        if (userName.length() > 0 && password.length() > 0) {
            if (userName.equals("hafsal")) {

                if (password.equals("tasky")) {

                    signInView.showLoginSuccess();

                    resetSignInAttempt();

                    return;

                } else {

                    signInView.showPasswordError();

                }

            } else {

                signInView.showUsernameError();

            }
        } else {
            signInView.showWhenAnyOfInputIsEmpty();
        }

        // increment login attempt only if it's fail
        incrementSignInAttempt();

    }
}
