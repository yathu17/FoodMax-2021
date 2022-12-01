package com.example.foodmax;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends BaseAdapter {

    // for grid view
    private Context context;
    private LayoutInflater inflater;
    private String[] foodlist;
    private String[] pricelist;
    private int[] foodImg;


    public MainAdapter(Context c, String[] foodlist, String[] pricelist, int[] foodImg) {
        context = c;

        this.foodlist = foodlist;
        this.pricelist = pricelist;
        this.foodImg = foodImg;
    }


    @Override
    public int getCount() {
        return foodlist.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_item, null);

        }
//for show item in single activity & grid view when i click grid view products it shows food name
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.textView);
        TextView textView2 = convertView.findViewById(R.id.textView2);

        imageView.setImageResource(foodImg[position]);
        textView.setText(foodlist[position]);
        textView2.setText(pricelist[position]);
        return convertView;
    }


}
