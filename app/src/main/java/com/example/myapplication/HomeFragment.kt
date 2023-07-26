package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton


class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_home, container, false)

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val btnRekam = view.findViewById<ImageButton>(R.id.btn_tutorial_rekam)
        val btnTulis = view.findViewById<ImageButton>(R.id.btn_tutorial_tulis)

        // Set on click listener for btnRekam
        btnRekam.setOnClickListener {
            val rekamTutorialFragment = RekamTutorialFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, rekamTutorialFragment)
                .addToBackStack(null) // Optional: Add to back stack
                .commit()
        }

        // Set on click listener for btnTulis
        btnTulis.setOnClickListener {
            val tulisTutorialFragment = TulisTutorialFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, tulisTutorialFragment)
                .addToBackStack(null) // Optional: Add to back stack
                .commit()
        }

        return view
    }
}