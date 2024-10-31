package com.example.wordleclone.views

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.wordleclone.R
import com.example.wordleclone.databinding.FragmentBesHarfliOyunBinding
import kotlin.random.Random

class BesHarfliOyunFragment : Fragment() {

    private lateinit var binding : FragmentBesHarfliOyunBinding
    val args : BesHarfliOyunFragmentArgs by navArgs()
    private lateinit var odaTipi : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBesHarfliOyunBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val letterNum = args.letterNum
        val guessWord = args.guessWord
        odaTipi = args.odaTipi


        if(odaTipi == "Harf sabitli"){
            var rand = Random.nextInt(0,5)
            Log.d("random num","$rand")
            Log.d("random num", odaTipi)

            var sabit = guessWord[rand].toString()
            Log.d("random num", sabit.toString())
            Log.d("random num", "harf sabitli if")


            when(rand){
                0->{
                    Log.d("random num", "burda 0")
                    binding.letter11.setText(sabit)
                    binding.letter11.setBackgroundColor(Color.parseColor("#33cc33"))
                    //binding.letter11.isEnabled = false


                }
                1->{
                    Log.d("random num", "burda 1")
                    binding.letter12.setText(sabit)
                    binding.letter12.setBackgroundColor(Color.parseColor("#33cc33"))
                    //binding.letter12.isEnabled = false

                }
                2->{
                    Log.d("random num", "burda 2")
                    binding.letter13.setText(sabit)
                    binding.letter13.setBackgroundColor(Color.parseColor("#33cc33"))
                    //binding.letter13.isEnabled = false

                }
                3->{
                    Log.d("random num", "burda 3")
                    binding.letter14.setText(sabit)
                    binding.letter14.setBackgroundColor(Color.parseColor("#33cc33"))
                    //binding.letter14.isEnabled = false

                }
                4->{
                    Log.d("random num", "burda 4")
                    binding.letter15.setText(sabit)
                    binding.letter15.setBackgroundColor(Color.parseColor("#33cc33"))
                    //binding.letter15.isEnabled = false

                }



            }
        }

        /*Log.d("letters","1 ${guessWord[0]}")
        Log.d("letters","2${guessWord[1]}")
        Log.d("letters","3 ${guessWord[2]}")
        Log.d("letters","4 ${guessWord[3]}")
        Log.d("letters","5 ${guessWord[4]}")*/

        focusGecisiYap()


        binding.letter15.addTextChangedListener {
            satirlariDogrula(
                binding.letter11,
                binding.letter12,
                binding.letter13,
                binding.letter14,
                binding.letter15,
                guessWord
            )
        }
        binding.letter25.addTextChangedListener {
            satirlariDogrula(
                binding.letter21,
                binding.letter22,
                binding.letter23,
                binding.letter24,
                binding.letter25,
                guessWord
            )
        }
        binding.letter35.addTextChangedListener {
            satirlariDogrula(
                binding.letter31,
                binding.letter32,
                binding.letter33,
                binding.letter34,
                binding.letter35,
                guessWord
            )
        }
        binding.letter45.addTextChangedListener {
            satirlariDogrula(
                binding.letter41,
                binding.letter42,
                binding.letter43,
                binding.letter44,
                binding.letter45,
                guessWord
            )
        }
        binding.letter55.addTextChangedListener {
            satirlariDogrula(
                binding.letter51,
                binding.letter52,
                binding.letter53,
                binding.letter54,
                binding.letter55,
                guessWord
            )
        }

        Toast.makeText(requireContext(),"Kelime $guessWord, harf $letterNum",Toast.LENGTH_LONG).show()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun satirlariDogrula(
        edt1 : EditText,
        edt2 : EditText,
        edt3 : EditText,
        edt4 : EditText,
        edt5 : EditText,
        guessWord : String
    ) {
        val let1 = guessWord[0].toString()
        val let2 = guessWord[1].toString()
        val let3 = guessWord[2].toString()
        val let4 = guessWord[3].toString()
        val let5 = guessWord[4].toString()

        val edt1Text = edt1.text.toString()
        val edt2Text = edt2.text.toString()
        val edt3Text = edt3.text.toString()
        val edt4Text = edt4.text.toString()
        val edt5Text = edt5.text.toString()


        if(edt1Text == let2 || edt1Text == let3 || edt1Text == let4 || edt1Text == let5){
            edt1.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt2Text == let1 || edt2Text == let3 || edt2Text == let4 || edt2Text == let5){
            edt2.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt3Text == let1 || edt3Text == let2 || edt3Text == let4 || edt3Text == let5){
            edt3.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt4Text == let1 || edt4Text == let2 || edt4Text == let3 || edt4Text == let5){
            edt4.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt5Text == let1 || edt5Text == let2 || edt5Text == let3 || edt5Text == let4){
            edt5.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt1Text == let1){
            edt1.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if(edt2Text == let2){
            edt2.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if(edt3Text == let3){
            edt3.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if(edt4Text == let4){
            edt4.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if(edt5Text == let5){
            edt5.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if(edt1Text != let1 && edt1Text != let2 && edt1Text != let3 && edt1Text != let4 && edt1Text != let5){
            edt1.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt2Text != let1 && edt2Text != let2 && edt2Text != let3 && edt2Text != let4 && edt2Text != let5){
            edt2.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt3Text != let1 && edt3Text != let2 && edt3Text != let3 && edt3Text != let4 && edt3Text != let5){
            edt3.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt4Text != let1 && edt4Text != let2 && edt4Text != let3 && edt4Text != let4 && edt4Text != let5){
            edt4.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt5Text != let1 && edt5Text != let2 && edt5Text != let3 && edt5Text != let4 && edt5Text != let5){
            edt5.setBackgroundColor(Color.parseColor("#ff3333"))
        }

        //tum harfler dogru - oyun kazanildi
        if(edt1Text == let1 && edt2Text == let2 && edt3Text == let3 && edt4Text == let4 && edt5Text == let5){
            Toast.makeText(requireContext(),"Tebrikler, Oyunu Kazandınız!",Toast.LENGTH_LONG).show()
            //edit textleri inaktif et
            editTextDisable()
            return
        }

        //en son edit texte gelinirse ve bilinmemisse - oyun kaybedilir
        if(edt5.id == R.id.letter55){
            Toast.makeText(requireContext(),"Uzgunuz, Oyunu Kaybettiniz.",Toast.LENGTH_LONG).show()
            //edit textleri inaktif et
            editTextDisable()
            return
        }


    }

    private fun editTextDisable(){
        binding.letter11.isEnabled = false
        binding.letter12.isEnabled = false
        binding.letter13.isEnabled = false
        binding.letter14.isEnabled = false
        binding.letter15.isEnabled = false
        binding.letter21.isEnabled = false
        binding.letter22.isEnabled = false
        binding.letter23.isEnabled = false
        binding.letter24.isEnabled = false
        binding.letter25.isEnabled = false
        binding.letter31.isEnabled = false
        binding.letter32.isEnabled = false
        binding.letter33.isEnabled = false
        binding.letter34.isEnabled = false
        binding.letter35.isEnabled = false
        binding.letter41.isEnabled = false
        binding.letter42.isEnabled = false
        binding.letter43.isEnabled = false
        binding.letter44.isEnabled = false
        binding.letter45.isEnabled = false
        binding.letter51.isEnabled = false
        binding.letter52.isEnabled = false
        binding.letter53.isEnabled = false
        binding.letter54.isEnabled = false
        binding.letter55.isEnabled = false

    }

    private fun editTextFocus(edt1 : EditText, edt2 : EditText){
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
    private fun focusGecisiYap(){
        editTextFocus(binding.letter11,binding.letter12)
        editTextFocus(binding.letter12,binding.letter13)
        editTextFocus(binding.letter13,binding.letter14)
        editTextFocus(binding.letter14,binding.letter15)
        editTextFocus(binding.letter21,binding.letter22)
        editTextFocus(binding.letter22,binding.letter23)
        editTextFocus(binding.letter23,binding.letter24)
        editTextFocus(binding.letter24,binding.letter25)
        editTextFocus(binding.letter31,binding.letter32)
        editTextFocus(binding.letter32,binding.letter33)
        editTextFocus(binding.letter33,binding.letter34)
        editTextFocus(binding.letter34,binding.letter35)
        editTextFocus(binding.letter41,binding.letter42)
        editTextFocus(binding.letter42,binding.letter43)
        editTextFocus(binding.letter43,binding.letter44)
        editTextFocus(binding.letter44,binding.letter45)
        editTextFocus(binding.letter51,binding.letter52)
        editTextFocus(binding.letter52,binding.letter53)
        editTextFocus(binding.letter53,binding.letter54)
        editTextFocus(binding.letter54,binding.letter55)
    }


}