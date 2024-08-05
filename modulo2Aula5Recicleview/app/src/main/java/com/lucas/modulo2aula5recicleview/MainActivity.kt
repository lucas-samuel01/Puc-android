package com.lucas.modulo2aula5recicleview

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.lucas.modulo2aula5recicleview.databinding.ActivityMainBinding
import org.json.JSONArray

class MainActivity : AppCompatActivity(), OnItemClickListenet{
    private var listaNoticia: List<NoticiaModel> = listOf()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v(this.javaClass.simpleName, "metodo on create")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listaNoticia = readJSON(this)

        binding.recicleViewId.layoutManager = LinearLayoutManager(this)
        binding.recicleViewId.adapter = NoticiaAdapter(listaNoticia, Glide.with(this),this@MainActivity)

    }

    private fun readJSON(context: Context): List<NoticiaModel> {
        val listaTemp = mutableListOf<NoticiaModel>()
        val json: String = context.assets.open("data.json").bufferedReader().use { it.readText() }

        try {


            val jsonArray = JSONArray(json)

            for (i in 0 until jsonArray.length()) {
                val jsonOBject = jsonArray.getJSONObject(i)
                val authorame = jsonOBject.getString("authorName")
                val authorImageUrl = jsonOBject.getString("authorImageUrl")
                val newsImageURL = jsonOBject.getString("newsImageUrl")
                val newsTitle = jsonOBject.getString("newsTitle")
                val newsDescription = jsonOBject.getString("newsDescription")
                val newsDate = jsonOBject.getString("newsDate")
                val link = jsonOBject.getString("newsLink")

                val notice = NoticiaModel(
                    authorame,
                    authorImageUrl,
                    newsImageURL,
                    newsTitle,
                    newsDescription,
                    newsDate,
                    link
                )
                listaTemp.add(notice)
            }
        }catch (
            error:Exception
        ){
            println(
                "ERRO NO JSON: ${error}"
            )
        }
        return listaTemp
    }

    override fun openLink(link: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(link)
        startActivity(intent)
    }

}