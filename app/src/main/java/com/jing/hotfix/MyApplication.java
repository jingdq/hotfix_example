package com.jing.hotfix;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.util.Log;

import com.alipay.euler.andfix.patch.PatchManager;
import com.jing.hotfix.util.FileManager;

/**
 * Created by jimi on 11/19/15.
 */
public class MyApplication extends Application {

    PatchManager patchManager;

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0);
            patchManager = new PatchManager(this);
            patchManager.init(packageInfo.versionName);//current version

            // load patch
            patchManager.loadPatch();

            String hotfixPath = FileManager.getHotFixPath();

            if (hotfixPath != null) {

                Log.e("aaa", "add path");

                patchManager.addPatch(hotfixPath);
            }else{

                Log.e("aaa", "not add path");
            }

        } catch (Exception e) {


        }
    }
}
