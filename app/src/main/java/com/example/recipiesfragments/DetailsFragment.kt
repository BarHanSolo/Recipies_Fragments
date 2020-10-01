package com.example.recipiesfragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.fragment_details.view.*
import kotlinx.android.synthetic.main.fragment_details.view.button_close

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        val bundle =  this.getArguments()
        val title = bundle?.getString("name")
        val index = bundle?.getInt("index")
        val recipes = resources.getStringArray(R.array.recipe_values)
        view.details_content.text = recipes[index!!]
        view.details_title.text = title
        view.button_close.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.displayListFragment()
        }
        return view
    }


}
