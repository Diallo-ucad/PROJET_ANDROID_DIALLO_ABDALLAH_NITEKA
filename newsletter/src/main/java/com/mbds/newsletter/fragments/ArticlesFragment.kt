package com.mbds.newsletter.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mbds.newsletter.R
import com.mbds.newsletter.adapters.ArticleRecyclerViewAdapter
import com.mbds.newsletter.model.Category
import com.mbds.newsletter.repository.Contents
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * A fragment representing a list of Items.
 */
class ArticlesFragment(private val category: Category) : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activity?.title = "Catégorie - ${category.label.toLowerCase()}"

        val view = inflater.inflate(R.layout.fragment_articles, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                GlobalScope.launch(Dispatchers.Main) {
                    adapter = Contents.categoryArticles[category.name]?.let {
                        ArticleRecyclerViewAdapter(
                            it
                        )
                    }
                    layoutManager = GridLayoutManager(view.context, 1)
                }

            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

    }
}