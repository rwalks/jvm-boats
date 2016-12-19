package com.marqod.rogue.art

import java.awt.BasicStroke
import java.awt.geom.GeneralPath

import com.marqod.rogue.models.Entity
import com.marqod.rogue.utils.{Colors, Config, Vector2, Vector3}

import scala.swing.{Color, Graphics2D}

/**
  * Created by ryan.walker on 11/12/16.
  */
class Polygon(val points: List[Vector3], val color: Color) extends Config{


  val minX = points.map(_.x).min
  val maxX = points.map(_.x).max
  val minY = points.map(_.y).min
  val maxY = points.map(_.y).max
  val originPoint = Vector2((minX + maxX)/2,(minY + maxY)/2)
  val originDistance = originPoint.distance(-1,-1)
  val path = getPath()

  // val orderedPoints = points.map( p => Vector2(p.x,p.y).distance(-1,-1))
  //  val originNear = orderedPoints.min
  // val originFar = orderedPoints.max
   //val originDistance = orderedPoints.sum / orderedPoints.length
 // val farthestY = points.sortWith((p1, p2) => p1.y < p2.y).last
//  val originDistance =

  def getPath(): GeneralPath = {
    val polygon: GeneralPath = new GeneralPath()
    val zOffset = -STANDARD_UNIT.z
    val lX = STANDARD_UNIT.x / 2
    val lY = STANDARD_UNIT.y / 2
    //first point
    val fZ = points.last.z * zOffset
    polygon.moveTo(
      (points.last.x * lX) + fZ,
      (points.last.y * lY) + fZ
    )
    points.foreach { p =>
      val fZ = p.z * zOffset
      polygon.lineTo(
        (p.x * lX) + fZ,
        (p.y * lY) + fZ
      )
    }
    polygon.closePath()
    polygon
  }

  def drawFill(g: Graphics2D) = {
   // g.setStroke(new BasicStroke(1))
    g.setColor(color)
    g.fill(path)
    g.setColor(Colors.black)
    g.draw(path)
  }

  def rotate(theta: Double): Polygon = {
    //Creating this might be too expensive
    new Polygon(points.map(_.rotate(theta)), color)
  }

  def mirror(): Polygon = {
    new Polygon(
      points ++ points.slice(1,points.size-1).reverse.map { point =>
        Vector3(-point.x, point.y, point.z)
      }, color)
  }

/*
  def overlaps(poly: Polygon): Boolean = {
    return (poly.minZ <= maxZ && poly.maxZ >= minZ || (minZ <= poly.maxZ && maxZ >= poly.minZ;
  }
  */
}
