package id.ac.dodledupdup.movieproject.DataEntity;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DataFavorite.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DataFavoriteDAO dao();
    private static AppDatabase appDatabase;

    public static AppDatabase iniDb(Context context){
        if(appDatabase==null)
            appDatabase= Room.databaseBuilder(context, AppDatabase.class, "dbFav")
                    .allowMainThreadQueries().build();
        return appDatabase;
    }
    public static void destroyInstance(){
        appDatabase=null;
    }
}
