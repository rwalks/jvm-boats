package com.marqod.rogue.art

import com.marqod.rogue.models.Entity
import com.marqod.rogue.utils.Colors

import scala.swing.Graphics2D

/**
  * Created by ryan.walker on 12/26/16.
  */
class IslandArt extends Art {

  def drawClass(g: Graphics2D, w: Entity) = {
    g.rotate(w.rotation.theta)
    g.setColor(Colors.brightBlue)
    g.fill3DRect(
      (-w.dimensions.x / 2).toInt,
      (-w.dimensions.y / 2).toInt,
      w.dimensions.x.toInt,w.dimensions.y.toInt,true
    )
  }

}
