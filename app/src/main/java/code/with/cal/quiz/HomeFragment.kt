package code.with.cal.quiz

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.GsonBuilder
import code.with.cal.quiz.databinding.FragmentHomeBinding
import code.with.cal.quiz.NetworkManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class HomeFragment:Fragment(R.layout.fragment_home) {
    private lateinit var bindingHome: FragmentHomeBinding
    private lateinit var videoAdapter: ImageAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        bindingHome = FragmentHomeBinding.bind(view)

        bindingHome.recyclerviewHome.layoutManager = GridLayoutManager(context,2)

        NetworkManager.service.uploadImage("1c04e05bce6e626247758d120b372a73",
            "flickr.photos.getPopular",
            "34427466731@N01",
            "url_s",
            "json",
            1,
            100,
            1
                ).enqueue(object :
        Callback<Any>{
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                val body = response.body().toString()
                val gson = GsonBuilder().create()
                val result = gson.fromJson(body, ImageModel::class.java)
                Log.i("App", body)
                val adapter = ImageAdapter(this@HomeFragment,result)

                bindingHome.recyclerviewHome.adapter = adapter
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                Log.i("TAG_APP",t.toString())
            }

        })

        super.onViewCreated(view, savedInstanceState)
    }
}
