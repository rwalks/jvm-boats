package com.marqod.rogue.art

import com.marqod.rogue.models.{Entity, Island}
import com.marqod.rogue.utils.{Colors, Vector3}

import scala.swing.Graphics2D

/**
  * Created by ryan.walker on 12/26/16.
  */
class IslandArt extends Art[Island] {

  val islandPoly = new Polygon(List(
    Vector3(-50,0,1),
    Vector3(-50,50,1),
    Vector3(50,50,1),
    Vector3(50,0,1)
  ), Colors.brightGreen)

  val wallPoly = new Polygon(List(
    Vector3(-50,50,1),
    Vector3(-50,55,0),
    Vector3(50,55,0),
    Vector3(50,50,1)
  ), Colors.yellow)

  val wallPoly2 = new Polygon(List(
    Vector3(50,50,1),
    Vector3(50,50,0),
    Vector3(55,50,0),
    Vector3(55,0,0),
    Vector3(50,0,1)
  ), Colors.yellow)

  def drawClass(g: Graphics2D, i: Island) = {
    islandPoly.drawFill(g)
    wallPoly.drawFill(g)
    wallPoly2.drawFill(g)
  }

}
