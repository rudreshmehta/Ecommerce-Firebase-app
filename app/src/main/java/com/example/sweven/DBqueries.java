package com.example.sweven;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DBqueries {
    public static FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    public static List<CategoryModel> categoryModelList = new ArrayList<>();

    public static List<List<HomePageModel>> lists = new ArrayList<>();
    public static List<String> loadCategoriesNames = new ArrayList<>();


    public static void loadCategories(final RecyclerView categoryRecyclerview, final Context context) {


        firebaseFirestore.collection("CATEGORIES").orderBy("index").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                        categoryModelList.add(new CategoryModel(documentSnapshot.get("icon").toString(), documentSnapshot.get("categoryName").toString()));
                    }
                    CategoryAdapter categoryAdapter = new CategoryAdapter(categoryModelList);
                    categoryRecyclerview.setAdapter(categoryAdapter);
                    categoryAdapter.notifyDataSetChanged();
                } else {
                    String error = task.getException().getMessage();
                    Toast.makeText(context, error, Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public static void loadFragmentData(final RecyclerView homePageRecyclerview, final Context context, final int index, String categoryName){
        firebaseFirestore.collection("CATEGORIES")
                .document(categoryName.toUpperCase())
                .collection("TOP_DEALS")
                .orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
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
                            lists.get(index).add(new HomePageModel(0, sliderModelList));

                        } else if ((long) documentSnapshot.get("view_type") == 1) {
                            lists.get(index).add(new HomePageModel(1, documentSnapshot.get("strip_ad_banner").toString(), documentSnapshot.get("background").toString()));
                        } else if ((long) documentSnapshot.get("view_type") == 2) {

                            List<WishlistModel> viewAllProductList = new ArrayList<>();

                            List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
                            long no_of_products = (long) documentSnapshot.get("no_of_products");
                            for (long x = 1; x < no_of_products + 1; x++) {
                                horizontalProductScrollModelList.add(
                                        new HorizontalProductScrollModel
                                                (documentSnapshot.get("product_ID_" + x).toString(),
                                                        documentSnapshot.get("product_image_" + x).toString(),
                                                        documentSnapshot.get("product_title_" + x).toString(),
                                                        documentSnapshot.get("product_subtitle_" + x).toString(),
                                                        documentSnapshot.get("product_price_" + x).toString()));
                                viewAllProductList.add(
                                        new WishlistModel(documentSnapshot.get("product_image_"+x).toString()
                                                         ,documentSnapshot.get("product_full_title_" + x).toString()
                                                         ,(long)documentSnapshot.get("free_coupons_" + x)
                                                ,documentSnapshot.get("average_rating_" + x).toString()
                                                ,(long)documentSnapshot.get("total_ratings_" + x)
                                                ,documentSnapshot.get("product_price_" + x).toString()
                                                ,documentSnapshot.get("cutted_price_" + x).toString()
                                                ,(boolean)documentSnapshot.get("COD_" + x)));
                            }
                            lists.get(index).add(new HomePageModel(2, documentSnapshot.get("layout_title").toString(), documentSnapshot.get("layout_background").toString(), horizontalProductScrollModelList,viewAllProductList));

                        } else if ((long) documentSnapshot.get("view_type") == 3) {
                            List<HorizontalProductScrollModel> gridLayoutModelList = new ArrayList<>();
                            long no_of_products = (long) documentSnapshot.get("no_of_products");
                            for (long x = 1; x < no_of_products + 1; x++) {
                                gridLayoutModelList.add(
                                        new HorizontalProductScrollModel
                                                (documentSnapshot.get("product_ID_" + x).toString(),
                                                        documentSnapshot.get("product_image_" + x).toString(),
                                                        documentSnapshot.get("product_title_" + x).toString(),
                                                        documentSnapshot.get("product_subtitle_" + x).toString(),
                                                        documentSnapshot.get("product_price_" + x).toString()));
                            }
                            lists.get(index).add(new HomePageModel(3, documentSnapshot.get("layout_title").toString(), documentSnapshot.get("layout_background").toString(), gridLayoutModelList));

                        }

                    }
                    HomePageAdapter adapter = new HomePageAdapter(lists.get(index));
                    homePageRecyclerview.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    HomeFragment.swipeRefreshLayout.setRefreshing(false);

                } else {
                    String error = task.getException().getMessage();
                    Toast.makeText(context, error, Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
