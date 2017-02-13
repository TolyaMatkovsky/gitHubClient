package com.example.app.testapp.presentation.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app.testapp.R;
import com.example.app.testapp.data.entity.UserRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tolik on 10.02.2017.
 */

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ReposViewHolder> {
    public interface OnItemClickListener {
        void onUserItemClicked(UserRepository userRepository);
    }

    private List<UserRepository> usersCollection;
    private final LayoutInflater layoutInflater;

    private OnItemClickListener onItemClickListener;

    public ReposAdapter(Context context) {
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.usersCollection = Collections.emptyList();
    }

    @Override
    public int getItemCount() {
        return (this.usersCollection != null) ? this.usersCollection.size() : 0;
    }

    @Override
    public ReposViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.row_repos, parent, false);
        return new ReposViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReposViewHolder holder, final int position) {
        final UserRepository userRepository = this.usersCollection.get(position);

        holder.reposTitle.setText(userRepository.getRepositoryTitle());
        holder.language.setText(userRepository.getLanguage());
        holder.forceCount.setText(String.valueOf(userRepository.getForks()));
        holder.starCount.setText(String.valueOf(userRepository.getStars()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ReposAdapter.this.onItemClickListener != null) {
                    ReposAdapter.this.onItemClickListener.onUserItemClicked(userRepository);
                }
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setReposCollection(Collection<UserRepository> usersCollection) {
        this.validateUsersCollection(usersCollection);
        this.usersCollection = (List<UserRepository>) usersCollection;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private void validateUsersCollection(Collection<UserRepository> usersCollection) {
        if (usersCollection == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    static class ReposViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.language)
        TextView language;

        @BindView(R.id.repos_title)
        TextView reposTitle;

        @BindView(R.id.force_count)
        TextView forceCount;

        @BindView(R.id.star_count)
        TextView starCount;

        public ReposViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
