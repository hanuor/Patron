package com.hanuor.patron.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanuor.patron.R;

import java.util.List;

/**
 * Created by Shantanu Johri on 28-07-2016.
 */
public class RealmRecycler extends RecyclerView.Adapter<ReyclerViewHolders>{


    private List<String> itemList;
    private Context context;

    public RealmRecycler(Context context, List<String> itemList) {
        this.itemList = itemList;
        this.context = context;
    }


    @Override
    public ReyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_single_item, null);
        ReyclerViewHolders rcv = new ReyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(ReyclerViewHolders holder, int position) {
        holder.countryName.setText(itemList.get(position));
    }


    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
