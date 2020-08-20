package com.mit.myapplication

import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstInputNumber = findViewById<EditText>(R.id.edt_number_1)
        val secondInputNumber:EditText = findViewById(R.id.edt_number_2)
        val btnCalculate:Button = findViewById(R.id.btn_calculate)

        //find radio group
        val radioGroupMathOp:RadioGroup = findViewById(R.id.radio_group_math_operation)
        val txtResults:TextView = findViewById(R.id.txtResult)

        //tO create a toast -
        //we have to have a context - is simply where we at the time
        /*
        * Like right now we are at the Main Activity
        * so our context is on activity - specifically MainActivity
        *
        *
        * we have to have a message to display as a toast
        * Next is the duration - how long will show - two option - Short and Long
        * -Then we show
        *  */



        //get the value that the user will input
        btnCalculate.setOnClickListener {
            //
            if (firstInputNumber.text.isEmpty()){
                //report an error
                firstInputNumber.setError("Enter Number 1")
                //firstInputNumber.error="Enter Number 1"
            }else{
                if (secondInputNumber.text.isEmpty()){
                    //report an error
                    secondInputNumber.setError("Enter Number 2")
                }else{
                    val num1 = firstInputNumber.text.toString().toInt()
                    val num2 = secondInputNumber.text.toString().toInt()

                    val selectedOperation = radioGroupMathOp.checkedRadioButtonId

                    var result =0
                   if (selectedOperation ==R.id.radio_btn_add){
                       //addition
                       result=num1+num2
                   }else if(selectedOperation == R.id.radio_btn_minus){
                       //minus
                       result=num1-num2
                   }else if(selectedOperation == R.id.radio_btn_multiply){
                       //multiply
                       result=num1*num2
                   }else if(selectedOperation == R.id.radio_btn_divide){
                       //divide
                       if (num2>0) {
                           result=num1/num2
                       }
                   }else{
                       //no operation
                       val text = "No Operation  Selected"
                       val duration = Toast.LENGTH_LONG

                       val toast = Toast.makeText(applicationContext, text, duration)
                       toast.setGravity(Gravity.CENTER,0,0)
                       toast.show()
                   }

                    txtResults.setText("Results ${result}")

                   /* when(selectedOperation){
                        R.id.radio_btn_add->{
                            //add
                        }
                        R.id.radio_btn_minus->{
                            //minus
                        }
                        R.id.radio_btn_divide->{
                            //division
                        }
                        R.id.radio_btn_multiply->{
                            //multiply
                        }
                    }*/
                    }
                }
            }


        }


    }
