package id.ac.dodledupdup.movieproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.ac.dodledupdup.movieproject.Model.TvShow.TvShowResultsItem;
import id.ac.dodledupdup.movieproject.R;
import id.ac.dodledupdup.movieproject.View.Activity.DetailActivity;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.ViewHolder> {

    private static final String TAG = "Movie Discover Adapter";
    private ArrayList<TvShowResultsItem> tvShowItems= new ArrayList<>();
    private Context context;
    private static String BASE_IMAGE_URL ="https://image.tmdb.org/t/p/original/";

    public TvShowAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<TvShowResultsItem>items){
        tvShowItems.clear();
        tvShowItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TvShowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);

        return new TvShowAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(BASE_IMAGE_URL+tvShowItems.get(position)
                .getPosterPath())
                .into(holder.iv_Thumb);

        holder.tvTitle.setText(tvShowItems.get(position).getName());
        holder.tvRate.setText(String.valueOf(tvShowItems.get(position).getVoteAverage()));

        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + tvShowItems.get(position).getName());

                Toast.makeText(context, tvShowItems.get(position).getName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("imageURL", BASE_IMAGE_URL+tvShowItems.get(position)
                        .getPosterPath());
                intent.putExtra("title", tvShowItems.get(position).getName());
                intent.putExtra("rate", String.valueOf(tvShowItems.get(position).getVoteAverage()));
                intent.putExtra("backimage", BASE_IMAGE_URL+tvShowItems.get(position)
                        .getBackdropPath());
                intent.putExtra("overview", tvShowItems.get(position).getOverview());
                intent.putExtra("date", tvShowItems.get(position).getFirstAirDate());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tvShowItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_Thumb;
        TextView tvTitle,tvRate;
        CardView cvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
            iv_Thumb=itemView.findViewById(R.id.itemlist_iv_thumbnail);
            tvTitle = itemView.findViewById(R.id.itemlist_movie_title);
            tvRate = itemView.findViewById(R.id.itemlist_tv_rate);
        }
    }
}
