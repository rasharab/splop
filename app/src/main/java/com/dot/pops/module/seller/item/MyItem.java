package com.dot.Pops.module.seller.item;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dot.Pops.R;
import com.dot.Pops.helper.ActivityHelper;
import com.dot.Pops.helper.NoScrollRecycler;
import com.dot.Pops.module.seller.FragmentSeller;
import com.dot.Pops.module.seller.shipment.ItemAdapter;
import com.dot.Pops.module.seller.shipment.MItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Win7 on 26/05/2016.
 */

public class MyItem extends FragmentSeller {

    View view;

    @Bind(R.id.rv)
    NoScrollRecycler rv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view   = inflater.inflate(R.layout.my_item, container, false);
        ButterKnife.bind(this, view);
        setupFragment();

        return  view;
    }

    private void setupFragment() {
        activity.addActionBar(activity.ACTIONBAR_BACK, getString(R.string.my_item));
        sampleItem();
    }

    private void sampleItem() {
        List<MItem> data = new ArrayList<>();
        for (int i=0;i < 3;i++){
            data.add(new MItem("Iphone 6 plus", "IDR 6.000.000"));
        }
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        rv.setNestedScrollingEnabled(false);
        ItemAdapter mAdapter = new ItemAdapter(getActivity(), data);
        mAdapter.notifyDataSetChanged();
        rv.setAdapter(mAdapter);
    }

    @OnClick(R.id.buttonAdd)
    protected void addItem(){
        ActivityHelper.toNextPage(getActivity(), NewItem.class);
    }
}
