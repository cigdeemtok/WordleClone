package com.example.wordleclone.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.wordleclone.databinding.FragmentKayitOlBinding
import com.example.wordleclone.models.Kullanici
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class KayitOlFragment : Fragment() {

    private lateinit var binding: FragmentKayitOlBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var referans : DatabaseReference
    private lateinit var kullaniciListesi : MutableList<Kullanici>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKayitOlBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        database = Firebase.database
        referans = database.getReference("kullanicibilgileri")

        kullaniciListesi = mutableListOf()

        //veritabanindan veri alma
        //niye veri aldik??
        val valueEventListener = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                kullaniciListesi.clear()
                for (user in snapshot.children){
                    val kayitKullaniciAdi = user.child("kayitKullaniciAdi").getValue(String::class.java)
                    val kayitSifre = user.child("kayitSifre").getValue(String::class.java)

                    println("Kayit kismi $kayitKullaniciAdi, $kayitSifre")
                    kullaniciListesi.add(Kullanici(kayitKullaniciAdi.toString(),kayitSifre.toString()))
                }
            }

            override fun onCancelled(error: DatabaseError) {
                //Toast mesaji ekledim ekranda gorunsun diye
                Toast.makeText(requireContext(),error.message,Toast.LENGTH_SHORT).show()
            }

        }

        referans.addListenerForSingleValueEvent(valueEventListener)

        //Kayıt ol butonuna basıldığında veritabanına kayıt ekleme
        binding.btnKaydet.setOnClickListener {
            val kayitKullaniciAdi = binding.kayitKullaniciAdi.text.toString()
            val kayitSifre = binding.kayitSifre.text.toString()
            val kullanici = Kullanici(kayitKullaniciAdi,kayitSifre)

            var isimKullanilmakta = false

            kullaniciListesi.forEach {
                println("for each ${it.kayitKullaniciAdi}, ${it.kayitSifre}")
                if(it.kayitSifre == kullanici.kayitKullaniciAdi){
                    isimKullanilmakta = true
                }
            }


            if(!isimKullanilmakta and (kullanici.kayitSifre != "")){
                println("kayit ifi ")
                val idReferans = referans.push()
                idReferans.setValue(kullanici)
                Toast.makeText(requireContext(),"Kullanıcı başarıyla kaydedildi",Toast.LENGTH_SHORT).show()

                //gecis burada olmali, cunku kayit basarili olmazsa giris ekranina donmemeli
                val direction = KayitOlFragmentDirections.actionKayitOlFragmentToGirisYapFragment()
                findNavController().navigate(direction)

                /*referans.setValue(kullanici).addOnSuccessListener {
                    Toast.makeText(requireContext(),"Kullanıcı başarıyla kaydedildi",Toast.LENGTH_SHORT).show()
                    val direction = KayitOlFragmentDirections.actionKayitOlFragmentToGirisYapFragment()
                    findNavController().navigate(direction)*/


            }
            else{
                Toast.makeText(requireContext(),"Kullanıcı ismi daha önceden alınmıştır!",Toast.LENGTH_SHORT).show()
            }


        }


        super.onViewCreated(view, savedInstanceState)
    }

}