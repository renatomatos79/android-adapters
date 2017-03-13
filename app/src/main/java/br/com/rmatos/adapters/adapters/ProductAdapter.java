package br.com.rmatos.adapters.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.rmatos.adapters.R;
import br.com.rmatos.adapters.models.ProductModel;

public class ProductAdapter extends CustomAdapter<ProductModel, ProductAdapter.ProductViewHolder> {

    public ProductAdapter(Context ctx, List<ProductModel> list) {
        super(ctx, list);
    }

    @Override
    public int getLayout() {
        return R.layout.product_view_model;
    }

    @Override
    public ProductViewHolder createHolder(ProductModel model, int position, View convertView, ViewGroup parent) {
        ProductViewHolder holder = new ProductViewHolder();
        holder.img = (ImageView)convertView.findViewById(R.id.img);
        holder.lbl = (TextView)convertView.findViewById(R.id.lbl);
        return holder;
    }

    @Override
    public void updateHolder(ProductViewHolder holder, ProductModel model, int position, View convertView, ViewGroup parent){
        holder.img.setImageResource(model.Icon);
        holder.lbl.setText(model.Name);
    }

    public static class ProductViewHolder
    {
        ImageView img;
        TextView lbl;
    }
}
