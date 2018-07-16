package android.micgon.com.githubgame.view;

import android.micgon.com.githubgame.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

abstract public class BaseActivity extends AppCompatActivity {
    private static final String UID_KEY = "uid";

    abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.fragment_container);

        if(f == null) {
            f = createFragment();
            Bundle args = new Bundle();
            f.setArguments(args);
            fm.beginTransaction().add(R.id.fragment_container, f).commit();
        }
    }
}
