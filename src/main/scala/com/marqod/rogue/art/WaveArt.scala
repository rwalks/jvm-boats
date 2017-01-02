package com.marqod.rogue.art

import com.marqod.rogue.models.{Wake, Wave}
import com.marqod.rogue.utils.Colors

import scala.swing.Graphics2D

/**
  * Created by ryan.walker on 11/12/16.
  */
class WaveArt extends Art[Wave] {

  def drawClass(g: Graphics2D, w: Wave) = {
    g.rotate(w.rotation.theta)
    g.setColor(Colors.brightBlue)
    g.fill3DRect(
      (-w.dimensions.x / 2).toInt,
      (-w.dimensions.y / 2).toInt,
      w.dimensions.x.toInt,w.dimensions.y.toInt,true
    )
  }
}

class WakeArt extends Art[Wake] {
  def drawClass(g: Graphics2D, w: Wake) = {
    g.rotate(w.rotation.theta)
    g.setColor(Colors.getFoamBlue(1 - (w.dimensions.x  / 60)))
    val oX = (-w.dimensions.x / 2).toInt
    val oY = (-w.dimensions.y / 2).toInt
    g.fill3DRect(
      oX,
      oY,
      w.dimensions.x.toInt,
      1,
      true
    )
  }
}
