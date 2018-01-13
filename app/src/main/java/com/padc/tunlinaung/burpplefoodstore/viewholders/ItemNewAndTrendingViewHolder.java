package com.padc.tunlinaung.burpplefoodstore.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.padc.tunlinaung.burpplefoodstore.R;
import com.padc.tunlinaung.burpplefoodstore.data.vo.FeaturesVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eidoshack on 1/10/18.
 */

public class ItemNewAndTrendingViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_new_and_trending_item_title)
    TextView tvNewAndTrendingItemTitle;

    @BindView(R.id.rv_new_and_trending_item)
    RecyclerView rvNewAndTrendingItem;

    @BindView(R.id.tv_explore_button)
    TextView tvExporeButton;

    public ItemNewAndTrendingViewHolder(View itemView)
    {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }
}
