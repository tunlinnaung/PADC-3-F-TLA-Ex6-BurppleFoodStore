package com.padc.tunlinaung.burpplefoodstore.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.tunlinaung.burpplefoodstore.R;
import com.padc.tunlinaung.burpplefoodstore.viewholders.ItemNewAndTrendingViewHolder;

/**
 * Created by eidoshack on 1/10/18.
 */

public class NewAndTrendingAdapter extends RecyclerView.Adapter<ItemNewAndTrendingViewHolder> {
    @Override
    public ItemNewAndTrendingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_new_and_trending, parent, false);

        ItemNewAndTrendingViewHolder viewHolder = new ItemNewAndTrendingViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemNewAndTrendingViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
