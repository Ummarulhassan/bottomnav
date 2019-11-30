package camera1.hdfilter.bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         bottomNavigationView= findViewById(R.id.bottom_nav);
         bottomNavigationView.setOnNavigationItemSelectedListener(navlistener);
         getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer,new HomeFragment()).commit();

  //hello to the 
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navlistener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedfragment=null;
            switch (menuItem.getItemId())
            {
                case R.id.nav_home:
                   selectedfragment=new HomeFragment();
                    break;
                case R.id.nav_favorites:
                    selectedfragment=new FavouriteFragment();
                    break;
                case R.id.nav_search:
                    selectedfragment=new SearchFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer,selectedfragment).commit();
            return true;
        }
    };
}
