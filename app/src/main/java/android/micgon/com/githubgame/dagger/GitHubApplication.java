package android.micgon.com.githubgame.dagger;

import android.app.Application;


public class GitHubApplication extends Application {

    private AppComponent component;


    @Override
    public void onCreate() {
        super.onCreate();

        //component = DaggerAppComponent.builder().appModule(new AppModule()).build();

    }

    public AppComponent getComponent() {
        return  component;
    }
}
