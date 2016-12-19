package com.marqod.rogue.graphics;

import java.awt.{Graphics2D, RenderingHints}

import com.marqod.rogue.utils.Colors

import scala.swing._

class Canvas extends Panel {

  focusable = true

  var graphicsEngine: GraphicsEngine = null

  override def paintComponent(g: Graphics2D) {
    g.setColor(Colors.black)
    g.fillRect(0, 0, size.width, size.height)
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
    graphicsEngine.drawScene(g)
  }

  def draw(): Unit = {
    this.repaint()
  }

}
