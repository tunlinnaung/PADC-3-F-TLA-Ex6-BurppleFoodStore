package com.padc.tunlinaung.burpplefoodstore.adapters;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.tunlinaung.burpplefoodstore.R;
import com.padc.tunlinaung.burpplefoodstore.data.vo.FeaturesVO;
import com.padc.tunlinaung.burpplefoodstore.viewitems.ImageInFoodDetailsViewItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eidoshack on 1/5/18.
 */

public class ImageInFoodDetailsAdapter extends PagerAdapter {

    private List<FeaturesVO> mFeaturesList;

    public ImageInFoodDetailsAdapter() {
        mFeaturesList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mFeaturesList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageInFoodDetailsViewItem viewItem =
                (ImageInFoodDetailsViewItem) LayoutInflater.from(container.getContext())
                                                            .inflate(R.layout.item_food_details_images, container, false);
        container.addView(viewItem);
        return viewItem;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public void setFeatures(List<FeaturesVO> features) {
        this.mFeaturesList = features;
        notifyDataSetChanged();
    }

}
