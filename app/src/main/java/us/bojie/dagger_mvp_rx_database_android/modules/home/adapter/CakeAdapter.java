package us.bojie.dagger_mvp_rx_database_android.modules.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import us.bojie.dagger_mvp_rx_database_android.R;
import us.bojie.dagger_mvp_rx_database_android.mvp.model.Cake;

/**
 * Created by bojiejiang on 2/6/17.
 */

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.Holder> {

    private LayoutInflater mLayoutInflater;
    private List<Cake> mCakeList = new ArrayList<>();
    private Context mContext;

    public CakeAdapter(Context context, LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
        mContext = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item_layout, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.bind(mCakeList.get(position));
    }

    @Override
    public int getItemCount() {
        return mCakeList.size();
    }

    public void addCakes(List<Cake> cakes) {
        mCakeList.addAll(cakes);
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @Bind(R.id.cake_icon) protected ImageView mCakeIcon;
        @Bind(R.id.textview_title) protected TextView mCakeTitle;
        @Bind(R.id.textview_preview_description) protected TextView mCakePreviewDescription;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Cake cake) {
            mCakeTitle.setText(cake.getTitle());
            mCakePreviewDescription.setText(cake.getPreviewDescription());

            Glide.with(mContext)
                    .load(cake.getImage())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(mCakeIcon);
        }
    }
}
