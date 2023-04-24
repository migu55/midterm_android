package com.bcit.miguelmarasigan_midterm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.ViewHolder> {

    private Hippo[] localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * This template comes with a TextView
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final TextView textViewAge;
        private final TextView textViewFood;
        private final ImageView imgView;

        public ViewHolder(View view) {
            super(view);

            textViewName = view.findViewById(R.id.textView_inventory_nameDesc);
            textViewAge = view.findViewById(R.id.textView_inventory_ageDesc);
            textViewFood = view.findViewById(R.id.textView_inventory_foodDesc);
            imgView = view.findViewById(R.id.imageView_inventory);
        }

        public TextView getTextViewName() {
            return textViewName;
        }
        public TextView getTextViewAge() {
            return textViewAge;
        }
        public TextView getTextViewFood() {
            return textViewFood;
        }
        public ImageView getImgView() { return imgView; }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView.
     */
    public InventoryAdapter(Hippo[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_inventory, viewGroup, false); //error here should be expected, this is a template

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        String fix = "" + localDataSet[position].getAge();
        viewHolder.getTextViewName().setText(localDataSet[position].getName());
        viewHolder.getTextViewAge().setText(fix);
        viewHolder.getTextViewFood().setText(localDataSet[position].getFood());
        viewHolder.getImgView().setImageResource(localDataSet[position].getResId());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}