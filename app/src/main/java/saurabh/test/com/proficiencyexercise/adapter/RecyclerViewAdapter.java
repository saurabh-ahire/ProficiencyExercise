package saurabh.test.com.proficiencyexercise.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import saurabh.test.com.proficiencyexercise.R;
import saurabh.test.com.proficiencyexercise.model.CanadaInformation;

/**
 * Created by saurabha on 18/10/18.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<CanadaInformation> canadaInformationList;

    public RecyclerViewAdapter(List<CanadaInformation> canadaInformationList) {
        this.canadaInformationList = canadaInformationList;

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_home_data, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        CanadaInformation canadaInformation = canadaInformationList.get(position);
        holder.tvTitle.setText(canadaInformation.getTitle());
        holder.tvDescription.setText(canadaInformation.getDescription());
        Picasso.get()
                .load(canadaInformation.getImageHref())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.ivImage);

    }

    @Override
    public int getItemCount() {
        return canadaInformationList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_description)
        TextView tvDescription;
        @BindView(R.id.iv_image)
        ImageView ivImage;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
