package com.idn.doadzikir

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ArtikelAdapter(private val listArtikel: ArrayList<Artikel>) :
    RecyclerView.Adapter<ArtikelAdapter.MyViewHolder>() {

        inner class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
            val imgArtikel: ImageView = view.findViewById(R.id.img_artikel)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_item_artikel, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imgArtikel.setImageResource(listArtikel[position].imageArtikel)
        holder.imgArtikel.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailArtikelActivity::class.java)
            intent.putExtra(DetailArtikelActivity.DATA_TITLE, listArtikel[position].titleArtikel)
            intent.putExtra(DetailArtikelActivity.DATA_DESC, listArtikel[position].descArtikel)
            intent.putExtra(DetailArtikelActivity.DATA_IMAGE, listArtikel[position].imageArtikel)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listArtikel.size
    }
}