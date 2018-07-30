package android.micgon.com.githubgame.view;

import android.micgon.com.githubgame.R;
import android.micgon.com.githubgame.model.User;
import android.micgon.com.githubgame.network.GitHubService;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// TODO convert to data binding architecture
public class UserProfileFragment extends Fragment {
    public static final String TAG = "UserProfileFragment";
    private static final String UID_KEY = "uid";
    public static final String USER_DATA_FILENAME = "users.json";

    private TextView textView;
    private ImageView imageView;


    private RecyclerView recyclerView;
    private GameAdapter adapter;
    private User[] users;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        users = getUsersFromJsonFile();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_profile_list, container, false);
        textView = v.findViewById(R.id.name_text);
        textView.setText("Select a Github user");
        imageView = v.findViewById(R.id.image_user);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView = v.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);


        adapter = new GameAdapter(getContext(), Arrays.asList(users));
        recyclerView.setAdapter(adapter);

        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        return v;
    }

    public User[] getUsersFromJsonFile() {

        Gson gson = new Gson();
        InputStreamReader inputStreamReader = null;

        try {
            inputStreamReader = new InputStreamReader(getResources().getAssets().open(USER_DATA_FILENAME));
            users = gson.fromJson(inputStreamReader, User[].class);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }
}
