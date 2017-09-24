package com.hafsalrahman.tasky.data;

import com.hafsalrahman.tasky.data.model.Post;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Hafsal on 23-Oct-16.
 */

public interface AppDataStore {
    Observable<List<Post>> getPost();
}
