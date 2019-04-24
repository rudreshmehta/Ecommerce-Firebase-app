package com.example.sweven;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyWishlistFragment extends Fragment {


    public MyWishlistFragment() {
        // Required empty public constructor
    }

    private RecyclerView myWishlistRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_my_wishlist, container, false);
        myWishlistRecyclerView= view.findViewById(R.id.my_wishlist_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myWishlistRecyclerView.setLayoutManager(linearLayoutManager);
        List<WishlistModel> wishlistModelList = new ArrayList<>();
        wishlistModelList.add(new WishlistModel(R.drawable.flour,"Aashirvaad Aata",1,"3",145,"Rs. 659/-","Rs. 759/-","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.dal,"Robin Toor Dal",0,"3",145,"Rs. 559/-","Rs. 449/-","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.biscuit,"Cadbury Cookies",2,"3",145,"Rs. 80/-","Rs. 120/-","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.air_fresheners,"Air Freshner",4,"3",145,"Rs. 269/-","Rs. 329/-","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.deo,"Police Deo",1,"3",145,"Rs. 359/-","Rs. 459/-","Cash on Delivery"));
        WishlistAdapter wishlistAdapter = new WishlistAdapter(wishlistModelList);
        myWishlistRecyclerView.setAdapter(wishlistAdapter);
        wishlistAdapter.notifyDataSetChanged();
        return  view;
        }

}
