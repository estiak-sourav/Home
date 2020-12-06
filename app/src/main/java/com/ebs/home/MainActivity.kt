package com.ebs.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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

            val recipientList: String = "easourav25@gmail.com"
            val recipients = recipientList.split(",".toRegex()).toTypedArray()


            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, recipients)
            intent.putExtra(Intent.EXTRA_SUBJECT, "subject")
            intent.putExtra(Intent.EXTRA_TEXT, "message")
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Choose an email client"))

            /*val mailClient = Intent(Intent.ACTION_VIEW)
            mailClient.setClassName(
                "com.google.android.gm",
                "com.google.android.gm.ConversationListActivity"
            )
            startActivity(mailClient)*/

            /*var intent: Intent? = application.packageManager.getLaunchIntentForPackage("com.ebs.teleflix")

            if (intent != null) {
                //intent = Intent(Intent.ACTION_SEND)
                intent.putExtra(Intent.EXTRA_EMAIL, recipients)
                intent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                intent.putExtra(Intent.EXTRA_TEXT, "message")
                intent.type = "message/rfc822"
                startActivity(intent)
            }
            else{
                Toast.makeText(applicationContext, "Sorry...You don't have gmail app", Toast.LENGTH_LONG).show()
            }*/

            /*val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("abc@gmail.com")
            intent.setClassName(
                "com.google.android.gm",
                "com.google.android.gm.ComposeActivityGmail"
            )
            intent.putExtra(Intent.EXTRA_CC, arrayOf("xyz@gmail.com"))
            intent.putExtra(Intent.EXTRA_BCC, arrayOf("pqr@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "your subject goes here...")
            intent.putExtra(Intent.EXTRA_TEXT, "Your message content goes here...")

            startActivity(intent)*/
        }
    }
}