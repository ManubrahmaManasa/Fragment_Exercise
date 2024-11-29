package com.example.fragment_exercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.fragment_exercise.FragmentActionListener.Companion.ACTION_KEY
import com.example.fragment_exercise.FragmentActionListener.Companion.ACTION_VALUE_FRUIT_SELECTED
import com.example.fragment_exercise.FragmentActionListener.Companion.KEY_SELECTED_FRUIT
import com.example.fragment_exercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),FragmentActionListener {

    private lateinit var mainBinding: ActivityMainBinding
    lateinit var fragmentManager:FragmentManager
    lateinit var fragmentTransaction:FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        fragmentManager = supportFragmentManager

        /*window.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)*/

        addFragment()
    }

    private fun addFragment() {
        fragmentTransaction = fragmentManager.beginTransaction()
        val listFragment = ListFragment()
        listFragment.assignCallBackInterface(this)
        fragmentTransaction.add(R.id.fragment_container,listFragment)
        fragmentTransaction.commit()
    }

    private fun addDescriptionFragment(bundle: Bundle){
        fragmentTransaction = fragmentManager.beginTransaction()
        val listDescriptionFragment = ListDescription_Fragment()

        listDescriptionFragment.arguments = bundle

        fragmentTransaction.replace(R.id.fragment_container,listDescriptionFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onAction(bundle: Bundle) {
        val actionPerformed:Int = bundle.getInt(ACTION_KEY)
        when(actionPerformed){
            ACTION_VALUE_FRUIT_SELECTED -> addDescriptionFragment(bundle)
        }
    }
}
