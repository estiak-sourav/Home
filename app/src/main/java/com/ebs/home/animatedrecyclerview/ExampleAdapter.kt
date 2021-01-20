package com.ebs.home.animatedrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ebs.home.R

class ExampleAdapter(private val exampleList: ArrayList<RealObject>)
    : RecyclerView.Adapter<ExampleAdapter.AlphabetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlphabetViewHolder {
        val view: View? = LayoutInflater.from(parent.context).inflate(
            R.layout.item_example,
            parent,
            false
        )
        return AlphabetViewHolder(view!!)
    }

    override fun getItemCount(): Int {
        return exampleList.size
    }

    override fun onBindViewHolder(holder: AlphabetViewHolder, position: Int) {
        val content = exampleList[position]

        /*if (contentType == "spelling"){ // different effect for specific Type
            holder.exampleName.setLinkTextColor(Color.BLACK)
            holder.exampleName.apply {
                this.startAnimation(AnimationUtils.loadAnimation(this.context, android.R.anim.fade_in))
                this.text = content.nameEn + "DSGFSDF"
                this.letterSpacing = 1f
            }
        } else {
            holder.exampleName.text = content.nameEn
        }*/

        Glide
            .with(holder.itemView.context)
            .load(content.objectImage)
            .into(holder.alphabetIv)

        holder.itemView.setOnClickListener {
            //onItemClickListener.onItemClickListener(holder.itemView, position)
        }
        //holder.alphabetIv.setBackgroundColor(Color.parseColor("#${content.color}"))
    }

    inner class AlphabetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var alphabetIv : ImageView = itemView.findViewById(R.id.alphabetIv)
        var exampleName : TextView = itemView.findViewById(R.id.exampleNameTv)
        //var exampleItemLayout : Constraintlayout = itemView.findViewById(R.id.example_item_layout)
    }
}