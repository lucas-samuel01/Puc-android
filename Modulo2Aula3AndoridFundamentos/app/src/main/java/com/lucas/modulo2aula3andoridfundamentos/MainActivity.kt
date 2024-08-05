 package com.lucas.modulo2aula3andoridfundamentos

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import org.w3c.dom.Text

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textField = findViewById<EditText>(R.id.edit_text_id)
        val buttomSearch = findViewById<Button>(R.id.button_search)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val resultText = findViewById<TextView>(R.id.text_descricao)
        val titleText = findViewById<TextView>(R.id.text_title)
        val image = findViewById<ImageView>(R.id.imagem_id)

        buttomSearch.setOnClickListener {
            Toast.makeText(this, "Valor do cmapo de testo: ${textField.text}",Toast.LENGTH_SHORT)

            textField.isEnabled = false
            progressBar.isVisible= true
            buttomSearch.isVisible= false

            if(textField.text.toString() == "lagarto")
                titleText.text = "LARGATO"
                resultText.text = "SEI LA MAN PARA DE PESQUISAR LAGARTO NA INTERNET SEU ESTRANHO"
                image.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.lagarto))
            }
            textField.isEnabled = true
            progressBar.isVisible= false
            buttomSearch.isVisible= true


        }

    }
}