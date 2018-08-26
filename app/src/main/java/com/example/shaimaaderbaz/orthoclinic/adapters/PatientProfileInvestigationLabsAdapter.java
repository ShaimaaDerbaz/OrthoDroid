package com.example.shaimaaderbaz.orthoclinic.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.LabItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by Shaimaa Derbaz on 8/17/2018.
 */

public class PatientProfileInvestigationLabsAdapter extends RecyclerView.Adapter<PatientProfileInvestigationLabsAdapter.ViewHolder> {

private List<LabItem> DataSet;
private static Context context;


    public PatientProfileInvestigationLabsAdapter(Context cont, List<LabItem> dataSet)
    {
        context=cont;
        DataSet = dataSet;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.status_invest_labs_text_item)TextView status_invest_text_item;
        @BindView(R.id.info_invest_labs_text_item)TextView info_invest_text_item;
       // @BindView(R.id.images_invest_linear)LinearLayout images_invest_linear;
        //@BindView(R.id.vedios_invest_linear)TextView vedios_invest_linear;
       // @BindView(R.id.iv_image)ImageView iv_image;
       // @BindView(R.id.iv_video)VideoView iv_video;
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

        public TextView getStatus_invest_text_item() {
            return status_invest_text_item;
        }

        public void setStatus_invest_text_item(TextView status_invest_text_item) {
            this.status_invest_text_item = status_invest_text_item;
        }

        public TextView getInfo_invest_text_item() {
            return info_invest_text_item;
        }

        public void setInfo_invest_text_item(TextView info_invest_text_item) {
            this.info_invest_text_item = info_invest_text_item;
        }

        /*public LinearLayout getImages_invest_linear() {
            return images_invest_linear;
        }

        public void setImages_invest_linear(LinearLayout images_invest_linear) {
            this.images_invest_linear = images_invest_linear;
        }

        public TextView getVedios_invest_linear() {
            return vedios_invest_linear;
        }

        public void setVedios_invest_linear(TextView vedios_invest_linear) {
            this.vedios_invest_linear = vedios_invest_linear;
        }

        public ImageView getIv_image() {
            return iv_image;
        }

        public void setIv_image(ImageView iv_image) {
            this.iv_image = iv_image;
        }

        public VideoView getIv_video() {
            return iv_video;
        }

        public void setIv_video(VideoView iv_video) {
            this.iv_video = iv_video;
        }*/
    }

    @Override
    public PatientProfileInvestigationLabsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patient_personal_investigation_labs_item, parent, false);

        return  new PatientProfileInvestigationLabsAdapter.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final PatientProfileInvestigationLabsAdapter.ViewHolder holder, int position)
    {
        if (DataSet.get(position) != null) {
            Log.d("", "Element " + position + " set.");
            holder.getStatus_invest_text_item().setText(DataSet.get(position).getName());
            holder.getInfo_invest_text_item().setText(DataSet.get(position).getInfo());
        }
    }

    @Override
    public int getItemCount() {
        return DataSet.size();
    }

    public void filterList(List<LabItem> filterdNames) {
        this.DataSet = filterdNames;
        notifyDataSetChanged();
    }


}
