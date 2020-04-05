package com.jayantx.zomatoclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isEmpty
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_signup_with_email.*

class SignUpWithEmail : AppCompatActivity() {

    private lateinit var etSignupName: EditText
    private lateinit var etSignupEmail: EditText
    private lateinit var etSignupPassword: EditText

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_with_email)

        auth = FirebaseAuth.getInstance()


        btn_continue_in_sign_up.setOnClickListener {
//            noEmptyFields()

            etSignupName = findViewById<EditText>(R.id.et_signup_name)
            etSignupEmail= findViewById<EditText>(R.id.et_signup_email)
            etSignupPassword = findViewById<EditText>(R.id.et_signup_password)


            if (etSignupName.text.isNullOrEmpty()){
                et_signup_name_layout.error = "Please enter your name"
                etSignupName.requestFocus()
                return@setOnClickListener
            }
            else et_signup_name_layout.isErrorEnabled = false


            if (etSignupEmail.text.isNullOrEmpty()){
                et_signup_email_layout.error = "Please enter your email"
                etSignupEmail.requestFocus()
                return@setOnClickListener
            }
            else et_signup_email_layout.isErrorEnabled = false


            if (etSignupPassword.text.isNullOrEmpty()){
                et_signup_password_layout.error = "Please enter password"
                etSignupPassword.requestFocus()
                return@setOnClickListener
            }
            else et_signup_password_layout.isErrorEnabled = false


            if (etSignupPassword.text!!.length < 8){
                et_signup_password_layout.error = "Please enter 8 character long Password"
                etSignupPassword.requestFocus()
                return@setOnClickListener
            }
            else et_signup_password_layout.isErrorEnabled = false


            if (!Patterns.EMAIL_ADDRESS.matcher(etSignupEmail.text.toString()).matches()){
                et_signup_email_layout.error = "Please enter correct email"
                etSignupEmail.requestFocus()
                return@setOnClickListener
            }
            else et_signup_email_layout.isErrorEnabled = false



            userSignUp(etSignupEmail.text.toString(), etSignupPassword.text.toString())
        }

        tv_already_have_an_acc.setOnClickListener{
            startActivity(Intent(this,LoginWithEmailActivity::class.java))
            this.finish()
        }

    }





//    fun noEmptyFields(){

//        etSignupName = findViewById<EditText>(R.id.et_signup_name)
//        etSignupEmail= findViewById<EditText>(R.id.et_signup_email)
//        etSignupPassword = findViewById<EditText>(R.id.et_signup_password)
//
//
//        if (etSignupName.text.isNullOrEmpty()){
//            et_signup_name_layout.error = "Please enter your name"
//            etSignupName.requestFocus()
//            return
//        }
//        else et_signup_name_layout.isErrorEnabled = false
//
//
//        if (etSignupEmail.text.isNullOrEmpty()){
//            et_signup_email_layout.error = "Please enter your email"
//            etSignupEmail.requestFocus()
//            return
//        }
//        else et_signup_email_layout.isErrorEnabled = false
//
//
//        if (etSignupPassword.text.isNullOrEmpty()){
//            et_signup_password_layout.error = "Please enter password"
//            etSignupPassword.requestFocus()
//            return
//        }
//        else et_signup_password_layout.isErrorEnabled = false
//
//
//        if (etSignupPassword.text!!.length < 8){
//            et_signup_password_layout.error = "Please enter 8 character long Password"
//            etSignupPassword.requestFocus()
//            return
//        }
//        else et_signup_password_layout.isErrorEnabled = false
//
//
//        if (!Patterns.EMAIL_ADDRESS.matcher(etSignupEmail.text.toString()).matches()){
//            et_signup_email_layout.error = "Please enter correct email"
//            etSignupEmail.requestFocus()
//            return
//        }
//        else et_signup_email_layout.isErrorEnabled = false
//    }




    private fun userSignUp(email:String?, password : String?){
        auth.createUserWithEmailAndPassword(email!!, password!!)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {

                    Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }


    private fun updateUI(user: FirebaseUser?){
        startActivity(Intent(this,MainActivity::class.java))
        this.finish()
    }
}
