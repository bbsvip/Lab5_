package com.bbs.mr.employeemanage;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter implements ListAdapter {
    private List<Employee> arrEmployees;
    public Activity context;
    private LayoutInflater inflater;

    public CustomAdapter(Activity context, List<Employee> arrayCaiDat) {
        super();
        this.context = context;
        this.arrEmployees = arrayCaiDat;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return arrEmployees.size();
    }

    @Override
    public Object getItem(int position) {
        return arrEmployees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    public static class ViewHolder {
        ImageView img;
        TextView txtName;
        TextView txtPhone;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.activity_custom_adapter, null);
            holder.img = convertView.findViewById(R.id.ivIconEm);
            holder.txtName = convertView.findViewById(R.id.tvName);
            holder.txtPhone = convertView.findViewById(R.id.tvPhone);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
        Employee _entry = arrEmployees.get(position);
        holder.img.setImageResource(R.drawable.contact);
        holder.txtName.setText(_entry.getName());
        holder.txtPhone.setText(_entry.getPhone());
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
