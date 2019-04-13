package pavanjdot.com.taskapplication.Activities
/**
 * Created by Pavan on 17/3/18.
 */

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_from_signup.*
import org.json.JSONException
import org.json.JSONObject
import pavanjdot.com.taskapplication.API.RetrofitClint
import pavanjdot.com.taskapplication.Models.DefaultResponse
import pavanjdot.com.taskapplication.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class FromSignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_from_signup)

        signup_form_btnlogin.setOnClickListener {
            startActivity(Intent( this@FromSignupActivity, FormSigninActivity::class.java))

        }

        signup_form_btnsignup.setOnClickListener {

            if (signup_form_edtpassword.text.toString().equals(signup_form_edtconfirmpassword.text.toString())) {

                var email = signup_form_edtemail.text.toString().trim()
                var username = signup_form_edtusername.text.toString().trim()
                var password = signup_form_edtpassword.text.toString().trim()
                var confirm_password = signup_form_edtconfirmpassword.text.toString().trim()

                if(email.isEmpty()){

                    signup_form_edtemail.error = "Email required"
                    signup_form_edtemail.requestFocus()
                    return@setOnClickListener
                }


                if(username.isEmpty()){

                    signup_form_edtusername.error = "Username required"
                    signup_form_edtusername.requestFocus()
                    return@setOnClickListener
                }

                if(password.isEmpty()){

                    signup_form_edtpassword.error = "Password required"
                    signup_form_edtpassword.requestFocus()
                    return@setOnClickListener
                }

                if(confirm_password.isEmpty()){

                    signup_form_edtconfirmpassword.error = "Confirm Password required"
                    signup_form_edtconfirmpassword.requestFocus()

                    return@setOnClickListener
                }

                RetrofitClint.instance.createuser(email, username, password, confirm_password)
                    .enqueue(object: Callback<DefaultResponse>{
                        override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {

                            Log.d("Response", t.message)
                            Toast.makeText(this@FromSignupActivity, t.message, Toast.LENGTH_SHORT).show()


                        }

                        override fun onResponse(call: Call<DefaultResponse>, response: Response<DefaultResponse>) {

                            Log.d("Response", response.toString())
                            Log.d("Response", "Response is working")
                            Toast.makeText(this@FromSignupActivity, response.body()?.message , Toast.LENGTH_SHORT).show()

                        }


                    })
            }




        }

    }
}
