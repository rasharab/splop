package com.dot.Pops.module.seller.useractivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dot.Pops.R;
import com.dot.Pops.helper.NoScrollRecycler;
import com.dot.Pops.module.seller.FragmentSeller;
import com.dot.Pops.module.seller.useractivity.adapter.ActiveAdapter;
import com.dot.Pops.module.seller.useractivity.adapter.CompleteAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Win7 on 26/05/2016.
 */

public class StatusFragment extends FragmentSeller {
    private static final String TYPE_FRAGMENT = "TYPE_FRAGMENT";
    public static final int ACTIVE = 0;
    public static final int COMPLETE = 1;

    View view;

    @Bind(R.id.rv)
    NoScrollRecycler rv;

    public static StatusFragment newInstance(int type) {
        StatusFragment mFragment = new StatusFragment();
        Bundle mBundle = new Bundle();
        mBundle.putInt(TYPE_FRAGMENT, type);
        mFragment.setArguments(mBundle);

        return mFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view   = inflater.inflate(R.layout.list, container, false);
        ButterKnife.bind(this, view);
        sampleItem();

        return view;
    }

    private void sampleItem(){
        int type = getArguments().getInt(TYPE_FRAGMENT);
        List<String> data = new ArrayList<>();
        for (int i=0;i < 3;i++){
            data.add(i+"");
        }
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        rv.setNestedScrollingEnabled(false);
        if (type == ACTIVE) {
            ActiveAdapter mAdapter = new ActiveAdapter(getActivity(), data);
            mAdapter.notifyDataSetChanged();
            rv.setAdapter(mAdapter);
        }else{
            CompleteAdapter mAdapter = new CompleteAdapter(getActivity(), data);
            mAdapter.notifyDataSetChanged();
            rv.setAdapter(mAdapter);
        }

    }
}
