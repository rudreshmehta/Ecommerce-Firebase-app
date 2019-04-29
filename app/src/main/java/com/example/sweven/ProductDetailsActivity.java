package com.example.sweven;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.sweven.MainActivity.showCart;

public class ProductDetailsActivity extends AppCompatActivity {
    private ViewPager productImagesViewPager;
    private TabLayout viewPagerIndicator;
    private ViewPager productDetailsViewPager;
    private TabLayout productDetailsTabLayout;
    private static Boolean ALREADY_ADDED_TO_WISHLIST = false;
    private FloatingActionButton addToWishListBtn;

    /*********** RATINGS LAYOUT ******/

    private LinearLayout rateNowContainer;

    /*********** RATINGS LAYOUT ******/

    /*********** COUPON DIALOG ******/
    public static TextView couponTitle;
    public static TextView couponExpiryDate;
    public static TextView couponTBody;
    private static RecyclerView opencouponsRecyclerView;
    private static LinearLayout selectedCoupon;
    /*********** COUPON DIALOG ******/

    private Button buyNowBtn;
    private Button couponRedeemBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productImagesViewPager = findViewById(R.id.product_images_viewpager);
        viewPagerIndicator = findViewById(R.id.viewpager_indicator);
        addToWishListBtn = findViewById(R.id.add_to_wishlist_btn);
        productDetailsViewPager = findViewById(R.id.product_details_viewpager);
        productDetailsTabLayout = findViewById(R.id.product_details_tablayout);
        buyNowBtn = findViewById(R.id.buy_now_btn);
        couponRedeemBtn=findViewById(R.id.coupon_redemption_btn);

        List<Integer> productImages = new ArrayList<>();
        productImages.add(R.drawable.flour);
        productImages.add(R.drawable.flour);
        productImages.add(R.drawable.flour);
        productImages.add(R.drawable.flour);
        ProductImagesAdapter productImagesAdapter = new ProductImagesAdapter(productImages);
        productImagesViewPager.setAdapter(productImagesAdapter);
        viewPagerIndicator.setupWithViewPager(productImagesViewPager, true);
        addToWishListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ALREADY_ADDED_TO_WISHLIST) {
                    ALREADY_ADDED_TO_WISHLIST = false;
                    addToWishListBtn.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9E9E9E")));
                } else {
                    ALREADY_ADDED_TO_WISHLIST = true;
                    addToWishListBtn.setSupportImageTintList(getResources().getColorStateList(R.color.btnRed));
                }
            }
        });

        productDetailsViewPager.setAdapter(new ProductDetailsAdapter(getSupportFragmentManager(), productDetailsTabLayout.getTabCount()));
        productDetailsViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailsTabLayout));
        productDetailsTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDetailsViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        /*********** RATINGS LAYOUT ******/
        rateNowContainer = findViewById(R.id.rate_now_container);
        for (int i = 0; i < rateNowContainer.getChildCount(); i++) {
            final int starPosition = i;
            rateNowContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setRating(starPosition);
                }
            });
        }
        /*********** RATINGS LAYOUT ******/

        buyNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliveryIntent = new Intent(ProductDetailsActivity.this, DeliveryActivity.class);
                startActivity(deliveryIntent);
            }
        });


        /* ********* COUPON DIALOG********* */
        final Dialog checkCouponPriceDialog = new Dialog(ProductDetailsActivity.this);
        checkCouponPriceDialog.setContentView(R.layout.coupon_redeem_dialog);
        checkCouponPriceDialog.setCancelable(true);
        checkCouponPriceDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ImageView toggleRecyclerView = checkCouponPriceDialog.findViewById(R.id.toggle_recyclerview);
        opencouponsRecyclerView = checkCouponPriceDialog.findViewById(R.id.coupons_recyclerview);
        selectedCoupon = checkCouponPriceDialog.findViewById(R.id.selected_coupon);
        couponTitle=checkCouponPriceDialog.findViewById(R.id.coupon_title);
        couponExpiryDate=checkCouponPriceDialog.findViewById(R.id.coupon_validity);
        couponTBody=checkCouponPriceDialog.findViewById(R.id.coupon_body);


        TextView originalPrice = checkCouponPriceDialog.findViewById(R.id.original_price);
        TextView discountedPrice = checkCouponPriceDialog.findViewById(R.id.discounted_price);
        LinearLayoutManager layoutManager = new LinearLayoutManager(ProductDetailsActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        opencouponsRecyclerView.setLayoutManager(layoutManager);
        List<RewardModel> rewardModelList = new ArrayList<>();
        rewardModelList.add(new RewardModel("CashBack", "till, 2nd,June 2019", "GET 20% CashBack on any product above Rs. 200/- and below Rs. 3000/-"));
        rewardModelList.add(new RewardModel("Discount", "till, 2nd,June 2019", "GET 20% CashBack on any product above Rs. 200/- and below Rs. 3000/-"));
        rewardModelList.add(new RewardModel("Buy 1 get 1 Free", "till, 2nd,June 2019", "GET 20% CashBack on any product above Rs. 200/- and below Rs. 3000/-"));
        rewardModelList.add(new RewardModel("CashBack", "till, 2nd,June 2019", "GET 20% CashBack on any product above Rs. 200/- and below Rs. 3000/-"));
        rewardModelList.add(new RewardModel("Discount", "till, 2nd,June 2019", "GET 20% CashBack on any product above Rs. 200/- and below Rs. 3000/-"));
        rewardModelList.add(new RewardModel("Buy 1 get 1 Free", "till, 2nd,June 2019", "GET 20% CashBack on any product above Rs. 200/- and below Rs. 3000/-"));
        rewardModelList.add(new RewardModel("CashBack", "till, 2nd,June 2019", "GET 20% CashBack on any product above Rs. 200/- and below Rs. 3000/-"));
        rewardModelList.add(new RewardModel("Discount", "till, 2nd,June 2019", "GET 20% CashBack on any product above Rs. 200/- and below Rs. 3000/-"));
        rewardModelList.add(new RewardModel("Buy 1 get 1 Free", "till, 2nd,June 2019", "GET 20% CashBack on any product above Rs. 200/- and below Rs. 3000/-"));

        MyRewardsAdapter myRewardsAdapter = new MyRewardsAdapter(rewardModelList,true);
        opencouponsRecyclerView.setAdapter(myRewardsAdapter);
        myRewardsAdapter.notifyDataSetChanged();

        toggleRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogRecyclerView();
            }
        });


        couponRedeemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkCouponPriceDialog.show();
            }
        });
        /* ********* COUPON DIALOG********* */
    }

    public static void showDialogRecyclerView(){
        if(opencouponsRecyclerView.getVisibility() == View.GONE){
            opencouponsRecyclerView.setVisibility(View.VISIBLE);
            selectedCoupon.setVisibility(View.GONE);

        }else{
            opencouponsRecyclerView.setVisibility(View.GONE);
            selectedCoupon.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_and_cart_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {

            finish();
            return true;
        } else if (id == R.id.main_search_icon) {
            //todo:search
            return true;
        } else if (id == R.id.main_cart_icon) {
            Intent cartIntent = new Intent(ProductDetailsActivity.this, MainActivity.class);
            showCart = true;
            startActivity(cartIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*********** RATINGS LAYOUT ******/
    private void setRating(int starPosition) {
        for (int x = 0; x < rateNowContainer.getChildCount(); x++) {
            ImageView starBtn = (ImageView) rateNowContainer.getChildAt(x);
            starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
            if (x <= starPosition) {
                starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));
            }
        }
    }
    /*********** RATINGS LAYOUT ******/
}

