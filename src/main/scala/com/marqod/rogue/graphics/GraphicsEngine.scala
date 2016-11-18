package com.marqod.rogue.graphics

import com.marqod.rogue.art.{ArtHolder}
import com.marqod.rogue.engine.GameEngine
import com.marqod.rogue.utils.Config

import scala.swing.Graphics2D
import com.marqod.rogue.utils.Colors

/**
  * Created by ryan.walker on 10/29/16.
  */
class GraphicsEngine(engine: GameEngine, canvas: Canvas) extends Config with ArtHolder {

  val camera = new Camera()

  def draw(): Unit = {
    camera.update(engine.gameState.player.position)
    canvas.draw()
  }

  def drawScene(g: Graphics2D) = {
    drawWater(g)
    //waves
    engine.gameState.waves.foreach { w =>
      waveArt.draw(g,w,camera.offset)
    }

    engine.gameState.wakes.foreach { w =>
      wakeArt.draw(g,w,camera.offset)
    }
    //player
    playerArt.draw(g,engine.gameState.player,camera.offset)
    //stuff
  }

  private def drawWater(g: Graphics2D) = {
    g.setColor(Colors.blue)
    g.fillRect(0, 0, CANVAS_SIZE.x.toInt, CANVAS_SIZE.y.toInt)
  }
}
