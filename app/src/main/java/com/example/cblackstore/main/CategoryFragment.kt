package com.example.cblackstore.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cblackstore.R
import com.example.cblackstore.adapter.CategoryAdapter

class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)

        val categories = listOf("Fiction", "Non-Fiction", "Science", "History", "Fantasy")

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewCategories)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CategoryAdapter(categories)

        return view
    }
}