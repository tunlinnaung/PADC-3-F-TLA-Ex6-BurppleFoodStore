package com.padc.tunlinaung.burpplefoodstore.activities;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.padc.tunlinaung.burpplefoodstore.MMBurppleApp;
import com.padc.tunlinaung.burpplefoodstore.R;
import com.padc.tunlinaung.burpplefoodstore.adapters.BurppleGuidesAdapter;
import com.padc.tunlinaung.burpplefoodstore.adapters.ImageInFoodDetailsAdapter;
import com.padc.tunlinaung.burpplefoodstore.adapters.NewAndTrendingAdapter;
import com.padc.tunlinaung.burpplefoodstore.adapters.PromotionsAdapter;
import com.padc.tunlinaung.burpplefoodstore.data.models.FeaturesModel;
import com.padc.tunlinaung.burpplefoodstore.data.models.GuidesModel;
import com.padc.tunlinaung.burpplefoodstore.data.models.LoginUserModel;
import com.padc.tunlinaung.burpplefoodstore.data.models.PromotionsModel;
import com.padc.tunlinaung.burpplefoodstore.delegates.AfterLoginDelegate;
import com.padc.tunlinaung.burpplefoodstore.delegates.BeforeLoginDelegate;
import com.padc.tunlinaung.burpplefoodstore.events.LoadedFeaturesEvent;
import com.padc.tunlinaung.burpplefoodstore.events.LoadedGuidesEvent;
import com.padc.tunlinaung.burpplefoodstore.events.LoadedPromotionsEvent;
import com.padc.tunlinaung.burpplefoodstore.viewpod.AccountControlViewPod;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BeforeLoginDelegate, AfterLoginDelegate {

    @BindView(R.id.tb_details)
    Toolbar mToolBar;

    @BindView(R.id.vp_food_details_image)
    ViewPager viewPager;

    @BindView(R.id.rv_promotions)
    RecyclerView rvPromotions;

    @BindView(R.id.rv_burpple_guides)
    RecyclerView rvBurppleGuides;

    @BindView(R.id.rv_new_and_trending)
    RecyclerView rvNewAndTrending;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;

    private ImageInFoodDetailsAdapter mImageInFoodDetailsAdapter;

    private PromotionsAdapter mPromotionAdapter;

    private BurppleGuidesAdapter mBurppleGuidesAdapter;

    private NewAndTrendingAdapter mNewAndTrendingAdapter;

    private AccountControlViewPod vpAccountControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this, this);

        setSupportActionBar(mToolBar);
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setHomeButtonEnabled(true);

            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dehaze_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            getSupportActionBar().setTitle("");
        }

        vpAccountControl = (AccountControlViewPod) mNavigationView.getHeaderView(0);
        vpAccountControl.setDelegate((BeforeLoginDelegate) this);
        vpAccountControl.setDelegate((AfterLoginDelegate) this);

        mImageInFoodDetailsAdapter = new ImageInFoodDetailsAdapter();
        viewPager.setAdapter(mImageInFoodDetailsAdapter);

        FeaturesModel.getObjInstance().loadFeatures();

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
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFeaturesLoaded(LoadedFeaturesEvent event) {
        Log.d(MMBurppleApp.LOG_TAG, "onFeaturesLoaded: " + event.getFeatures().size());
        mImageInFoodDetailsAdapter.setFeatures(event.getFeatures());
    }

    @Override
    public void onTapToLogin() {
        Intent intent = AccountControlActivity.newIntentLogin(getApplicationContext());
        startActivity(intent);
    }

    @Override
    public void onTapToRegister() {
        Intent intent = AccountControlActivity.newIntentRegister(getApplicationContext());
        startActivity(intent);
    }

    @Override
    public void onTapLogout() {
        LoginUserModel.getInstance().logout();
    }
}
