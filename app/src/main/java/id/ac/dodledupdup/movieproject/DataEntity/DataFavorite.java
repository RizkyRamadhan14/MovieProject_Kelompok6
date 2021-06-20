package id.ac.dodledupdup.movieproject.DataEntity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "fav_db")
public class DataFavorite {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "posterImage")
    private String posterImage;
    @ColumnInfo(name = "backImage")
    private String backImage;
    @ColumnInfo(name = "rate")
    private String rate;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "overview")
    private String overview;

    @NonNull
    //get data
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getPosterImage() { return posterImage; }
    public String getBackImage() { return backImage; }
    public String getRate() { return rate; }
    public String getDate() { return date; }
    public String getOverview() { return overview; }
    //set data
    public void setId(@NonNull int id) { this.id = id; }
    public void SetTitle(String title){ this.title=title; }
    public void SetPosterImage(String posterImage){ this.posterImage=posterImage; }
    public void SetBackImage(String backImage){ this.backImage=backImage; }
    public void SetRate(String rate){ this.rate=rate; }
    public void SetOverview(String overview){ this.overview=overview; }
}
