package com.emmanuelmess.patreonlistapp

import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import com.emmanuelmess.patreonlistlibrary.Backer
import com.emmanuelmess.patreonlistlibrary.PatreonListData
import com.emmanuelmess.patreonlistlibrary.PatreonsListActivity
import com.github.javafaker.Faker
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {

    lateinit var backers: List<Backer>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BackerList(this).execute()
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

    class BackerList(mainActivity: MainActivity) : AsyncTask<Unit, Unit, List<Backer>>() {
        val mainActivity = WeakReference(mainActivity)

        override fun doInBackground(vararg params: Unit?): List<Backer> {
            return List(100) {Backer(Faker().name().username())}
        }

        override fun onPostExecute(result: List<Backer>) {
            mainActivity.get()?.let { mainActivity ->
                mainActivity.backers = result

                mainActivity.progressBar.visibility = GONE
                mainActivity.button.visibility = VISIBLE
            }
        }
    }
}
