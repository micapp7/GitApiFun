package android.micgon.com.githubgame.network;

import android.micgon.com.githubgame.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubService {
    //Base URL = https://api.github.com";

    @GET("/users/{user}")
    Call<User> getSingleUser(@Path("user") String userId);

    // There's a limit on Github api call with no auth.
    @GET("/users")
    Call<List<User>> getUsers();

}
