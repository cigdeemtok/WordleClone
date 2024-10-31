package com.example.wordleclone.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.wordleclone.databinding.FragmentGirisYapBinding
import com.example.wordleclone.models.Kullanici
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class GirisYapFragment : Fragment() {

    private lateinit var binding: FragmentGirisYapBinding

    val database = Firebase.database
    val referans = database.getReference("kullanicibilgileri")

    private lateinit var kullaniciListesi : MutableList<Kullanici>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGirisYapBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        kullaniciListesi = mutableListOf()

        //Giriş Yap butonuna basıldığında oyun odası seçimi sayfasına yönlendirme
        binding.btnGirisYap.setOnClickListener {
            val kullaniciAdi = binding.kullaniciAdi.text.toString()
            val sifre = binding.sifre.text.toString()
            val kullanici = Kullanici(kullaniciAdi,sifre)

            var bilgilerDogru = false

            kullaniciListesi.forEach {
                Log.d("kayit","kayitlar${it.kayitKullaniciAdi}")
                if((it.kayitKullaniciAdi == kullanici.kayitKullaniciAdi) and (it.kayitSifre == kullanici.kayitSifre)){
                    bilgilerDogru = true
                }
            }

            if(bilgilerDogru){
                println("giris bilgiler dogru girdi")
                Toast.makeText(requireContext(),"Giriş Başarılı",Toast.LENGTH_SHORT).show()

                val direction = GirisYapFragmentDirections.actionGirisYapFragmentToRoomFragment(kullaniciAdi)
                findNavController().navigate(direction)
            }
            else{
                Toast.makeText(requireContext(),"Hatali Giris Yaptiniz",Toast.LENGTH_SHORT).show()
            }

        }

        //Kayıt Ol butonuna basıldığında kayıt olma sayfasına yönlendirme
        binding.btnKayitOl.setOnClickListener {
            val direction = GirisYapFragmentDirections.actionGirisYapFragmentToKayitOlFragment()
            findNavController().navigate(direction)
        }


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        val kullaniciListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                kullaniciListesi.clear()
                for (user in dataSnapshot.children) {
                    val kayitKullaniciAdi = user.child("kayitKullaniciAdi").getValue(String::class.java)
                    val kayitSifre = user.child("kayitSifre").getValue(String::class.java)

                    println("$kayitKullaniciAdi, $kayitSifre")
                    kullaniciListesi.add(Kullanici(kayitKullaniciAdi.toString(), kayitSifre.toString()))
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                println("hata olustu: $databaseError")
            }
        }
        referans.addListenerForSingleValueEvent(kullaniciListener)
        println("updated user list in MainActivity page!")
    }

}