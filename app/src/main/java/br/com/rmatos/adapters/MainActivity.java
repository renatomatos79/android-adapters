package br.com.rmatos.adapters;

import android.icu.text.Replaceable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.rmatos.adapters.fragments.CustomGroupListFragment;
import br.com.rmatos.adapters.fragments.CustomListFragment;
import br.com.rmatos.adapters.fragments.SimpleListFragment;
import br.com.rmatos.adapters.interfaces.OnItemSelectedListener;
import br.com.rmatos.adapters.models.ProductModel;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener<Object> {

    private String[] list;
    private Spinner spnOptions;
    private ArrayAdapter<String> adpOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.list = this.getResources().getStringArray(R.array.list_options);

        adpOptions = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        spnOptions = (Spinner) findViewById(R.id.spnOptions);
        spnOptions.setAdapter(adpOptions);


        spnOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = list[i];
                ListFragment fragment = null;
                if (item.equals("Lista simples")){
                    fragment = new SimpleListFragment();
                } else if (item.equals("Lista customizada")){
                    fragment = new CustomListFragment();
                } else if (item.equals("Lista agrupada")){
                    fragment = new CustomGroupListFragment();
                }
                if (fragment != null){
                    replaceFragment(fragment);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void replaceFragment(ListFragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.customLayout, fragment);
        ft.commit();
    }

    @Override
    public void Select(Object item) {
        String name = "";

        if (item instanceof String){
            name = (String)item;
        } else {
            name = ((ProductModel)item).Name;
        }
        Toast.makeText(this, name, Toast.LENGTH_LONG).show();
    }
}