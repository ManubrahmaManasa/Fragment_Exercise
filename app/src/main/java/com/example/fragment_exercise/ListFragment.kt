package com.example.fragment_exercise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class ListFragment : Fragment() {

    lateinit var rootView:View
    lateinit var listViewFruits:ListView
    lateinit var fruitsAdapter:ArrayAdapter<String>
    lateinit var fruits:Array<String>
    private var fragmentActionListener: FragmentActionListener? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_list, container, false)
        initializeUI()
        return rootView
    }

    override fun onResume() {
        super.onResume()
        //need to work on title update
    }

    fun assignCallBackInterface(fragmentActionListener: FragmentActionListener){
        this.fragmentActionListener = fragmentActionListener;
    }


    private fun initializeUI() {
        val context = requireContext()
        fruits = resources.getStringArray(R.array.fruits)
        listViewFruits = rootView.findViewById(R.id.fruitslist)
        fruitsAdapter = ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,fruits)
        listViewFruits.adapter = fruitsAdapter
        listViewFruits.setOnItemClickListener { adapterView, view, i, l ->
            val bundle = Bundle()
            bundle.putInt(FragmentActionListener.ACTION_KEY,FragmentActionListener.ACTION_VALUE_FRUIT_SELECTED)
            bundle.putString(FragmentActionListener.KEY_SELECTED_FRUIT,fruits[i])
            fragmentActionListener?.onAction(bundle)
        }
    }

}