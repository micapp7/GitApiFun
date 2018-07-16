package android.micgon.com.githubgame.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

public class UserProfileViewModel extends ViewModel {
    private String userId;
    private LiveData<User> user;



    public void init(String userId) {
        if (this.user != null) {
            // ViewModel is created per Fragment so
            // we know the userId won't change
            return;
        }
    }

    public LiveData<User> getUser() {
        return this.user;
    }
}
