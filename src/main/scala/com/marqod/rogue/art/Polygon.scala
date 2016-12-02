package com.marqod.rogue.art

import java.awt.geom.GeneralPath

import com.marqod.rogue.models.Entity
import com.marqod.rogue.utils.{Config, Vector3}

import scala.swing.Graphics2D

/**
  * Created by ryan.walker on 11/12/16.
  */
class Polygon(var points: List[Vector3]) extends Config {

  def draw(g: Graphics2D, e: Entity) = {
    val rot = e.rotation.theta

    val lX = (e.dimensions.x / 2) * UNIT_SIZE.x
    val lY = (e.dimensions.y / 2) * UNIT_SIZE.y
    val lZ = -e.dimensions.z * UNIT_SIZE.y
    val polygon: GeneralPath = new GeneralPath()
    polygon.moveTo(
      points.last.x * lX,
      points.last.z * lZ
    )
    points.foreach { p =>
      polygon.lineTo(
        p.x * lX,
        p.z * lZ
      )
    }
    polygon.closePath()
    g.draw(polygon)
    //g.fill(polygon)
  }

  def mirrorX(): Polygon = {
    new Polygon(
      points ++ points.slice(1,points.size-1).reverse.map { point =>
        Vector3(-point.x, point.y, point.z)
      }
    )
  }
}

case class Square() extends Polygon(List(
      Vector3(1.0, 0.0, 1.0),
      Vector3(1.0, 0.0, 0.0),
      Vector3(-1.0, 0.0, 0.0),
      Vector3(-1.0, 0.0, 1.0)
))

