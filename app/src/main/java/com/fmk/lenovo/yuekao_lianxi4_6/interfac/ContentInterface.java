package com.fmk.lenovo.yuekao_lianxi4_6.interfac;

/**
 * @Auther: 付明锟
 * @Date: 2019/4/6 14:17:24
 * @Description:
 */
public class ContentInterface {

    //V层
    public interface VInterface{
        public void showShu(Object object);
    }

    //P层
    public interface PInterface{
        public void onZhan(int uid);
        public void onDsply();
    }

}
