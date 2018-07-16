package android.micgon.com.githubgame.view;

import android.content.Context;
import android.micgon.com.githubgame.BuildConfig;
import android.micgon.com.githubgame.R;
import android.micgon.com.githubgame.model.User;
import android.micgon.com.githubgame.model.UserProfileViewModel;
import android.micgon.com.githubgame.network.GitHubService;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// TODO consider delegating business logic to presenter class;
public class UserProfileFragment extends Fragment {
    public static final String TAG = "UserProfileFragment";
    private static final String UID_KEY = "uid";

    private TextView textView;
    private ImageView imageView;
    GitHubService gitHubService;


    private RecyclerView recyclerView;
    private GameAdapter adapter;
    private List<User> dataList;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        String userId = getArguments().getString(UID_KEY);
//        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
//        viewModel.init(userId);
//        viewModel.getUser().observe(this, user -> {
//            Log.d(TAG, "Observable User Updated");
//        });

        //((GitHubApplication) getActivity().getApplication()).getComponent().inject(this);


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
        dataList = new ArrayList<>();
        adapter = new GameAdapter(getContext(), dataList);
        recyclerView.setAdapter(adapter);

        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);



        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .build();

        GitHubService gitHubService = retrofit.create(GitHubService.class);
        gitHubService.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Toast.makeText(getActivity(), "Get Successful", Toast.LENGTH_SHORT).show();
                adapter.updateUserList(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getActivity(), "Call failed", Toast.LENGTH_SHORT).show();
            }
        });





        return v;
    }
}
