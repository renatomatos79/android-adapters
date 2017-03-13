package br.com.rmatos.adapters.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import br.com.rmatos.adapters.models.ProductModel;

public class ProductAutoCompleteAdapter extends CustomAutoCompleteAdapter<ProductModel> {

    public ProductAutoCompleteAdapter(Context ctx, ArrayList<ProductModel> fullList)
    {
        super(ctx, fullList);
    }

    @Override
    public List<ProductModel> createList(CharSequence text)
    {
        List<ProductModel> result = new ArrayList<ProductModel>();
        for (ProductModel c : getList()){
            if (c.Name.toLowerCase().trim().contains(text)){
                result.add(c);
            }
        }
        return result;
    }
}