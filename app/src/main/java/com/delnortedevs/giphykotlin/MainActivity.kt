package com.delnortedevs.giphykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delnortedevs.giphykotlin.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonBuscar.setOnClickListener{

            //limit es opcional
            //https://api.giphy.com/v1/gifs/search?q=cat&api_key=O09OndFTDm6M6oUhI1zyshNIKeh9YVhp&limit=10
            var params = mutableMapOf<String, String> ()
            val search = binding.editTextGiphy.text.toString()
            params["api_key"] = "ZdSIlZt5YhlaoTWPWQ3QddAeytwFKm48"
            params["q"] = search

            val giphyInterface = GiphyInterface.create().getGiphys(params)
            giphyInterface.enqueue(object : Callback<GiphyResponse> {
                override fun onResponse(
                    call: Call<GiphyResponse>,
                    response: Response<GiphyResponse>
                ) {
                    Log.i("APICall",response.toString())
                    val items : GiphyResponse? = response.body()
                    val adapter = Adapter(applicationContext, items!!)

                    binding.rvGiphys.adapter = adapter
                    binding.rvGiphys.layoutManager = GridLayoutManager(applicationContext,
                        3, RecyclerView.VERTICAL,false)

                }

                override fun onFailure(call: Call<GiphyResponse>, t: Throwable) {
                    Log.i("APICall:", t.message.toString())
                }


            } )

        }





    }
}