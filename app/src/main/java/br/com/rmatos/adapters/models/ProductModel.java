package br.com.rmatos.adapters.models;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.rmatos.adapters.R;

/**
 * Created by renato on 12/03/17.
 */

public class ProductModel implements Serializable {
    public String Name;
    final public int Icon;

    public ProductModel(String name, int icon) {
        this.Name = name;
        this.Icon = icon;
    }

    @Override
    public String toString() {
        return this.Name;
    }

    public static ArrayList<ProductModel> fakeList(){
        ArrayList<ProductModel> result = new ArrayList<ProductModel>();
        result.add(new ProductModel("Keyboard", R.drawable.item_keyboard));
        result.add(new ProductModel("Mouse", R.drawable.item_mouse));
        result.add(new ProductModel("Notebook", R.drawable.item_notebook));
        result.add(new ProductModel("Printer", R.drawable.item_printer));
        return result;
    }
}
