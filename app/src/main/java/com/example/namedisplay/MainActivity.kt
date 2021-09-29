package com.example.namedisplay

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var usernameEditText: TextInputEditText
    lateinit var displayButton: Button
    lateinit var displayName: TextView
    lateinit var usernameContainer: TextInputLayout
    lateinit var greetingsLayout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameEditText = findViewById(R.id.user_name_edit_text)
        displayButton = findViewById(R.id.apply_button)
        displayName = findViewById(R.id.display_name)
        usernameContainer = findViewById(R.id.user_name_container)
        greetingsLayout = findViewById(R.id.greetings_layout)


        displayButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            if (username.isEmpty()){
                usernameContainer.isErrorEnabled = true
                usernameContainer.error = "Please kindly input a name"
            } else {
                greetingsLayout.visibility = View.VISIBLE
                displayName.text = username
                usernameContainer.isErrorEnabled = false
                closeSoftKeyboard()
            }
            usernameEditText.setText("")
        }
    }
    private fun closeSoftKeyboard(){
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken,0)
        }
    }
}