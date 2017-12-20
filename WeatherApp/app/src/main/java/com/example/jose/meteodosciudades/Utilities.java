package com.example.jose.meteodosciudades;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.util.Log;

import org.apache.http.params.HttpConnectionParams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jose on 2/04/17.
 */

public class Utilities {

    private static byte[] bitmapRdo = null;

    public static boolean isNetworkAvailable(Context context) {
        boolean rdo = false;
        ConnectivityManager connectivity = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {

            //NetworkInfo info = connectivity.getActiveNetworkInfo();
            NetworkInfo[] info = connectivity.getAllNetworkInfo();  // Esta línea fallaba, pq no tenía permisos de acceso al estado de la red en el Manifest
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        rdo = true;
                    }
                }
            }
        }
        return rdo;
    }

    public static String sendPostRequest(String requestURL) {

        URL url;
        String line = "";
        String response = null;    // JR
        try {
            url = new URL(requestURL);
            //url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Madrid&appid=db87faa1ae2eb9f5b56d2d2bd6e11ff2&units=metric&lang=es");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Cache-Control", "no-cache");
            //conn.setReadTimeout(15000);
            //conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.connect();                 // JR


            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

            writer.flush();
            writer.close();
            os.close();
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                response = br.readLine();
                /*while ((line = br.readLine()) != null) {
                    response += line;                    // JR prueba
                } */
            }

            /*else {
                response = "Error Registering";
            } */
            conn.disconnect();               // JR

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    public static String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    private static InputStream OpenHttpConnection(String strURL) throws IOException {
        InputStream inputStream = null;
        URL url = new URL(strURL);
        URLConnection conn = url.openConnection();
        try{
            HttpURLConnection httpConn = (HttpURLConnection)conn;
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = httpConn.getInputStream();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } return inputStream;

    }

    private static void getInternetBitmapThread(Context context, String imageURL){
        InputStream in;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] data = new byte[16384];
        try {
            in = OpenHttpConnection(imageURL);

            int nRead;
            if (in !=null){

                while ((nRead = in.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, nRead);
                }

                buffer.flush();
                bitmapRdo = buffer.toByteArray();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static byte[] getInternetBitmap(final Context context, final String imageURL){
        byte[] rdo = null;
        if (isNetworkAvailable(context)){
            Thread getBitmap = new Thread()  {
                @Override
                public void run() {
                    synchronized(this){
                        getInternetBitmapThread(context, imageURL);
                    }
                }
            };
            getBitmap.start();
            try {
                getBitmap.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (bitmapRdo != null){
                rdo = bitmapRdo.clone();
            }
            bitmapRdo = null;
        }
        return rdo;
    }


}
