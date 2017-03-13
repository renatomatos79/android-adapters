package br.com.rmatos.adapters.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.rmatos.adapters.interfaces.OnItemSelectedListener;

public abstract class CustomGroupAdapter<T extends Object, H extends Object> extends BaseExpandableListAdapter {

    private Context context;
    private Map<String, ArrayList<T>> list;
    private List<String> keys;

    public CustomGroupAdapter(Context ctx, Map<String, ArrayList<T>> list)
    {
        this.context = ctx;
        this.list = list;
        this.keys = new ArrayList<String>(
                list.keySet()
        );
    }

    public Context getContext(){
        return this.context;
    }

    public List<String> getKeys(){
        return this.keys;
    }

    public int getGroupLayout(){
        return android.R.layout.simple_expandable_list_item_1;
    }

    public void updateGroup(View converView, String groupName){
        TextView txt = (TextView)converView.findViewById(android.R.id.text1);
        txt.setBackgroundColor(Color.GRAY);
        txt.setTextColor(Color.WHITE);
        txt.setText(groupName);
    }

    public abstract int getLayout();

    public abstract H createHolder(T model, int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent);

    public abstract void updateHolder(H holder, T model, int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent);

    @Override
    public Object getGroup(int groupPosition) {
        return keys.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return keys.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View converView, ViewGroup parent){
        String groupName = keys.get(groupPosition);
        if (converView == null){
            converView = LayoutInflater.from(this.context).inflate(this.getGroupLayout(), null);
        }
        updateGroup(converView, groupName);
        return converView;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition){
        return list.get(keys.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition){
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final T model = list.get(keys.get(groupPosition)).get(childPosition);
        final H holder;
        if (convertView ==  null)
        {
            convertView = LayoutInflater.from(this.context).inflate(this.getLayout(), null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (context instanceof OnItemSelectedListener){
                        OnItemSelectedListener listener = (OnItemSelectedListener)context;
                        listener.select(model);
                    }
                }
            });
            holder = createHolder(model, groupPosition, childPosition, isLastChild, convertView, parent);
            convertView.setTag(holder);
        } else {
            holder = (H)convertView.getTag();
        }
        updateHolder(holder, model, groupPosition, childPosition, isLastChild, convertView, parent);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition){
        return list.get(keys.get(groupPosition)).size();
    }

    @Override
    public boolean hasStableIds(){
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition){
        return true;
    }

}
