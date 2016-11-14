package com.marqod.rogue.art

import java.awt.geom.GeneralPath

import com.marqod.rogue.models.Entity

import scala.swing.Graphics2D

/**
  * Created by ryan.walker on 11/12/16.
  */
class Polygon(val points: List[(Double,Double)]) {

  def drawFill(g: Graphics2D, e: Entity) = {
    val polygon: GeneralPath = new GeneralPath()
    val lX = e.dimensions.x / 2
    val lY = e.dimensions.y / 2
    polygon.moveTo(
      points.last._1 * lX,
      points.last._2 * lY
    )
    points.foreach { p =>
      polygon.lineTo(
        p._1 * lX,
        p._2 * lY
      )
    }
    polygon.closePath()
    g.fill(polygon)
  }

  def mirror(): Polygon = {
    new Polygon(
      points ++ points.slice(1,points.size-1).reverse.map { point =>
        (-point._1, point._2)
      }
    )
  }
}
