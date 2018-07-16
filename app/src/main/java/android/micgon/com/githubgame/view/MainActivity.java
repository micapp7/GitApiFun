package android.micgon.com.githubgame.view;

import android.micgon.com.githubgame.R;
import android.support.v4.app.Fragment;
import android.os.Bundle;

public class MainActivity extends BaseActivity {



    @Override
    protected Fragment createFragment() {
        return new UserProfileFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }
}
