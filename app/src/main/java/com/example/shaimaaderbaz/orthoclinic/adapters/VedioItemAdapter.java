package com.example.shaimaaderbaz.orthoclinic.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.MediaItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by Shaimaa Derbaz on 8/17/2018.
 */

public class VedioItemAdapter extends RecyclerView.Adapter<VedioItemAdapter.ViewHolder> {

    private List<MediaItem> DataSet;
    private static Context context;
    private VedioItemAdapter.VedioItemAdapterListener mVedioItemAdapterListener;
    public interface VedioItemAdapterListener{
        void onItemVedioClicked(int adapterPos);

    }

    public VedioItemAdapter(Context cont, List<MediaItem> dataSet, VedioItemAdapterListener listener)
    {
        context=cont;
        DataSet = dataSet;
        this.mVedioItemAdapterListener=listener;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.iv_video)ImageView iv_video;

        public ViewHolder(View v)
        {

             super(v);

            v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Element " + getPosition() + " clicked.");
                if(mVedioItemAdapterListener != null){
                    MediaItem clickedItem = DataSet.get(getAdapterPosition());
                    mVedioItemAdapterListener.onItemVedioClicked(getAdapterPosition());
                }

            }
            });

            ButterKnife.bind(this,v);

        }

        public ImageView getIv_video() {
            return iv_video;
        }

        public void setIv_video(ImageView iv_video) {
            this.iv_video = iv_video;
        }
    }

    @Override
    public VedioItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_item, parent, false);

        return  new VedioItemAdapter.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final VedioItemAdapter.ViewHolder holder, int position)
    {
        if (DataSet.get(position) != null) {
            Log.d("", "Element " + position + " set.");
            String vedioUrl=DataSet.get(position).getUrl();
            Picasso.with(context).load(vedioUrl).resize(600,900).into(holder.iv_video);
        }
    }

    @Override
    public int getItemCount() {
        return DataSet.size();
    }

    public void filterList(List<MediaItem> filterdNames) {
        this.DataSet = filterdNames;
        notifyDataSetChanged();
    }


}
