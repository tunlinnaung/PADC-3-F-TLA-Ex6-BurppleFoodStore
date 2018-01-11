package com.padc.tunlinaung.burpplefoodstore.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.padc.tunlinaung.burpplefoodstore.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eidoshack on 1/10/18.
 */

public class ItemBurppleGuidesViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_burpple_guide_item_status)
    TextView tvBurppleGuideItemStatus;

    @BindView(R.id.tv_burpple_guide_item_title)
    TextView tvBurppleGuideItemTitle;

    @BindView(R.id.tv_burpple_guide_item_icon)
    TextView getTvBurppleGuideItemIcon;

    public ItemBurppleGuidesViewHolder(View itemView)
    {
        super(itemView);

        ButterKnife.bind(this, itemView);


    }

}
