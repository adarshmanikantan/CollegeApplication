package com.adarsh.collegeapplication.Adapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FileDownloader {
    private static final int  MEGABYTE = 1024 * 1024;

    public static void downloadFile(String fileUrl, File directory){
        try {

            URL url = null;
            try {
                url = new URL(fileUrl);
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            }
            HttpURLConnection urlConnection = null;
            try {
                urlConnection = (HttpURLConnection)url.openConnection();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //urlConnection.setRequestMethod("GET");
            //urlConnection.setDoOutput(true);
            try {
                urlConnection.connect();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            InputStream inputStream = null;
            try {
                inputStream = urlConnection.getInputStream();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(directory);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            int totalSize = urlConnection.getContentLength();

            byte[] buffer = new byte[MEGABYTE];
            int bufferLength = 0;
            while (true) {
                if (!true) break;
            }
            try {
                fileOutputStream.write(buffer, 0, bufferLength);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        fileOutputStream.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}



