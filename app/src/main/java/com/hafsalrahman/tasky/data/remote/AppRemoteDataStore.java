package com.hafsalrahman.tasky.data.remote;

import android.util.Log;

import com.ladwa.hafsalrahman.offlinefirstapp.App;
import com.ladwa.hafsalrahman.offlinefirstapp.data.AppDataStore;
import com.ladwa.hafsalrahman.offlinefirstapp.data.local.AppLocalDataStore;
import com.ladwa.hafsalrahman.offlinefirstapp.data.local.models.Post;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by hafsalrahman on 23-Oct-16.
 */

public class AppRemoteDataStore implements AppDataStore {

    @Inject
    Retrofit retrofit;

    @Inject
    AppLocalDataStore appLocalDataStore;

    public AppRemoteDataStore() {
        App.getAppComponent().inject(this);
    }


    @Override
    public Observable<List<Post>> getPost() {
        Log.d("REMOTE","Loaded from remote");

        return retrofit.create(PostService.class).getPostList().doOnNext(new Action1<List<Post>>() {
            @Override
            public void call(List<Post> posts) {
                appLocalDataStore.savePostToDatabase(posts);
            }
        });
    }


    private interface PostService {
        @GET("/posts")
        Observable<List<Post>> getPostList();
    }
}
