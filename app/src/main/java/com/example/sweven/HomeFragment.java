package com.example.sweven;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

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
    private RecyclerView homePageRecyclerView;
    private List<CategoryModel> categoryModelList;
    private FirebaseFirestore firebaseFirestore;
    private HomePageAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        categoryModelList = new ArrayList<CategoryModel>();

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);


        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("CATEGORIES").orderBy("index").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                        categoryModelList.add(new CategoryModel(documentSnapshot.get("icon").toString(), documentSnapshot.get("categoryName").toString()));
                    }
                    categoryAdapter.notifyDataSetChanged();
                } else {
                    String error = task.getException().getMessage();
                    Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
                }
            }
        });

        /////////////////////////BANNER SLIDER///////////////////////


//        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();





/*
        sliderModelList.add(new SliderModel(R.drawable.banner, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.banner_one, "#CFAB7F"));
        sliderModelList.add(new SliderModel(R.drawable.banner_two, "#FFFFFF"));
        sliderModelList.add(new SliderModel(R.drawable.banner_three, "#E7E9E8"));
        sliderModelList.add(new SliderModel(R.drawable.banner_four, "#FFFFFF"));
        sliderModelList.add(new SliderModel(R.drawable.banner_five, "#E5D3DF"));
        sliderModelList.add(new SliderModel(R.drawable.banner_six, "#FFFFFF"));
        sliderModelList.add(new SliderModel(R.drawable.banner_seven, "#000000"));
*/
        ///////////////////////////////////


        //////////////////////////////// HORIZONTAL PRODUCT SCROLL LAYOUT ////////////////////////////////////////////////
        /*List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();

        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.flour, "Aashirwaad Aata", "Pure Sugar Wheat Control Flour", "Rs. 649/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.biscuits, "Cadbury Cookies", "Delicious Cadbury Cookies", "Rs. 99/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.chips, "Lays Chips", "Simply Salted Chips", "Rs. 29/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.cleaner, "Lizol Cleaner", "Lizol Cleaner with Jasmine", "Rs. 250/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.coffee, "Nescafe Coffee", "Try Classic Coffee", "Rs. 120/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.dal, "Robin Toor Dal", "Perfect Tool Dal", "Rs. 659/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.deo, "Police Deo", "Try our 3 Combo deo", "Rs. 498/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.perfume, "Denver Perfume", "Smell Good", "Rs. 125/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.cleaning_tools, "MOP Cleaner", "Clean your floor with MOP", "Rs. 999/-"));*/
        //////////////////////////////// HORIZONTAL PRODUCT SCROLL LAYOUT ////////////////////////////////////////////////

        homePageRecyclerView = view.findViewById(R.id.homepage_recyclerview);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homePageRecyclerView.setLayoutManager(testingLayoutManager);
        final List<HomePageModel> homePageModelList = new ArrayList<>();
        adapter = new HomePageAdapter(homePageModelList);
        homePageRecyclerView.setAdapter(adapter);
        firebaseFirestore.collection("CATEGORIES")
                .document("HOME").collection("TOP_DEALS").orderBy("index").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                        if ((long) documentSnapshot.get("view_type") == 0) {
                            List<SliderModel> sliderModelList = new ArrayList<>();
                            long no_of_banners = (long) documentSnapshot.get("no_of_banners");
                            for (long x = 1; x < no_of_banners + 1; x++) {
                                sliderModelList.add(new SliderModel(documentSnapshot.get("banner_" + x).toString(), documentSnapshot.get("banner_" + x + "_background").toString()));
                            }
                            homePageModelList.add(new HomePageModel(0, sliderModelList));

                        } else if ((long) documentSnapshot.get("view_type") == 1) {
                            homePageModelList.add(new HomePageModel(1, documentSnapshot.get("strip_ad_banner").toString(), documentSnapshot.get("background").toString()));
                        } else if ((long) documentSnapshot.get("view_type") == 2) {
                            List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
                            long no_of_products = (long) documentSnapshot.get("no_of_products");
                            for (long x = 1; x < no_of_products + 1; x++) {
                                horizontalProductScrollModelList.add(
                                        new HorizontalProductScrollModel
                                                (documentSnapshot.get("product_ID_" + x).toString(),
                                                 documentSnapshot.get("product_image_" + x).toString(),
                                                 documentSnapshot.get("product_title_"+x).toString(),
                                                 documentSnapshot.get("product_subtitle_"+x).toString(),
                                                 documentSnapshot.get("product_price_"+x).toString()));
                            }
                            homePageModelList.add(new HomePageModel(2,documentSnapshot.get("layout_title").toString(),documentSnapshot.get("layout_background").toString() ,horizontalProductScrollModelList));

                        } else if ((long) documentSnapshot.get("view_type") == 3) {

                        }

                    }
                    adapter.notifyDataSetChanged();

                } else {
                    String error = task.getException().getMessage();
                    Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
                }
            }
        });


        return view;
    }

    ///////////////////BANNER SLIDER


}
