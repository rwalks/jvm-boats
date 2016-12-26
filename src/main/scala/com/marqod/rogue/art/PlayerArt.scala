package com.marqod.rogue.art

import java.awt.geom.GeneralPath

import com.marqod.rogue.models.Entity
import com.marqod.rogue.utils.{Colors, Config, Vector3}

import scala.swing.Graphics2D

/**
  * Created by ryan.walker on 11/12/16.
  */
class PlayerArt extends Art with Config {

  val deckZ = 0.3

  val playerPoly = new Polygon(List(
    Vector3(0.0, -0.8, 0),
    Vector3(0.3, -0.6, 0),
    Vector3(0.3, 0.9, 0),
    Vector3(0.0, 0.9, 0)
  ), Colors.red).mirror()

  val bottomPanels = mirrorPolys(List(
    new Polygon(List(Vector3(0, 1.0, deckZ),Vector3(0.5, 1.0, deckZ),Vector3(0.3, 0.9, 0.0),Vector3(0, 0.9, 0)), Colors.brown),
    new Polygon(List(Vector3(0.5, 1.0, deckZ),Vector3(0.5, -0.8, deckZ),Vector3(0.3, -0.6, 0.0),Vector3(0.3, 0.9, 0)), Colors.brown),
    new Polygon(List(Vector3(0.5, -0.8, deckZ),Vector3(0.0, -1.0, deckZ),Vector3(0.0, -0.8, 0.0),Vector3(0.3, -0.6, 0)), Colors.brown)
  ))

  val playerPoly2 = List(new Polygon(List(
    Vector3(0.0, -1.0, deckZ),
    Vector3(0.5, -0.8, deckZ),
    Vector3(0.5, 1.0, deckZ),
    Vector3(0.0, 1.0, deckZ)
  ), Colors.red).mirror())

  //mast
  val mastPos = Vector3(0,-0.2,0)
  val mastSize = Vector3(0.05,0.05,1.5)
  val mastPanels = List(
    new Polygon(List(Vector3(mastPos.x, mastPos.y + mastSize.y, mastPos.z), Vector3(mastPos.x + mastSize.x, mastPos.y, mastPos.z), Vector3(mastPos.x + mastSize.x, mastPos.y, mastPos.z + mastSize.z), Vector3(mastPos.x, mastPos.y + mastSize.y, mastPos.z + mastSize.z)), Colors.yellow),
    new Polygon(List(Vector3(mastPos.x + mastSize.x, mastPos.y, mastPos.z), Vector3(mastPos.x, mastPos.y - mastSize.y, mastPos.z), Vector3(mastPos.x, mastPos.y - mastSize.y, mastSize.z), Vector3(mastPos.x + mastSize.x, mastPos.y, mastPos.z + mastSize.z)), Colors.yellow),
    new Polygon(List(Vector3(mastPos.x, mastPos.y - mastSize.y, mastPos.z), Vector3(mastPos.x - mastPos.x, mastPos.y, mastPos.z), Vector3(mastPos.x - mastSize.x, mastPos.y, mastPos.z), Vector3(mastPos.x, mastPos.y - mastSize.y, mastPos.z)), Colors.yellow),
    new Polygon(List(Vector3(mastPos.x - mastSize.x, mastPos.y, mastPos.z), Vector3(mastPos.x, mastPos.y + mastSize.y, mastPos.z), Vector3(mastPos.x, mastPos.y + mastSize.y, mastPos.z + mastSize.z), Vector3(mastPos.x - mastSize.x, mastPos.y, mastPos.z + mastSize.z)), Colors.yellow)
  )

  val sailPos = Vector3(mastPos.x, mastPos.y + mastSize.y, 0.4)
  val sailPolys = List(
    new Polygon(List(Vector3(sailPos.x, sailPos.y, sailPos.z),Vector3(sailPos.x, sailPos.y, 1.45),Vector3(sailPos.x,sailPos.y+0.1,1.45),Vector3( sailPos.x, 1.0, sailPos.z)),Colors.purple)
  )

  val artMap: Map[Int, List[Polygon]] = loadArt()

  def loadArt(): Map[Int, List[Polygon]] = {
    0 to 62 map { d =>
      d -> generatePolys(d / 10.0)
    } toMap
  }

  def generatePolys(theta: Double): List[Polygon] = {
    List(playerPoly.rotate(theta)) ++
      (bottomPanels ++ mastPanels).map(_.rotate(theta)).sortWith(sortPolygons) ++
      sailPolys.map(_.rotate(theta)).sortWith(sortPolygons)
  }

  var t = 0.0
  var dt = 0.001

  def drawClass(g: Graphics2D, p: Entity) = {
    t += dt
    if (t < -0.1 || t > 0.1) { dt = -dt }
    g.rotate(t)
    val theta = (p.rotation.theta * 10).toInt
    artMap.getOrElse(theta, List()) foreach { poly =>
      poly.drawFill(g)
    }
  }

  def sortPolygons(p1: Polygon, p2: Polygon) = {
    p1.originDistance < p2.originDistance
  }


  def mirrorPolys(polys: List[Polygon]): List[Polygon] = {
    polys ++ polys.reverse.map { panel =>
      new Polygon(panel.points.map( p => Vector3(-p.x, p.y, p.z)), panel.color)
    }
  }

}
