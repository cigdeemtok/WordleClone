package com.example.wordleclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wordleclone.models.Room
import com.example.wordleclone.databinding.RoomItemBinding

class RoomAdapter(private val rooms : ArrayList<Room>, private val itemClickListener: (Room) -> Unit) : RecyclerView.Adapter<RoomAdapter.RoomHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomHolder {
        val binding = RoomItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RoomHolder(binding)
    }

    override fun getItemCount() : Int = rooms.size

    override fun onBindViewHolder(holder: RoomHolder, position: Int) {
        val room = rooms[position]

        holder.binding.roomNumText.text = "Oda ${position+1}"
        holder.binding.roomTypeText.text = room.odaTipi
        holder.binding.letterNumText.text = room.harfSayisi

        holder.binding.root.setOnClickListener{
            itemClickListener(room)
        }

    }

    class RoomHolder (val binding : RoomItemBinding) :RecyclerView.ViewHolder(binding.root){

    }
}
