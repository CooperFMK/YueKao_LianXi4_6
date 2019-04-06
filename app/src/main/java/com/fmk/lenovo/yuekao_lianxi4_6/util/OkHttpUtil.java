package com.fmk.lenovo.yuekao_lianxi4_6.util;

import android.util.Log;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Auther: 付明锟
 * @Date: 2019/4/6 14:03:41
 * @Description:
 */
public class OkHttpUtil {

    public OkHttpClient okHttpClient;
    private static OkHttpUtil okHttpUtil;

    //构造方法私有化,拦截器
    private OkHttpUtil(){
        okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Log.e("tab","UrlRequest=="+request);
                Response proceed = chain.proceed(request);
                return proceed;
            }
        }).build();
    }

    //单例模式
    public static synchronized OkHttpUtil getInOkHttpUtil(){

        if (okHttpUtil==null){
            okHttpUtil = new OkHttpUtil();
        }
        return okHttpUtil;
    }

    //Get
    public void doGet(String url, Map<String,String> map, Callback callback){
        if (map!=null && map.size()>0){
            StringBuilder builder = new StringBuilder();
            for (String key : map.keySet()){
                String s = map.get(key);
                builder.append(key)
                        .append("=")
                        .append(s)
                        .append("&");
            }
            String str = builder.toString();
            int i = str.lastIndexOf("&");
            str = str.substring(0, i);
            url = url + "?" + str;

            Request request = new Request.Builder()
                    .get()
                    .url(url)
                    .build();
            Call call = okHttpClient.newCall(request);
            call.enqueue(callback);
        }
    }
}
