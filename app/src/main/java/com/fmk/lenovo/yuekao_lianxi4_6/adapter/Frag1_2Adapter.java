package com.fmk.lenovo.yuekao_lianxi4_6.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fmk.lenovo.yuekao_lianxi4_6.R;
import com.fmk.lenovo.yuekao_lianxi4_6.jsonbean.JsonBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * @Auther: 付明锟
 * @Date: 2019/4/6 15:05:11
 * @Description:
 */
public class Frag1_2Adapter extends XRecyclerView.Adapter<Frag1_2Adapter.Holder> {

    public List<JsonBean.DataBean.ListBean> list;
    public Context mContext;

    public Frag1_2Adapter(List<JsonBean.DataBean.ListBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frag2_item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        boolean select = list.get(i).isItemSelect();
        holder.frag_item2_CheckBox.setChecked(select);

        String sellerName = list.get(i).getTitle();
        holder.frag_item2_name.setText(sellerName);

        String price = list.get(i).getPrice()+"";
        holder.frag_item2_pice.setText(price);

        String images = list.get(i).getImages();
        Glide.with(mContext).load(images).into(holder.frag_item2_ImageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends XRecyclerView.ViewHolder {

        public  CheckBox frag_item2_CheckBox;
        public  ImageView frag_item2_ImageView;
        public  TextView frag_item2_name,frag_item2_pice;

        public Holder(@NonNull View itemView) {
            super(itemView);
            frag_item2_CheckBox = itemView.findViewById(R.id.frag_item2_CheckBox);
            frag_item2_ImageView = itemView.findViewById(R.id.frag_item2_ImageView);
            frag_item2_name = itemView.findViewById(R.id.frag_item2_name);
            frag_item2_pice = itemView.findViewById(R.id.frag_item2_pice);
        }
    }
}
