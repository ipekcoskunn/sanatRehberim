package com.ipekcoskun.sanatrehberim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TiyatroRecyclerAdapter extends RecyclerView.Adapter<TiyatroRecyclerAdapter.PostHolder> { //extends ile implement ettik

    private ArrayList<String> userEmailList;
    private ArrayList<String> userCommentList;
    private ArrayList<String> userImageList;
    private ArrayList<String> userOyunAdiList;
    private ArrayList<String> userKurumAdiList;

    public TiyatroRecyclerAdapter(ArrayList<String> userEmailList, ArrayList<String> userCommentList, ArrayList<String> userImageList, ArrayList<String> userOyunAdiList, ArrayList<String> userKurumAdiList) {
        this.userEmailList = userEmailList;
        this.userCommentList = userCommentList;
        this.userImageList = userImageList;
        this.userOyunAdiList = userOyunAdiList;
        this.userKurumAdiList = userKurumAdiList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //viewholder oluşturunca yapacaklarımız

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_row,parent,false);
        return new PostHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) { //viewholder bağlanınca yapacaklarımız
        holder.userEmailText.setText(userEmailList.get(position));
        holder.oyunAdiText.setText(userOyunAdiList.get(position));
        holder.kurumAdiText.setText(userKurumAdiList.get(position));
        holder.commentText.setText(userCommentList.get(position));
        Picasso.get().load(userImageList.get(position)).into(holder.imageView);

    }

    @Override
    public int getItemCount() { //kaç tane row olacak yazıyoruz
        return userEmailList.size();
    }

    class PostHolder extends RecyclerView.ViewHolder { //görünüm tutucuları tanımlıyoruz.burada tutuluyor

        ImageView imageView;
        TextView userEmailText;
        TextView commentText;
        TextView oyunAdiText;
        TextView kurumAdiText;

        public PostHolder(@NonNull View itemView) {  //tanımlama
            super(itemView);

            imageView = itemView.findViewById(R.id.recyclerview_row_imageview);
            userEmailText = itemView.findViewById(R.id.recyclerview_row_useremail_text);
            oyunAdiText = itemView.findViewById(R.id.recyclerview_row_oyunadi_text);
            kurumAdiText = itemView.findViewById(R.id.recyclerview_row_kurumadi_text);
            commentText = itemView.findViewById(R.id.recyclerview_row_comment_text);

        }
    }
}
