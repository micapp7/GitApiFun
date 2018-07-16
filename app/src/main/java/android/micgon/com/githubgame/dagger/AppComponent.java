package android.micgon.com.githubgame.dagger;


import android.micgon.com.githubgame.view.UserProfileFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { AppModule.class })
public interface AppComponent {
    void inject(UserProfileFragment target);
}
