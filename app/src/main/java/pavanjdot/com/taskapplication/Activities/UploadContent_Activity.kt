package pavanjdot.com.taskapplication.Activities
/**
 * Created by Pavan on 17/3/18.
 */

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_uploaded_content.*
import pavanjdot.com.taskapplication.R
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.R
import android.content.ContentUris
import android.util.Base64
import android.util.Log
import okhttp3.*
import pavanjdot.com.taskapplication.API.Api
import pavanjdot.com.taskapplication.API.RetrofitClint
import retrofit2.Retrofit
import java.io.ByteArrayOutputStream
import java.io.File


class UploadContent_Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(pavanjdot.com.taskapplication.R.layout.activity_uploaded_content)



    }


}
