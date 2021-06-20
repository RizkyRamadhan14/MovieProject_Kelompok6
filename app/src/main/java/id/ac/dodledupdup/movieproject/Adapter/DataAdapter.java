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

import java.util.List;

import id.ac.dodledupdup.movieproject.DataEntity.DataFavorite;
import id.ac.dodledupdup.movieproject.Database.MainContract;
import id.ac.dodledupdup.movieproject.R;
import id.ac.dodledupdup.movieproject.View.Activity.DetailActivity;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.viewHolder>{

    Context context;
    List<DataFavorite> list;
    MainContract.view view;
    private static final String TAG = "Data Adapter";

    public DataAdapter(Context context,List<DataFavorite>list, MainContract.view view){
        this.view =view;
        this.context = context;
        this.list = list ;
    }

    class viewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle,tvRate,id;
        CardView cvItem;
        ImageView iv_Thumb;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
            iv_Thumb=itemView.findViewById(R.id.itemlist_iv_thumbnail);
            tvTitle = itemView.findViewById(R.id.itemlist_movie_title);
            tvRate = itemView.findViewById(R.id.itemlist_tv_rate);
            id=itemView.findViewById(R.id.itemlist_tv_id);
        }
    }
    @NonNull
    @Override
    public DataAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.viewHolder holder, int position) {
        final DataFavorite item = list.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvRate.setText(item.getRate());
        Glide.with(context).load(item.getPosterImage()).into(holder.iv_Thumb);

        holder.id.setText(String.valueOf(item.getId()));

        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //view.editData(item);
                Log.d(TAG, "onClick: clicked on: " + item.getTitle());

                Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("imageURL", item.getPosterImage());
                intent.putExtra("title", item.getTitle());
                intent.putExtra("rate", item.getRate());
                intent.putExtra("backimage", item.getBackImage());
                intent.putExtra("overview", item.getOverview());
                intent.putExtra("date", item.getDate());
                context.startActivity(intent);
            }
        });
        holder.cvItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                view.deleteData(item);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
