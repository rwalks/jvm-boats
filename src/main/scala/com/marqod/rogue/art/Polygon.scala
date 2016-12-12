package com.marqod.rogue.art

import java.awt.geom.GeneralPath

import com.marqod.rogue.models.Entity
import com.marqod.rogue.utils.Vector3

import scala.swing.Graphics2D

/**
  * Created by ryan.walker on 11/12/16.
  */
class Polygon(val points: List[Vector3]) {

  def drawFill(g: Graphics2D, e: Entity) = {
    val polygon: GeneralPath = new GeneralPath()
    val zOffset = -e.dimensions.z
    val lX = e.dimensions.x / 2
    val lY = e.dimensions.y / 2
    val rPoints = rotate(e.rotation.theta)
    //first point
    val fZ = rPoints.last.z * zOffset
    polygon.moveTo(
      (rPoints.last.x * lX) + fZ,
      (rPoints.last.y * lY) + fZ
    )
    rPoints.foreach { p =>
      val fZ = p.z * zOffset
      polygon.lineTo(
        (p.x * lX) + fZ,
        (p.y * lY) + fZ
      )
    }
    polygon.closePath()
    g.fill(polygon)
  }

  def rotate(theta: Double): List[Vector3] = {
    points.map(_.rotate(theta))
  }

  def mirror(): Polygon = {
    new Polygon(
      points ++ points.slice(1,points.size-1).reverse.map { point =>
        Vector3(-point.x, point.y, point.z)
      }
    )
  }
}

class PanelSet(val polygons: List[Polygon]) {

  def draw(g: Graphics2D, p: Entity) = {
    polygons.foreach { bp =>
      bp.drawFill(g, p)
    }
  }

  def mirror(): PanelSet = {
    new PanelSet(
      polygons ++ polygons.reverse.map { panel =>
        new Polygon(panel.points.map( p => Vector3(-p.x, p.y, p.z)))
      }
    )
  }
}
