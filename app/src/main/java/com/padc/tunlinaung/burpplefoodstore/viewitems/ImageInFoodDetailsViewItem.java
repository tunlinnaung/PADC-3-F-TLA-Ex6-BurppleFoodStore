package com.padc.tunlinaung.burpplefoodstore.viewitems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.tunlinaung.burpplefoodstore.R;
import com.padc.tunlinaung.burpplefoodstore.data.vo.FeaturesVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eidoshack on 1/5/18.
 */

public class ImageInFoodDetailsViewItem extends FrameLayout {

    @BindView(R.id.iv_food_details_image)
    ImageView ivFoodDetailsImage;

    @BindView(R.id.tv_food_cateogry)
    TextView tvFoodCategory;

    @BindView(R.id.tv_food_details_title)
    TextView tvFoodDetailsTitle;

    @BindView(R.id.tv_food_details_description)
    TextView tvFoodDetailsDescription;

    public ImageInFoodDetailsViewItem(@NonNull Context context) {
        super(context);
    }

    public ImageInFoodDetailsViewItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageInFoodDetailsViewItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ButterKnife.bind(this, this);
    }

    public void setFeature(FeaturesVO feature) {
        Glide.with(ivFoodDetailsImage.getContext())
                .load(feature.getImage())
                .into(ivFoodDetailsImage);

        tvFoodCategory.setText(feature.getTag());
        tvFoodDetailsTitle.setText(feature.getTitle());
        tvFoodDetailsDescription.setText(feature.getDescription());
    }
}
