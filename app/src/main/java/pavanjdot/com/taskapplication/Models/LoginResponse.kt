package pavanjdot.com.taskapplication.Models

import com.google.gson.annotations.SerializedName

/**
 * Created by Pavan on 17/3/18.
 */

internal class ServerResponse {
    // variable name should be same as in the json response from php
    @SerializedName("success")
    private var success:Boolean = false
    @SerializedName("message")
    lateinit var message:String
}