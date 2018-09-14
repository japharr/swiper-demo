package com.japharr.swiper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.R.attr.name
import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import java.nio.file.Files.size





/**
 * Created by Japharr on 9/14/2018.
 */
class CardsAdapter(context: Context, var cards: ArrayList<Card>): ArrayAdapter<Card>(context, -1) {
    val layoutInflater = LayoutInflater.from(context)

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = layoutInflater.inflate(R.layout.card_item, parent, false)

        val card = cards[position]
        (view.findViewById(R.id.card_image) as ImageView).setImageResource(card.imageId)
        (view.findViewById(R.id.helloText) as TextView).text = card.name

        return view
    }

    override fun getItem(position: Int): Card? {
        return cards[position]
    }

    override fun getCount(): Int {
        return cards.size
    }

}