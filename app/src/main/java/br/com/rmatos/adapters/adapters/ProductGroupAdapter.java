package br.com.rmatos.adapters.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.rmatos.adapters.R;
import br.com.rmatos.adapters.models.ProductModel;

public class ProductGroupAdapter extends CustomGroupAdapter<ProductModel, ProductGroupAdapter.ProductViewHolder> {

    public ProductGroupAdapter(Context ctx, Map<String, ArrayList<ProductModel>> list) {
        super(ctx, list);
    }

    @Override
    public int getLayout() {
        return R.layout.product_view_model;
    }

    @Override
    public ProductViewHolder createHolder(ProductModel model, int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ProductViewHolder holder = new ProductViewHolder();
        holder.img = (ImageView)convertView.findViewById(R.id.img);
        holder.lbl = (TextView)convertView.findViewById(R.id.lbl);
        return holder;
    }

    @Override
    public void updateHolder(ProductViewHolder holder, ProductModel model, int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent){
        holder.img.setImageResource(model.Icon);
        holder.lbl.setText(model.Name);
    }

    public static class ProductViewHolder
    {
        ImageView img;
        TextView lbl;
    }
}
