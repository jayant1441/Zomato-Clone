package com.jayantx.zomatoclone

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.jayantx.zomatoclone.Location.SearchLocation
import kotlinx.android.synthetic.main.activity_before_login.*


class BeforeLogin : AppCompatActivity() {

    val RC_SIGN_IN = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_before_login)


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        val account = GoogleSignIn.getLastSignedInAccount(this)
        if (account != null) {
            val personName: String? = account.displayName
            val personEmail: String? = account.email
            val personId: String?= account.id
            val personPhoto: Uri? = account.photoUrl
        }
        updateUI(account)




        btn_continue_with_email.setOnClickListener {
            startActivity(Intent(this, SignUpWithEmail::class.java))
        }

        btn_login_with_google.setOnClickListener {
            val signInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

        btn_skip_before_login.setOnClickListener {
            startActivity(Intent(this,SearchLocation::class.java))
            this.finish()
        }


    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach a listener.
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }


    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            // Signed in successfully, show authenticated UI.
            updateUI(account)
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            //Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d("TAG", "signInResult:failed code=" + e.statusCode)
            Toast.makeText(this,e.toString(), Toast.LENGTH_LONG).show()
            updateUI(null)
        }
    }

    private fun updateUI(account: GoogleSignInAccount?){
        startActivity(Intent(this,MainActivity::class.java))
        this.finish()
    }
}
