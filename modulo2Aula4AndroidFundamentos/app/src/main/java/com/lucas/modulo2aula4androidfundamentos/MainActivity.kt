package com.lucas.modulo2aula4androidfundamentos

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lucas.modulo2aula4androidfundamentos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val listaDeTarefas: ArrayList<String> = ArrayList()
    private lateinit var adapter:ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDeTarefas)
        setContentView(binding.root)
        setupListView()
        setAddButtonClickListener()
        setItemLongClickListener()

    }
    private fun setItemLongClickListener(){
        binding.listItem.setOnItemLongClickListener{_,_,position,_ ->
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Atenção")
            alert.setMessage("Voce quer mesmo apagar esse item?")
            alert.setPositiveButton("confirmar"){dialog,_ ->
                listaDeTarefas.removeAt(position)
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }
            alert.setNegativeButton("Cancelar"){dialog,_ ->
                dialog.dismiss()
            }
            alert.create().show()
            true
        }
    }
    private fun setupListView(){
        binding.listItem.adapter = adapter
    }
    private fun setAddButtonClickListener(){
        binding.buttonAdd.setOnClickListener {
            val value = binding.editTextId.text.toString()
            if (value.isNotBlank()){
                binding.editTextId.setText("")
                listaDeTarefas.add(value)
                adapter.notifyDataSetChanged()

            }else{
                Toast.makeText(this, "Você nao pode adicionar tarefa sem titulo",Toast.LENGTH_SHORT).show()
            }
        }
    }
}