package com.example.root

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.main_page.ui.MainFragment
import com.example.rawgio.R

class RootActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = MainFragment()
        replace(fragment, R.id.fragmentContainer)
    }

    private fun replace(fragment: Fragment, id: Int) {
        val fragmentManager = this.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack(null)
            .replace(id, fragment)
            .commit()
    }
}