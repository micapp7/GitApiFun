package android.micgon.com.githubgame.view;

import android.micgon.com.githubgame.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class GameViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public ImageView imageView;

    public GameViewHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.user_list_item, parent, false));
        textView = itemView.findViewById(R.id.text_username);
        imageView = itemView.findViewById(R.id.image_user);
    }
}
