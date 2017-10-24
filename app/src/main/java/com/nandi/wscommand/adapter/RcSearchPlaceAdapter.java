package com.nandi.wscommand.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nandi.wscommand.R;
import com.nandi.wscommand.entity.SearchPlace;

/**
 * Created by lemon on 2017/7/25.
 */

public class RcSearchPlaceAdapter extends RecyclerView.Adapter<RcSearchPlaceAdapter.ViewHolderA>{
    private Context mContext;
    private SearchPlace mSearchPlace;
    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public RcSearchPlaceAdapter(Context context, SearchPlace searchPlace) {
        mContext = context;
        mSearchPlace =  searchPlace;
    }


    public interface OnItemClickListener{
        void onItemClick(View view);
    }
    @Override
    public ViewHolderA onCreateViewHolder(ViewGroup parent, int viewType) {
        //此处动态加载ViewHolder的布局文件并返回holder
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycleview_search_place,parent, false);
        ViewHolderA holderA = new ViewHolderA(view);
        return holderA;
    }

    @Override
    public void onBindViewHolder(ViewHolderA holder, int position) {
        holder.tv_1.setText(mSearchPlace.getData().get(position).getName());
        holder.tv_2.setText(mSearchPlace.getData().get(position).getType_name());
        holder.tv_3.setText(mSearchPlace.getData().get(position).getNumber());

    }

    @Override
    public int getItemCount() {
        //生成的item的数量
        return mSearchPlace.getData().size();
    }

    //Item的ViewHolder以及item内部布局控件的id绑定
    class ViewHolderA extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tv_1;
        TextView tv_2;
        TextView tv_3;
        TextView tv_4;
        public ViewHolderA(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tv_1 = (TextView) itemView.findViewById(R.id.tv_search_1);
            tv_2 = (TextView) itemView.findViewById(R.id.tv_search_2);
            tv_3 = (TextView) itemView.findViewById(R.id.tv_search_3);
            tv_4 = (TextView) itemView.findViewById(R.id.tv_search_4);
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view);
            }
        }
    }

}
