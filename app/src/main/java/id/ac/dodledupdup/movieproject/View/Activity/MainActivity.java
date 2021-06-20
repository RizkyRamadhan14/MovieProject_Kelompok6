package id.ac.dodledupdup.movieproject.View.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import id.ac.dodledupdup.movieproject.DataEntity.FavFragment;
import id.ac.dodledupdup.movieproject.View.Fragment.MovieFragment;
import id.ac.dodledupdup.movieproject.R;
import id.ac.dodledupdup.movieproject.View.Fragment.PopularMovieFragment;
import id.ac.dodledupdup.movieproject.View.Fragment.TvShowFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment selectedFragment = new PopularMovieFragment();
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView= findViewById(R.id.activitymain_bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(selectedFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu_bottomnav_movie:
                selectedFragment= new MovieFragment();
                loadFragment(selectedFragment);
                break;

            case R.id.menu_bottomnav_tvshow:
                selectedFragment= new TvShowFragment();
                loadFragment(selectedFragment);
                break;
            case R.id.menu_bottomnav_popular:
                selectedFragment= new PopularMovieFragment();
                loadFragment(selectedFragment);
                break;
            case R.id.menu_bottomnav_fav:
                loadFragment(new FavFragment());
                break;
        }
        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if(selectedFragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activitymain_fragmentcontainer,selectedFragment)
                    .commit();
            return true;
        }
        return false;
    }
}