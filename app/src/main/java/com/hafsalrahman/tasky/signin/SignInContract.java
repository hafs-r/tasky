package com.hafsalrahman.tasky.signin;

import com.hafsalrahman.tasky.task.Task;

import java.util.List;

/**
 * Created by hafsal on 7/23/17.
 */

public class SignInContract {
    interface View {

        void signInSuccess();

        void showError(String message);


    }

    interface Presenter {
        void signIn(String username,String password);
    }

}
