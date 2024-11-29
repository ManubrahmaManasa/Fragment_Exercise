package com.example.fragment_exercise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment_exercise.databinding.FragmentListDescriptionBinding

class ListDescription_Fragment : Fragment() {

    lateinit var rootView:View
    private lateinit var descriptionBinding: FragmentListDescriptionBinding
   
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_list_description_, container, false)
        return rootView
    }
}