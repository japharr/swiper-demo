package com.japharr.swiper

import `in`.arjsna.swipecardlib.SwipeCardView
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private var al: ArrayList<Card> = ArrayList<Card>()
    private var arrayAdapter: CardsAdapter? = null
    private val i: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        al = ArrayList<Card>()
        getDummyData(al)
        arrayAdapter = CardsAdapter(this, al)

        initCards()
    }

    private fun initCards() {
        card_stack_view.adapter = arrayAdapter;
        card_stack_view.setFlingListener(object: SwipeCardView.OnCardFlingListener {
            override fun onCardExitLeft(dataObject: Any?) {

            }

            override fun onAdapterAboutToEmpty(itemsInAdapter: Int) {

            }

            override fun onScroll(scrollProgressPercent: Float) {

            }

            override fun onCardExitTop(dataObject: Any?) {

            }

            override fun onCardExitBottom(dataObject: Any?) {

            }

            override fun onCardExitRight(dataObject: Any?) {

            }
        })

        card_stack_view.setOnItemClickListener { itemPosition, dataObject ->

        }
    }

    private fun getDummyData(al: ArrayList<Card>) {
        al.add(Card("Card1", R.drawable.faces1))
        al.add(Card("Card2", R.drawable.faces2))
        al.add(Card("Card3", R.drawable.faces3))
        al.add(Card("Card4",  R.drawable.faces4))

        al.add(Card("Card1", R.drawable.faces1))
        al.add(Card("Card2", R.drawable.faces2))
        al.add(Card("Card3", R.drawable.faces3))
        al.add(Card("Card4",  R.drawable.faces4))
    }

}
