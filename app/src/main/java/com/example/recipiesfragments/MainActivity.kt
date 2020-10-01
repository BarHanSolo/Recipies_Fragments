package com.example.recipiesfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayListFragment()
    }

    fun displayListFragment(){
        val listFragment = ListFragment()

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        val oldFragment = fragmentManager.findFragmentByTag("detailsFragmentTag")
        if (oldFragment != null) {
            transaction.remove(oldFragment)
        }
        transaction.add(R.id.fragment_container, listFragment, "listFragmentTag")
            .commit()
    }

    fun displayDetailsFragment(index: Int){
        val detailsFragment = DetailsFragment()

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        val arguments = Bundle()
        val titles = resources.getStringArray(R.array.recipe_titles)
        val title = titles[index]
        arguments.putString("name", title)
        arguments.putInt("index", index)
        detailsFragment.arguments = arguments

        val oldFragment = fragmentManager.findFragmentByTag("listFragmentTag")
        transaction.remove(oldFragment!!)
        transaction.add(R.id.fragment_container, detailsFragment, "detailsFragmentTag")
            .commit()
    }
}
