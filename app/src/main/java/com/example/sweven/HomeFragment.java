package com.example.sweven;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView testing;
   /* ///////////////////////// BANNER SLIDER  /////////////////////////////////////////

    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage = 2;
    private Timer timer;
    final private long DELAY_TIME = 3000;
    final private long PERIOD_TIME = 3000;

    ////////////////////////////  ENDS    ////////////////////////////////////
*/
/*
    ////////////////////////////////STRIP AD  ////////////////////////////////////////////////

    private ImageView stripAdImage;
    private ConstraintLayout stripAdContainer;

    //////////////////////////////// STRIP AD ////////////////////////////////////////////////

  */
/*
//////////////////////////////// HORIZONTAL PRODUCT SCROLL LAYOUT ////////////////////////////////////////////////
    private TextView horizontalLayoutTitle;
    private Button horizontalViewAllBtn;
    private RecyclerView horizontalRecyclerView;

    //////////////////////////////// HORIZONTAL PRODUCT SCROLL LAYOUT ////////////////////////////////////////////////

*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        final List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link", "Home"));
        categoryModelList.add(new CategoryModel("link", "Cooking Essentials"));
        categoryModelList.add(new CategoryModel("link", "Packaged Foods"));
        categoryModelList.add(new CategoryModel("link", "Household Essentials"));
        categoryModelList.add(new CategoryModel("link", "Beauty & Grooming"));
        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();


        /////////////////////////BANNER SLIDER///////////////////////

        List<SliderModel>sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.mipmap.home_icon, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.custom_error_icon, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.green_mail, "#077AE4"));

        sliderModelList.add(new SliderModel(R.mipmap.red_mail, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher_round, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.cart_black, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.profile_placeholder, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.home_icon, "#077AE4"));


        sliderModelList.add(new SliderModel(R.mipmap.custom_error_icon, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.green_mail, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.red_mail, "#077AE4"));

        ///////////////////////////////////



        //////////////////////////////// HORIZONTAL PRODUCT SCROLL LAYOUT ////////////////////////////////////////////////
        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();

        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.image2, "Redmi 5A", "SD 625 Processor", "Rs. 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.ic_launcher, "Redmi 5A", "SD 625 Processor", "Rs. 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.ic_launcher_round, "Redmi 5A", "SD 625 Processor", "Rs. 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.cart_black, "Redmi 5A", "SD 625 Processor", "Rs. 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.custom_error_icon, "Redmi 5A", "SD 625 Processor", "Rs. 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.green_mail, "Redmi 5A", "SD 625 Processor", "Rs. 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.red_mail, "Redmi 5A", "SD 625 Processor", "Rs. 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.home_icon, "Redmi 5A", "SD 625 Processor", "Rs. 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.cart_black, "Redmi 5A", "SD 625 Processor", "Rs. 5999/-"));
        //////////////////////////////// HORIZONTAL PRODUCT SCROLL LAYOUT ////////////////////////////////////////////////

        testing = view.findViewById(R.id.homepage_recyclerview);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);
        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripadd,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ffff00"));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripadd,"#ff0000"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }

    ///////////////////BANNER SLIDER


}
