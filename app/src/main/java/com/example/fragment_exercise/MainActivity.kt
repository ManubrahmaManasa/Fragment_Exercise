package com.example.fragment_exercise

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.fragment_exercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),CallBackInterface {

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
        fragmentTransaction.add(R.id.fragment_container,ListFragment())
        fragmentTransaction.commit()
    }

    override fun callBackMethod() {
        Toast.makeText(this,"Trigger other Fragment",Toast.LENGTH_SHORT).show()
    }
}