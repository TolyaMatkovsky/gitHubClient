package com.example.app.testapp.data.manager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Tolik on 11.02.2017.
 */

public final class ImageSaveManager {
    private static final String IMAGE_FOLDER = "/Files/User/Images";
    private static final String EXTENSION = ".png";

    public static void writeImage(Bitmap bitmap, String imageName) {
        File imageFile = getFileByImageName(imageName);
        Log.e("FILE", imageFile.getAbsolutePath());

        FileOutputStream out = null;

        try {
            out = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 85, out);
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Bitmap readImage(String imageName) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        File imageFile = getFileByImageName(imageName);

        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(new FileInputStream(imageFile), null, options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    private static File getFileByImageName(String fileName) {
        String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + IMAGE_FOLDER;
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        return new File(dir, fileName + EXTENSION);
    }

}
