package com.ebs.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ebs.home.model.Contents

class HomeItemAdapter (
    private val context: Context?,
    private val contentType : String,
    private val contentList: MutableList<Contents>

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // If uiCode is "wide", the view is different. the value of uiCode is defined for IN APP LEVEL ui upgrade

    private var setItemClickListener : ItemClickListener? = null
    private var setItemClickListenerCwt : ItemClickListenerCwt? = null
    //private var sessionManager : SessionManager? = null

    companion object {

        // CONTENT_VIEW_TYPE
        const val CONTENT_VIEW_TYPE_ENTERTAINMENT = "entertainment"
        const val CONTENT_VIEW_TYPE_SINGLE_ROW = "bill"

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View? = null
        if (contentType == CONTENT_VIEW_TYPE_ENTERTAINMENT) {
             view = LayoutInflater.from(parent.context).inflate(R.layout.item_entr_icon, parent, false)
            return EntertainmentViewHolder(view)
        } else if (contentType == CONTENT_VIEW_TYPE_SINGLE_ROW){
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_single_icon, parent, false)
            return HorizontalListViewHolder(view)
        }else {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_single_icon, parent, false)
            return HorizontalListViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return contentList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val content = contentList[position]

        if (contentType == CONTENT_VIEW_TYPE_SINGLE_ROW){
            try {
                val homeListViewHolder = holder as HorizontalListViewHolder
                homeListViewHolder.titleTv.text = content.title

                //homeListViewHolder.catHostNameTv.visibility = View.GONE

                Glide
                    .with(homeListViewHolder.itemView.context)
                    .load(content.img)
                    .placeholder(R.drawable.no_img)
                    .into(homeListViewHolder.menuIv)

                homeListViewHolder.itemView.setOnClickListener {
                    //setItemClickListener!!.onItemClickListener(position, content)
                }
            } catch (e : Exception){
                //showLogE("Home Adapter- " + e.message.toString())
            }
        } else if ( contentType == CONTENT_VIEW_TYPE_ENTERTAINMENT){

            try {
                val entertainmentViewHolder = holder as EntertainmentViewHolder
                entertainmentViewHolder.titleTv.text = content.title

                Glide
                    .with(entertainmentViewHolder.itemView.context)
                    .load(content.img)
                    .placeholder(R.drawable.no_img)
                    .into(entertainmentViewHolder.menuEntrIv)


                entertainmentViewHolder.itemView.setOnClickListener {
                    //setItemClickListenerCwt!!.onItemClickListenerCwt(position, content)
                    //context.showToast("clicked ")
                }
            } catch (e : Exception){
                //showLogE("Home Adapter- " + e.message.toString())
            }
        }else{
            try {
                val homeListViewHolder = holder as HorizontalListViewHolder
                homeListViewHolder.titleTv.text = content.title

                //homeListViewHolder.catHostNameTv.visibility = View.GONE

                Glide
                    .with(homeListViewHolder.itemView.context)
                    .load(content.img)
                    .placeholder(R.drawable.no_img)
                    .into(homeListViewHolder.menuIv)

                homeListViewHolder.itemView.setOnClickListener {
                    //setItemClickListener!!.onItemClickListener(position, content)
                }
            } catch (e : Exception){
                //showLogE("Home Adapter- " + e.message.toString())
            }
        }
    }

    inner class HorizontalListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var titleTv : TextView = itemView.findViewById(R.id.titleTv)
        var menuIv : ImageView = itemView.findViewById(R.id.menuIv)

    }

    fun setItemClickListener(setItemClickListener: ItemClickListener) {
        this.setItemClickListener = setItemClickListener
    }

    inner class EntertainmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var titleTv : TextView = itemView.findViewById(R.id.titleTv)
        var menuEntrIv : ImageView = itemView.findViewById(R.id.menuEntrIv)
    }

    interface ItemClickListener {
        fun onItemClickListener(
            position: Int,
            content: Contents
        )
    }

    fun setItemClickListenerCwt(setItemClickListener: ItemClickListenerCwt) {
        this.setItemClickListenerCwt = setItemClickListener
    }

    interface ItemClickListenerCwt {
        fun onItemClickListenerCwt(
            position: Int,
            content: Contents
        )
    }

}