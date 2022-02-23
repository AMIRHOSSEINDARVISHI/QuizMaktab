package code.with.cal.quiz

import android.graphics.Bitmap
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ImageService {

    @Multipart
    @GET("/services/rest/")
    fun uploadImage(
        @Query("api_key") api_key: String,
        @Query("method") method: String,
        @Query("user_id") user_id: String,
        @Query("extras") extras: String,
        @Query("format") format: String,
        @Query("nojsoncallback") noJsonCallBack: Int,
        @Query("per_page") per_page: Int,
        @Query("page") page: Int
    ): Call<Any>

}