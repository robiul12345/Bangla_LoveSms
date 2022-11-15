package com.love.lovesms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SMSListCostomAdapter extends ArrayAdapter<SMSListModel> {
    private Context context;
    private ArrayList<SMSListModel> arrayList;

    public SMSListCostomAdapter(@NonNull Context context, ArrayList<SMSListModel> arrayList) {
        super(context, R.layout.sms_main_item);
        this.context = context;
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.sms_main_item, parent, false);

        TextView title = convertView.findViewById(R.id.textView_id);
        SMSListModel item = arrayList.get(position);
        title.setText(item.getName());

      return convertView;
    }

    @Override
    public int getCount() {
     return arrayList.size();
    }
}
