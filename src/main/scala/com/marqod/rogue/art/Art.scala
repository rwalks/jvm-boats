package com.marqod.rogue.art

import com.marqod.rogue.models.Entity
import com.marqod.rogue.utils.Vector2

import scala.swing.Graphics2D

/**
  * Created by ryan.walker on 11/12/16.
  */
abstract class Art[T <: Entity] {

  def draw(g: Graphics2D, entity: T, offset: Vector2) = {
    val dX = entity.position.x - offset.x
    val dY = entity.position.y - offset.y

    val gCon: Graphics2D = g.create().asInstanceOf[Graphics2D]
    gCon.translate(dX,dY)
    drawClass(gCon, entity)
    gCon.dispose()
  }

  def drawClass(g: Graphics2D, entity: T): Unit

}

trait ArtHolder {
  val waveArt = new WaveArt()
  val playerArt = new PlayerArt()
  val wakeArt = new WakeArt()
  val islandArt = new IslandArt()
}
