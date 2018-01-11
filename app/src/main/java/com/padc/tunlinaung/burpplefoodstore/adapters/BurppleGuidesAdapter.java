package com.padc.tunlinaung.burpplefoodstore.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.tunlinaung.burpplefoodstore.R;
import com.padc.tunlinaung.burpplefoodstore.viewholders.ItemBurppleGuidesViewHolder;

/**
 * Created by eidoshack on 1/10/18.
 */

public class BurppleGuidesAdapter extends RecyclerView.Adapter<ItemBurppleGuidesViewHolder> {
    @Override
    public ItemBurppleGuidesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_burpple_guides, parent, false);

        ItemBurppleGuidesViewHolder viewHolder = new ItemBurppleGuidesViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemBurppleGuidesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
