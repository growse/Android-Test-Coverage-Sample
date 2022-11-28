package com.example.testcoveragesample

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate. This should be coverage enabled!")
        setContentView(R.layout.activity_main)
    }

    override fun onPause() {
        Timber.i("onPause. This should be coverage enabled!")
        super.onPause()
    }

    override fun onContextMenuClosed(menu: Menu) {
        Timber.i("onContextMenuClosed. This should not be covered, because there's no context menu!")
        super.onContextMenuClosed(menu)
    }
}
