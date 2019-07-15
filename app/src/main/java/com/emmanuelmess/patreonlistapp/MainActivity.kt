package com.emmanuelmess.patreonlistapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.emmanuelmess.patreonlistlibrary.Backer
import com.emmanuelmess.patreonlistlibrary.PatreonListData
import com.emmanuelmess.patreonlistlibrary.PatreonsListActivity
import com.github.javafaker.Faker

class MainActivity : AppCompatActivity() {

    lateinit var backers: List<Backer>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backers = List(100) {Backer(Faker().name().username())}
    }

    fun onClickList(view: View) {
        startActivity(Intent(this, PatreonsListActivity::class.java).apply {
            putExtra(
                PatreonsListActivity.DATA_ARG, PatreonListData(
                    backers,
                    Uri.parse("http://emmanuelmessulam.com.ar/thanks.html")
                )
            )
        })
    }
}
