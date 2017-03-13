package br.com.rmatos.adapters.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.com.rmatos.adapters.R;
import br.com.rmatos.adapters.adapters.ProductGroupAdapter;
import br.com.rmatos.adapters.interfaces.OnItemSelectedListener;
import br.com.rmatos.adapters.models.ProductModel;

public class CustomGroupListFragment extends ListFragment {

    private ArrayList<ProductModel> list;
    private ProductGroupAdapter adp;
    private ExpandableListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adp = new ProductGroupAdapter(getActivity(), getData());
        View view = inflater.inflate(R.layout.product_view_group_model, null);
        listView = (ExpandableListView)view.findViewById(R.id.listView);
        listView.setAdapter(adp);
        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Activity activity = getActivity();
        if (activity instanceof OnItemSelectedListener){
            String value = (String)l.getItemAtPosition(position);
            OnItemSelectedListener handler = (OnItemSelectedListener)activity;
            handler.select(value);
        }
    }

    private Map<String, ArrayList<ProductModel>> getData(){
        Map<String, ArrayList<ProductModel>> result = new HashMap<String, ArrayList<ProductModel>>();

        ArrayList<ProductModel> group1 = new ArrayList<ProductModel>();
        group1.add(new ProductModel("Keyboard", R.drawable.item_keyboard));
        group1.add(new ProductModel("Mouse", R.drawable.item_mouse));

        ArrayList<ProductModel> group2 = new ArrayList<ProductModel>();
        group2.add(new ProductModel("Notebook", R.drawable.item_notebook));
        group2.add(new ProductModel("Printer", R.drawable.item_printer));

        result.put("Grupo 2", group2);
        result.put("Grupo 1", group1);

        return result;
    }

}
