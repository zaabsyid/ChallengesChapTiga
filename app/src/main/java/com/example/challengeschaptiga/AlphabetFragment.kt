package com.example.challengeschaptiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_alphabet.*

class AlphabetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alphabet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listDataAlphabet = arrayListOf(
            ListDataAlphabetWord("A"),
            ListDataAlphabetWord("B"),
            ListDataAlphabetWord("C"),
            ListDataAlphabetWord("D"),
            ListDataAlphabetWord("E"),
            ListDataAlphabetWord("F"),
            ListDataAlphabetWord("G"),
            ListDataAlphabetWord("H"),
            ListDataAlphabetWord("I"),
            ListDataAlphabetWord("J")
        )

        val alphabetAdapter = AlphabetAdapter(listDataAlphabet)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_alphabet.layoutManager = layoutManager
        rv_alphabet.adapter = alphabetAdapter

        alphabetAdapter.onItemClick = {
            val wordFragment = WordFragment()

            val sendData = Bundle()
            sendData.putSerializable("alphabet", it)
            wordFragment.arguments = sendData

            val fragmentManager = fragmentManager
            val fragmentTransaction = fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.container, wordFragment)
            fragmentTransaction?.commit()
        }

        fun changeView() {
            val thisFragment = AlphabetFragment()
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, thisFragment)?.commit()
        }

        btn_change_view.setOnClickListener {
            val adapterAlphabet = AlphabetAdapter(listDataAlphabet)
            val layoutManager = GridLayoutManager(context, 2)
            rv_alphabet.layoutManager = layoutManager
            rv_alphabet.adapter = adapterAlphabet

            adapterAlphabet.onItemClick = {
                val wordFragment = WordFragment()

                val sendData = Bundle()
                sendData.putSerializable("alphabet", it)
                wordFragment.arguments = sendData

                val fragmentManager = fragmentManager
                val fragmentTransaction = fragmentManager?.beginTransaction()
                fragmentTransaction?.replace(R.id.container, wordFragment)
                fragmentTransaction?.commit()
            }
            btn_change_view.setImageResource(R.drawable.ic_list_view)

            btn_change_view.setOnClickListener {
                changeView()
            }
        }
    }
}