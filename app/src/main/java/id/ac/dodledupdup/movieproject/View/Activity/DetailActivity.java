package id.ac.dodledupdup.movieproject.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import id.ac.dodledupdup.movieproject.DataEntity.AppDatabase;
import id.ac.dodledupdup.movieproject.DataEntity.DataFavorite;
import id.ac.dodledupdup.movieproject.Database.MainContract;
import id.ac.dodledupdup.movieproject.Database.MainPresenter;
import id.ac.dodledupdup.movieproject.R;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "DetailActivity";
    private MainPresenter presenter;
    private AppDatabase appDatabase;
    private MainContract.view view;
    List<DataFavorite>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        Log.d(TAG, "getIncomingIntent: found intent extras.");

        String imageUrl = getIntent().getStringExtra("imageURL");
        String imageName = getIntent().getStringExtra("title");
        String imageRate = getIntent().getStringExtra("rate");
        String imageBack = getIntent().getStringExtra("backimage");
        String imageOverview = getIntent().getStringExtra("overview");
        String imageDate = getIntent().getStringExtra("date");

        Log.d(TAG, imageName);
        Log.d(TAG, imageUrl);
        Log.d(TAG, imageRate);
        setData(imageUrl, imageName,imageRate,imageBack,imageOverview,imageDate);

    }

    private void setData(String imageUrl, String imageName,String imageRate, String imageBack,String imageOverview,String imageDate) {
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        ImageView fav=findViewById(R.id.itemdata_iv_favorite);
        TextView name = findViewById(R.id.itemdata_tv_title);
        name.setText(imageName);
        TextView rate = findViewById(R.id.itemdata_tv_rate);
        rate.setText(imageRate+"/10.0");
        TextView overview=findViewById(R.id.itemdata_movie_overview);
        overview.setText(imageOverview);
        TextView date=findViewById(R.id.itemdata_tv_releasedate);
        date.setText(imageDate);

        ImageView image = findViewById(R.id.itemdata_iv_thumbnail);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
        ImageView backimage = findViewById(R.id.imagePosterBack);
        Glide.with(this)
                .asBitmap()
                .load(imageBack).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(backimage);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"berhasil");
                Log.d(TAG,imageName);
                Log.d(TAG,imageUrl);
                Log.d(TAG,imageBack);
                Log.d(TAG,imageRate);
                Log.d(TAG,imageOverview);

                //nanti balik perbaiki ini
                Toast.makeText(DetailActivity.this, "Berhasil ditambahkan"
                        , Toast.LENGTH_SHORT).show();
                //toast ini

                presenter.insertData(imageName, imageUrl, imageBack, imageRate
                        , imageOverview, appDatabase);

            }
        });
    }
}