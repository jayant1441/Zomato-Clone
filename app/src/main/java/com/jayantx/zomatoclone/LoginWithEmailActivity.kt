package com.jayantx.zomatoclone

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

class LoginWithEmailActivity : AppCompatActivity() {

    private lateinit var etLoginEmail: EditText
    private lateinit var etLoginPassword: EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var progressDialog : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()


        btn_continue_in_login.setOnClickListener {

            etLoginEmail= findViewById<EditText>(R.id.et_login_email)
            etLoginPassword = findViewById<EditText>(R.id.et_login_password)



            if (etLoginEmail.text.isNullOrEmpty()){
                et_login_email_layout.error = "Please enter your email"
                etLoginEmail.requestFocus()
                return@setOnClickListener
            }
            else et_login_email_layout.isErrorEnabled = false


            if (etLoginPassword.text.isNullOrEmpty()){
                et_login_password_layout.error = "Please enter password"
                etLoginPassword.requestFocus()
                return@setOnClickListener
            }
            else et_login_password_layout.isErrorEnabled = false


            if (etLoginPassword.text!!.length < 8){
                et_login_password_layout.error = "Please enter 8 character long Password"
                etLoginPassword.requestFocus()
                return@setOnClickListener
            }
            else et_login_password_layout.isErrorEnabled = false


            if (!Patterns.EMAIL_ADDRESS.matcher(etLoginEmail.text.toString()).matches()){
                et_login_email_layout.error = "Please enter correct email"
                etLoginEmail.requestFocus()
                return@setOnClickListener
            }
            else et_login_email_layout.isErrorEnabled = false

//            noEmptyFields()

            progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Login")
            progressDialog.setMessage("Please wait it may take a moment.")
            progressDialog.show()


            auth.signInWithEmailAndPassword(etLoginEmail.text.toString(), etLoginPassword.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser
                        updateUI(user)
                        progressDialog.dismiss()
                    } else {
                        // If sign in fails, display a message to the user.
                        progressDialog.dismiss()
                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                        updateUI(null)

                    }
                }


        }

        tv_dont_have_account.setOnClickListener{
            startActivity(Intent(this,SignUpWithEmail::class.java))
            this.finish()
        }

    }

//    private fun noEmptyFields(){

//        etLoginEmail= findViewById<EditText>(R.id.et_login_email)
//        etLoginPassword = findViewById<EditText>(R.id.et_login_password)
//
//
//
//        if (etLoginEmail.text.isNullOrEmpty()){
//            et_login_email_layout.error = "Please enter your email"
//            etLoginEmail.requestFocus()
//            return
//        }
//        else et_login_email_layout.isErrorEnabled = false
//
//
//        if (etLoginPassword.text.isNullOrEmpty()){
//            et_login_password_layout.error = "Please enter password"
//            etLoginPassword.requestFocus()
//            return
//        }
//        else et_login_password_layout.isErrorEnabled = false
//
//
//        if (etLoginPassword.text!!.length < 8){
//            et_login_password_layout.error = "Please enter 8 character long Password"
//            etLoginPassword.requestFocus()
//            return
//        }
//        else et_login_password_layout.isErrorEnabled = false
//
//
//        if (!Patterns.EMAIL_ADDRESS.matcher(etLoginEmail.text.toString()).matches()){
//            et_login_email_layout.error = "Please enter correct email"
//            etLoginEmail.requestFocus()
//            return
//        }
//        else et_login_email_layout.isErrorEnabled = false
//    }


    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }



    private fun updateUI(user:FirebaseUser?){
        if(FirebaseAuth.getInstance().currentUser!=null){
            startActivity(Intent(this,MainActivity::class.java))
            this.finish()
        }

    }

}
