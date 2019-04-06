package com.fmk.lenovo.yuekao_lianxi4_6.mvp.m;

import android.os.Handler;
import android.os.Message;

import com.fmk.lenovo.yuekao_lianxi4_6.jsonbean.JsonBean;
import com.fmk.lenovo.yuekao_lianxi4_6.util.OkHttpUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import java.util.zip.ZipEntry;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @Auther: 付明锟
 * @Date: 2019/4/6 14:22:38
 * @Description:
 */
public class MyModel {

    public MyCallBack myCallBack;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int type = msg.arg1;
            String string = (String) msg.obj;
            if (type==1){
                Gson gson = new Gson();
                JsonBean jsonBean = gson.fromJson(string, JsonBean.class);
                myCallBack.succer(jsonBean);
            }
        }
    };


    //Get
    public void doGet(String url, final Map<String,String>map){
        OkHttpUtil okHttpUtil = OkHttpUtil.getInOkHttpUtil();
        okHttpUtil.doGet(url, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Message message = new Message();
                message.arg1 = 1;
                message.obj = string;
                handler.sendMessage(message);
            }
        });
    }

    public void setMyCallBack(MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
    }

    //内部接口
    public interface MyCallBack{
        public void succer(Object object);
    }
}
