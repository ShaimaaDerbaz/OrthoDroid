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
import com.example.shaimaaderbaz.orthoclinic.models.PatientProfile;
import com.example.shaimaaderbaz.orthoclinic.models.PersonalItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by Shaimaa Derbaz on 8/17/2018.
 */

public class PatientProfileHistoryAdapter extends RecyclerView.Adapter<PatientProfileHistoryAdapter.ViewHolder> {

private List<PersonalItem> DataSet;
private static Context context;


    public PatientProfileHistoryAdapter(Context cont, List<PersonalItem> dataSet)
    {
        context=cont;
        DataSet = dataSet;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.status_history_text_item)TextView status_history_text_item;
        @BindView(R.id.info_history_text_item)TextView info_history_text_item;
        @BindView(R.id.images_history_linear)LinearLayout images_history_linear;
        @BindView(R.id.vedios_history_linear)TextView vedios_history_linear;
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

        public LinearLayout getImages_history_linear() {
            return images_history_linear;
        }

        public void setImages_history_linear(LinearLayout images_history_linear) {
            this.images_history_linear = images_history_linear;
        }

        public TextView getVedios_history_linear() {
            return vedios_history_linear;
        }

        public void setVedios_history_linear(TextView vedios_history_linear) {
            this.vedios_history_linear = vedios_history_linear;
        }

   /*     public ImageView getIv_image() {
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
            holder.getStatus_history_text_item().setText(DataSet.get(position).getStatusName());
            holder.getInfo_history_text_item().setText(DataSet.get(position).getInfo());


        }
    }

    @Override
    public int getItemCount() {
        return DataSet.size();
    }

    public void filterList(List<PersonalItem> filterdNames) {
        this.DataSet = filterdNames;
        notifyDataSetChanged();
    }


}
