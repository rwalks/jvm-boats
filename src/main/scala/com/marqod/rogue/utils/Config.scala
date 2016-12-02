package com.marqod.rogue.utils

trait Config {
  val WINDOW_SIZE: Vector2 = Vector2(800,600)
  val CANVAS_SIZE: Vector2 = Vector2(800,600)
  val WORLD_SIZE: Vector2 = Vector2(4000,4000)
  val HORIZON_Y: Double = 0.5 * CANVAS_SIZE.y
  val HORIZON_D: Double = 10000.0
  val UNIT_SIZE: Vector2 = Vector2(
    CANVAS_SIZE.x / 80,
    CANVAS_SIZE.y / 60
  )
  val FPS: Int = 60
}
