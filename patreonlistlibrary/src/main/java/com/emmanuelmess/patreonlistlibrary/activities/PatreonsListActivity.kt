package com.emmanuelmess.patreonlistlibrary.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_patreonslist.*
import android.content.Intent
import android.net.Uri
import com.emmanuelmess.patreonlistlibrary.R
import android.app.Activity
import androidx.core.app.ActivityCompat

class PatreonsListActivity : AppCompatActivity() {

    private var parentActivity: Class<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patreonslist)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val comp = intent.component

        parentActivity = if(comp == null) null else Class.forName(comp.className)


        fab.setOnClickListener { _ ->
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://emmanuelmessulam.com.ar/thanks.html")))
        }
    }


    override fun getSupportParentActivityIntent(): Intent? {
        return getParentActivityIntentImpl()
    }

    override fun getParentActivityIntent(): Intent? {
        return getParentActivityIntentImpl()
    }

    private fun getParentActivityIntentImpl(): Intent {
        val i = Intent(this, parentActivity)
        // set any flags or extras that you need.
        // If you are reusing the previous Activity (i.e. bringing it to the top
        // without re-creating a new instance) set these flags:
        i.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP

        return i
    }
}
