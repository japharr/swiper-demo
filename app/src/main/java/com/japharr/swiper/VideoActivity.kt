package com.japharr.swiper

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.deep.videotrimmer.interfaces.OnTrimVideoListener

import kotlinx.android.synthetic.main.activity_video.*
import android.content.Intent
import android.view.View
import kotlinx.android.synthetic.main.content_video.*


class VideoActivity : BaseActivity(), OnTrimVideoListener {
    override fun getResult(uri: Uri?) {
        runOnUiThread { tvCroppingMessage.setVisibility(View.GONE) }
        croppedVideoURI = uri.toString()
        val intent = Intent()
        intent.data = uri
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    override fun cancelAction() {
        mVideoTrimmer.destroy()
        runOnUiThread { tvCroppingMessage.setVisibility(View.GONE) }
        finish()
    }

    val EXTRA_VIDEO_PATH = "/storage/emulated/0/Downloadd/Dog.mp4";
    var croppedVideoURI = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extraIntent = intent
        var path = EXTRA_VIDEO_PATH

        /*
        if (extraIntent != null) {
            path = extraIntent.getStringExtra(EXTRA_VIDEO_PATH)
        }*/

        if (mVideoTrimmer != null && path != null) {
            mVideoTrimmer.setMaxDuration(100);
            mVideoTrimmer.setOnTrimVideoListener(this);
            mVideoTrimmer.setVideoURI(Uri.parse(path));
        } else {
            showToastLong(getString(R.string.toast_cannot_retrieve_selected_video));
        }
    }

}
