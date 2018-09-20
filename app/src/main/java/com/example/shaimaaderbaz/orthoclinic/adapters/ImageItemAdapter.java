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
import com.example.shaimaaderbaz.orthoclinic.views.TouchImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by Shaimaa Derbaz on 8/17/2018.
 */

public class ImageItemAdapter extends RecyclerView.Adapter<ImageItemAdapter.ViewHolder> {

    private List<MediaItem> DataSet;
    private static Context context;
    private ImageItemAdapter.ImageItemAdapterListener mImageItemAdapterListener;
    public interface ImageItemAdapterListener{
        void onItemImageClicked( int adapterPos);
        void onItemImageClickedLong(int adapterPos);

    }

    public ImageItemAdapter(Context cont, List<MediaItem> dataSet, ImageItemAdapterListener listener)
    {
        context=cont;
        DataSet = dataSet;
        this.mImageItemAdapterListener=listener;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        //@BindView(R.id.iv_image)ImageView iv_image;
       @BindView(R.id.iv_image)TouchImageView iv_image;


        public ViewHolder(View v)
        {

             super(v);

            v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Element " + getPosition() + " clicked.");
                if(mImageItemAdapterListener != null){
                    MediaItem clickedItem = DataSet.get(getAdapterPosition());
                    mImageItemAdapterListener.onItemImageClicked(getAdapterPosition());
                }

            }
            });

            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    // TODO Auto-generated method stub
                    mImageItemAdapterListener.onItemImageClickedLong(getAdapterPosition());
                    return true;
                }
            });

            ButterKnife.bind(this,v);

        }

        public TouchImageView getIv_image() {
            return iv_image;
        }

        public void setIv_image(TouchImageView iv_image) {
            this.iv_image = iv_image;
        }
    }

    @Override
    public ImageItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_item, parent, false);

        return  new ImageItemAdapter.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final ImageItemAdapter.ViewHolder holder, int position)
    {
        if (DataSet.get(position) != null) {
            Log.d("", "Element " + position + " set.");
            String imageUrl=DataSet.get(position).getUrl();
            //Picasso.with(context).load(imageUrl).resize(120,120).into(holder.iv_image);
            holder.iv_image=new TouchImageView(context);
            Picasso.with(context).load(imageUrl).placeholder(R.drawable.placeholder).into(holder.iv_image);
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
