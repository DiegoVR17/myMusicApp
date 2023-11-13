package com.example.mymusicapp

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusicapp.databinding.CardViewItemBinding
import com.squareup.picasso.Picasso

class MyAdapter (val context: Activity, val dataList: List<Data>,var onItemClicked: (Data) -> Unit) : RecyclerView.Adapter<MyAdapter.MyViewHolder> (){
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

        holder.itemView.setOnClickListener {
            onItemClicked(currentData)
            val intent = Intent(holder.itemView.context, DetailSongActivity::class.java)
            intent.putExtra("title", currentData.title)
            intent.putExtra("cover",currentData.album.cover)
            intent.putExtra("nameSinger",currentData.artist.name)
            intent.putExtra("rank",currentData.rank)
            // Agregar otros datos de la canción que desees mostrar en la actividad de detalle
            holder.itemView.context.startActivity(intent)
        }

        holder.play.setOnClickListener {
            mediaPlayer.start()
        }

        holder.pause.setOnClickListener {
            mediaPlayer.stop()
        }

    }

    override fun getItemCount(): Int = dataList.size


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = CardViewItemBinding.bind(itemView)
        val image = binding.ImageViewPhotoSinger
        val title  = binding.textViewSinger
        val play = binding.buttonPlay
        val pause = binding.buttonStop
    }

}