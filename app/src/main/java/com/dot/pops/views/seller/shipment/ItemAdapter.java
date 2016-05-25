package com.dot.Pops.views.seller.shipment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dot.Pops.R;
import com.dot.Pops.font.PopsTextView;

import java.util.List;

/**
 * Created by Win7 on 25/05/2016.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    Context context;
    private List<MItem> data;

    public ItemAdapter(Context context, List<MItem> data) {
        this.context = context;
        this.data = data;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_goods, null);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder v, final int position) {

        MItem m = data.get(position);

        v.name.setText(m.title);

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
