package com.example.hw_paging;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.bumptech.glide.Glide;
import android.widget.ImageView;
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<Article> articles;
    public NewsAdapter(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.sourceName.setText(article.getSource().getName());
        holder.title.setText(article.getTitle());
        holder.description.setText(article.getDescription());
        holder.publishedTime.setText(article.getPublishedAt());

        // Load the image using Glide
        Glide.with(holder.itemView.getContext())
                .load(article.getUrlToImage())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.articleImage);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView sourceName, title, description, publishedTime;
        ImageView articleImage;  // ImageView for the article image

        public NewsViewHolder(View itemView) {
            super(itemView);
            sourceName = itemView.findViewById(R.id.sourceName);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            publishedTime = itemView.findViewById(R.id.publishedTime);
            articleImage = itemView.findViewById(R.id.articleImage);
        }
    }
}
