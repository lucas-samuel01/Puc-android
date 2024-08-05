package com.lucas.modulo2aula5recicleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.lucas.modulo2aula5recicleview.databinding.ItemListBinding

class NoticiaAdapter(
    private val listaNoticia: List<NoticiaModel>,
    private val glide:RequestManager,
    private val link: OnItemClickListenet
):RecyclerView.Adapter<NoticiaAdapter.ViewHolder>(){
    private lateinit var binding: ItemListBinding
    inner class ViewHolder(item: View):RecyclerView.ViewHolder(item) {
        val titulo = binding.tituloNoticia
        val descricao = binding.descricaoNoticia
        val autorImagem = binding.imagemAvatar
        val autorNome = binding.nomeAutor
        val imagemNOticia = binding.imagemNoticia
        val dataNoticia = binding.dataNoticia
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return listaNoticia.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemAtual= listaNoticia[position]

        holder.titulo.text = itemAtual.tituloNotivia
        holder.descricao.text = itemAtual.descricaoNoticia
        holder.autorNome.text = itemAtual.nomeAutor
        holder.dataNoticia.text = itemAtual.dataNoticia

        holder.itemView.setOnClickListener{
            link.openLink(itemAtual.link)
        }
        glide.load(itemAtual.imagemAutorUrl)
            .into(holder.autorImagem)
        glide.load(itemAtual.imageNoticia)
            .into(holder.imagemNOticia)
    }


}