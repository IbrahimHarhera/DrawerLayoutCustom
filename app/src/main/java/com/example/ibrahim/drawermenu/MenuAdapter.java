package com.example.ibrahim.drawermenu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ibrahim on 5/14/2017.
 */

public class MenuAdapter extends BaseAdapter {
    private Context context;
    private List<MenuItem> lstItem;

    public MenuAdapter(Context context, List<MenuItem> lstItem) {
        this.context = context;
        this.lstItem = lstItem;
    }


    @Override
    public int getCount() {
        return lstItem.size();
    }

    @Override
    public Object getItem(int position) {
        return lstItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=View.inflate(context, R.layout.list_item,null);
        ImageView imageView=(ImageView)view.findViewById(R.id.img_menu_item);
        TextView textView=(TextView)view.findViewById(R.id.tv_menu_item);

        MenuItem itemSlideMenu=lstItem.get(position);
        imageView.setImageResource(itemSlideMenu.getImgId());
        textView.setText(itemSlideMenu.getTitle());
        return view;
    }
}
