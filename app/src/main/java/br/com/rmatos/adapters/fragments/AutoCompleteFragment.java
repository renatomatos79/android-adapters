package br.com.rmatos.adapters.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.rmatos.adapters.R;
import br.com.rmatos.adapters.adapters.ProductAutoCompleteAdapter;
import br.com.rmatos.adapters.interfaces.OnItemSelectedListener;
import br.com.rmatos.adapters.models.ProductModel;

public class AutoCompleteFragment extends Fragment {

    private ProductAutoCompleteAdapter adp;
    private AutoCompleteTextView actProduct;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.adp = new ProductAutoCompleteAdapter(getActivity(), ProductModel.fakeList());
        View layout = inflater.inflate(R.layout.product_view_autocomplete, container, false);
        actProduct = (AutoCompleteTextView)layout.findViewById(R.id.actProduct);
        actProduct.setAdapter(this.adp);
        return layout;
    }

}
