@file:Suppress("DEPRECATION")

package pavanjdot.com.taskapplication.API
/**
 * Created by Pavan on 17/3/18.
 */

import android.provider.ContactsContract
import pavanjdot.com.taskapplication.Models.DefaultResponse
import pavanjdot.com.taskapplication.Models.ImageClass
import pavanjdot.com.taskapplication.Models.LoginResponse
import pavanjdot.com.taskapplication.Models.Request
import retrofit2.Call
import retrofit2.http.*


interface Api {

    @FormUrlEncoded
    @POST("sign_up")

    fun createuser(
        @Field("form_email") email: String,
        @Field("form_uname") username: String,
        @Field("form_password") password: String,
        @Field("form_confirm_password") confirm_password: String

    ): Call<DefaultResponse>

    @FormUrlEncoded
    @POST("sign_in")

    fun Request(
        @Field("form_username") email_login: String,
        @Field("from_password") password_login: String

    ): Call<LoginResponse>

    @FormUrlEncoded
    @Multipart
    @POST("upload")

    fun uploadphoto(


        @Field("file_name") file_name: String,
        @Field("part_number") part_number: Int
    ): Call<ImageClass>


}