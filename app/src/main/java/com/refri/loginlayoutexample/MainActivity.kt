package com.refri.loginlayoutexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.refri.loginlayoutexample.databinding.ActivityMainBinding
import com.shashank.sony.fancytoastlib.FancyToast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.llActionLoginFb.setOnClickListener {
            FancyToast.makeText(
                this,
                "Login Facebook Success !",
                Toast.LENGTH_SHORT,
                FancyToast.SUCCESS,
                false
            ).show()
        }
        binding.llActionLoginGmail.setOnClickListener {
            FancyToast.makeText(
                this,
                "Login Gmail Success!",
                Toast.LENGTH_SHORT,
                FancyToast.SUCCESS,
                false
            ).show()
        }

        binding.btnLogin.setOnClickListener {
            checkLogin()
        }

    }

    private fun checkLogin() {
        //if form valid , means password and email is not empty
        if (isFormValid()) {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            if (email == "admin@gmail.com" && password == "admin") {
                FancyToast.makeText(
                    this,
                    "Login Success!",
                    Toast.LENGTH_SHORT,
                    FancyToast.SUCCESS,
                    false
                ).show()
            } else {
                FancyToast.makeText(
                    this,
                    "Login Failed!",
                    Toast.LENGTH_SHORT,
                    FancyToast.ERROR,
                    false
                ).show()
            }
        }
    }

    /*
    * @Function : this method to check is form email and password already filled or not
    *
    * */
    private fun isFormValid(): Boolean {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        var isFormValid = true

        //checking email
        if (email.isEmpty()) {
            isFormValid = false
            binding.tilEmail.isErrorEnabled = true
            binding.tilEmail.error = getString(R.string.text_error_email_field)
        } else {
            binding.tilEmail.isErrorEnabled = false
        }

        //checking password
        if (password.isEmpty()) {
            isFormValid = false
            binding.tilPassword.isErrorEnabled = true
            binding.tilPassword.error = getString(R.string.text_error_password_field)
        } else {
            binding.tilPassword.isErrorEnabled = false
        }
        return isFormValid
    }


}