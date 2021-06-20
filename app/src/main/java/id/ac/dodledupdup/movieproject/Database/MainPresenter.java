package id.ac.dodledupdup.movieproject.Database;

import android.os.AsyncTask;

import java.util.List;

import id.ac.dodledupdup.movieproject.DataEntity.AppDatabase;
import id.ac.dodledupdup.movieproject.DataEntity.DataFavorite;

public class MainPresenter implements MainContract.presenter{
    private MainContract.view viewContract;

    public MainPresenter(MainContract.view viewContact){
        this.viewContract=viewContact;
    }

    class InsertData extends AsyncTask<Void,Void,Long>{
        private AppDatabase database;
        private DataFavorite dataFavorite;

        public InsertData(AppDatabase database, DataFavorite dataFavorite){
            this.database=database;
            this.dataFavorite=dataFavorite;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            return database.dao().insertData(dataFavorite);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
            viewContract.successAdd();
        }
    }
    @Override
    public void insertData(String title, String image_poster, String image_back
            , String rate, String overview,final AppDatabase database) {
        final DataFavorite dataFavorite= new DataFavorite();
        dataFavorite.SetTitle(title);
        dataFavorite.SetPosterImage(image_poster);
        dataFavorite.SetBackImage(image_back);
        dataFavorite.SetRate(rate);
        dataFavorite.SetOverview(overview);
        new InsertData(database, dataFavorite).execute();
    }

    @Override
    public void readData(AppDatabase database) {
        List<DataFavorite> list;
        list = database.dao().getData();
        viewContract.getData(list);
    }

    //////////////////////

    class DeleteData extends AsyncTask<Void,Void, Void>{
        private AppDatabase database;
        private DataFavorite dataFavorite;

        public DeleteData(AppDatabase database, DataFavorite dataFavorite){
            this.database = database;
            this.dataFavorite = dataFavorite;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            database.dao().deleteData(dataFavorite);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            viewContract.successDelete();
        }
    }
    @Override
    public void deleteData(DataFavorite dataFavorite,final AppDatabase database) {
        new DeleteData(database, dataFavorite).execute();

    }

}
