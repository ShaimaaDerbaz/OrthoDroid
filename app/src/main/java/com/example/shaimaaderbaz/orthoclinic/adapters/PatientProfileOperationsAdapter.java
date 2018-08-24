package com.example.shaimaaderbaz.orthoclinic.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.OperationsItem;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by shaimaa Derbaz on 08/23/2018.
 */

public class PatientProfileOperationsAdapter extends RecyclerView.Adapter<PatientProfileOperationsAdapter.ViewHolder> {

    private List<OperationsItem> DataSet;
    private static Context context;

    public PatientProfileOperationsAdapter(Context cont, List<OperationsItem> dataSet)
    {
        context=cont;
        DataSet = dataSet;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.op_name_text_item)TextView op_name_text_item;
        @BindView(R.id.date_text_item)TextView date_text_item;
        @BindView(R.id.steps_text_item)TextView steps_text_item;
        @BindView(R.id.persons_text_item)TextView persons_text_item;
        @BindView(R.id.follow_text_item)TextView follow_text_item;


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

        public TextView getOp_name_text_item() {
            return op_name_text_item;
        }

        public void setOp_name_text_item(TextView op_name_text_item) {
            this.op_name_text_item = op_name_text_item;
        }

        public TextView getDate_text_item() {
            return date_text_item;
        }

        public void setDate_text_item(TextView date_text_item) {
            this.date_text_item = date_text_item;
        }

        public TextView getSteps_text_item() {
            return steps_text_item;
        }

        public void setSteps_text_item(TextView steps_text_item) {
            this.steps_text_item = steps_text_item;
        }

        public TextView getPersons_text_item() {
            return persons_text_item;
        }

        public void setPersons_text_item(TextView persons_text_item) {
            this.persons_text_item = persons_text_item;
        }

        public TextView getFollow_text_item() {
            return follow_text_item;
        }

        public void setFollow_text_item(TextView follow_text_item) {
            this.follow_text_item = follow_text_item;
        }
    }

    @Override
    public PatientProfileOperationsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patient_personal_operations_item, parent, false);

        return  new PatientProfileOperationsAdapter.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final PatientProfileOperationsAdapter.ViewHolder holder, int position)
    {
        if (DataSet.get(position) != null) {
            Log.d("", "Element " + position + " set.");
            holder.getOp_name_text_item().setText(DataSet.get(position).getName());
            holder.getDate_text_item().setText(DataSet.get(position).getDate());
            holder.getSteps_text_item().setText(DataSet.get(position).getSteps()+"");
            holder.getPersons_text_item().setText(DataSet.get(position).getPersons());
            holder.getFollow_text_item().setText(DataSet.get(position).getFollowup());


        }
    }

    @Override
    public int getItemCount() {
        return DataSet.size();
    }

    public void filterList(List<OperationsItem> filterdNames) {
        this.DataSet = filterdNames;
        notifyDataSetChanged();
    }


}
