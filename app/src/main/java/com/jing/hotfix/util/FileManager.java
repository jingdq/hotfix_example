package com.jing.hotfix.util;

import android.os.Environment;

import java.io.File;


public class FileManager {

    private static final String BASE_PATH = "hotfix";
    private static final String IMAGE = "image";
    private static final String TEMP_FILE = "temp_file";
    private static final String LOG = "log";
    private static final String DEBUG = "debug";

    public static boolean isSDCardAvailable() {

        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    private static File getBasepath() {
        File appCacheDir = null;
        if (isSDCardAvailable()) {
            appCacheDir = new File(Environment.getExternalStorageDirectory(), BASE_PATH);
        }
        if (!appCacheDir.exists())
            appCacheDir.mkdirs();
        return appCacheDir;
    }

    private static File getPath(String fileName) {
        File file = new File(getBasepath(), fileName);
        if (!file.exists())
            file.mkdirs();
        return file;
    }

    private static boolean checkFileIsExist(String fileName) {
        File file = new File(getBasepath(), fileName);
        return file.exists();
    }


    public static String getHotFixPath() {

        File file = new File(getBasepath(), "test.apatch");

        if (!file.exists()) {
            return null;
        } else {
            return file.getAbsolutePath();
        }

    }

}
