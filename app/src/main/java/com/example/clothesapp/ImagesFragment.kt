package com.example.clothesapp

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ImagesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_images, container, false)
        if (data.currentListOfClothes.isNotEmpty()){
            view.findViewById<TextView>(R.id.textViewEmpty).visibility = View.GONE
            view.findViewById<ImageView>(R.id.imageViewEmpty).visibility = View.GONE
            var recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.adapter = ClothesRecyclerViewAdapter()
            recyclerView.layoutManager = GridLayoutManager(view.context, 2)
        }
        view.findViewById<FloatingActionButton>(R.id.fabAddClothes).setOnClickListener {
            view.findNavController().navigate(R.id.action_imagesFragment_to_changeImageFragment)
        }
        return view
    }
}