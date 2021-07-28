package com.jyoti.albumssample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.jyoti.albumssample.BR;
import com.jyoti.albumssample.R;
import com.jyoti.albumssample.data.Album;
import com.jyoti.albumssample.databinding.AlbumItemLayoutBinding;

import java.util.List;

public class AlbumRecyclerViewAdapter extends RecyclerView.Adapter<AlbumRecyclerViewAdapter.ViewHolder>  {

    private List<Album> albumList;
    private Context context;

    public AlbumRecyclerViewAdapter(List<Album> albumList, Context ctx) {
        this.albumList = albumList;
        context = ctx;
    }

    @Override
    public AlbumRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                  int viewType) {
        AlbumItemLayoutBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.album_item_layout, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Album dataModel = albumList.get(position);
        holder.bind(dataModel);
//        holder.itemRowBinding.setItemClickListener(this);
    }


    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public AlbumItemLayoutBinding itemRowBinding;

        public ViewHolder(AlbumItemLayoutBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.album, obj);
            itemRowBinding.executePendingBindings();
        }
    }

//    public void cardClicked(Album f) {
//        Toast.makeText(context, "You clicked " + f.getTitle(),
//                Toast.LENGTH_LONG).show();
//    }
}