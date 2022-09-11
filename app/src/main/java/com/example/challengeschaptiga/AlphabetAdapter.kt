package com.example.challengeschaptiga

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class AlphabetAdapter(val listDataAlphabetWord: ArrayList<ListDataAlphabetWord>) : RecyclerView.Adapter<AlphabetAdapter.ViewHolder>() {

    var onItemClick : ((ListDataAlphabetWord) -> Unit)? = null

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var cardViewAlphabet = view.findViewById<CardView>(R.id.cv_alphabet)
        var textAlphabet = view.findViewById<TextView>(R.id.tv_alphabet)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlphabetAdapter.ViewHolder {
        val v  = LayoutInflater.from(parent.context).inflate(R.layout.item_alphabet, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AlphabetAdapter.ViewHolder, position: Int) {
        holder.textAlphabet.text = listDataAlphabetWord[position].data
        holder.cardViewAlphabet.setOnClickListener{
            onItemClick?.invoke(listDataAlphabetWord[position])
        }
    }

    override fun getItemCount(): Int {
        return listDataAlphabetWord.size
    }
}