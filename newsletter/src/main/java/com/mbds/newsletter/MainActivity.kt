package com.mbds.newsletter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mbds.newsletter.fragments.CategoriesFragment
import com.mbds.newsletter.fragments.ArticlesFragment
import com.mbds.newsletter.model.Category
import com.mbds.newsletter.repository.Contents
import com.mbds.newsletter.utils.CellClickListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), CellClickListener {

    private val cellClickListener: CellClickListener = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Contents.isFetched.not()){
            GlobalScope.launch(Dispatchers.Main) {
                Contents.fetchAllArticles()
                changeFragment(CategoriesFragment(cellClickListener))
            }
        }
        else {
            changeFragment(CategoriesFragment(this))
        }
    }
    override fun onCellClickListener(category: Category) {
        println("Catégory cliquée : $category")
        changeFragment(ArticlesFragment(category))
    }
}

/**
 * Ajouter le fragmet [ComputationFragment] dans l'activité
 */
fun MainActivity.changeFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().apply {
        //3) on remplace le contenu du container
        replace(R.id.fragment_container, fragment)
        //4) on ajoute la transaction dans la backstack
        addToBackStack(null)
    }.commit()
    // 5) on commit la transaction
}