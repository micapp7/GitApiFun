package android.micgon.com.githubgame.view;

import android.content.Context;
import android.micgon.com.githubgame.GlideApp;
import android.micgon.com.githubgame.model.User;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameViewHolder> {
    List<User> userList;
    TextView textView;
    ImageView imageView;
    Context context;

    public GameAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;


    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        return new GameViewHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        String url = userList.get(position).getAvatarUrl();
        holder.textView.setText(userList.get(position).getLogin());
        textView = holder.textView;
        imageView = holder.imageView;

        GlideApp.with(context)
                .load(url)
                .into(imageView);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void updateUserList(List<User> users) {
        userList = users;
        notifyDataSetChanged();
    }

}
