package com.dot.Pops.module.main.profile;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dot.Pops.R;
import com.dot.Pops.font.PopsTextView;
import com.dot.Pops.helper.ActivityHelper;

import java.util.List;

/**
 * Created by Win7 on 27/05/2016.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private final int EDIT      = 0;
    private final int COMPLAIN  = 1;
    private final int SETTING   = 2;
    private final int ABOUT     = 3;
    private final int TERM_OF_SERVICE = 4;
    private final int SWITCH    = 5;

    Context context;
    private List<ModelMenu> data;

    public MenuAdapter(Context context, List<ModelMenu> data) {
        this.context = context;
        this.data = data;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, null);
        MenuAdapter.ViewHolder viewHolder = new MenuAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MenuAdapter.ViewHolder v, final int position) {

        v.image.setImageResource(data.get(position).image);
        v.name.setText(data.get(position).name);
        v.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == COMPLAIN) {
                    ActivityHelper.toNextPage(context, Complain.class);
                }
            }
        });

    }

    // inner class to hold a reference to each item of RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder {

        PopsTextView name;
        ImageView image;
        public ViewHolder(View v) {
            super(v);
            name   = (PopsTextView) v.findViewById(R.id.name);
            image   = (ImageView) v.findViewById(R.id.icon);
        }

    }

    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return data.size();
    }

}