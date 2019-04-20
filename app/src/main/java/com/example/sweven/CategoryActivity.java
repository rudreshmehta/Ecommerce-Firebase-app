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

        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);
        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripadd,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ffff00"));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripadd,"#ff0000"));
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
