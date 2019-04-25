package com.example.sweven;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static com.example.sweven.DeliveryActivity.SELECT_ADDRESS;

public class MyAddressesActivity extends AppCompatActivity {

    private RecyclerView myaddressesRecyclerView;
    private static AddressesAdapter addressesAdapter;
    private Button deliverHereBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_addresses);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("My Addresses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
myaddressesRecyclerView = findViewById(R.id.addresses_recyclerview);
deliverHereBtn = findViewById(R.id.deliver_here_btn);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myaddressesRecyclerView.setLayoutManager(linearLayoutManager);
        List<AddressesModel> addressesModelList = new ArrayList<>();
        addressesModelList.add(new AddressesModel("Parth Maniar","Ahmedabad","380001",true));
        addressesModelList.add(new AddressesModel("Rudresh Mehta","Ahmedabad","380001",false));
        addressesModelList.add(new AddressesModel("Rahul Mehta","Ahmedabad","380001",false));
        addressesModelList.add(new AddressesModel("Parth Maniar","Ahmedabad","380001",false));
        addressesModelList.add(new AddressesModel("Rudresh Mehta","Ahmedabad","380001",false));
        addressesModelList.add(new AddressesModel("Rahul Mehta","Ahmedabad","380001",false));
        addressesModelList.add(new AddressesModel("Parth Maniar","Ahmedabad","380001",false));
        addressesModelList.add(new AddressesModel("Rudresh Mehta","Ahmedabad","380001",false));
        addressesModelList.add(new AddressesModel("Rahul Mehta","Ahmedabad","380001",false));

        int mode = getIntent().getIntExtra("MODE",-1);
        if(mode==SELECT_ADDRESS){
            deliverHereBtn.setVisibility(View.VISIBLE);
        }else{
            deliverHereBtn.setVisibility(View.GONE);
        }
         addressesAdapter = new AddressesAdapter(addressesModelList,mode);
        myaddressesRecyclerView.setAdapter(addressesAdapter);
        ((SimpleItemAnimator)myaddressesRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        addressesAdapter.notifyDataSetChanged();
    }

    public static  void refreshItem(int deSelect, int select){
        addressesAdapter.notifyItemChanged(deSelect);
        addressesAdapter.notifyItemChanged(select);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
