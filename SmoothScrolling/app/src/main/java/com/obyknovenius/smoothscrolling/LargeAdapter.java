package com.obyknovenius.smoothscrolling;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by obyknovenius on 13/03/15.
 */
public final class LargeAdapter extends RecyclerView.Adapter<LargeAdapter.ViewHolder> {
    private static final int SIZE = 1000;
    private final List<String> items;

    public static LargeAdapter newInstace(Context context) {
        List<String> items = new ArrayList<>();
        String format = context.getString(R.string.item_string);
        for (int i = 0; i < SIZE; i++) {
            items.add(String.format(format, i + 1));
        }
        return new LargeAdapter(items);
    }

    private LargeAdapter(List<String> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1, viewGroup, false);
        return ViewHolder.newInstance(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String text = items.get(i);
        viewHolder.setText(text);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public static ViewHolder newInstance(View itemView) {
            TextView textView = (TextView) itemView.findViewById(android.R.id.text1);
            return new ViewHolder(itemView, textView);
        }

        private ViewHolder(View itemView, TextView textView) {
            super(itemView);
            this.textView = textView;
        }

        public void setText(CharSequence text) {
            textView.setText(text);
        }
    }
}
