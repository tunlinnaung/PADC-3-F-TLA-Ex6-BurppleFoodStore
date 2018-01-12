package com.padc.tunlinaung.burpplefoodstore.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.tunlinaung.burpplefoodstore.R;
import com.padc.tunlinaung.burpplefoodstore.data.vo.PromotionsVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eidoshack on 1/10/18.
 */

public class ItemPromotionsViewHolder extends RecyclerView.ViewHolder
{

    @BindView(R.id.iv_guide_item)
    ImageView ivPromotionItem;

    @BindView(R.id.tv_promotion_item_category)
    TextView tvPromotionItemCategory;

    @BindView(R.id.tv_promotion_item_title)
    TextView tvPromotionItemTitle;

    @BindView(R.id.tv_promotion_item_date)
    TextView tvPromotionItemDate;

    public ItemPromotionsViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void setPromotions(PromotionsVO promotionsVO) {
        this.tvPromotionItemTitle.setText(promotionsVO.getTitle());
        this.tvPromotionItemDate.setText(promotionsVO.getUntilTime());

        Glide.with(ivPromotionItem.getContext())
                .load(promotionsVO.getImage())
                .into(ivPromotionItem);
    }
}
