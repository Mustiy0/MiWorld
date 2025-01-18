package dev.trindadedev.miworld

class MiWorld {

  companion object {
    init {
      System.loadLibrary("miworld_game")
    }
  }

  /** return 0 if success */
  external fun initGame(): Int
}