package com.hafsalrahman.tasky.data.local;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.hafsalrahman.tasky.data.AppDataStore;


import com.hafsalrahman.tasky.data.local.models.Post;
import com.pushtorefresh.storio.contentresolver.ContentResolverTypeMapping;
import com.pushtorefresh.storio.contentresolver.StorIOContentResolver;
import com.pushtorefresh.storio.contentresolver.impl.DefaultStorIOContentResolver;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 *
 * Created by hafsalrahman on 23-Oct-16.
 */

public class AppLocalDataStore implements AppDataStore {

    private StorIOContentResolver mStorIOContentResolver;

    @Inject
    public AppLocalDataStore(@NonNull Context context) {
        mStorIOContentResolver = DefaultStorIOContentResolver.builder()
                .contentResolver(context.getContentResolver())
                .addTypeMapping(Post.class, ContentResolverTypeMapping.<Post>builder()
                        .putResolver(null)//new PostStorIOContentResolverPutResolver())
                        .getResolver(null)//new PostStorIOContentResolverGetResolver())
                        .deleteResolver(null)//new PostStorIOContentResolverDeleteResolver())
                        .build()
                ).build();
    }


    @Override
    public Observable<List<Post>> getPost() {
        Log.d("LOCAL","Loaded from local");
//        return mStorIOContentResolver.get()
//                .listOfObjects(Post.class)
//                .withQuery(Query.builder().uri(DatabaseContract.Post.CONTENT_URI).build())
//                .prepare()
//                .asRxObservable();
        return null;
    }

    public void savePostToDatabase(List<Post> posts) {
        mStorIOContentResolver.put().objects(posts).prepare().executeAsBlocking();
    }

    public void saveSinglePostToDatabase(Post post) {
        mStorIOContentResolver.put().object(post).prepare().executeAsBlocking();
    }
}
