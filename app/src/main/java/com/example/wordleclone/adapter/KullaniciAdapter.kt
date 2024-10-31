package com.example.wordleclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wordleclone.models.Kullanici
import com.example.wordleclone.databinding.ItemAktifKullaniciBinding

class KullaniciAdapter(private val kullanicilar : ArrayList<String>, private val kullaniciClickListener : (String) -> Unit) : RecyclerView.Adapter<KullaniciAdapter.KullaniciHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KullaniciHolder {
        val binding = ItemAktifKullaniciBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return KullaniciHolder(binding)
    }

    override fun getItemCount(): Int = kullanicilar.size

    override fun onBindViewHolder(holder: KullaniciHolder, position: Int) {
        val user = kullanicilar[position]

        holder.binding.nameItemUser.text = user

        holder.binding.istekItemButon.setOnClickListener {
            kullaniciClickListener(user)
        }
    }

    class KullaniciHolder(val binding: ItemAktifKullaniciBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}