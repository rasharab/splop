package com.dot.Pops.views.seller.useractivity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dot.Pops.R;
import com.dot.Pops.font.PopsTextView;

import java.util.List;

/**
 * Created by Win7 on 26/05/2016.
 */

public class CompleteAdapter extends RecyclerView.Adapter<CompleteAdapter.ViewHolder> {
    Context context;
    private List<String> data;

    public CompleteAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CompleteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ua_complete, null);
        ViewHolder viewHolder = new CompleteAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CompleteAdapter.ViewHolder v, final int position) {

    }

    // inner class to hold a reference to each item of RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder {

        PopsTextView name;
        public ViewHolder(View v) {
            super(v);
            name   = (PopsTextView) v.findViewById(R.id.name);
        }

    }

    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return data.size();
    }

}
