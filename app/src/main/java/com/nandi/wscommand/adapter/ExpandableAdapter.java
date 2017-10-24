package com.nandi.wscommand.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.nandi.wscommand.R;

import java.util.List;
import java.util.Map;

/**
 * Created by ChenPeng on 2017/10/23.
 */

public class ExpandableAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> parent;
    private Map<String,List<String>> child;

    public ExpandableAdapter(Context context, List<String> parent, Map<String, List<String>> child) {
        this.context = context;
        this.parent = parent;
        this.child = child;
    }

    @Override
    public int getGroupCount() {
        return parent.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return child.get(parent.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return parent.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return child.get(parent.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        ParentHolder holder;
        if (view==null){
            view= LayoutInflater.from(context).inflate(R.layout.item_parent_view,null);
            holder=new ParentHolder();
            holder.tvName= (TextView) view.findViewById(R.id.tv_name);
            view.setTag(holder);
        }else {
            holder= (ParentHolder) view.getTag();
        }
        holder.tvName.setText(parent.get(i));
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildHolder holder;
        if (view==null){
            view=LayoutInflater.from(context).inflate(R.layout.item_child_view,null);
            holder=new ChildHolder();
            holder.tvName= (TextView) view.findViewById(R.id.tv_name);
            view.setTag(holder);
        }else {
            holder= (ChildHolder) view.getTag();
        }
        holder.tvName.setText(child.get(parent.get(i)).get(i1));
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
    private class ParentHolder{
        TextView tvName;
    }
    private class ChildHolder{
        TextView tvName;
    }
}
