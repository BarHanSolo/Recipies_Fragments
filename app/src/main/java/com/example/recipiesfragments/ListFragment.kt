package com.example.recipiesfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_list.view.*



class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val titles = resources.getStringArray(R.array.recipe_titles)
        for ((i,title) in titles.withIndex()){
            val button = Button(activity)
            button.text = title
            view.recipies_list.addView(button)
            button.setOnClickListener{
                val mainActivity = activity as MainActivity
                mainActivity.displayDetailsFragment(i)
            }
        }
        return view
    }
}
