package com.nwise.mvptemplate.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.nwise.mvptemplate.R;
import com.nwise.mvptemplate.domain.models.Answer;
import com.nwise.mvptemplate.domain.models.ListWrapper;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ListWrapper<Answer> data;
    private Context context;
    private int itemViewType;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(itemViewType,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Answer answer = ((Answer) data.items.get(position));
        holder.text.setText(answer.toString());
        holder.itemView.setTag(answer.answerId);
        Glide.with(context).load(answer.owner.profileImage).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView text;
        public ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.img_avator);
            text = (TextView) itemView.findViewById(R.id.text1);



        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2 == 0)
        {
            return itemViewType = R.layout.even_selectable_list_item;
        }
        else return itemViewType = R.layout.odd_selectable_list_item;
    }

    public RecyclerViewAdapter(ListWrapper<Answer> data , Context context) {
        this.data = data;
        this.context = context;
    }
}
