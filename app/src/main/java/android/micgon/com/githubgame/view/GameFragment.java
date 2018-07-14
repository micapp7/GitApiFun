package android.micgon.com.githubgame.view;

import android.micgon.com.githubgame.R;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView.*;

import java.util.ArrayList;
import java.util.List;

// TODO consider delegating business logic to presenter class;
public class GameFragment extends Fragment {
    public static final String TAG = "GameFragment";

    private TextView nameText;
    private RecyclerView recyclerView;
    private GameAdapter adapter;
    private List<String> dataList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_game, container, false);
        nameText = v.findViewById(R.id.name_text);
        nameText.setText("Keegan Smith");
        LayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView = v.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);

        dataList = new ArrayList<>();

        dataList.add("Steve");
        dataList.add("Theresa");
        dataList.add("Coco");
        dataList.add("Johnny");
        adapter = new GameAdapter(dataList);
        recyclerView.setAdapter(adapter);


        return v;
    }
}
