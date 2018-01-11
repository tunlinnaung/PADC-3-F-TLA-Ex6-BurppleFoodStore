package com.padc.tunlinaung.burpplefoodstore.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.tunlinaung.burpplefoodstore.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eidoshack on 1/10/18.
 */

public class ItemPromotionsViewHolder extends RecyclerView.ViewHolder
{

    @BindView(R.id.iv_promotion_item)
    ImageView ivPromotionItem;

    @BindView(R.id.tv_promotion_item_category)
    TextView getTvPromotionItemCategory;

    @BindView(R.id.tv_promotion_item_title)
    TextView tvPromotionItemTitle;

    @BindView(R.id.tv_promotion_item_date)
    TextView tvPromotionItemDate;

    public ItemPromotionsViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);


    }
}
