package com.hafsalrahman.tasky.data;

import com.hafsalrahman.tasky.data.local.AppLocalDataStore;
import com.hafsalrahman.tasky.data.model.Post;
import com.hafsalrahman.tasky.data.remote.AppRemoteDataStore;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by hafsalrahman on 23-Oct-16.
 */

public class AppRepository implements AppDataStore {

    private AppLocalDataStore mAppLocalDataStore;
    private AppRemoteDataStore mAppRemoteDataStore;


    @Inject
    public AppRepository(AppLocalDataStore mAppLocalDataStore, AppRemoteDataStore mAppRemoteDataStore) {
        this.mAppLocalDataStore = mAppLocalDataStore;
        this.mAppRemoteDataStore = mAppRemoteDataStore;
    }

    @Override
    public Observable<List<Post>> getPost() {
//        return Observable.concat(mAppLocalDataStore.getPost(), mAppRemoteDataStore.getPost())
//                .first(new Function<List<Post>, Boolean>() {
//                    @Override
//                    public Boolean apply(List<Post> posts) {
//                        //Commeted this log due Arrayindexoutofbound exception at first lauch of application
////                        Log.d("Repo", posts.get(0).getTitle());
//                        return posts != null;
//                    }
        // });
        return null;
    }
}
