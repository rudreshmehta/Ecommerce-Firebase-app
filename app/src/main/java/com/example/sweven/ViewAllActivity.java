package com.example.sweven;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Deals of the Day");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler_view);
        gridView = findViewById(R.id.grid_view);
        int layout_code=getIntent().getIntExtra("layout_code",-1);
        if(layout_code == 0){

        recyclerView.setVisibility(View.VISIBLE);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<WishlistModel> wishlistModelList = new ArrayList<>();
        wishlistModelList.add(new WishlistModel(R.drawable.flour,"Aashirvaad Aata",1,"3",145,"Rs. 659/-","Rs. 759/-","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.dal,"Robin Toor Dal",0,"3",145,"Rs. 559/-","Rs. 449/-","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.biscuit,"Cadbury Cookies",2,"3",145,"Rs. 80/-","Rs. 120/-","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.air_fresheners,"Air Freshner",4,"3",145,"Rs. 269/-","Rs. 329/-","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.deo,"Police Deo",1,"3",145,"Rs. 359/-","Rs. 459/-","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.flour,"Aashirvaad Aata",1,"3",145,"Rs. 659/-","Rs. 759/-","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.dal,"Robin Toor Dal",0,"3",145,"Rs. 559/-","Rs. 449/-","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.biscuit,"Cadbury Cookies",2,"3",145,"Rs. 80/-","Rs. 120/-","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.air_fresheners,"Air Freshner",4,"3",145,"Rs. 269/-","Rs. 329/-","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.deo,"Police Deo",1,"3",145,"Rs. 359/-","Rs. 459/-","Cash on Delivery"));

        WishlistAdapter adapter = new WishlistAdapter(wishlistModelList,false);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        }
        else if(layout_code==1) {
            gridView.setVisibility(View.VISIBLE);
            List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();

/*
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.flour, "Aashirwaad Aata", "Pure Sugar Wheat Control Flour", "Rs. 649/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.biscuits, "Cadbury Cookies", "Delicious Cadbury Cookies", "Rs. 99/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.chips, "Lays Chips", "Simply Salted Chips", "Rs. 29/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.cleaner, "Lizol Cleaner", "Lizol Cleaner with Jasmine", "Rs. 250/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.coffee, "Nescafe Coffee", "Try Classic Coffee", "Rs. 120/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.dal, "Robin Toor Dal", "Perfect Tool Dal", "Rs. 659/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.deo, "Police Deo", "Try our 3 Combo deo", "Rs. 498/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.perfume, "Denver Perfume", "Smell Good", "Rs. 125/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.cleaning_tools, "MOP Cleaner", "Clean your floor with MOP", "Rs. 999/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.flour, "Aashirwaad Aata", "Pure Sugar Wheat Control Flour", "Rs. 649/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.biscuits, "Cadbury Cookies", "Delicious Cadbury Cookies", "Rs. 99/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.chips, "Lays Chips", "Simply Salted Chips", "Rs. 29/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.cleaner, "Lizol Cleaner", "Lizol Cleaner with Jasmine", "Rs. 250/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.coffee, "Nescafe Coffee", "Try Classic Coffee", "Rs. 120/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.dal, "Robin Toor Dal", "Perfect Tool Dal", "Rs. 659/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.deo, "Police Deo", "Try our 3 Combo deo", "Rs. 498/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.perfume, "Denver Perfume", "Smell Good", "Rs. 125/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.cleaning_tools, "MOP Cleaner", "Clean your floor with MOP", "Rs. 999/-"));
*/

            GridProductLayoutAdapter gridProductLayoutAdapter = new GridProductLayoutAdapter(horizontalProductScrollModelList);
            gridView.setAdapter(gridProductLayoutAdapter);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
        finish();
        return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
