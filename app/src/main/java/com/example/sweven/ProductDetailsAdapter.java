package com.example.sweven;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class ProductDetailsAdapter extends FragmentPagerAdapter {

    private int totalTabs;

    public ProductDetailsAdapter(FragmentManager fm, int totalTabs) {
        super(fm);
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                   ProductDescriptionFragment productDescriptionFragment1 = new ProductDescriptionFragment();
                   return  productDescriptionFragment1;
                case 1:
                        ProductSpecificationFragment productSpecificationFragment = new ProductSpecificationFragment();
                        return productSpecificationFragment;
                    case 2:
                        ProductDescriptionFragment productDescriptionFragment2 = new ProductDescriptionFragment();
                        return  productDescriptionFragment2;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
