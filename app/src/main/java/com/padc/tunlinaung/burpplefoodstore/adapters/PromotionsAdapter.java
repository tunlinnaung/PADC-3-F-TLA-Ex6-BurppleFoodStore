package com.padc.tunlinaung.burpplefoodstore.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.tunlinaung.burpplefoodstore.R;
import com.padc.tunlinaung.burpplefoodstore.viewholders.ItemPromotionsViewHolder;

/**
 * Created by eidoshack on 1/10/18.
 */

public class PromotionsAdapter extends RecyclerView.Adapter<ItemPromotionsViewHolder> {
    @Override
    public ItemPromotionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_promotions, parent, false);

        ItemPromotionsViewHolder viewHolder = new ItemPromotionsViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemPromotionsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
