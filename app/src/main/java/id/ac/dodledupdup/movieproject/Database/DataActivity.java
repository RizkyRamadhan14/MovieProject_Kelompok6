package id.ac.dodledupdup.movieproject.Database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import id.ac.dodledupdup.movieproject.DataEntity.AppDatabase;
import id.ac.dodledupdup.movieproject.R;

public class DataActivity extends AppCompatActivity {

    AppDatabase appDatabase;
    ImageView btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        appDatabase= AppDatabase.iniDb(getApplicationContext());

        btnOk=findViewById(R.id.itemdata_iv_favorite);
        //btnOk.setOnClickListener(this);
    }

}