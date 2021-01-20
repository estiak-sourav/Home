package com.ebs.home.animatedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebs.home.R
import kotlinx.android.synthetic.main.activity_recycler_view_demo.*

class RecyclerViewDemoActivity : AppCompatActivity() {

    // source - https://github.com/MLSDev/AnimatedRecyclerView

    var exampleList : ArrayList<RealObject>? = null
    private var exampleAdapter: ExampleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_demo)

        val FRUITS_LIST = arrayListOf(
            RealObject("আপেল", "Apple", R.drawable.green_onions),
            RealObject("কলা", "Banana", R.drawable.green_onions),
            RealObject("ব্লুবেরি", "Blueberry", R.drawable.guava),
            RealObject("নারকেল", "Coconut", R.drawable.guppy),
            RealObject("ড্রাগন ফল", "Dragon Fruit", R.drawable.hat),
            RealObject("আঙ্গুর", "Grapes", R.drawable.hen),
            RealObject("পেয়ারা", "Guava", R.drawable.heron),
            RealObject("কাঁঠাল", "Jackfruit", R.drawable.hexagon),
            RealObject("লেবু", "Lemon", R.drawable.hibiscus),
            RealObject("আপেল", "Apple", R.drawable.green_onions),
            RealObject("কলা", "Banana", R.drawable.green_onions),
            RealObject("ব্লুবেরি", "Blueberry", R.drawable.guava),
            RealObject("নারকেল", "Coconut", R.drawable.guppy),
            RealObject("ড্রাগন ফল", "Dragon Fruit", R.drawable.hat),
            RealObject("আঙ্গুর", "Grapes", R.drawable.hen),
            RealObject("পেয়ারা", "Guava", R.drawable.heron),
            RealObject("কাঁঠাল", "Jackfruit", R.drawable.hexagon),
            RealObject("লেবু", "Lemon", R.drawable.hibiscus),
            RealObject("আপেল", "Apple", R.drawable.green_onions),
            RealObject("কলা", "Banana", R.drawable.green_onions),
            RealObject("ব্লুবেরি", "Blueberry", R.drawable.guava),
            RealObject("নারকেল", "Coconut", R.drawable.guppy),
            RealObject("ড্রাগন ফল", "Dragon Fruit", R.drawable.hat),
            RealObject("আঙ্গুর", "Grapes", R.drawable.hen),
            RealObject("পেয়ারা", "Guava", R.drawable.heron),
            RealObject("কাঁঠাল", "Jackfruit", R.drawable.hexagon),
            RealObject("লেবু", "Lemon", R.drawable.hibiscus),
            RealObject("আপেল", "Apple", R.drawable.green_onions),
            RealObject("কলা", "Banana", R.drawable.green_onions),
            RealObject("ব্লুবেরি", "Blueberry", R.drawable.guava),
            RealObject("নারকেল", "Coconut", R.drawable.guppy),
            RealObject("ড্রাগন ফল", "Dragon Fruit", R.drawable.hat),
            RealObject("আঙ্গুর", "Grapes", R.drawable.hen),
            RealObject("পেয়ারা", "Guava", R.drawable.heron),
            RealObject("কাঁঠাল", "Jackfruit", R.drawable.hexagon),
            RealObject("লেবু", "Lemon", R.drawable.hibiscus)

        )

        exampleList = FRUITS_LIST

        val recyclerView = AnimatedRecyclerView.Builder(this)
            .orientation(LinearLayoutManager.VERTICAL)
            .layoutManagerType(AnimatedRecyclerView.LayoutManagerType.LINEAR)
            .animation(R.anim.layout_animation_from_bottom)
            .animationDuration(600)
            .reverse(false)
            .build()

        recyclerView.scheduleLayoutAnimation();

        exampleAdapter = ExampleAdapter(exampleList!!)
        recycler_view!!.adapter = exampleAdapter
    }
}