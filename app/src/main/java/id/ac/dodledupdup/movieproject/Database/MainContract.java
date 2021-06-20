package id.ac.dodledupdup.movieproject.Database;

import android.view.View;

import java.util.List;

import id.ac.dodledupdup.movieproject.DataEntity.AppDatabase;
import id.ac.dodledupdup.movieproject.DataEntity.DataFavorite;

public interface MainContract {
    interface view extends View.OnClickListener{
        void successAdd();
        void successDelete();
        void getData(List<DataFavorite> list);
        void deleteData(DataFavorite item);
    }

    interface presenter {
        void insertData(String title, String image_poster, String image_back, String rate
                ,String overview, AppDatabase database);
        void readData(AppDatabase database);
        void deleteData(DataFavorite dataFavorite, AppDatabase database);
    }
}
