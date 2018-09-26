package com.japharr.swiper

import `in`.arjsna.swipecardlib.SwipeCardView
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.dailymotion.android.player.sdk.PlayerWebView

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
            /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()*/

            startActivity(Intent(this, VideoActivity::class.java))
        }

        al = ArrayList<Card>()
        getDummyData(al)
        arrayAdapter = CardsAdapter(this, al)

        //initCards()
        //initPlayer()
    }

    private fun initPlayer() {
        val playerParams = HashMap<String, String>()
        dm_player_web_view.load("x26hv6c", playerParams as Map<String, Any>?)

        dm_player_web_view.setEventListener { event, map ->
            when (event) {
                "apiready" -> log("apiready")
                "start" -> log("start")
                "loadedmetadata" -> log("loadedmetadata")
                "progress" -> log(event + " (bufferedTime: " + dm_player_web_view.bufferedTime + ")")
                "durationchange" -> log(event + " (duration: " + dm_player_web_view.duration + ")")
                "timeupdate", "ad_timeupdate", "seeking", "seeked" -> log(event + " (currentTime: " + dm_player_web_view.position + ")")
                "video_start", "ad_start", "ad_play", "playing", "end" -> log(event + " (ended: " + dm_player_web_view.isEnded + ")")
                "ad_pause", "ad_end", "video_end", "play", "pause" -> log(event + " (paused: " + dm_player_web_view.videoPaused + ")")
                "qualitychange" -> log(event + " (quality: " + dm_player_web_view.quality + ")")
                PlayerWebView.EVENT_VOLUMECHANGE -> log(event + " (volume: " + dm_player_web_view.volume + ")")
                //PlayerWebView.EVENT_FULLSCREEN_TOGGLE_REQUESTED -> onFullScreenToggleRequested()
                else -> {
                }
            }
        }
    }

    private fun log(value: String) {

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

    override fun onBackPressed() {
        dm_player_web_view.goBack()
    }

    override fun onPause() {
        super.onPause()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            dm_player_web_view.onPause()
        }
    }

    override fun onResume() {
        super.onResume()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            dm_player_web_view.onResume()
        }
    }

}
