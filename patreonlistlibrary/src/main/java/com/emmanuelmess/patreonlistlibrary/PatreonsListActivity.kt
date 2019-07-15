package com.emmanuelmess.patreonlistlibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_patreonslist.*
import android.content.Intent
import android.net.Uri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.content_patreons_list.*

class PatreonsListActivity : AppCompatActivity() {
    companion object {
        const val DATA_ARG = "data"
    }

    private var parentActivity: Class<*>? = null
    private lateinit var completeListUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patreonslist)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val comp = intent.component

        parentActivity = if(comp == null) null else Class.forName(comp.className)

        val data = intent.getParcelableExtra<PatreonListData>(DATA_ARG)

        completeListUri = data.completeList

        fab.setOnClickListener { _ ->
            startActivity(Intent(Intent.ACTION_VIEW, completeListUri))
        }

        val adapter = PatreonListAdapter(this, data.backers.map(::BackerItem))
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
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
