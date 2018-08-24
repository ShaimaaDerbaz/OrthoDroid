package com.example.shaimaaderbaz.orthoclinic.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.ExaminationItem;
import com.example.shaimaaderbaz.orthoclinic.models.HistoryItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by Shaimaa Derbaz on 8/17/2018.
 */

public class PatientProfileExaminationAdapter extends RecyclerView.Adapter<PatientProfileExaminationAdapter.ViewHolder> {

private List<ExaminationItem> DataSet;
private static Context context;


    public PatientProfileExaminationAdapter(Context cont, List<ExaminationItem> dataSet)
    {
        context=cont;
        DataSet = dataSet;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.trauma_text_item)TextView trauma_text_item;
        @BindView(R.id.knee_text_item)TextView knee_text_item;
        @BindView(R.id.shoulder_text_item)TextView shoulder_text_item;
        @BindView(R.id.sqine_text_item)TextView sqine_text_item;
        @BindView(R.id.pelvis_text_item)TextView pelvis_text_item;
        @BindView(R.id.anke_text_item)TextView anke_text_item;
        @BindView(R.id.elbow_text_item)TextView elbow_text_item;
        @BindView(R.id.wrist_text_item)TextView wrist_text_item;



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

        public TextView getTrauma_text_item() {
            return trauma_text_item;
        }

        public void setTrauma_text_item(TextView trauma_text_item) {
            this.trauma_text_item = trauma_text_item;
        }

        public TextView getKnee_text_item() {
            return knee_text_item;
        }

        public void setKnee_text_item(TextView knee_text_item) {
            this.knee_text_item = knee_text_item;
        }

        public TextView getShoulder_text_item() {
            return shoulder_text_item;
        }

        public void setShoulder_text_item(TextView shoulder_text_item) {
            this.shoulder_text_item = shoulder_text_item;
        }

        public TextView getSqine_text_item() {
            return sqine_text_item;
        }

        public void setSqine_text_item(TextView sqine_text_item) {
            this.sqine_text_item = sqine_text_item;
        }

        public TextView getPelvis_text_item() {
            return pelvis_text_item;
        }

        public void setPelvis_text_item(TextView pelvis_text_item) {
            this.pelvis_text_item = pelvis_text_item;
        }

        public TextView getAnke_text_item() {
            return anke_text_item;
        }

        public void setAnke_text_item(TextView anke_text_item) {
            this.anke_text_item = anke_text_item;
        }

        public TextView getElbow_text_item() {
            return elbow_text_item;
        }

        public void setElbow_text_item(TextView elbow_text_item) {
            this.elbow_text_item = elbow_text_item;
        }

        public TextView getWrist_text_item() {
            return wrist_text_item;
        }

        public void setWrist_text_item(TextView wrist_text_item) {
            this.wrist_text_item = wrist_text_item;
        }
    }

    @Override
    public PatientProfileExaminationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patient_personal_examination_item, parent, false);

        return  new PatientProfileExaminationAdapter.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final PatientProfileExaminationAdapter.ViewHolder holder, int position)
    {
        if (DataSet.get(position) != null) {
            Log.d("", "Element " + position + " set.");
            if(DataSet.get(position).getTrauma())
            {
                holder.getTrauma_text_item().setText("Trauma");
                holder.getTrauma_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).getKnee())
            {
                holder.getKnee_text_item().setText("Knee");
                holder.getKnee_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).getShoulder())
            {
                holder.getShoulder_text_item().setText("Shoulder");
                holder.getShoulder_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).getSqine())
            {
                holder.getSqine_text_item().setText("sQine");
                holder.getSqine_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).getPelvis())
            {
                holder.getPelvis_text_item().setText("Pelvis");
                holder.getPelvis_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).getAnkefoot())
            {
                holder.getAnke_text_item().setText("Ankefoot");
                holder.getAnke_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).getElbow())
            {
                holder.getElbow_text_item().setText("Elbow");
                holder.getElbow_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).getWrist())
            {
                holder.getWrist_text_item().setText("Wrist");
                holder.getWrist_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }




        }
    }

    @Override
    public int getItemCount() {
        return DataSet.size();
    }

    public void filterList(List<ExaminationItem> filterdNames) {
        this.DataSet = filterdNames;
        notifyDataSetChanged();
    }


}
