    package pavanjdot.com.taskapplication.Activities
    /**
     * Created by Pavan on 17/3/18.
     */

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_form__signin.*
import kotlinx.android.synthetic.main.activity_from_signup.*
import pavanjdot.com.taskapplication.API.RetrofitClint
import pavanjdot.com.taskapplication.Models.LoginResponse
import pavanjdot.com.taskapplication.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

    class FormSigninActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form__signin)

        login_form_btnlogin.setOnClickListener {

            val email_login = login_form_edtemail.text.toString().trim()
            val password_login = login_form_edtpassword.text.toString().trim()

            if(email_login.isEmpty()){

                login_form_edtemail.error = "Email required"
                login_form_edtemail.requestFocus()
                return@setOnClickListener
            }

            if(password_login.isEmpty()){

                login_form_edtpassword.error = "Username required"
                login_form_edtpassword.requestFocus()
                return@setOnClickListener
            }

            RetrofitClint.instance.Request(email_login, password_login)
                .enqueue(object :Callback<LoginResponse>{
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

                        Log.d("Response", t.message)
                        Log.d("Response", " this is onFailure body")

                        Toast.makeText(this@FormSigninActivity, t.message, Toast.LENGTH_SHORT).show()

                    }

                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {


                        Log.d("Response", response.toString())
                            Log.d("Response", " this is Response body ")


//                        if(!response.body()?.success!!){
//
//                            Log.d("Response", response.toString())
//                            Log.d("Response", " this is Response body ")
//
//                            Toast.makeText(this@FormSigninActivity, response.body()?.message, Toast.LENGTH_SHORT).show()
//
//                        }else{
//                            Log.d("Response", response.toString())
//                            Toast.makeText(this@FormSigninActivity, response.body()?.message, Toast.LENGTH_SHORT).show()
//                        }


                    }

                })

    }

    }



    }
