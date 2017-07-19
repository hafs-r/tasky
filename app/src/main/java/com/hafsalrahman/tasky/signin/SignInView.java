package com.hafsalrahman.tasky.signin;

/**
 * @author  hafsalrahman on 7/19/17.
 */

public interface SignInView {

    void showWhenAnyOfInputIsEmpty();

    void showPasswordError();

    void showUsernameError();

    void showMaxLoginAttemptError();

    void showLoginSuccess();
}
