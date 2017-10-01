package com.hafsalrahman.tasky.data.remote;




import com.hafsalrahman.tasky.TaskyApplication;
import com.hafsalrahman.tasky.data.AppDataStore;
import com.hafsalrahman.tasky.data.local.AppLocalDataStore;
import com.hafsalrahman.tasky.data.local.models.Post;


import java.util.List;

import javax.inject.Inject;
import io.reactivex.Observable;

import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;
import retrofit2.http.GET;


/**
 * Created by hafsalrahman on 23-Oct-16.
 */

public class AppRemoteDataStore implements AppDataStore {

    @Inject
    Retrofit retrofit;

    @Inject
    AppLocalDataStore appLocalDataStore;

    public AppRemoteDataStore() {
        TaskyApplication.getNetComponent().inject(this);
    }


//    @Override
//    public Observable<List<Post>> getPost() {
//        Log.d("REMOTE","Loaded from remote");
//
////        return retrofit.create(PostService.class).getPostList().doOnNext(new Consumer<List<Post>>() {
////            @Override
////            public void accept(List<Post> posts) {
////                appLocalDataStore.savePostToDatabase(posts);
////            }
////        });
//        return new Observable<List<Post>>() {
//            @Override
//            protected void subscribeActual(Observer<? super List<Post>> observer) {
//
//            }
//        };
//    }


    @Override
    public Observable<List<Post>> getPost() {
        return retrofit.create(PostService.class).getPostList().doOnNext(new Consumer<List<Post>>() {
            @Override
            public void accept(List<Post> posts) {
                appLocalDataStore.savePostToDatabase(posts);
            }
        });

    }

    private interface PostService {
        @GET("/posts")
        Observable<List<Post>> getPostList();
    }
}
