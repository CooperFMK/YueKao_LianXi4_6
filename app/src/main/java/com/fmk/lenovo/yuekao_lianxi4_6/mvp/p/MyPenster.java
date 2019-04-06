package com.fmk.lenovo.yuekao_lianxi4_6.mvp.p;

import com.fmk.lenovo.yuekao_lianxi4_6.interfac.ContentInterface;
import com.fmk.lenovo.yuekao_lianxi4_6.mvp.m.MyModel;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 付明锟
 * @Date: 2019/4/6 14:27:39
 * @Description:
 */
public class MyPenster<T> implements ContentInterface.PInterface {

    public MyModel myModel;
    public T tt;

    public MyPenster(T tt) {
        myModel = new MyModel();
        this.tt = tt;
    }

    @Override
    public void onZhan(int uid) {
        String purl="http://172.17.8.100/ks/product/getCarts";
        Map<String,String>map = new HashMap<>();
        map.put("uid","51");
        myModel.setMyCallBack(new MyModel.MyCallBack() {
            @Override
            public void succer(Object object) {
                ((ContentInterface.VInterface)tt).showShu(object);
            }
        });
        myModel.doGet(purl,map);
    }

    @Override
    public void onDsply() {
         if (tt!=null){
             tt=null;
         }
    }
}
