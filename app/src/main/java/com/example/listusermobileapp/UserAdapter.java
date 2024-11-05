package com.example.listusermobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> users;
    private LayoutInflater inflater;
    private OnItemClickListener listener;

    public UserAdapter(Context context, List<User> users) {
        this.users = users;
        this.inflater = LayoutInflater.from(context);
    }

    public interface OnItemClickListener {
        void onItemClick(User user);
        void onItemLongClick(View view, User user);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.element, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.imageView.setImageResource(user.getId());
        holder.nameView.setText(user.getName());
        holder.familyView.setText(user.getFamily());
        holder.ageView.setText(String.valueOf(user.getAge()));
        holder.cityView.setText(user.getCity());
        holder.countryView.setText(user.getCountry());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(user);
            }
        });

        holder.itemView.setOnLongClickListener(v -> {
            if (listener != null) {
                listener.onItemLongClick(v, user);
            }
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView nameView, familyView, ageView, cityView, countryView;

        UserViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageViewAvatar);
            nameView = view.findViewById(R.id.textViewName);
            familyView = view.findViewById(R.id.textViewFamily);
            ageView = view.findViewById(R.id.textViewAge);
            cityView = view.findViewById(R.id.textViewCity);
            countryView = view.findViewById(R.id.textViewCountry);
        }
    }

    public void remove(User user) {
        int position = users.indexOf(user);
        if (position >= 0) {
            users.remove(position);
            notifyItemRemoved(position);
        }
    }
}
