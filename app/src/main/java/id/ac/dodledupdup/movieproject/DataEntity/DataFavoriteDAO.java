package id.ac.dodledupdup.movieproject.DataEntity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import id.ac.dodledupdup.movieproject.DataEntity.DataFavorite;

@Dao
public interface DataFavoriteDAO {

    @Insert
    Long insertData(DataFavorite dataFav);

    @Query("Select*from fav_db")
    List<DataFavorite> getData();

    @Delete
    void deleteData(DataFavorite item);
}
