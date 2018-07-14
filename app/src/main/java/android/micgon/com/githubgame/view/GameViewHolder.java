package android.micgon.com.githubgame.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class GameViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;

    public GameViewHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(android.R.layout.test_list_item, parent, false));
        textView = itemView.findViewById(android.R.id.text1);
    }
}
