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
import com.example.shaimaaderbaz.orthoclinic.models.InvestigationItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by Shaimaa Derbaz on 8/17/2018.
 */

public class PatientProfileInvestigationAdapter extends RecyclerView.Adapter<PatientProfileInvestigationAdapter.ViewHolder> {

private List<InvestigationItem> DataSet;
private static Context context;


    public PatientProfileInvestigationAdapter(Context cont, List<InvestigationItem> dataSet)
    {
        context=cont;
        DataSet = dataSet;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.chemistry_text_item)TextView chemistry_text_item;
        @BindView(R.id.cls_text_item)TextView cls_text_item;
        @BindView(R.id.cutology_text_item)TextView cytology_text_item;
        @BindView(R.id.xray_text_item)TextView xray_text_item;
        @BindView(R.id.scanogram_text_item)TextView scanogram_text_item;
        @BindView(R.id.ct_text_item)TextView ct_text_item;
        @BindView(R.id.mri_text_item)TextView mri_text_item;
        @BindView(R.id.dexa_text_item)TextView dexa_text_item;
        @BindView(R.id.bone_text_item)TextView bone_text_item;

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

        public TextView getChemistry_text_item() {
            return chemistry_text_item;
        }

        public void setChemistry_text_item(TextView chemistry_text_item) {
            this.chemistry_text_item = chemistry_text_item;
        }

        public TextView getCls_text_item() {
            return cls_text_item;
        }

        public void setCls_text_item(TextView cls_text_item) {
            this.cls_text_item = cls_text_item;
        }

        public TextView getCytology_text_item() {
            return cytology_text_item;
        }

        public void setCytology_text_item(TextView cytology_text_item) {
            this.cytology_text_item = cytology_text_item;
        }

        public TextView getXray_text_item() {
            return xray_text_item;
        }

        public void setXray_text_item(TextView xray_text_item) {
            this.xray_text_item = xray_text_item;
        }

        public TextView getScanogram_text_item() {
            return scanogram_text_item;
        }

        public void setScanogram_text_item(TextView scanogram_text_item) {
            this.scanogram_text_item = scanogram_text_item;
        }

        public TextView getCt_text_item() {
            return ct_text_item;
        }

        public void setCt_text_item(TextView ct_text_item) {
            this.ct_text_item = ct_text_item;
        }

        public TextView getMri_text_item() {
            return mri_text_item;
        }

        public void setMri_text_item(TextView mri_text_item) {
            this.mri_text_item = mri_text_item;
        }

        public TextView getDexa_text_item() {
            return dexa_text_item;
        }

        public void setDexa_text_item(TextView dexa_text_item) {
            this.dexa_text_item = dexa_text_item;
        }

        public TextView getBone_text_item() {
            return bone_text_item;
        }

        public void setBone_text_item(TextView bone_text_item) {
            this.bone_text_item = bone_text_item;
        }
    }

    @Override
    public PatientProfileInvestigationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patient_personal_investigation_item, parent, false);

        return  new PatientProfileInvestigationAdapter.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final PatientProfileInvestigationAdapter.ViewHolder holder, int position)
    {
        if (DataSet.get(position) != null) {
            Log.d("", "Element " + position + " set.");
            if(DataSet.get(position).getChemistry())
            {
                holder.getChemistry_text_item().setText("Chemistry");
                holder.getChemistry_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).getCls())
            {
                holder.getCls_text_item().setText("C.L.S");
                holder.getCls_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).getCytology())
            {
                holder.getCytology_text_item().setText("Cytology");
                holder.getCytology_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).getXray())
            {
                holder.getXray_text_item().setText("X-Ray");
                holder.getXray_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).getScanogram())
            {
                holder.getScanogram_text_item().setText("Scanogram");
                holder.getScanogram_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).getCt())
            {
                holder.getCt_text_item().setText("C.T");
                holder.getCt_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).getMri())
            {
                holder.getMri_text_item().setText("M.R.I");
                holder.getMri_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).getDexa())
            {
                holder.getDexa_text_item().setText("DEXA");
                holder.getDexa_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }
            if(DataSet.get(position).getBonescan())
            {
                holder.getBone_text_item().setText("Bone Scan");
                holder.getBone_text_item().setTextColor(context.getResources().getColor(R.color.colorPrimary));
            }

        }
    }

    @Override
    public int getItemCount() {
        return DataSet.size();
    }

    public void filterList(List<InvestigationItem> filterdNames) {
        this.DataSet = filterdNames;
        notifyDataSetChanged();
    }


}
