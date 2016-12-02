package com.marqod.rogue.art

import java.awt.geom.GeneralPath

import com.marqod.rogue.models.Entity
import com.marqod.rogue.utils.{Colors, Vector3}

import scala.swing.Graphics2D

/**
  * Created by ryan.walker on 11/12/16.
  */
class PlayerArt extends Art {

  val polys: List[Polygon] = List(Square())

  def drawClass(g: Graphics2D, entity: Entity) = {
    g.setColor(Colors.red)
    polys.foreach { p =>
      p.draw(g, entity)
    }
    /*
    g.fill3DRect(
      (-p.dimensions.x / 2).toInt,
      (-p.dimensions.y / 2).toInt,
      p.dimensions.x.toInt,p.dimensions.y.toInt,true
    )
    */
  }

}
