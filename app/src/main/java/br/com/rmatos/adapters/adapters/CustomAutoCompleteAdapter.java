package br.com.rmatos.adapters.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomAutoCompleteAdapter<T extends Object> extends ArrayAdapter<T> {

    private Context ctx;
    private List<T> list;
    private List<T> result;
    private Filter customFilter;

    public CustomAutoCompleteAdapter(Context ctx, List<T> fullList)
    {
        super(ctx, android.R.layout.simple_dropdown_item_1line, fullList);
        this.ctx = ctx;
        this.list = fullList;
        this.result = fullList;
        this.customFilter = new CustomFilter();
    }

    public List<T> getList(){
        return this.list;
    }

    @Override
    public int getCount() {
        return result.size();
    }

    @Override
    public T getItem(int position) {
        if (this.result != null && this.result.size() > 0 && position < this.result.size()){
            return this.result.get(position);
        }
        return null;
    }

    @Override
    public Filter getFilter(){

        return this.customFilter;
    }

    public abstract List<T> createList(CharSequence text);

    private class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults fr = new FilterResults();
            ArrayList<T> temp = new ArrayList<T>();
            if (constraint != null){
                constraint = constraint.toString().trim().toLowerCase();
                List<T> filteredList = createList(constraint);
                for (T c : filteredList){
                    temp.add(c);
                }
            }
            fr.values = temp;
            fr.count = temp.size();
            return fr;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            result = (ArrayList<T>)(filterResults.values);
            notifyDataSetChanged();
        }
    }

}