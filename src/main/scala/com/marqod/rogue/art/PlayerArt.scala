package com.marqod.rogue.art

import java.awt.geom.GeneralPath

import com.marqod.rogue.models.Entity
import com.marqod.rogue.utils.Colors

import scala.swing.Graphics2D

/**
  * Created by ryan.walker on 11/12/16.
  */
class PlayerArt extends Art {

  val playerPoly = new Polygon(List(
    (0.0, -1.0),
    (1.0, -0.8),
    (1.0, 1.0),
    (0.0, 1.0)
  )).mirror()

  def drawClass(g: Graphics2D, p: Entity) = {
    g.setColor(Colors.red)
    playerPoly.drawFill(g, p)
    /*
    g.fill3DRect(
      (-p.dimensions.x / 2).toInt,
      (-p.dimensions.y / 2).toInt,
      p.dimensions.x.toInt,p.dimensions.y.toInt,true
    )
    */
  }

}
