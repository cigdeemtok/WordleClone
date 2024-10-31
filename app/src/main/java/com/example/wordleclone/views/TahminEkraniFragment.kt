package com.example.wordleclone.views

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.wordleclone.databinding.FragmentTahminEkraniBinding


class TahminEkraniFragment : Fragment() {

    private lateinit var binding: FragmentTahminEkraniBinding
    val args : TahminEkraniFragmentArgs by navArgs()
    private lateinit var odaTipi : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTahminEkraniBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val letterNum = args.letterNum
        odaTipi = args.odaTipi


        when(letterNum){
            "5 Harfli" -> {
                binding.letter16.visibility = View.GONE
                binding.letter17.visibility = View.GONE
                binding.letter18.visibility = View.GONE
                focusGecisiYap(5)
            }
            "6 Harfli" -> {
                binding.letter16.visibility = View.VISIBLE
                focusGecisiYap(6)

            }
            "7 Harfli" -> {
                binding.letter16.visibility = View.VISIBLE
                binding.letter17.visibility = View.VISIBLE
                focusGecisiYap(7)

            }
            "8 Harfli" ->{
                binding.letter16.visibility = View.VISIBLE
                binding.letter17.visibility = View.VISIBLE
                binding.letter18.visibility = View.VISIBLE
                focusGecisiYap(8)

            }
        }


        binding.tahminButon.setOnClickListener {
            when(letterNum){
                "5 Harfli" -> {
                    val letters = arrayListOf<String>()
                    val edt1 = binding.letter11.text.toString()
                    val edt2 = binding.letter12.text.toString()
                    val edt3 = binding.letter13.text.toString()
                    val edt4 = binding.letter14.text.toString()
                    val edt5 = binding.letter15.text.toString()
                    letters.add(edt1)
                    letters.add(edt2)
                    letters.add(edt3)
                    letters.add(edt4)
                    letters.add(edt5)

                    val guessWord = letters.joinToString(separator = "")


                    val direction = TahminEkraniFragmentDirections.actionTahminEkraniFragmentToBesHarfliOyunFragment(letterNum,guessWord,odaTipi)
                    findNavController().navigate(direction)

                }
                "6 Harfli" -> {
                    val letters = arrayListOf<String>()
                    val edt1 = binding.letter11.text.toString()
                    val edt2 = binding.letter12.text.toString()
                    val edt3 = binding.letter13.text.toString()
                    val edt4 = binding.letter14.text.toString()
                    val edt5 = binding.letter15.text.toString()
                    val edt6 = binding.letter16.text.toString()

                    letters.add(edt1)
                    letters.add(edt2)
                    letters.add(edt3)
                    letters.add(edt4)
                    letters.add(edt5)
                    letters.add(edt6)

                    val guessWord = letters.joinToString(separator = "")
                    val direction = TahminEkraniFragmentDirections.actionTahminEkraniFragmentToAltiHarfliOyunFragment(letterNum,guessWord,odaTipi)
                    findNavController().navigate(direction)

                }
                "7 Harfli" -> {
                    val letters = arrayListOf<String>()
                    val edt1 = binding.letter11.text.toString()
                    val edt2 = binding.letter12.text.toString()
                    val edt3 = binding.letter13.text.toString()
                    val edt4 = binding.letter14.text.toString()
                    val edt5 = binding.letter15.text.toString()
                    val edt6 = binding.letter16.text.toString()
                    val edt7 = binding.letter17.text.toString()

                    letters.add(edt1)
                    letters.add(edt2)
                    letters.add(edt3)
                    letters.add(edt4)
                    letters.add(edt5)
                    letters.add(edt6)
                    letters.add(edt7)

                    val guessWord = letters.joinToString(separator = "")

                    val direction = TahminEkraniFragmentDirections.actionTahminEkraniFragmentToYediHarfliOyunFragment(letterNum,guessWord,odaTipi)
                    findNavController().navigate(direction)
                }
                "8 Harfli" ->{
                    val letters = arrayListOf<String>()
                    val edt1 = binding.letter11.text.toString()
                    val edt2 = binding.letter12.text.toString()
                    val edt3 = binding.letter13.text.toString()
                    val edt4 = binding.letter14.text.toString()
                    val edt5 = binding.letter15.text.toString()
                    val edt6 = binding.letter16.text.toString()
                    val edt7 = binding.letter17.text.toString()
                    val edt8 = binding.letter18.text.toString()

                    letters.add(edt1)
                    letters.add(edt2)
                    letters.add(edt3)
                    letters.add(edt4)
                    letters.add(edt5)
                    letters.add(edt6)
                    letters.add(edt7)
                    letters.add(edt8)

                    val guessWord = letters.joinToString(separator = "")

                    val direction = TahminEkraniFragmentDirections.actionTahminEkraniFragmentToSekizHarfliOyunFragment(letterNum,guessWord,odaTipi)
                    findNavController().navigate(direction)
                }
            }
        }
    }

    private fun editTextFocus(edt1 : EditText ,edt2 : EditText){
        edt1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if(edt1.length() == 1){
                    edt2.requestFocus()
                }

            }

        })
    }
    private fun focusGecisiYap(letterNum : Int){
        if(letterNum == 5){
            editTextFocus(binding.letter11,binding.letter12)
            editTextFocus(binding.letter12,binding.letter13)
            editTextFocus(binding.letter13,binding.letter14)
            editTextFocus(binding.letter14,binding.letter15)
        }
        else if(letterNum == 6){
            editTextFocus(binding.letter11,binding.letter12)
            editTextFocus(binding.letter12,binding.letter13)
            editTextFocus(binding.letter13,binding.letter14)
            editTextFocus(binding.letter14,binding.letter15)
            editTextFocus(binding.letter15,binding.letter16)
        }
        else if(letterNum == 7){
            editTextFocus(binding.letter11,binding.letter12)
            editTextFocus(binding.letter12,binding.letter13)
            editTextFocus(binding.letter13,binding.letter14)
            editTextFocus(binding.letter14,binding.letter15)
            editTextFocus(binding.letter15,binding.letter16)
            editTextFocus(binding.letter16,binding.letter17)
        }
        else if(letterNum == 8){
            editTextFocus(binding.letter11,binding.letter12)
            editTextFocus(binding.letter12,binding.letter13)
            editTextFocus(binding.letter13,binding.letter14)
            editTextFocus(binding.letter14,binding.letter15)
            editTextFocus(binding.letter15,binding.letter16)
            editTextFocus(binding.letter16,binding.letter17)
            editTextFocus(binding.letter17,binding.letter18)
        }
    }



}