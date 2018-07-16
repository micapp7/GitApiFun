package android.micgon.com.githubgame.dagger;

import android.app.Application;
import android.micgon.com.githubgame.model.UserProfileViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {

    Application application;


    public AppModule(Application mApplication) {
        this.application = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

}