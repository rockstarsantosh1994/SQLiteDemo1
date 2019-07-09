package com.gmsoftech.sqlitedemo1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gmsoftech.sqlitedemo1.R;
import com.gmsoftech.sqlitedemo1.data.ProductData;

import java.util.ArrayList;

/**
 * Created by Admin on 9/19/2018.
 */

public class ProductAdapter extends BaseAdapter {

    Context context;
    ArrayList<ProductData> list;

    public ProductAdapter(Context context, ArrayList<ProductData> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ProductData getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getProductId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if ( view == null) {
            view = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.product_item, null);
        }
        ProductData data = list.get(position);
        TextView tvProductName = view.findViewById(R.id.tvProductName);
        TextView tvCategory = view.findViewById(R.id.tvCategory);
        TextView tvPrice = view.findViewById(R.id.tvPrice);
        TextView tvStockQty = view.findViewById(R.id.tvStkQty);

        tvProductName.setText(data.getProductName());
        tvCategory.setText(data.getCategory());
        tvPrice.setText(" marks "+data.getPrice());
        tvStockQty.setText("percentage : "+data.getStkQty());

        return view;
    }
}
