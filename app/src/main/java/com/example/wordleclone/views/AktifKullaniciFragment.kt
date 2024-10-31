package com.example.wordleclone.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordleclone.adapter.KullaniciAdapter
import com.example.wordleclone.databinding.FragmentAktifKullaniciBinding
import com.example.wordleclone.models.Kullanici

class AktifKullaniciFragment : Fragment() {

    private lateinit var binding: FragmentAktifKullaniciBinding
    private lateinit var myAdapter : KullaniciAdapter
    private lateinit var kullanicilar : ArrayList<String>
    val args : AktifKullaniciFragmentArgs by navArgs()
    private lateinit var odaTipi : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAktifKullaniciBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val letterNum = args.letterNum
        odaTipi = args.odaTipi
        val kullaniciAdi = args.kullaniciAdi


        kullanicilar = arrayListOf()
        kullanicilar.add(kullaniciAdi)

        binding.aktifKUllaniciRc.layoutManager = LinearLayoutManager(requireContext())
        myAdapter = KullaniciAdapter(kullanicilar){
            val direction = AktifKullaniciFragmentDirections.actionAktifKullaniciFragmentToTahminEkraniFragment(letterNum,odaTipi)
            findNavController().navigate(direction)
        }
        binding.aktifKUllaniciRc.adapter = myAdapter


    }

}