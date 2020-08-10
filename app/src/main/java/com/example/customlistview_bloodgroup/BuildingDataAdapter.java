package com.example.customlistview_bloodgroup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

class BuildingDataAdapter extends ArrayAdapter<BuildingData> {

    private Context context;
    private ArrayList<BuildingData>  values;
    TextView tvID,tvstatus,tvDetail,tvPlace,tvDays,tvDepartment,tvPriority,tvType;
    ImageView im1,im2;
    View view2;

    public BuildingDataAdapter(@NonNull Context context, ArrayList<BuildingData> list) {
        super(context, R.layout.row_layout_building,list);

        this.context = context;
        this.values=list;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowview= inflater.inflate(R.layout.row_layout_building,parent,false);

        tvID = rowview.findViewById(R.id.tvID);
        tvstatus = rowview.findViewById(R.id.tvStatus);
        tvDetail = rowview.findViewById(R.id.tvDetail);
        tvPlace = rowview.findViewById(R.id.tvPlace);
        tvDays = rowview.findViewById(R.id.tvTime);
        tvDepartment = rowview.findViewById(R.id.tvDepartment);
        tvPriority = rowview.findViewById(R.id.tvPriority);
        tvType = rowview.findViewById(R.id.tvType);
        view2 = rowview.findViewById(R.id.view2);
        im1 = rowview.findViewById(R.id.im1);
        im2 = rowview.findViewById(R.id.im2);

        if(values.get(position).getType()==null) {
            view2.setVisibility(View.GONE);
        }

        tvID.setText(values.get(position).getID());
        tvstatus.setText(values.get(position).getStatus());
        tvDetail.setText(values.get(position).getDetail());
        tvPlace.setText(values.get(position).getPlace());
        tvDays.setText(values.get(position).getDays());
        tvDepartment.setText(values.get(position).getDepartment());
        tvPriority.setText(values.get(position).getPriority());
        tvType.setText(values.get(position).getType());
        im1.setImageResource(values.get(position).getMain_image());
        im2.setImageResource(values.get(position).getSecond_image());


        return rowview;

    }
}
