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
import com.example.shaimaaderbaz.orthoclinic.models.ComplainItem;
import com.example.shaimaaderbaz.orthoclinic.models.ExaminationItem;
import com.example.shaimaaderbaz.orthoclinic.models.HistoryItem;
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

public class PatientProfileExaminationAdapter extends RecyclerView.Adapter<PatientProfileExaminationAdapter.ViewHolder> {

    private List<ComplainItem> DataSet;
    private static Context context;
    private PatientProfileExaminationAdapter.PatientProfileExaminationAdapterListener mPatientProfileExaminationAdapterListener;
    public interface PatientProfileExaminationAdapterListener{
        void onItemCompClicked(int id,int adapterPos);

    }


    public PatientProfileExaminationAdapter(Context cont, List<ComplainItem> dataSet,PatientProfileExaminationAdapterListener listener)
    {
        context=cont;
        DataSet = dataSet;
        mPatientProfileExaminationAdapterListener=listener;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.status_ex_text_item)TextView status_ex_text_item;
        @BindView(R.id.info_ex_text_item)TextView info_ex_text_item;
        //@BindView(R.id.images_examination_linear)LinearLayout images_examination_linear;
        //@BindView(R.id.vedios_examination_linear)TextView vedios_examination_linear;
      //  @BindView(R.id.iv_image)ImageView iv_image;
      //  @BindView(R.id.iv_video)VideoView iv_video;

        public ViewHolder(View v)
        {

             super(v);

            v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Element " + getPosition() + " clicked.");
                if(mPatientProfileExaminationAdapterListener != null){
                    ComplainItem clickedItem = DataSet.get(getAdapterPosition());
                    mPatientProfileExaminationAdapterListener.onItemCompClicked(clickedItem.getId(),getAdapterPosition());
                }

            }
            });

            ButterKnife.bind(this,v);

        }

        public TextView getStatus_ex_text_item() {
            return status_ex_text_item;
        }

        public void setStatus_ex_text_item(TextView status_ex_text_item) {
            this.status_ex_text_item = status_ex_text_item;
        }

        public TextView getInfo_ex_text_item() {
            return info_ex_text_item;
        }

        public void setInfo_ex_text_item(TextView info_ex_text_item) {
            this.info_ex_text_item = info_ex_text_item;
        }

      /*  public LinearLayout getImages_examination_linear() {
            return images_examination_linear;
        }

        public void setImages_examination_linear(LinearLayout images_examination_linear) {
            this.images_examination_linear = images_examination_linear;
        }

        public TextView getVedios_examination_linear() {
            return vedios_examination_linear;
        }

        public void setVedios_examination_linear(TextView vedios_examination_linear) {
            this.vedios_examination_linear = vedios_examination_linear;
        }*/
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
            holder.getStatus_ex_text_item().setText(DataSet.get(position).getName());
            holder.getInfo_ex_text_item().setText(DataSet.get(position).getInfo());
           /* for(int i=0;i<DataSet.get(position).getImages().size();i++) {
                //ExaminationItem item = DataSet.get(position);
                ImageView imageViewPoster = holder.iv_image;
               // String imagePoster=""+item.getPoster_path();
                String imagePoster=""+"";
                Picasso.with(context).load(imagePoster).resize(600,900).into(imageViewPoster);
              //  ImageView imageView = new ImageView(holder.images_examination_linear.getContext());
                holder.images_examination_linear.addView(imageViewPoster);
               // holder.getImages_examination_linear().addView(DataSet.get(position).getImages().get(i)., 0, 0);
            }
            for(int i=0;i<DataSet.get(position).getVideos().size();i++) {
               // holder.getImages_examination_linear().addView(DataSet.get(position).getImages().get(i)., 0, 0);
            }*/
        }
    }

    @Override
    public int getItemCount() {
        return DataSet.size();
    }

    public void filterList(List<ComplainItem> filterdNames) {
        this.DataSet = filterdNames;
        notifyDataSetChanged();
    }


}
