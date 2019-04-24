package com.example.sweven;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyRewardsAdapter extends RecyclerView.Adapter<MyRewardsAdapter.ViewHolder> {


    private List<RewardModel> rewardModelList;

    public MyRewardsAdapter(List<RewardModel> rewardModelList) {
        this.rewardModelList = rewardModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rewards_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        String title = rewardModelList.get(position).getTitle();
        String validity=rewardModelList.get(position).getExpiryDate();
        String body = rewardModelList.get(position).getCouponBody();
        viewHolder.setData(title,validity,body);
    }

    @Override
    public int getItemCount() {
        return rewardModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView couponTitle;
        private TextView couponValidity;
        private TextView couponBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            couponTitle=itemView.findViewById(R.id.coupon_title);
            couponValidity=itemView.findViewById(R.id.coupon_validity);
            couponBody=itemView.findViewById(R.id.coupon_body);
        }
        private void setData(String title,String validity,String body){
            couponTitle.setText(title);
            couponValidity.setText(validity);
            couponBody.setText(body);
        }
    }
}
