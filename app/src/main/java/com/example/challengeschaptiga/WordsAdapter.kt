package com.example.challengeschaptiga

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class WordsAdapter(val listDataAlphabetWords: ArrayList<ListDataAlphabetWord>) : RecyclerView.Adapter<WordsAdapter.ViewHolder>() {

    var onItemClick : ((ListDataAlphabetWord) -> Unit)? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var cardViewWord = view.findViewById<CardView>(R.id.cv_word)
        var textWord = view.findViewById<TextView>(R.id.tv_word)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: WordsAdapter.ViewHolder, position: Int) {
        holder.textWord.text = listDataAlphabetWords[position].data
        holder.cardViewWord.setOnClickListener {
            onItemClick?.invoke(listDataAlphabetWords[position])
        }
    }

    override fun getItemCount(): Int {
        return listDataAlphabetWords.size
    }
}