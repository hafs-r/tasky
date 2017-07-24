package com.hafsalrahman.tasky.signin;

import org.junit.Assert;
import org.junit.Test;

import retrofit2.Retrofit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 * Created by hafsal on 7/19/17.
 */


public class SignInPresenterTest {

    @Test
    public void checkIfSignInAttemptExceeded() throws Exception {
        SignInContract.View mView = mock(SignInContract.View.class);

        SignInPresenter loginPresenter = new SignInPresenter(null, mView);
        Assert.assertEquals(1, loginPresenter.incrementSignInAttempt());
        Assert.assertEquals(2, loginPresenter.incrementSignInAttempt());
        Assert.assertEquals(3, loginPresenter.incrementSignInAttempt());
        Assert.assertTrue(loginPresenter.isSignInAttemptExceeded());
    }

    @Test
    public void checkIfSignInIsSucceed() throws Exception {
        SignInContract.View mView = mock(SignInContract.View.class);

        SignInPresenter loginPresenter = new SignInPresenter(null, mView);
        loginPresenter.signIn("hafsal", "tasky");
        verify(mView).signInSuccess();
    }
}