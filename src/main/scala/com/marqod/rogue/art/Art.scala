package com.marqod.rogue.art

import com.marqod.rogue.graphics.Camera
import com.marqod.rogue.models.Entity
import com.marqod.rogue.utils.{Config, Vector2}

import scala.swing.Graphics2D

/**
  * Created by ryan.walker on 11/12/16.
  */
abstract class Art extends Config {

  def draw(g: Graphics2D, entity: Entity, camera: Camera) = {
   // val dX = entity.position.x - offset.x
    //val dY = entity.position.y - offset.y
    val d = 1200.0
    val scale = Math.max(0, 1.0 - (d / HORIZON_D))
    val horizonY = 0.5 * CANVAS_SIZE.y
    val dX = 0.5 * CANVAS_SIZE.x
    val dY = CANVAS_SIZE.y - (Math.max(0, (d / HORIZON_D) * HORIZON_Y))
    val gCon: Graphics2D = g.create().asInstanceOf[Graphics2D]
    gCon.translate(dX,dY)
    gCon.scale(scale, scale)
    drawClass(gCon, entity)
    gCon.dispose()
  }

  def drawClass(g: Graphics2D, entity: Entity): Unit

}

trait ArtHolder {
  val waveArt = new WaveArt()
  val playerArt = new PlayerArt()
  val wakeArt = new WakeArt()
}

object ArtType extends Enumeration {
  val WAVE_ART, PLAYER_ART, WAKE_ART = Value
}
