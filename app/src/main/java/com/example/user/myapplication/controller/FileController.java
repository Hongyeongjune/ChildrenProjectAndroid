package com.example.user.myapplication.controller;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.example.user.myapplication.network.NetRetrofit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FileController {

    private static final String PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ChildrenProject";

    private boolean response;

    Context context;

    public FileController(Context context) {
        this.context = context;
    }

    public void createNHFile(String name) {
        Call<Void> call = NetRetrofit.getInstance().getNetRetrofitInterface().createNHFile(name);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public void createCIFile(String name) {
        Call<Void> call = NetRetrofit.getInstance().getNetRetrofitInterface().createCIFile(name);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public void createFilePath() {

        File excelDir = new File(PATH + "/ChildrenProject");

        if(!excelDir.exists()) {
            Log.d("Test : ", "createFilePath: exist");
            excelDir.mkdirs();
        }

    }

    public boolean confirmFile(String fileName) {

        File file = new File(PATH + "/" + fileName);

        if(!file.exists()) {
            return false;
        }
        else return true;
    }

    private boolean writeFileToDisk(ResponseBody responseBody, String fileName) {

        try {
            File file = new File(PATH + "/" + File.separator + fileName);

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[32768];
                long fileSize = responseBody.contentLength();
                long fileSizeDownloaded = 0;
                inputStream = responseBody.byteStream();
                outputStream = new FileOutputStream(file);

                while(true) {
                    int read = inputStream.read(fileReader);
                    if(read == -1)
                        break;

                    outputStream.write(fileReader, 0 , read);
                    fileSizeDownloaded += read;
                    Log.i("TAG : ", "file download: " + fileSizeDownloaded + " of " + fileSize);
                }

                outputStream.flush();
                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if(inputStream != null)
                    inputStream.close();
                if(outputStream != null)
                    outputStream.close();;
            }
        } catch (IOException e) {
            return false;
        }
    }

    public void downloadFileByFileName(final String fileName) {

        response = false;

        final Call<ResponseBody> call = NetRetrofit.getInstance().getNetRetrofitInterface().downloadFileByFileName(fileName);

        Log.d("Test : ", "downloadFileByName: exist");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<ResponseBody> respon = call.execute();
                    ResponseBody body;
                    if(respon.raw().code() == 200) {
                        Log.d("Test : ", "downloadFileByName: exist");
                        body = respon.body();
                    }
                    else {
                        Log.d("Test : ", "파일 다운 실패");
                        body = null;
                    }

                    boolean writtenToDisk = writeFileToDisk(body, fileName);
                    if(writtenToDisk) {
                        response = true;
                    }
                    else {
                        response = false;
                    }
                } catch (Exception e) {
                    response = false;
                }
            }
        }).start();

        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
