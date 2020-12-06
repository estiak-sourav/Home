package com.ebs.home

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ebs.home.model.Contents
import com.ebs.home.model.HomeMainContent
import com.jama.carouselview.CarouselView
import com.jama.carouselview.enums.IndicatorAnimationType
import com.jama.carouselview.enums.OffsetType

class HomeMainAdapter(
    private val mContext: Context,
    private val mainItemList: MutableList<HomeMainContent>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var seeAllClickListener: SeeAllItemClickListener? = null
    private var setItemClickListener: ItemOClickListener? = null
    private var setItemClickListenerCwt: ItemOClickListenerCwt? = null
    var viewType = 0
    var viewTypeModel = 0

    companion object {
        const val CONTENT_VIEW_TYPE_SLIDER = 1  // slider
        const val VIEW_TYPE_ENTERTAINMENT = 2 // single row with progress bar
        const val VIEW_TYPE_SINGLE_ROW = 3 //single row
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View? = null
        return when(viewType) {
            VIEW_TYPE_SINGLE_ROW -> {
                view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_recyclerview_main,
                    parent,
                    false
                )
                HomeGroupContentViewHolder(view!!)
            }
            VIEW_TYPE_ENTERTAINMENT -> {
                view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_recyclerview_main,
                    parent,
                    false
                )
                HomeGroupContentViewHolder(view!!)
            }
            CONTENT_VIEW_TYPE_SLIDER -> {
                view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_slider,
                    parent,
                    false
                )
                BannerContentViewHolder(view!!)
            }
            else -> {
                view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_recyclerview_main,
                    parent,
                    false
                )
                HomeGroupContentViewHolder(view!!)
            }
        }
    }

    override fun getItemCount(): Int {
        return mainItemList.size
    }

    // FOR MULTIPLE  Types of VIEWS
    override fun getItemViewType(position: Int): Int {

        viewType = when {
            mainItemList[position].contentType.contains("banner") -> {
                1
            }
            mainItemList[position].contentType.contains("entertainment") -> {
                2
            }
            mainItemList[position].contentType.contains("bill") -> {
                3
            }
            else -> {
                3
            }
        }

        return when (viewType) {
            VIEW_TYPE_SINGLE_ROW -> {
                VIEW_TYPE_SINGLE_ROW
            }
            VIEW_TYPE_ENTERTAINMENT -> {
                VIEW_TYPE_ENTERTAINMENT
            }

            CONTENT_VIEW_TYPE_SLIDER -> {
                CONTENT_VIEW_TYPE_SLIDER
            }

            else -> {
                -1
            }
        }


    } // getItemViewType

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val title = mainItemList[position].contentName
        val contentList = mainItemList[position].contentList
        val contentType = mainItemList[position].contentType


        viewTypeModel = when {
            mainItemList[position].contentType.contains("banner") -> {
                1
            }
            mainItemList[position].contentType.contains("entertainment") -> {
                2
            }
            mainItemList[position].contentType.contains("bill") -> {
                3
            }
            else -> {
                3
            }
        }

        when (viewTypeModel) {

            VIEW_TYPE_SINGLE_ROW -> {
                try {
                    val homeGroupContentViewHolder = viewHolder as HomeGroupContentViewHolder
                    homeGroupContentViewHolder.contentGroupTitleTv.text = title

                    /*val displayMetrics = DisplayMetrics()
                    (mContext as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
                    val width: Int = displayMetrics.widthPixels*/

                    //homeGroupContentViewHolder.contentRecyclerView.setPadding(width / 2, 0, 0, 0)
                    //homeGroupContentViewHolder.contentRecyclerView.setMargin(0, 10, 0, 0)
                    homeGroupContentViewHolder.contentRecyclerView.overScrollMode = View.OVER_SCROLL_NEVER
                    homeGroupContentViewHolder.contentRecyclerView.isNestedScrollingEnabled = true

                    homeGroupContentViewHolder.contentRecyclerView.layoutManager =
                        LinearLayoutManager(
                            mContext,
                            LinearLayoutManager.HORIZONTAL,
                            false
                        )

                    val mAdapter = HomeItemAdapter(
                        mContext,
                        contentType,
                        contentList
                    )
                    homeGroupContentViewHolder.contentRecyclerView.adapter = mAdapter

                    /*mAdapter.setItemClickListener(object : HomeItemAdapter.ItemClickListener {

                        override fun onItemClickListener(position: Int, content: Content) {
                            setItemClickListener!!.onItemClickListener(
                                position,
                                content
                            )
                            //mContext.showToast("gg")
                        }

                    })*/

                    homeGroupContentViewHolder.seeAllContentBtn.setOnClickListener {
                        seeAllClickListener!!.onSeeAllClickListener(position, mainItemList)
                    }

                } catch (e: Exception) {
                    //showLogE("Home Adapter- " + e.message.toString())
                }
            }

            VIEW_TYPE_ENTERTAINMENT -> {
                val continuePlayingViewHolder = viewHolder as HomeGroupContentViewHolder
                if (contentList.size > 0){
                    try {
                        continuePlayingViewHolder.contentGroupTitleTv.text = title
                        //continuePlayingViewHolder.seeAllContentBtn.text = "History"

                        //continuePlayingViewHolder.contentRecyclerView.setMargin(0, 10, 0, 0)
                        continuePlayingViewHolder.contentRecyclerView.overScrollMode =
                            View.OVER_SCROLL_NEVER
                        continuePlayingViewHolder.contentRecyclerView.isNestedScrollingEnabled = true

                        continuePlayingViewHolder.contentRecyclerView.layoutManager =
                            LinearLayoutManager(
                                mContext,
                                LinearLayoutManager.HORIZONTAL,
                                false
                            )

                        val mAdapter = HomeItemAdapter(
                            mContext,
                            contentType,
                            contentList
                        )
                        continuePlayingViewHolder.contentRecyclerView.adapter = mAdapter

                        /*mAdapter.setItemClickListenerCwt(object : HomeItemAdapter.ItemClickListenerCwt {

                            override fun onItemClickListenerCwt(position: Int, content: Content) {
                                setItemClickListenerCwt!!.onItemClickListenerCwt(
                                    position,
                                    content
                                )
                                //mContext.showToast("gg")
                            }

                        })*/

                        if (contentList.size < 4){
                            continuePlayingViewHolder.seeAllContentBtn.visibility = View.INVISIBLE
                        }

                        continuePlayingViewHolder.seeAllContentBtn.setOnClickListener {
                            seeAllClickListener!!.onSeeAllClickListener(position, mainItemList)
                        }

                    } catch (e: Exception) {
                        //showLogE("Home Adapter- " + e.message.toString())
                    }
                }else{
                    continuePlayingViewHolder.seeAllContentBtn.visibility = View.GONE
                    continuePlayingViewHolder.itemView.visibility = View.GONE
                    continuePlayingViewHolder.contentGroupTitleTv.visibility = View.GONE
                }

            }

            CONTENT_VIEW_TYPE_SLIDER -> {

                try {
                    val spotLight = mainItemList[position].contentList
                    val bannerContentViewHolder = viewHolder as BannerContentViewHolder


                    bannerContentViewHolder.carouselView.apply {
                        size = spotLight.size
                        resource = R.layout.item_slider_image_view
                        autoPlay = true
                        indicatorAnimationType = IndicatorAnimationType.THIN_WORM
                        carouselOffset = OffsetType.CENTER
                        setCarouselViewListener { view, position ->
                            // Example here is setting up a full image carousel
                            val imageView = view.findViewById<ImageView>(R.id.iv_image_slider)
                            Glide
                                .with(bannerContentViewHolder.itemView.context)
                                .load(spotLight[position].img)
                                .placeholder(R.drawable.no_img)
                                .into(imageView)

                            imageView.setOnClickListener {
                                setItemClickListener!!.onItemClickListener(
                                    position,
                                    spotLight[position]
                                )
                                //context.showToast(" img slider"+position.toString())
                            }
                        }
                        // After you finish setting up, show the CarouselView
                        show()
                    }
                } catch (e: Exception) {
                    //showLogE("Home Adapter- " + e.message.toString())
                }

            }

            else -> {
                try {
                    val homeGroupContentViewHolder = viewHolder as HomeGroupContentViewHolder
                    homeGroupContentViewHolder.contentGroupTitleTv.text = title

                    // Logic for See All Button
                    val contentNum = mainItemList[position].contentList.size
                    if (contentNum > 4){
                        homeGroupContentViewHolder.seeAllContentBtn.visibility = View.VISIBLE
                    } else {
                        homeGroupContentViewHolder.seeAllContentBtn.visibility = View.INVISIBLE
                    }
                } catch (e: Exception){
                    //showLogE("Home Adapter- " + e.message.toString())
                }
            }
        }

    } //


    inner class HomeGroupContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var contentGroupTitleTv : TextView = itemView.findViewById(R.id.itemNameTv)
        var seeAllContentBtn : TextView = itemView.findViewById(R.id.seeAllBtn)
        var contentRecyclerView : RecyclerView = itemView.findViewById(R.id.homeItemMainRv)
    }

    inner class BannerContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var imageSlider : SliderView = itemView.findViewById(R.id.imageSlider)
        //var imageViewSlider : ImageView= itemView.findViewById(R.id.iv_image_slider)
        var carouselView = itemView.findViewById<CarouselView>(R.id.carouselSliderView)
    }


    fun setSeeAllClickListener(seeAllClickListener: SeeAllItemClickListener) {
        this.seeAllClickListener = seeAllClickListener
    }

    interface SeeAllItemClickListener {
        fun onSeeAllClickListener(
            position: Int,
            groupItemList: MutableList<HomeMainContent>
        )
    }

    fun setItemClickListener(setItemClickListener: ItemOClickListener) {
        this.setItemClickListener = setItemClickListener
    }

    interface ItemOClickListener {
        fun onItemClickListener(
            position: Int,
            content: Contents
        )
    }

    fun setItemClickListenerCwt(setItemClickListenerCwt: ItemOClickListenerCwt) {
        this.setItemClickListenerCwt = setItemClickListenerCwt
    }

    interface ItemOClickListenerCwt {
        fun onItemClickListenerCwt(
            position: Int,
            content: Contents
        )
    }
}