package com.marqod.rogue.utils

case class Vector2(var x: Double, var y: Double) {

  def set(tx: Double, ty: Double): Vector2 = {
    x = tx
    y = ty
    this
  }

  def set(target: Vector2): Vector2 = {
    x = target.x
    y = target.y
    this
  }

  def move(dx: Double, dy: Double): Vector2 = {
    set(dx+x,dy+y)
    this
  }

  def move(v2: Vector2): Vector2 = {
    set(x+v2.x, y+v2.y)
    this
  }

  def subtract(v2: Vector2): Vector2 = {
    set(x - v2.x, y - v2.y)
    this
  }

  def magnitude(): Double = {
    Math.abs(x) + Math.abs(y)
  }

  def rotate(theta: Double): Vector2 = {
    val cos = Math.cos(theta);
    val sin = Math.sin(theta);
    val ox = x
    val oy = y
    x = cos * ox - sin * oy
    y = sin * ox + cos * oy
    this
  }

  override def clone(): Vector2 = {
    new Vector2(x,y)
  }
}

case class Vector3(var x: Double, var y: Double, var z: Double) extends Config {

  def getScreenCoords(d: Double): Vector2 = {
    val sY = CANVAS_SIZE.y - Math.max(0, 1.0 - (d / HORIZON_D)) * HORIZON_Y
    Vector2(x,sY)
  }
}

class EntityPosition(ox: Double, oy: Double) extends Vector2(ox,oy) with Utils with Config {
  override def set(tx: Double, ty: Double): Vector2 = {
    x = clamp(tx, 0, WORLD_SIZE.x)
    y = clamp(ty, 0, WORLD_SIZE.y)
    this
  }

  override def set(vec: Vector2): Vector2 = {
    x = clamp(x + vec.x, 0, WORLD_SIZE.x)
    y = clamp(y + vec.y, 0, WORLD_SIZE.y)
    this
  }

  def onBorder(): Boolean = {
    x <= 0 || x >= WORLD_SIZE.x || y <= 0 || y >= WORLD_SIZE.y
  }

  override def clone(): EntityPosition = {
    new EntityPosition(x,y)
  }

}

class EntityRotation(t: Double) {
  var theta = t

  def set(t: Double): Unit = {
    theta = t
  }

  def rotate(t: Double) = {
    theta += t
  }
}

object Timer {
  def apply(interval: Int, repeats: Boolean = true)(op: => Unit) {
    val timeOut = new javax.swing.AbstractAction() {
      def actionPerformed(e : java.awt.event.ActionEvent) = op
    }
    val t = new javax.swing.Timer(interval, timeOut)
    t.setRepeats(repeats)
    t.start()
  }
}

trait Utils {
  def clamp(x: Double, min: Double, max: Double): Double = {
    Math.min(max,Math.max(x,min))
  }
}

