package com.dot.Pops.views.main.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dot.Pops.R;
import com.dot.Pops.helper.NoScrollRecycler;
import com.dot.Pops.views.seller.FragmentSeller;
import com.dot.Pops.views.seller.useractivity.ActiveAdapter;
import com.dot.Pops.views.seller.useractivity.CompleteAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Win7 on 27/05/2016.
 */

public class ProfileMenu extends FragmentSeller {

    View view;

    @Bind(R.id.rv)
    RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view   = inflater.inflate(R.layout.profile_home, container, false);
        ButterKnife.bind(this, view);
        setupFragment();

        return view;
    }

    private void setupFragment() {
        activity.addActionBar(activity.ACTIONBAR_NO_BACK, getString(R.string.my_pops));
        dataMenu();
    }

    private void dataMenu() {
        List<ModelMenu> data = new ArrayList<>();
        data.add(new ModelMenu(R.drawable.ic_edit, "Edit Profile"));
        data.add(new ModelMenu(R.drawable.ic_complain, "Complain"));
        data.add(new ModelMenu(R.drawable.ic_setting_pink, "Setting"));
        data.add(new ModelMenu(R.drawable.ic_info, "About Pop's"));
        data.add(new ModelMenu(R.drawable.ic_r, "Terms & Condition"));
        data.add(new ModelMenu(R.drawable.ic_switch, "Switch to Customer"));
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        MenuAdapter mAdapter = new MenuAdapter(getActivity(), data);
        mAdapter.notifyDataSetChanged();
        rv.setAdapter(mAdapter);

    }
}
