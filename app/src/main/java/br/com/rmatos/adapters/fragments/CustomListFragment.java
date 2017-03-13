package br.com.rmatos.adapters.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.rmatos.adapters.R;
import br.com.rmatos.adapters.adapters.ProductAdapter;
import br.com.rmatos.adapters.interfaces.OnItemSelectedListener;
import br.com.rmatos.adapters.models.ProductModel;

public class CustomListFragment extends ListFragment {

    private ArrayList<ProductModel> list;
    private ProductAdapter adp;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        adp = new ProductAdapter(getActivity(), getData());
        setListAdapter(adp);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Activity activity = getActivity();
        if (activity instanceof OnItemSelectedListener){
            String value = (String)l.getItemAtPosition(position);
            OnItemSelectedListener handler = (OnItemSelectedListener)activity;
            handler.Select(value);
        }
    }

    private ArrayList<ProductModel> getData(){
        ArrayList<ProductModel> result = new ArrayList<ProductModel>();
        result.add(new ProductModel("Keyboard", R.drawable.item_keyboard));
        result.add(new ProductModel("Mouse", R.drawable.item_mouse));
        result.add(new ProductModel("Notebook", R.drawable.item_notebook));
        result.add(new ProductModel("Printer", R.drawable.item_printer));
        return result;
    }

}
