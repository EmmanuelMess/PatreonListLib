package com.emmanuelmess.patreonlistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.emmanuelmess.patreonlistlibrary.activities.PatreonsListActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickList(view: View) {
        startActivity(Intent(this, PatreonsListActivity::class.java))
    }
}
