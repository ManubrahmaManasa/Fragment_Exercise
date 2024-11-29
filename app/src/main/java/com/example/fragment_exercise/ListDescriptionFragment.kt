package com.example.fragment_exercise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.fragment_exercise.FragmentActionListener.Companion.KEY_SELECTED_FRUIT
import com.example.fragment_exercise.databinding.FragmentListDescriptionBinding

class ListDescription_Fragment : Fragment() {

    lateinit var rootView: View
    lateinit var fruitName: String
    lateinit var fruitDescription: String
    lateinit var binding: FragmentListDescriptionBinding
    lateinit var  textView:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_list_description_, container, false)
        textView = rootView.findViewById(R.id.fruitDescription)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val bundle: Bundle? = arguments
        fruitName = bundle?.getString(KEY_SELECTED_FRUIT, "Mango").toString()
        fruitDescription = getString(getStringId(fruitName))
    }



    override fun onResume() {
        super.onResume()
        textView.text = fruitDescription
    }

    private fun getStringId(fruitName: String): Int {
        if (fruitName.equals("Mango")) {
            return R.string.Mango
        } else if (fruitName.equals("Banana")) {
            return R.string.Banana
        } else if (fruitName.equals("Orange")) {
            return R.string.Orange
        } else if (fruitName.equals("Pomegranate")) {
            return R.string.Pomegranate
        } else if (fruitName.equals("Watermelon")) {
            return R.string.Watermelon
        } else if (fruitName.equals("Kiwi")) {
            return R.string.Kiwi
        } else if (fruitName.equals("Cherry")) {
            return R.string.Cherry
        } else if (fruitName.equals("Strawberry")) {
            return R.string.Strawberry
        } else {
            return R.string.Mango
        }
    }
}