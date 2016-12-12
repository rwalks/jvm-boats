package com.marqod.rogue.art

import java.awt.geom.GeneralPath

import com.marqod.rogue.models.Entity
import com.marqod.rogue.utils.{Colors, Vector3}

import scala.swing.Graphics2D

/**
  * Created by ryan.walker on 11/12/16.
  */
class PlayerArt extends Art {

  val deckZ = 0.3

  val playerPoly = new Polygon(List(
    Vector3(0.0, -0.8, 0),
    Vector3(0.3, -0.6, 0),
    Vector3(0.3, 0.9, 0),
    Vector3(0.0, 0.9, 0)
  )).mirror()

  val bottomPanels = new PanelSet(List(
    new Polygon(List(Vector3(0, 1.0, deckZ),Vector3(0.5, 1.0, deckZ),Vector3(0.3, 0.9, 0.0),Vector3(0, 0.9, 0))),
    new Polygon(List(Vector3(0.5, 1.0, deckZ),Vector3(0.5, -0.8, deckZ),Vector3(0.3, -0.6, 0.0),Vector3(0.3, 0.9, 0))),
  new Polygon(List(Vector3(0.5, -0.8, deckZ),Vector3(0.0, -1.0, deckZ),Vector3(0.0, -0.8, 0.0),Vector3(0.3, -0.6, 0)))
  )).mirror()

  val playerPoly2 = new Polygon(List(
    Vector3(0.0, -1.0, deckZ),
    Vector3(0.5, -0.8, deckZ),
    Vector3(0.5, 1.0, deckZ),
    Vector3(0.0, 1.0, deckZ)
  )).mirror()

  //mast
  val mastZ = 1
  val mastPanels = new PanelSet(List(
    new Polygon(List(Vector3(0, 0.1, 0), Vector3(0.1, 0, 0), Vector3(0.1, 0, mastZ), Vector3(0, 0.1, mastZ))),
    new Polygon(List(Vector3(0.1, 0, 0), Vector3(0, -0.1, 0), Vector3(0, -0.1, mastZ), Vector3(0.1, 0, mastZ))),
    new Polygon(List(Vector3(0, -0.1, 0), Vector3(-0.1, 0, 0), Vector3(-0.1, 0, mastZ), Vector3(0, -0.1, mastZ))),
    new Polygon(List(Vector3(-0.1, 0, 0), Vector3(0, 0.1, 0), Vector3(0, 0.1, mastZ), Vector3(-0.1, 0, mastZ)))
  ))

  def drawClass(g: Graphics2D, p: Entity) = {
    g.setColor(Colors.red)
    playerPoly.drawFill(g, p)
    g.setColor(Colors.brown)
    bottomPanels.draw(g, p)
    g.setColor(Colors.brightRed)
    mastPanels.draw(g,p)
    //playerPoly2.drawFill(g, p)
    /*
    g.fill3DRect(
      (-p.dimensions.x / 2).toInt,
      (-p.dimensions.y / 2).toInt,
      p.dimensions.x.toInt,p.dimensions.y.toInt,true
    )
    */
  }

}
