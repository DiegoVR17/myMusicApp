package com.example.mymusicapp

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter (val context: Activity, val dataList: List<Data>) : RecyclerView.Adapter<MyAdapter.MyViewHolder> (){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentData = dataList[position]
        val mediaPlayer = MediaPlayer.create(context,currentData.preview.toUri())
        holder.title.text = currentData.title
        Picasso.get().load(currentData.album.cover).into(holder.image)


        holder.play.setOnClickListener {
            mediaPlayer.start()
        }

        holder.pause.setOnClickListener {
            mediaPlayer.stop()
        }
    }

    override fun getItemCount(): Int = dataList.size



    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
       val image: ImageView
       val title: TextView
       val play: ImageButton
       val pause: ImageButton

       init {
           image = itemView.findViewById(R.id.ImageViewPhotoSinger)
           title = itemView.findViewById(R.id.textViewSinger)
           play = itemView.findViewById(R.id.buttonPlay)
           pause = itemView.findViewById(R.id.buttonStop)

       }

    }

 }