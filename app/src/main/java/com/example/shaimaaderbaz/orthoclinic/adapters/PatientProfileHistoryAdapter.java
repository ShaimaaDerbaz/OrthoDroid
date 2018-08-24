package com.example.shaimaaderbaz.orthoclinic.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.HistoryItem;
import com.example.shaimaaderbaz.orthoclinic.models.PatientProfile;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by Shaimaa Derbaz on 8/17/2018.
 */

public class PatientProfileHistoryAdapter extends RecyclerView.Adapter<PatientProfileHistoryAdapter.ViewHolder> {

private List<HistoryItem> DataSet;
private static Context context;


    public PatientProfileHistoryAdapter(Context cont, List<HistoryItem> dataSet)
    {
        context=cont;
        DataSet = dataSet;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.ch_text_item)TextView ch_text_item;
        @BindView(R.id.gastritis_text_item)TextView gastritis_text_item;
        @BindView(R.id.smoking_text_item)TextView smoking_text_item;
        @BindView(R.id.pregnacy_text_item)TextView pregnacy_text_item;
        @BindView(R.id.lactation_text_item)TextView lactation_text_item;


        public ViewHolder(View v)
        {

             super(v);

            v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Element " + getPosition() + " clicked.");

            }
            });

            ButterKnife.bind(this,v);

        }

        public TextView getCh_text_item() {
            return ch_text_item;
        }

        public void setCh_text_item(TextView ch_text_item) {
            this.ch_text_item = ch_text_item;
        }

        public TextView getGastritis_text_item() {
            return gastritis_text_item;
        }

        public void setGastritis_text_item(TextView gastritis_text_item) {
            this.gastritis_text_item = gastritis_text_item;
        }

        public TextView getSmoking_text_item() {
            return smoking_text_item;
        }

        public void setSmoking_text_item(TextView smoking_text_item) {
            this.smoking_text_item = smoking_text_item;
        }

        public TextView getPregnacy_text_item() {
            return pregnacy_text_item;
        }

        public void setPregnacy_text_item(TextView pregnacy_text_item) {
            this.pregnacy_text_item = pregnacy_text_item;
        }

        public TextView getLactation_text_item() {
            return lactation_text_item;
        }

        public void setLactation_text_item(TextView lactation_text_item) {
            this.lactation_text_item = lactation_text_item;
        }
    }

    @Override
    public PatientProfileHistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patient_personal_history_item, parent, false);

        return  new PatientProfileHistoryAdapter.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final PatientProfileHistoryAdapter.ViewHolder holder, int position)
    {
        if (DataSet.get(position) != null) {
            Log.d("", "Element " + position + " set.");
            if(DataSet.get(position).isCh())
            {
                holder.getCh_text_item().setText("CH");
                holder.getCh_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).isGastritis())
            {
                holder.getGastritis_text_item().setText("Gastritis");
                holder.getGastritis_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).isSmoking())
            {
                holder.getSmoking_text_item().setText("Smoking");
                holder.getSmoking_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).isPregnecy())
            {
                holder.getPregnacy_text_item().setText("Pregnacy.");
                holder.getPregnacy_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).isLactation())
            {
                holder.getLactation_text_item().setText("Lactation");
                holder.getLactation_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }



        }
    }

    @Override
    public int getItemCount() {
        return DataSet.size();
    }

    public void filterList(List<HistoryItem> filterdNames) {
        this.DataSet = filterdNames;
        notifyDataSetChanged();
    }


}
