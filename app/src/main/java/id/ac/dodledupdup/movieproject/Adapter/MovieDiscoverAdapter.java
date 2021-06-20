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

import id.ac.dodledupdup.movieproject.Model.Movie.MovieDiscoverResultsItem;
import id.ac.dodledupdup.movieproject.R;
import id.ac.dodledupdup.movieproject.View.Activity.DetailActivity;

public class MovieDiscoverAdapter extends RecyclerView.Adapter<MovieDiscoverAdapter.ViewHolder>{

    private static final String TAG = "Movie Discover Adapter";
    private ArrayList<MovieDiscoverResultsItem> movieDiscoverItems= new ArrayList<>();
    private Context context;
    private static String BASE_IMAGE_URL ="https://image.tmdb.org/t/p/original/";

    public MovieDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<MovieDiscoverResultsItem>items){
        movieDiscoverItems.clear();
        movieDiscoverItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieDiscoverAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(BASE_IMAGE_URL+movieDiscoverItems.get(position)
                .getPosterPath())
                .into(holder.iv_Thumb);

        holder.tvTitle.setText(movieDiscoverItems.get(position).getTitle());
        holder.tvRate.setText(String.valueOf(movieDiscoverItems.get(position).getVoteAverage()));

        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + movieDiscoverItems.get(position).getTitle());

                Toast.makeText(context, movieDiscoverItems.get(position).getTitle(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("imageURL", BASE_IMAGE_URL+movieDiscoverItems.get(position)
                        .getPosterPath());
                intent.putExtra("title", movieDiscoverItems.get(position).getTitle());
                intent.putExtra("rate", String.valueOf(movieDiscoverItems.get(position).getVoteAverage()));
                intent.putExtra("backimage", BASE_IMAGE_URL+movieDiscoverItems.get(position)
                        .getBackdropPath());
                intent.putExtra("overview", movieDiscoverItems.get(position).getOverview());
                intent.putExtra("date", movieDiscoverItems.get(position).getReleaseDate());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieDiscoverItems.size();
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
