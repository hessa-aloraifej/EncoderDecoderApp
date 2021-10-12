package com.example.encoderdecoderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
     var codes:ArrayList<Coding> = arrayListOf()
    lateinit var userinput: EditText
    lateinit var charPhrase: CharArray
     var letter:Char = '\u0000'
    lateinit var myRV:RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userinput=findViewById(R.id.userinput)
        var encoder=findViewById<Button>(R.id.encodebtn)
        var decoder=findViewById<Button>(R.id.decodbtn)
        myRV=findViewById(R.id.myRV)
        encoder.setOnClickListener {

            var phrase = userinput.text.toString()
            if(phrase.isEmpty()){
                Toast.makeText(this, "Please Enter a Phrase ", Toast.LENGTH_SHORT).show()
            }

     else{
         var output= convert(phrase)

           codes.add(Coding("The Original Phrase: $phrase","The Encoded Phrase: $output"))
            myRV.adapter = CodeRVAdapter(codes)
            myRV.layoutManager = LinearLayoutManager(this)}
userinput.text.clear()
        }
        decoder.setOnClickListener {

            var phrase = userinput.text.toString()
            if(phrase.isEmpty()){
                Toast.makeText(this, "Please Enter a Phrase ", Toast.LENGTH_SHORT).show()
            }
            else {
                var output = convert(phrase)

                codes.add(Coding("The Original Phrase: $phrase", "The Decoded Phrase: $output"))
                myRV.adapter = CodeRVAdapter(codes)
                myRV.layoutManager = LinearLayoutManager(this)
            }
            userinput.text.clear()
        }
    }

  fun convert(input:String) :String {

      charPhrase = input.toCharArray()
      var i = 0
      var length = charPhrase.size
      while (i < length) {
          letter = charPhrase[i]

          if (letter >= 'a' && letter <= 'z') {


              if (letter > 'm') {
                  letter -= 13;
              } else {
                  letter += 13;
              }
          } else if (letter >= 'A' && letter <= 'Z') {


              if (letter > 'M') {
                  letter -= 13;
              } else {
                  letter += 13;
              }


          }
          charPhrase[i] = letter;
          i++
      }
      var newphrase=String(charPhrase)
      return "$newphrase"

  }



}

