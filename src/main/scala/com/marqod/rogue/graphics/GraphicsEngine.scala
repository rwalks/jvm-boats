package com.marqod.rogue.graphics

import java.awt.BasicStroke

import com.marqod.rogue.art.ArtHolder
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
    camera.update(engine.gameState.player.controlState)
    canvas.draw()
  }

  def drawScene(g: Graphics2D) = {
  //  drawWater(g)
    //waves
    /*
    engine.gameState.waves.foreach { w =>
      waveArt.draw(g,w,camera.offset)
    }

    engine.gameState.wakes.foreach { w =>
      wakeArt.draw(g,w,camera.offset)
    }
    */
    //player
    drawGrid(g, camera)
    playerArt.draw(g,engine.gameState.player,camera)
    //stuff
  }

  private def drawWater(g: Graphics2D) = {
    g.setColor(Colors.blue)
    g.fillRect(0, 0, CANVAS_SIZE.x.toInt, CANVAS_SIZE.y.toInt)
  }

  private def drawGrid(g: Graphics2D, camera: Camera) = {
    g.setColor(Colors.blue)
    g.setStroke(new BasicStroke(1))
    g.drawLine(0, HORIZON_Y.toInt, CANVAS_SIZE.x.toInt, HORIZON_Y.toInt)
    //horizontal lines
    val hLines = 10
    var y = HORIZON_Y
    val lineY = 20
    for ( i <- 0 until hLines) {
      g.drawLine(0, y.toInt, CANVAS_SIZE.x.toInt, y.toInt)
      y += lineY * i
    }
    //vert lines
    val lines = 20
    val mid = CANVAS_SIZE.x / 2
    val lineD = UNIT_SIZE.x * 10
    for( i <- 0 until lines) {
      g.drawLine((mid + (i * lineD)).toInt, CANVAS_SIZE.y.toInt, mid.toInt, HORIZON_Y.toInt)
      g.drawLine((mid - (i * lineD)).toInt, CANVAS_SIZE.y.toInt, mid.toInt, HORIZON_Y.toInt)
    }
  }
}
