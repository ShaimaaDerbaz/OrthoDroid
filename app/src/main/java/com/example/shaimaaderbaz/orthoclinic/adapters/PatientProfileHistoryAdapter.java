package com.example.shaimaaderbaz.orthoclinic.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.HistoryItem;
import com.example.shaimaaderbaz.orthoclinic.models.MedicalHistoryItem;
import com.example.shaimaaderbaz.orthoclinic.models.PatientProfile;
import com.example.shaimaaderbaz.orthoclinic.models.PersonalItem;
import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by Shaimaa Derbaz on 8/17/2018.
 */

public class PatientProfileHistoryAdapter extends RecyclerView.Adapter<PatientProfileHistoryAdapter.ViewHolder> {

    private List<MedicalHistoryItem> DataSet;
    private static Context context;
    private PatientProfileHistoryAdapter.PatientProfileHistoryAdapterListener mPatientProfileHistoryAdapterListener;
    public interface PatientProfileHistoryAdapterListener{
        void onItemHistoryClicked(int id,int adapterPos);

    }



    public PatientProfileHistoryAdapter(Context cont, List<MedicalHistoryItem> dataSet,PatientProfileHistoryAdapterListener listener)
    {
        context=cont;
        DataSet = dataSet;
        this.mPatientProfileHistoryAdapterListener=listener;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.status_history_text_item)TextView status_history_text_item;
        @BindView(R.id.info_history_text_item)TextView info_history_text_item;


        public ViewHolder(View v)
        {

             super(v);

            v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Element " + getPosition() + " clicked.");
                if(mPatientProfileHistoryAdapterListener != null){
                    MedicalHistoryItem clickedItem = DataSet.get(getAdapterPosition());
                    mPatientProfileHistoryAdapterListener.onItemHistoryClicked(clickedItem.getId(),getAdapterPosition());
                }

            }
            });

            ButterKnife.bind(this,v);

        }

        public TextView getStatus_history_text_item() {
            return status_history_text_item;
        }

        public void setStatus_history_text_item(TextView status_history_text_item) {
            this.status_history_text_item = status_history_text_item;
        }

        public TextView getInfo_history_text_item() {
            return info_history_text_item;
        }

        public void setInfo_history_text_item(TextView info_history_text_item) {
            this.info_history_text_item = info_history_text_item;
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
            holder.getStatus_history_text_item().setText(DataSet.get(position).getState_name());
            holder.getInfo_history_text_item().setText(DataSet.get(position).getInfo());


        }
    }

    @Override
    public int getItemCount() {
        return DataSet.size();
    }

    public void filterList(List<MedicalHistoryItem> filterdNames) {
        this.DataSet = filterdNames;
        notifyDataSetChanged();
    }


}
