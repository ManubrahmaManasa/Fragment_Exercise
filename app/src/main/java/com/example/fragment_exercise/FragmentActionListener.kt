package com.example.fragment_exercise

import android.os.Bundle

interface FragmentActionListener {




    companion object {
        const val KEY_SELECTED_FRUIT = "KEY_SELECTED_FRUIT"
        const val ACTION_KEY = "action_key"
        const val ACTION_VALUE_FRUIT_SELECTED = 1
    }

    fun onAction(bundle: Bundle)
}