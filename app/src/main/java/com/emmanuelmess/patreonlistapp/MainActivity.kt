package com.emmanuelmess.patreonlistapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.emmanuelmess.patreonlistlibrary.Backer
import com.emmanuelmess.patreonlistlibrary.PatreonListData
import com.emmanuelmess.patreonlistlibrary.PatreonsListActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickList(view: View) {
        startActivity(Intent(this, PatreonsListActivity::class.java).apply {
            putExtra(
                PatreonsListActivity.DATA_ARG, PatreonListData(
                listOf(
                    Backer("Alfred"),
                    Backer("Vishal Nehra")
                ),
                Uri.parse("http://emmanuelmessulam.com.ar/thanks.html")
            ))
        })
    }
}
