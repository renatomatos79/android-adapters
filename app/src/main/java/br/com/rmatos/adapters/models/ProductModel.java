package br.com.rmatos.adapters.models;

import java.io.Serializable;

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
}
