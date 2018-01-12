package com.padc.tunlinaung.burpplefoodstore.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.padc.tunlinaung.burpplefoodstore.MMBurppleApp;
import com.padc.tunlinaung.burpplefoodstore.R;
import com.padc.tunlinaung.burpplefoodstore.adapters.BurppleGuidesAdapter;
import com.padc.tunlinaung.burpplefoodstore.adapters.ImageInFoodDetailsAdapter;
import com.padc.tunlinaung.burpplefoodstore.adapters.NewAndTrendingAdapter;
import com.padc.tunlinaung.burpplefoodstore.adapters.PromotionsAdapter;
import com.padc.tunlinaung.burpplefoodstore.data.models.GuidesModel;
import com.padc.tunlinaung.burpplefoodstore.data.models.PromotionsModel;
import com.padc.tunlinaung.burpplefoodstore.events.LoadedGuidesEvent;
import com.padc.tunlinaung.burpplefoodstore.events.LoadedPromotionsEvent;
import com.padc.tunlinaung.burpplefoodstore.viewholders.ItemPromotionsViewHolder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.vp_food_details_image)
    ViewPager viewPager;

    @BindView(R.id.rv_promotions)
    RecyclerView rvPromotions;

    @BindView(R.id.rv_burpple_guides)
    RecyclerView rvBurppleGuides;

    @BindView(R.id.rv_new_and_trending)
    RecyclerView rvNewAndTrending;

    private ImageInFoodDetailsAdapter mImageInFoodDetailsAdapter;

    private PromotionsAdapter mPromotionAdapter;

    private BurppleGuidesAdapter mBurppleGuidesAdapter;

    private NewAndTrendingAdapter mNewAndTrendingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this, this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.tb_details);
        setSupportActionBar(myToolbar);

//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mImageInFoodDetailsAdapter = new ImageInFoodDetailsAdapter();
        viewPager.setAdapter(mImageInFoodDetailsAdapter);
        viewPager.setCurrentItem(1);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // TODO
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state < 5){
                    viewPager.setCurrentItem(0, true);
                } else if (state < 1 ) {
                    viewPager.setCurrentItem(5, true);
                }
            }
        });

        mPromotionAdapter = new PromotionsAdapter();
        LinearLayoutManager promotionLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rvPromotions.setLayoutManager(promotionLayoutManager);
        rvPromotions.setAdapter(mPromotionAdapter);

        PromotionsModel.getObjInstance().loadPromotions();

        mBurppleGuidesAdapter = new BurppleGuidesAdapter();
        LinearLayoutManager burppleGuideLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rvBurppleGuides.setLayoutManager(burppleGuideLayoutManager);
        rvBurppleGuides.setAdapter(mBurppleGuidesAdapter);

        GuidesModel.getObjInstance().loadGuides();

        mNewAndTrendingAdapter = new NewAndTrendingAdapter();
        LinearLayoutManager newAndTrendingLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rvNewAndTrending.setLayoutManager(newAndTrendingLayoutManager);
        rvNewAndTrending.setAdapter(mNewAndTrendingAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPromotionsLoaded(LoadedPromotionsEvent event) {
        Log.d(MMBurppleApp.LOG_TAG, "onPromotionsLoaded: " + event.getPromotions().size());
        mPromotionAdapter.setPromotions(event.getPromotions());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGuidesLoaded(LoadedGuidesEvent event) {
        Log.d(MMBurppleApp.LOG_TAG, "onGuidesLoaded: " + event.getGuides().size());
        mBurppleGuidesAdapter.setGuides(event.getGuides());
    }
}
