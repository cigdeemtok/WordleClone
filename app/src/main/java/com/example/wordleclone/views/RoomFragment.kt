package com.example.wordleclone.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordleclone.adapter.RoomAdapter
import com.example.wordleclone.databinding.FragmentRoomBinding
import com.example.wordleclone.models.Room
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class RoomFragment : Fragment() {

    private lateinit var binding : FragmentRoomBinding
    private lateinit var rooms : ArrayList<Room>
    private lateinit var myAdapter : RoomAdapter
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference
    val args : RoomFragmentArgs by navArgs()
    private lateinit var odaAdiDb : String
    private lateinit var kullaniciAdi : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRoomBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //db olusturma
        database = Firebase.database
        reference = database.getReference("odalar")
        Toast.makeText(requireContext(),"Odadasınız",Toast.LENGTH_SHORT).show()

        //write to db
        writeToDb(reference)

        kullaniciAdi = args.kullaniciAdi


        rooms = arrayListOf()

        reference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                //rooms.clear()
                for(odaSnapshot in snapshot.children){
                    val odaAdi = odaSnapshot.child("odaTipi").getValue(String::class.java) ?: ""
                    val harfSayisi = odaSnapshot.child("harfSayisi").getValue(String::class.java) ?: ""
                    val odaNum = odaSnapshot.child("odaNum").getValue(Int::class.java) ?: 0

                    //Log.d("oda","$odaAdi oda,$harfSayisi harf, $aktifKullanici kullanicio")
                    val oda = Room(odaAdi,harfSayisi,odaNum)
                    rooms.add(oda)
                    myAdapter.notifyDataSetChanged()


                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(),"Oda verileri okunamadi.", Toast.LENGTH_SHORT).show()
            }

        })

        /*if(rooms.isEmpty()){
            Log.d("oda","bos" )

        }*/
        binding.roomRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        myAdapter = RoomAdapter(rooms){it->
            Log.d("oda","adapter ${it.odaTipi}")
            odaAdiDb = "Oda ${it.odaNum}"
            Log.d("oda","adapter odaAdi $odaAdiDb")
            Log.d("oda","adapter kullanici $kullaniciAdi")
            //aktifKullaniciEkle(odaAdiDb,kullaniciAdi)
            val direction = RoomFragmentDirections.actionRoomFragmentToAktifKullaniciFragment(it.harfSayisi,it.odaTipi,kullaniciAdi)
            findNavController().navigate(direction)
        }
        binding.roomRecyclerView.adapter = myAdapter


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        //odadanCik(odaAdiDb,kullaniciAdi)
        super.onResume()
    }

   /* private fun aktifKullaniciEkle(odaAdiDb: String, kullaniciAdi : String){
        val database = Firebase.database
        val odaRef = database.getReference(odaAdiDb)
        odaRef.child(kullaniciAdi).setValue(true)
    }

    private fun odadanCik(odaAdiDb: String, kullaniciAdi : String){
        val database = Firebase.database
        val odaRef = database.getReference(odaAdiDb)
        odaRef.child(kullaniciAdi).removeValue()
    }*/

    private fun writeToDb(reference: DatabaseReference) {

        val oda1 = Room("Harf sabitli", "5 Harfli", 1)
        val oda2 = Room("Harf sabitli", "6 Harfli", 2)
        val oda3 = Room("Harf sabitli", "7 Harfli", 3)
        val oda4 = Room("Harf sabitli", "8 Harfli", 4)
        val oda5 = Room("Harf sabitsiz", "5 Harfli", 5)
        val oda6 = Room("Harf sabitsiz", "6 Harfli", 6)
        val oda7 = Room("Harf sabitsiz", "7 Harfli", 7)
        val oda8 = Room("Harf sabitsiz", "8 Harfli", 8)

        //write to db
        reference.child("oda1").setValue(oda1)
        reference.child("oda2").setValue(oda2)
        reference.child("oda3").setValue(oda3)
        reference.child("oda4").setValue(oda4)
        reference.child("oda5").setValue(oda5)
        reference.child("oda6").setValue(oda6)
        reference.child("oda7").setValue(oda7)
        reference.child("oda8").setValue(oda8)

    }
}