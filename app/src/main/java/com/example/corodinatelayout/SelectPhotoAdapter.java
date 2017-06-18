package com.example.corodinatelayout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wda on 2017/5/18.
 */
public class SelectPhotoAdapter extends RecyclerView.Adapter<SelectPhotoAdapter.WdaView> {
    private List<SelectpictureBeen> images;
    public SelectPhotoAdapter(List<SelectpictureBeen> list){
        images=list;
    }

    public static OnItemClickListener itemClickListener;

    public void setOnItemClickListener(
            OnItemClickListener itemClickListener){
        this.itemClickListener= itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    @Override
    public int getItemCount() {

        return images.size();
    }

    public static class WdaView extends  RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView textView;


        public WdaView(View itemView){
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.item_photo );
            imageView.setOnClickListener(this);
            textView= (TextView) itemView.findViewById(R.id.item_title);
        }
        @Override
        public void onClick(View v){
            if(itemClickListener!=null){
                itemClickListener.onItemClick(v,getPosition());
            }
        }
    }

    @Override
    public WdaView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.after_selected_imageitem_layout_xwk,parent,false);

        return new WdaView(view);
    }

    @Override
    public void onBindViewHolder(WdaView holder, int position) {
        holder.imageView.setImageResource(images.get(position).getImg());
        holder.textView.setText(images.get(position).getTitle());

    }

}
