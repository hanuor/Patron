package com.hanuor.patron.Launcher;

import android.app.Application;

import com.shephertz.app42.paas.sdk.android.App42API;

/**
 * Created by Shantanu Johri on 18-07-2016.
 */
public class Init extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        App42API.initialize(this, "6b70c1a89e00531992d12b0df5fa65ea9e62fc0490f8a909c5ce06f6f292aace","eb43c4d20d6c526862a3afda36f1eebe777ba6ade8950892363c48242b39e566");
    }
}
