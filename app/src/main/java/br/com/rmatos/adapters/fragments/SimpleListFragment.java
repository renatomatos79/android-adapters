package br.com.rmatos.adapters.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.com.rmatos.adapters.R;
import br.com.rmatos.adapters.interfaces.OnItemSelectedListener;

public class SimpleListFragment extends ListFragment {

    private String[] list;
    private ArrayAdapter<String> adp;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        this.list = this.getActivity().getResources().getStringArray(R.array.list_products);
        this.adp = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, list);
        setListAdapter(this.adp);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Activity activity = getActivity();
        if (activity instanceof OnItemSelectedListener){
            String name = (String)l.getItemAtPosition(position);
            OnItemSelectedListener listener = (OnItemSelectedListener)activity;
            listener.select(name);
        }
    }

}
