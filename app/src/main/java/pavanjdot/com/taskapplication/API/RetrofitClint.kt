package pavanjdot.com.taskapplication.API
/**
 * Created by Pavan on 17/3/18.
 */

import android.util.Base64
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object RetrofitClint {

  //private val AUTH = "Basic "+ Base64.encodeToString("".toByteArray(), Base64.NO_WRAP)

    private const val BASE_URL = "http://sfs.dev.ritesh.happlabs.in/dev/"

    val okHttpclint =  OkHttpClient.Builder()
        .addInterceptor()
        {
            chain ->
            val orignal = chain.request()

            val requestBuilder = orignal.newBuilder()
                .addHeader("Content-Type", "application/json charset=utf-8")
                .method(orignal.method(), orignal.body())

            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpclint)
            .build()

        retrofit.create(Api::class.java)

    }
}