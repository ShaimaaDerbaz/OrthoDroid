package com.example.shaimaaderbaz.orthoclinic.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.models.PatientProfile;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by Shaimaa Derbaz on 8/17/2018.
 */

public class PatientProfileAdapter extends RecyclerView.Adapter<PatientProfileAdapter.ViewHolder> {

private List<PatientProfile> DataSet;
private static Context context;


    public PatientProfileAdapter(Context cont, List<PatientProfile> dataSet)
    {
        context=cont;
        DataSet = dataSet;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.patientName)TextView patientName;
        @BindView(R.id.patientId)TextView patientId;
        @BindView(R.id.age)TextView age;
        @BindView(R.id.date)TextView date;
        @BindView(R.id.info)TextView info;


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

        public TextView getPatientName() {
            return patientName;
        }

         public void setPatientName(TextView patientName) {
             this.patientName = patientName;
        }

        public TextView getPatientId() {
            return patientId;
        }

        public void setPatientId(TextView patientId) {
            this.patientId = patientId;
        }

        public TextView getAge() {
            return age;
        }

        public void setAge(TextView age) {
            this.age = age;
        }

        public TextView getDate() {
            return date;
        }

        public void setDate(TextView date) {
            this.date = date;
        }

        public TextView getInfo() {
            return info;
        }

        public void setInfo(TextView info) {
            this.info = info;
        }


    }

    @Override
    public PatientProfileAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patient_item, parent, false);

        return  new PatientProfileAdapter.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final PatientProfileAdapter.ViewHolder holder, int position)
    {
        if (DataSet.get(position) != null) {
            Log.d("", "Element " + position + " set.");
            holder.getPatientName().setText(DataSet.get(position).getPatientName());
            holder.getPatientId().setText(DataSet.get(position).getId());
            holder.getAge().setText(DataSet.get(position).getAge()+"");
            holder.getInfo().setText(DataSet.get(position).getInfo());
            holder.getDate().setText(DataSet.get(position).getLastdate());


        }
    }

    @Override
    public SolventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == VIEW_WITH_EXTRA_TEXT_VIEW) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.solvent_list_with_extra_text_view, parent, false);
            return new SolventViewHolderWithExtraTextView(itemView);
        } else {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.solvent_list, parent, false);
            return new SolventViewHolder(itemView);
        }
    }

    @Override
    public int getItemCount() {
        return DataSet.size();
    }

    public void filterList(List<PatientProfile> filterdNames) {
        this.DataSet = filterdNames;
        notifyDataSetChanged();
    }


}
