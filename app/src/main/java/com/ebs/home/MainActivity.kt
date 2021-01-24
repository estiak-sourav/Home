package com.ebs.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebs.home.animatedrecyclerview.RecyclerViewDemoActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var myAdapter: HomeMainAdapter
    lateinit var mLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.setHasFixedSize(true)
        recyclerView.setItemViewCacheSize(20)
        mLayoutManager = LinearLayoutManager(
            applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerView.layoutManager = mLayoutManager

        myAdapter = HomeMainAdapter(applicationContext, Constant.HOME_CONTENT)
        recyclerView.adapter = myAdapter


        button.setOnClickListener {

            startActivity(Intent(this, PurchaseActivity::class.java))
            //startActivity(Intent(this, RecyclerViewDemoActivity::class.java))

            //mLayoutManager.scrollToPositionWithOffset(2, 20);


            // send mail
            /*val recipientList = "easourav25@gmail.com"
            val recipients = recipientList.split(",".toRegex()).toTypedArray()


            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, recipients)
            intent.putExtra(Intent.EXTRA_SUBJECT, "subject")
            intent.putExtra(Intent.EXTRA_TEXT, "message")
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Choose an email client"))

            val mailClient = Intent(Intent.ACTION_VIEW)
            mailClient.setClassName(
                "com.google.android.gm",
                "com.google.android.gm.ConversationListActivity"
            )*/
        }
    }
}