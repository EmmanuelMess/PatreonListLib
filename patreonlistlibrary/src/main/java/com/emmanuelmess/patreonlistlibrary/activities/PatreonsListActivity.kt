package com.emmanuelmess.patreonlistlibrary.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_patreonslist.*
import android.content.Intent
import android.net.Uri
import com.emmanuelmess.patreonlistlibrary.R

class PatreonsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patreonslist)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        fab.setOnClickListener { _ ->
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://emmanuelmessulam.com.ar/thanks.html")))
        }
    }
}
