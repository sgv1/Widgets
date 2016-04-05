package com.android.widgets.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by santi on 4/04/16.
 */
public class MyBaseAdapter extends BaseAdapter {


    List<ListMarca> myList = new ArrayList<ListMarca>();
    LayoutInflater inflater;
    Context context;

    public MyBaseAdapter(Context context, List<ListMarca> myList) {
        this.myList = myList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public ListMarca getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listitem, parent);
            mViewHolder = new MyViewHolder();
            mViewHolder.textListItem = (TextView) convertView.findViewById(R.id.textListItem);
            mViewHolder.imageListItem = (ImageView) convertView.findViewById(R.id.imageListItem);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        mViewHolder.textListItem.setText(myList.get(position).getTitle());
        mViewHolder.imageListItem.setImageResource(myList.get(position).getImgResId());
        return convertView;
    }

    private TextView detail(View v, String text) {
        TextView tv = (TextView) v.findViewById(R.id.textListItem);
        tv.setText(text);
        return tv;
    }

    private ImageView detail(View v, int resId, int icon) {
        ImageView iv = (ImageView) v.findViewById(resId);
        iv.setImageResource(icon);
        return iv;
    }

    private class MyViewHolder {
        TextView textListItem;
        ImageView imageListItem;
    }
}

