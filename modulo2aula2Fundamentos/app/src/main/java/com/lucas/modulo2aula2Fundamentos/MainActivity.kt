package com.lucas.modulo2aula2Fundamentos

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val TAG = "ActivityLifeCycle"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val fragment = BlankFragment()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.ButtonAdd).setOnClickListener{
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayoutids, fragment).commit()
        }
        findViewById<Button>(R.id.destruir).setOnClickListener{
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.remove(fragment).commit()
        }

    }

    override fun onStart() {
        super.onStart()
        println("$TAG${javaClass.simpleName}STARTOU")
    }

    override fun onResume() {
        super.onResume()
        println("$TAG${javaClass.simpleName}RESUMIU")
    }

    override fun onStop() {
        super.onStop()
        println("$TAG${javaClass.simpleName}Parou")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("$TAG${javaClass.simpleName}DESTRUIR")
    }
}