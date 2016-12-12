package com.marqod.rogue.utils

import java.awt.Color

object Colors {
  val black = new Color(0, 0, 0)
  val red = new Color(128, 0, 0)
  val yellow = new Color(128, 128, 0)
  val blue = new Color(0, 0, 128)
  val magenta = new Color(128, 0, 128)
  val cyan = new Color(0, 128, 128)
  val white = new Color(192, 192, 192)
  val brightBlack = new Color(128, 128, 128)
  val brightRed = new Color(255, 0, 0)
  val brightGreen = new Color(0, 255, 0)
  val brightYellow = new Color(255, 255, 0)
  val brightBlue = new Color(0, 0, 255)
  val brightMagenta = new Color(255, 0, 255)
  val brightCyan = new Color(0, 255, 255)
  val brightWhite = new Color(255, 255, 255)
  val foamBlue = new Color(0.2F,0.2F,0.9F,0.6F)
  val brown = new Color(139,69,19)

  def getFoamBlue(a: Double): Color = {
    val alpha = Math.max(0, a * 0.8).toFloat
    new Color(0.2F, 0.2F, 0.9F, alpha)
  }
}
