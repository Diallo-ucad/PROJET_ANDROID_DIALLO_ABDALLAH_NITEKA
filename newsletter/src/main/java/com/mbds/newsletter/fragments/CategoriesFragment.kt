package com.mbds.newsletter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mbds.newsletter.R
import com.mbds.newsletter.adapters.CategoriAdapter
import com.mbds.newsletter.model.Category
import com.mbds.newsletter.utils.CellClickListener

/**
 * A simple [Fragment] subclass.
 * Use the [CategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoriesFragment(private val cellClickListener: CellClickListener) : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        val articles = listOf(
                Category(name = "business",
                        image = "https://i.picsum.photos/id/1075/500/300.jpg?hmac=5DhRFK2dTT-URjGdj3Fgb8fBZOGnqy-lIR1gIm_JJ3U"),
                Category(name = "entertainment",
                        image = "https://picsum.photos/500/300?random=1"),
                Category(name = "general",
                        image = "https://picsum.photos/500/300?random=2"),
                Category(name = "health",
                        image = "https://picsum.photos/500/300?random=3"),
                Category(name = "science",
                        image = "https://picsum.photos/500/300?random=4"),
                Category(name = "sports",
                        image = "https://picsum.photos/500/300?random=5"),
                Category(name = "technology",
                        image = "https://picsum.photos/500/300?random=6")
        )
        val adapterRecycler = CategoriAdapter(articles, cellClickListener)
        recyclerView.layoutManager = GridLayoutManager(view.context, 1)
        recyclerView.adapter = adapterRecycler

    }

}