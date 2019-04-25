package com.example.sweven;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MyAddressesActivity extends AppCompatActivity {

    private RecyclerView myaddressesRecyclerView;

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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myaddressesRecyclerView.setLayoutManager(linearLayoutManager);
        List<AddressesModel> addressesModelList = new ArrayList<>();
        addressesModelList.add(new AddressesModel("Parth Maniar","Ahmedabad","380001"));
        addressesModelList.add(new AddressesModel("Rudresh Mehta","Ahmedabad","380001"));
        addressesModelList.add(new AddressesModel("Rahul Mehta","Ahmedabad","380001"));
        addressesModelList.add(new AddressesModel("Parth Maniar","Ahmedabad","380001"));
        addressesModelList.add(new AddressesModel("Rudresh Mehta","Ahmedabad","380001"));
        addressesModelList.add(new AddressesModel("Rahul Mehta","Ahmedabad","380001"));
        addressesModelList.add(new AddressesModel("Parth Maniar","Ahmedabad","380001"));
        addressesModelList.add(new AddressesModel("Rudresh Mehta","Ahmedabad","380001"));
        addressesModelList.add(new AddressesModel("Rahul Mehta","Ahmedabad","380001"));
        AddressesAdapter addressesAdapter = new AddressesAdapter(addressesModelList);
        myaddressesRecyclerView.setAdapter(addressesAdapter);
        addressesAdapter.notifyDataSetChanged();
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
