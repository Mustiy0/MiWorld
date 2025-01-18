package dev.trindadedev.miworld

import android.app.NativeActivity
import android.os.Bundle
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.view.KeyEvent
import java.util.concurrent.LinkedBlockingQueue

class MainActivity : NativeActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  fun showSoftInput() {
    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(this.window.decorView, 0)
  }

  fun hideSoftInput() {
    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(this.window.decorView.windowToken, 0)
  }

  private var unicodeCharacterQueue: LinkedBlockingQueue<Int> = LinkedBlockingQueue()

  override fun dispatchKeyEvent(event: KeyEvent): Boolean {
    if (event.action == KeyEvent.ACTION_DOWN) {
      unicodeCharacterQueue.offer(event.getUnicodeChar(event.metaState))
    }
    return super.dispatchKeyEvent(event)
  }

  fun pollUnicodeChar(): Int {
    return unicodeCharacterQueue.poll() ?: 0
  }
}