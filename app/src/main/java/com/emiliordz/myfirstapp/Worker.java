package com.emiliordz.myfirstapp;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.lang.ref.WeakReference;

public class Worker extends AsyncTask <Uri, Void, Bitmap>  {
    private final static int IMAGE_WIDTH = 400;
    private WeakReference<ImageView> imageView;

    public Worker(ImageView imageView){
        this.imageView = new WeakReference<>(imageView);
    }
    @Override
    protected Bitmap doInBackground(Uri... uris) {
        Bitmap bitmap = null;
        if(this.imageView.get() != null && uris.length > 0){
            try {
                Uri imageUri = uris[0];
                bitmap = ImageUtils.getScaledBitmapFromUri(this.imageView.get().getContext(),imageUri, IMAGE_WIDTH);
                Thread.sleep(3000);
                this.imageView.get().setImageBitmap(bitmap);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            return bitmap;
        }
        return null;
    }
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        //El metodo onPostExecute se ejecuta en el UI thread, por lo que podemos asignar la imagen al imageView
        if (this.imageView.get() != null && bitmap != null){
            this.imageView.get().setImageBitmap(bitmap);
        }
    }
}