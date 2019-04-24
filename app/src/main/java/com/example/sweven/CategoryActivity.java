package com.example.sweven;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private RecyclerView categoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerView=findViewById(R.id.category_recyclerview);

        /////////////////////////BANNER SLIDER///////////////////////

        List<SliderModel>sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.banner_six, "#FFFFFF"));
        sliderModelList.add(new SliderModel(R.drawable.banner_seven, "#000000"));

        sliderModelList.add(new SliderModel(R.drawable.banner, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.banner_one, "#CFAB7F"));
        sliderModelList.add(new SliderModel(R.drawable.banner_two, "#FFFFFF"));
        sliderModelList.add(new SliderModel(R.drawable.banner_three, "#E7E9E8"));
        sliderModelList.add(new SliderModel(R.drawable.banner_four, "#FFFFFF"));
        sliderModelList.add(new SliderModel(R.drawable.banner_five, "#E5D3DF"));
        sliderModelList.add(new SliderModel(R.drawable.banner_six, "#FFFFFF"));
        sliderModelList.add(new SliderModel(R.drawable.banner_seven, "#000000"));

        sliderModelList.add(new SliderModel(R.drawable.banner, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.banner_one, "#CFAB7F"));


        sliderModelList.add(new SliderModel(R.mipmap.custom_error_icon, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.green_mail, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.red_mail, "#077AE4"));

        ///////////////////////////////////



        //////////////////////////////// HORIZONTAL PRODUCT SCROLL LAYOUT ////////////////////////////////////////////////
        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();

        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.flour, "Aashirwaad Aata", "Pure Sugar Wheat Control Flour", "Rs. 649/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.biscuits, "Cadbury Cookies", "Delicious Cadbury Cookies", "Rs. 99/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.chips, "Lays Chips", "Simply Salted Chips", "Rs. 29/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.cleaner, "Lizol Cleaner", "Lizol Cleaner with Jasmine", "Rs. 250/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.coffee, "Nescafe Coffee", "Try Classic Coffee", "Rs. 120/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.dal, "Robin Toor Dal", "Perfect Tool Dal", "Rs. 659/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.deo, "Police Deo", "Try our 3 Combo deo", "Rs. 498/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.perfume, "Denver Perfume", "Smell Good", "Rs. 125/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.cleaning_tools, "MOP Cleaner", "Clean your floor with MOP", "Rs. 999/-"));
        //////////////////////////////// HORIZONTAL PRODUCT SCROLL LAYOUT ////////////////////////////////////////////////

        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);
        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripadd_flour_image,"#FFFFFF"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripadd_flour_image,"#ffffff"));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripadd_flour_image,"#FFFFFF"));
        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.main_search_icon) {
            //todo:search
            return true;
        }else if(id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
