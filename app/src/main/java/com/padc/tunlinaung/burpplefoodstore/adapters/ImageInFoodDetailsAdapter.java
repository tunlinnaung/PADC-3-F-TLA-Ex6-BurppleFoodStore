package com.padc.tunlinaung.burpplefoodstore.adapters;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.tunlinaung.burpplefoodstore.R;
import com.padc.tunlinaung.burpplefoodstore.viewitems.ImageInFoodDetailsViewItem;

/**
 * Created by eidoshack on 1/5/18.
 */

public class ImageInFoodDetailsAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 5;
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


}
