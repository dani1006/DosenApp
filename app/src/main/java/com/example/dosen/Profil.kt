package com.example.dosen

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Profil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        var gantiUsername = findViewById<View>(R.id.btnUbah) as TextView
        var Ed1 = findViewById<View>(R.id.edtGantinama) as EditText
        var Ed2 = findViewById<View>(R.id.edtGantiAlmt) as EditText
        var Ed3 = findViewById<View>(R.id.edtGantiTelp) as EditText
        val namauser = findViewById<TextView>(R.id.namauser)


        gantiUsername.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                Ed1.setEnabled(true)
                Ed1.setHint("")
            }
        })
        Ed1.setOnEditorActionListener { v, actionld, event ->
            Ed1.isEnabled = false
            val input = Ed1.text.toString()
            namauser.text = input
            if (actionld == EditorInfo.IME_ACTION_DONE) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                true
            } else {
                false
            }
        }

        var gantiAlamat = findViewById<View>(R.id.btnUbahAlmt) as TextView
        gantiAlamat.setOnClickListener(View.OnClickListener {
            Ed2.isEnabled = true
            Ed2.hint = ""
        })
        Ed2.setOnEditorActionListener { v, actionld, event ->
            Ed2.setEnabled(false)
            if (actionld == EditorInfo.IME_ACTION_DONE) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                true
            } else {
                false
            }
        }

        var gantiTelepon = findViewById<View>(R.id.btnUbahTelp) as TextView
        gantiTelepon.setOnClickListener(View.OnClickListener {
            Ed3.isEnabled = true
            Ed3.hint = ""
        })
        Ed3.setOnEditorActionListener { v, actionld, event ->
            Ed3.setEnabled(false)
            if (actionld == EditorInfo.IME_ACTION_DONE) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                true
            } else {
                false
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}




