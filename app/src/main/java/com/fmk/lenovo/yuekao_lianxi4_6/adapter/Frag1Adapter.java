package com.fmk.lenovo.yuekao_lianxi4_6.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.fmk.lenovo.yuekao_lianxi4_6.R;
import com.fmk.lenovo.yuekao_lianxi4_6.jsonbean.JsonBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * @Auther: 付明锟
 * @Date: 2019/4/6 15:05:11
 * @Description:
 */
public class Frag1Adapter extends XRecyclerView.Adapter<Frag1Adapter.Holder> {

    public List<JsonBean.DataBean> list;
    public Context mContext;

    public Frag1Adapter(List<JsonBean.DataBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frag1_item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        boolean select = list.get(i).isSelect();
        holder.main_item_checkBox.setChecked(select);

        String sellerName = list.get(i).getSellerName();
        holder.main_item_shang.setText(sellerName);

        //布局管理器
        LinearLayoutManager linear = new LinearLayoutManager(mContext);
        linear.setOrientation(LinearLayoutManager.VERTICAL);
        holder.main_item_rec.setLayoutManager(linear);

        //适配器
        Frag1_2Adapter frag1_2Adapter = new Frag1_2Adapter(list.get(i).getList(),mContext);
        holder.main_item_rec.setAdapter(frag1_2Adapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends XRecyclerView.ViewHolder {

        public final CheckBox main_item_checkBox;
        public final RecyclerView main_item_rec;
        public final TextView main_item_shang;

        public Holder(@NonNull View itemView) {
            super(itemView);
            main_item_checkBox = itemView.findViewById(R.id.main_item_CheckBox);
            main_item_rec = itemView.findViewById(R.id.main_item_rec);
            main_item_shang = itemView.findViewById(R.id.main_item_shang);
        }
    }
}
