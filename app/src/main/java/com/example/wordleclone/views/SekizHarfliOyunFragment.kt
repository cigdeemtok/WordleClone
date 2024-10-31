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
import com.example.wordleclone.databinding.FragmentSekizHarfliOyunBinding
import kotlin.random.Random

class SekizHarfliOyunFragment : Fragment() {

    private lateinit var binding : FragmentSekizHarfliOyunBinding
    val args : SekizHarfliOyunFragmentArgs by navArgs()
    private lateinit var odaTipi : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSekizHarfliOyunBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val letterNum = args.letterNum
        val guessWord = args.guessWord
        odaTipi = args.odaTipi

        Toast.makeText(requireContext(),"Kelime $guessWord, harf ${letterNum }}", Toast.LENGTH_LONG).show()



        if(odaTipi == "Harf sabitli"){
            var rand = Random.nextInt(0,8)
            Log.d("random num","$rand")
            Log.d("random num", odaTipi)

            var sabit = guessWord[rand].toString()
            Log.d("random num", sabit.toString())


            //Log.d("random num", "harf sabitli if")
            when(rand){
                0->{
                    //Log.d("random num", "burda 0")
                    binding.letter11.setText(sabit)
                    binding.letter11.setBackgroundColor(Color.parseColor("#33cc33"))
                    //binding.letter11.isEnabled = false


                }
                1->{
                    //Log.d("random num", "burda 1")
                    binding.letter12.setText(sabit)
                    binding.letter12.setBackgroundColor(Color.parseColor("#33cc33"))
                    //binding.letter12.isEnabled = false

                }
                2->{
                    //Log.d("random num", "burda 2")
                    binding.letter13.setText(sabit)
                    binding.letter13.setBackgroundColor(Color.parseColor("#33cc33"))
                    //binding.letter13.isEnabled = false

                }
                3->{
                    //Log.d("random num", "burda 3")
                    binding.letter14.setText(sabit)
                    binding.letter14.setBackgroundColor(Color.parseColor("#33cc33"))
                    //binding.letter14.isEnabled = false

                }
                4->{
                    //Log.d("random num", "burda 4")
                    binding.letter15.setText(sabit)
                    binding.letter15.setBackgroundColor(Color.parseColor("#33cc33"))
                    //binding.letter15.isEnabled = false

                }
                5->{
                    binding.letter16.setText(sabit)
                    binding.letter16.setBackgroundColor(Color.parseColor("#33cc33"))
                    //binding.letter16.isEnabled = false
                }
                6->{
                    binding.letter17.setText(sabit)
                    binding.letter17.setBackgroundColor(Color.parseColor("#33cc33"))
                    //binding.letter17.isEnabled = false

                }
                7->{
                    binding.letter18.setText(sabit)
                    binding.letter18.setBackgroundColor(Color.parseColor("#33cc33"))
                    //binding.letter18.isEnabled = false

                }



            }
        }

        focusGecisiYap()

        binding.letter18.addTextChangedListener {
            satirlariDogrula(
                binding.letter11,
                binding.letter12,
                binding.letter13,
                binding.letter14,
                binding.letter15,
                binding.letter16,
                binding.letter17,
                binding.letter18,
                guessWord
            )
        }
        binding.letter28.addTextChangedListener {
            satirlariDogrula(
                binding.letter21,
                binding.letter22,
                binding.letter23,
                binding.letter24,
                binding.letter25,
                binding.letter26,
                binding.letter27,
                binding.letter28,
                guessWord
            )
        }
        binding.letter38.addTextChangedListener {
            satirlariDogrula(
                binding.letter31,
                binding.letter32,
                binding.letter33,
                binding.letter34,
                binding.letter35,
                binding.letter36,
                binding.letter37,
                binding.letter38,
                guessWord
            )
        }
        binding.letter48.addTextChangedListener {
            satirlariDogrula(
                binding.letter41,
                binding.letter42,
                binding.letter43,
                binding.letter44,
                binding.letter45,
                binding.letter46,
                binding.letter47,
                binding.letter48,
                guessWord
            )
        }
        binding.letter58.addTextChangedListener {
            satirlariDogrula(
                binding.letter51,
                binding.letter52,
                binding.letter53,
                binding.letter54,
                binding.letter55,
                binding.letter56,
                binding.letter57,
                binding.letter58,
                guessWord
            )
        }
        binding.letter68.addTextChangedListener {
            satirlariDogrula(
                binding.letter61,
                binding.letter62,
                binding.letter63,
                binding.letter64,
                binding.letter65,
                binding.letter66,
                binding.letter67,
                binding.letter68,
                guessWord
            )
        }
        binding.letter78.addTextChangedListener {
            satirlariDogrula(
                binding.letter71,
                binding.letter72,
                binding.letter73,
                binding.letter74,
                binding.letter75,
                binding.letter76,
                binding.letter77,
                binding.letter78,
                guessWord
            )
        }
        binding.letter88.addTextChangedListener {
            satirlariDogrula(
                binding.letter81,
                binding.letter82,
                binding.letter83,
                binding.letter84,
                binding.letter85,
                binding.letter86,
                binding.letter87,
                binding.letter88,
                guessWord
            )
        }

    }


    private fun satirlariDogrula(
        edt1 : EditText,
        edt2 : EditText,
        edt3 : EditText,
        edt4 : EditText,
        edt5 : EditText,
        edt6 : EditText,
        edt7 : EditText,
        edt8 : EditText,
        guessWord : String
    ) {
        val let1 = guessWord[0].toString()
        val let2 = guessWord[1].toString()
        val let3 = guessWord[2].toString()
        val let4 = guessWord[3].toString()
        val let5 = guessWord[4].toString()
        val let6 = guessWord[5].toString()
        val let7 = guessWord[6].toString()
        val let8 = guessWord[7].toString()

        val edt1Text = edt1.text.toString()
        val edt2Text = edt2.text.toString()
        val edt3Text = edt3.text.toString()
        val edt4Text = edt4.text.toString()
        val edt5Text = edt5.text.toString()
        val edt6Text = edt6.text.toString()
        val edt7Text = edt7.text.toString()
        val edt8Text = edt8.text.toString()


        if(edt1Text == let2 || edt1Text == let3 || edt1Text == let4 || edt1Text == let5 || edt1Text == let6 || edt1Text == let7 || edt1Text == let8){
            edt1.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt2Text == let1 || edt2Text == let3 || edt2Text == let4 || edt2Text == let5 || edt2Text == let6 || edt2Text == let7 || edt2Text == let8){
            edt2.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt3Text == let1 || edt3Text == let2 || edt3Text == let4 || edt3Text == let5 || edt3Text == let6 || edt3Text == let7 || edt3Text == let8){
            edt3.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt4Text == let1 || edt4Text == let2 || edt4Text == let3 || edt4Text == let5 || edt4Text == let6 || edt4Text == let7 || edt4Text == let8){
            edt4.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt5Text == let1 || edt5Text == let2 || edt5Text == let3 || edt5Text == let4 || edt5Text == let6 || edt5Text == let7 || edt5Text == let8){
            edt5.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt6Text == let1 || edt6Text == let2 || edt6Text == let3 || edt6Text == let4 || edt6Text == let5 || edt6Text == let7 || edt6Text == let8){
            edt6.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt7Text == let1 || edt7Text == let2 || edt7Text == let3 || edt7Text == let4 || edt7Text == let6 || edt7Text == let5 || edt7Text == let8){
            edt7.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt8Text == let1 || edt8Text == let2 || edt8Text == let3 || edt8Text == let4 || edt8Text == let6 || edt8Text == let7 || edt8Text == let5){
            edt8.setBackgroundColor(Color.parseColor("#ffff00"))
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
        if(edt6Text == let6){
            edt6.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if(edt7Text == let7){
            edt7.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if(edt8Text == let8){
            edt8.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if(edt1Text != let1 && edt1Text != let2 && edt1Text != let3 && edt1Text != let4 && edt1Text != let5 && edt1Text != let6 && edt1Text != let7 && edt1Text != let8){
            edt1.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt2Text != let1 && edt2Text != let2 && edt2Text != let3 && edt2Text != let4 && edt2Text != let5 && edt2Text != let6 && edt2Text != let7 && edt2Text != let8){
            edt2.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt3Text != let1 && edt3Text != let2 && edt3Text != let3 && edt3Text != let4 && edt3Text != let5 && edt3Text != let6 && edt3Text != let7 && edt3Text != let8){
            edt3.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt4Text != let1 && edt4Text != let2 && edt4Text != let3 && edt4Text != let4 && edt4Text != let5  && edt4Text != let6 && edt4Text != let7 && edt4Text != let8){
            edt4.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt5Text != let1 && edt5Text != let2 && edt5Text != let3 && edt5Text != let4 && edt5Text != let5 && edt5Text != let6 && edt5Text != let7 && edt5Text != let8){
            edt5.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt6Text != let1 && edt6Text != let2 && edt6Text != let3 && edt6Text != let4 && edt6Text != let5 && edt6Text != let6 && edt6Text != let7 && edt6Text != let8){
            edt6.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt7Text != let1 && edt7Text != let2 && edt7Text != let3 && edt7Text != let4 && edt7Text != let5 && edt7Text != let6 && edt7Text != let7 && edt7Text != let8){
            edt7.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt8Text != let1 && edt8Text != let2 && edt8Text != let3 && edt8Text != let4 && edt8Text != let5 && edt8Text != let6 && edt8Text != let7 && edt8Text != let8){
            edt8.setBackgroundColor(Color.parseColor("#ff3333"))
        }

        //tum harfler dogru - oyun kazanildi
        if(edt1Text == let1 && edt2Text == let2 && edt3Text == let3 && edt4Text == let4 && edt5Text == let5 && edt6Text == let6 && edt7Text == let7 && edt8Text == let8){
            Toast.makeText(requireContext(),"Tebrikler, Oyunu Kazandınız!",Toast.LENGTH_LONG).show()
            //edit textleri inaktif et
            editTextDisable()
            return
        }

        //en son edit texte gelinirse ve bilinmemisse - oyun kaybedilir
        if(edt8.id == R.id.letter88){
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
        binding.letter16.isEnabled = false
        binding.letter17.isEnabled = false
        binding.letter18.isEnabled = false
        binding.letter21.isEnabled = false
        binding.letter22.isEnabled = false
        binding.letter23.isEnabled = false
        binding.letter24.isEnabled = false
        binding.letter25.isEnabled = false
        binding.letter26.isEnabled = false
        binding.letter27.isEnabled = false
        binding.letter28.isEnabled = false
        binding.letter31.isEnabled = false
        binding.letter32.isEnabled = false
        binding.letter33.isEnabled = false
        binding.letter34.isEnabled = false
        binding.letter35.isEnabled = false
        binding.letter36.isEnabled = false
        binding.letter37.isEnabled = false
        binding.letter38.isEnabled = false
        binding.letter41.isEnabled = false
        binding.letter42.isEnabled = false
        binding.letter43.isEnabled = false
        binding.letter44.isEnabled = false
        binding.letter45.isEnabled = false
        binding.letter46.isEnabled = false
        binding.letter47.isEnabled = false
        binding.letter48.isEnabled = false
        binding.letter51.isEnabled = false
        binding.letter52.isEnabled = false
        binding.letter53.isEnabled = false
        binding.letter54.isEnabled = false
        binding.letter55.isEnabled = false
        binding.letter56.isEnabled = false
        binding.letter57.isEnabled = false
        binding.letter58.isEnabled = false
        binding.letter61.isEnabled = false
        binding.letter62.isEnabled = false
        binding.letter63.isEnabled = false
        binding.letter64.isEnabled = false
        binding.letter65.isEnabled = false
        binding.letter66.isEnabled = false
        binding.letter67.isEnabled = false
        binding.letter68.isEnabled = false
        binding.letter71.isEnabled = false
        binding.letter72.isEnabled = false
        binding.letter73.isEnabled = false
        binding.letter74.isEnabled = false
        binding.letter75.isEnabled = false
        binding.letter76.isEnabled = false
        binding.letter77.isEnabled = false
        binding.letter78.isEnabled = false
        binding.letter81.isEnabled = false
        binding.letter82.isEnabled = false
        binding.letter83.isEnabled = false
        binding.letter84.isEnabled = false
        binding.letter85.isEnabled = false
        binding.letter86.isEnabled = false
        binding.letter87.isEnabled = false
        binding.letter88.isEnabled = false

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
        editTextFocus(binding.letter15,binding.letter16)
        editTextFocus(binding.letter16,binding.letter17)
        editTextFocus(binding.letter17,binding.letter18)


        editTextFocus(binding.letter21,binding.letter22)
        editTextFocus(binding.letter22,binding.letter23)
        editTextFocus(binding.letter23,binding.letter24)
        editTextFocus(binding.letter24,binding.letter25)
        editTextFocus(binding.letter25,binding.letter26)
        editTextFocus(binding.letter26,binding.letter27)
        editTextFocus(binding.letter27,binding.letter28)


        editTextFocus(binding.letter31,binding.letter32)
        editTextFocus(binding.letter32,binding.letter33)
        editTextFocus(binding.letter33,binding.letter34)
        editTextFocus(binding.letter34,binding.letter35)
        editTextFocus(binding.letter35,binding.letter36)
        editTextFocus(binding.letter37,binding.letter37)
        editTextFocus(binding.letter37,binding.letter38)


        editTextFocus(binding.letter41,binding.letter42)
        editTextFocus(binding.letter42,binding.letter43)
        editTextFocus(binding.letter43,binding.letter44)
        editTextFocus(binding.letter44,binding.letter45)
        editTextFocus(binding.letter45,binding.letter46)
        editTextFocus(binding.letter46,binding.letter47)
        editTextFocus(binding.letter47,binding.letter48)


        editTextFocus(binding.letter51,binding.letter52)
        editTextFocus(binding.letter52,binding.letter53)
        editTextFocus(binding.letter53,binding.letter54)
        editTextFocus(binding.letter54,binding.letter55)
        editTextFocus(binding.letter55,binding.letter56)
        editTextFocus(binding.letter56,binding.letter57)
        editTextFocus(binding.letter57,binding.letter58)


        editTextFocus(binding.letter61,binding.letter62)
        editTextFocus(binding.letter62,binding.letter63)
        editTextFocus(binding.letter63,binding.letter64)
        editTextFocus(binding.letter64,binding.letter65)
        editTextFocus(binding.letter65,binding.letter66)
        editTextFocus(binding.letter66,binding.letter67)
        editTextFocus(binding.letter67,binding.letter68)


        editTextFocus(binding.letter71,binding.letter72)
        editTextFocus(binding.letter72,binding.letter73)
        editTextFocus(binding.letter73,binding.letter74)
        editTextFocus(binding.letter74,binding.letter75)
        editTextFocus(binding.letter75,binding.letter76)
        editTextFocus(binding.letter76,binding.letter77)
        editTextFocus(binding.letter77,binding.letter78)


        editTextFocus(binding.letter81,binding.letter82)
        editTextFocus(binding.letter82,binding.letter83)
        editTextFocus(binding.letter83,binding.letter84)
        editTextFocus(binding.letter84,binding.letter85)
        editTextFocus(binding.letter85,binding.letter86)
        editTextFocus(binding.letter86,binding.letter87)
        editTextFocus(binding.letter87,binding.letter88)
    }

}