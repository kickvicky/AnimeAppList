package com.example.animelist;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class animeRecViewAdapter extends  RecyclerView.Adapter<animeRecViewAdapter.viewHolder>{
    //private static void final String TAG = "animeRecViewAdapter";

    private ArrayList<Anime> anime = new ArrayList<>();
    private Context mContext;
    private String parent;

    public animeRecViewAdapter(Context mContext, String parent) {
        this.mContext = mContext;
        this.parent = parent;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_anime,parent,false);
        return new viewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onBindViewHolder(@NonNull animeRecViewAdapter.viewHolder holder, int position) {
        //Log.d(TAG, "onBindViewHolder: Called");
        holder.txtAnime.setText(anime.get(position).getName());
        Glide.with(mContext).asBitmap().load(anime.get(position).getImageUrl()).into(holder.imgAnime);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,AnimeActivity.class);
                intent.putExtra("id",anime.get(position).getId());
                mContext.startActivity(intent);
                Toast.makeText(mContext,anime.get(position).getName() + " Selected", Toast.LENGTH_SHORT).show();
            }
        });

        holder.authorText.setText(anime.get(position).getAuthor());
        holder.txtAuthor.setText(anime.get(position).getName());
        holder.shortDesc.setText(anime.get(position).getShortDesc());

        if(anime.get(position).isExpanded()){
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expanded.setVisibility(View.VISIBLE);
            holder.down.setVisibility(View.GONE);

            if(parent.equals("AllAnimeActivity")){
                holder.btnDelete.setVisibility(View.GONE);
            }
            else if(parent.equals("AlreadyWatchedAnime")){
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete "+anime.get(position).getName()+" ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Utils.getInstance().remCompleted(anime.get(position))){
                                    Toast.makeText(mContext,"Anime Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                                else {
                                    Toast.makeText(mContext, "OOPS :(", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }
            else if (parent.equals("currAnime")){
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete "+anime.get(position).getName()+" ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Utils.getInstance().remCurr(anime.get(position))){
                                    Toast.makeText(mContext,"Anime Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                                else {
                                    Toast.makeText(mContext, "OOPS :(", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }
            else if(parent.equals("favAnime")){
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete "+anime.get(position).getName()+" ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Utils.getInstance().remFav(anime.get(position))){
                                    Toast.makeText(mContext,"Anime Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                                else {
                                    Toast.makeText(mContext, "OOPS :(", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }
            else{
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete "+anime.get(position).getName()+" ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Utils.getInstance().remWantToWatch(anime.get(position))){
                                    Toast.makeText(mContext,"Anime Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                                else {
                                    Toast.makeText(mContext, "OOPS :(", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }
        }
        else {
            //TransitionManager.beginDelayedTransition(holder.parent);
            holder.expanded.setVisibility(View.GONE);
            holder.down.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return anime.size();
    }

    public void setAnime(ArrayList<Anime> anime) {
        this.anime = anime;
        notifyDataSetChanged();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        private CardView parent;
        private ImageView imgAnime;
        private TextView txtAnime;

        private ImageView down,up;
        private TextView authorText,txtAuthor,shortDesc,btnDelete;
        private RelativeLayout expanded;
        public viewHolder(@NonNull View itemView){
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgAnime = itemView.findViewById(R.id.imgAnime);
            txtAnime = itemView.findViewById(R.id.txtAnime);

            down = itemView.findViewById(R.id.down);
            up = itemView.findViewById(R.id.up);
            expanded = itemView.findViewById(R.id.expanded);
            authorText = itemView.findViewById(R.id.authorText);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
            shortDesc = itemView.findViewById(R.id.shortDesc);

            btnDelete = itemView.findViewById(R.id.btnDelete);

            down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Anime animeList = anime.get(getAdapterPosition());
                    animeList.setExpanded(!animeList.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Anime animeList = anime.get(getAdapterPosition());
                    animeList.setExpanded(!animeList.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }

}
