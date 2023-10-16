package com.acabes.testprojectcar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carApi = RetrofitHelper.getInstance().create(CarApiFetchable::class.java)
        GlobalScope.launch {
            val result = carApi.getCarData()
            if(result != null){
                Log.d("car", result.body().toString())
            }
        }


    }
}