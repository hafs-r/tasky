package com.hafsalrahman.tasky.signin;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 * Created by hafsal on 7/19/17.
 */


public class SignInPresenterTest {


    @Test
    public void checkIfSIgnInAttemptIsExceeded() throws Exception {

        SignInView signInView = mock(SignInView.class);
        SignInPresenter loginPresenter = new SignInPresenter(signInView);
        Assert.assertEquals(1, loginPresenter.incrementSignInAttempt());
        Assert.assertEquals(2, loginPresenter.incrementSignInAttempt());
        Assert.assertEquals(3, loginPresenter.incrementSignInAttempt());
        Assert.assertTrue(loginPresenter.isSignInAttemptExceeded());
    }

    @Test
    public void checkIfSignAttemptIsNotExceeded() throws Exception {
        SignInView loginView = mock(SignInView.class);
        SignInPresenter loginPresenter = new SignInPresenter(loginView);
        Assert.assertFalse(loginPresenter.isSignInAttemptExceeded());
    }

    @Test
    public void checkIfUsernameIsIncorrect() throws Exception {
        SignInView loginView = mock(SignInView.class);
        SignInPresenter loginPresenter = new SignInPresenter(loginView);
        loginPresenter.doSignIn("incorrect", "tasky");
        verify(loginView).showUsernameError();
    }

    @Test
    public void checkIfPasswordIsCorrect() throws Exception {
        SignInView loginView = mock(SignInView.class);
        SignInPresenter loginPresenter = new SignInPresenter(loginView);
        loginPresenter.doSignIn("hafsal", "incorrect");
        verify(loginView).showPasswordError();
    }

    @Test
    public void checkIfSignInIsSucceed() throws Exception {
        SignInView loginView = mock(SignInView.class);
        SignInPresenter loginPresenter = new SignInPresenter(loginView);
        loginPresenter.doSignIn("hafsal", "tasky");
        verify(loginView).showLoginSuccess();
    }

}