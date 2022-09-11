package com.example.challengeschaptiga

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_word.*

class WordFragment : Fragment() {
    lateinit var words : ArrayList<ListDataAlphabetWord>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_word, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val getSerializableAlphabet = arguments?.getSerializable("alphabet") as ListDataAlphabetWord
        val alphabet = getSerializableAlphabet.data

        btn_back.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_wordFragment_to_alphabetFragment)
        }

        tv_title_text.text = "Words that Start With $alphabet"


        if (alphabet=="A") {
            words = arrayListOf(
                ListDataAlphabetWord("Asus"),
                ListDataAlphabetWord("Air"),
                ListDataAlphabetWord("Australia")
            )
        }else if (alphabet=="B") {
            words = arrayListOf(
                ListDataAlphabetWord("Bola"),
                ListDataAlphabetWord("Bahagia"),
                ListDataAlphabetWord("Belanda")
            )
        }else if (alphabet=="C") {
            words = arrayListOf(
                ListDataAlphabetWord("Cicak"),
                ListDataAlphabetWord("China"),
                ListDataAlphabetWord("Capcin")
            )
        }else if (alphabet=="D") {
            words = arrayListOf(
                ListDataAlphabetWord("Dendam"),
                ListDataAlphabetWord("Denmark"),
                ListDataAlphabetWord("Digital")
            )
        }else if (alphabet=="E") {
            words = arrayListOf(
                ListDataAlphabetWord("Economy"),
                ListDataAlphabetWord("Era"),
                ListDataAlphabetWord("Ekor")
            )
        }else if (alphabet=="F") {
            words = arrayListOf(
                ListDataAlphabetWord("Fanta"),
                ListDataAlphabetWord("France"),
                ListDataAlphabetWord("Fifa")
            )
        }else if (alphabet=="G") {
            words = arrayListOf(
                ListDataAlphabetWord("Gunung"),
                ListDataAlphabetWord("Ganas"),
                ListDataAlphabetWord("Graduation")
            )
        }else if (alphabet=="H") {
            words = arrayListOf(
                ListDataAlphabetWord("Helikopter"),
                ListDataAlphabetWord("Honda"),
                ListDataAlphabetWord("Harapan")
            )
        }else if (alphabet=="I") {
            words = arrayListOf(
                ListDataAlphabetWord("Ikan"),
                ListDataAlphabetWord("Indonesia"),
                ListDataAlphabetWord("Impresive")
            )
        }else if (alphabet=="J") {
            words = arrayListOf(
                ListDataAlphabetWord("Jakarta"),
                ListDataAlphabetWord("Jenazah"),
                ListDataAlphabetWord("Jin")
            )
        }

        val wordAdapter = WordsAdapter(words)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_words.layoutManager = layoutManager
        rv_words.adapter = wordAdapter

        wordAdapter.onItemClick = {
            val word = it.data
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=$word"))
            startActivity(intent)
        }
    }
}