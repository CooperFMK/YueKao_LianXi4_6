package com.fmk.lenovo.yuekao_lianxi4_6.mvp.v;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.fmk.lenovo.yuekao_lianxi4_6.R;
import com.fmk.lenovo.yuekao_lianxi4_6.adapter.Frag1Adapter;
import com.fmk.lenovo.yuekao_lianxi4_6.interfac.ContentInterface;
import com.fmk.lenovo.yuekao_lianxi4_6.jsonbean.JsonBean;
import com.fmk.lenovo.yuekao_lianxi4_6.mvp.p.MyPenster;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 付明锟
 * @Date: 2019/4/6 14:10:01
 * @Description:
 */
public class Frag1 extends Fragment implements ContentInterface.VInterface {

    public List<JsonBean.DataBean> list = new ArrayList<>();
    public int uid = 51;
    public int pager = 0;
    public XRecyclerView rec_id;
    public ContentInterface.PInterface pInterface;
    public Frag1Adapter frag1Adapter;
    public CheckBox frag_CheckBox;
    public TextView frag_zong;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1,container,false);

        rec_id = view.findViewById(R.id.rec_id);
        frag_CheckBox = view.findViewById(R.id.frag_CheckBox);
        frag_zong = view.findViewById(R.id.frag_zong);
        pInterface = new MyPenster(this);
        init();


        return view;
    }

    private void init() {

        //实例化布局管理器
        LinearLayoutManager linear = new LinearLayoutManager(getActivity());
        linear.setOrientation(LinearLayoutManager.VERTICAL);
        rec_id.setLayoutManager(linear);

        pInterface.onZhan(uid);

        //适配器
        frag1Adapter = new Frag1Adapter(list,getActivity());
        rec_id.setAdapter(frag1Adapter);

        //上拉下拉,刷新
        rec_id.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                list.clear();
                pager=1;
                pInterface.onZhan(uid);
                rec_id.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                pager++;
                pInterface.onZhan(uid);
                rec_id.loadMoreComplete();
            }
        });

        //全选反选
        frag_CheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frag_CheckBox.isChecked()){
                    //setChecAll
                }else{

                }
            }
        });
    }

    //全选反选


    @Override
    public void showShu(Object object) {
        JsonBean jsonBean = (JsonBean)object;
        List<JsonBean.DataBean> data = jsonBean.getData();
        data.remove(0);
        list.addAll(data);
        frag1Adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        pInterface.onDsply();
        pInterface = null;
    }
}
