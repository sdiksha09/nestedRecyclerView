package com.example.shipra.reciclerviewapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class programmingAdapter extends RecyclerView.Adapter<programmingAdapter.programmingViewHolder> {
    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;


    private static final int TOTAL = 2;

    ArrayList<listProvider> arrayList;
    private Context mContext;
    private  Context context;

    // public String[] data;

    public programmingAdapter(ArrayList<listProvider> arrayList) {
        //this.data =data;
        this.arrayList = new ArrayList<listProvider>();
        this.arrayList = arrayList;



    }


    public programmingAdapter(TextView arrayList) {
    }

    //create views
    @Override
    public programmingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_LIST) {
            return new programmingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false)
                    , viewType);
        } else if (viewType == TYPE_HEAD) {




            return new programmingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false)
                    , viewType);


        }
        return null;
    }

//bind data


    @Override
    public void onBindViewHolder(programmingViewHolder holder, int position) {
        listProvider listprovider;



        if (holder.view_type == TYPE_LIST) {

            final String[] rec_item={"a","b","c","d","e","f","g","h","k","l,","m","n","p","q","r","s","t","u","v","w","x","y","z"};

            SingleItemAdapter itemAdapter= new SingleItemAdapter(rec_item);


            holder.txtTitle.setHasFixedSize(false);
            holder.txtTitle.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
            holder.txtTitle.setAdapter(itemAdapter);

           // define interface for selecting an item




            //listprovider = arrayList.get(position - 1);
            // String title= data[position];
           // holder.txtTitle.setText(listprovider.getName());


        } else if (holder.view_type == TYPE_HEAD) {


           // holder.txtheader.setText(" this is Header");
        }

        //listprovider = arrayList.get(position);
        // String title= data[position];
       // holder.txtTitle.setText(listprovider.getName());

    }

    @Override
    public int getItemCount() {
        return TOTAL;
    }

    public class programmingViewHolder extends RecyclerView.ViewHolder {
        int view_type;

        RecyclerView txtTitle;
        TextView txtheader;


        public programmingViewHolder(View itemView, int viewtype) {
            super(itemView);
            if (viewtype == TYPE_LIST) {

                txtTitle = (RecyclerView) itemView.findViewById(R.id.textTitle);



                view_type = 1;
            } else if (viewtype == TYPE_HEAD) {
                txtheader = (TextView) itemView.findViewById(R.id.header_txt);
                view_type = 0;
            }

        }

    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0)
            return TYPE_HEAD;
        else
            return TYPE_LIST;


    }
}

