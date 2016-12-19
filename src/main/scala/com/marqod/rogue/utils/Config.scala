package com.marqod.rogue.utils

trait Config {
  val WINDOW_SIZE: Vector2 = Vector2(800,600)
  val CANVAS_SIZE: Vector2 = Vector2(800,600)
  val WORLD_SIZE: Vector2 = Vector2(4000,4000)
  val FPS: Int = 60
  val WAVE_INTERVAL: Double = 100
  val WAVE_COUNT = Vector2(
    WORLD_SIZE.x / WAVE_INTERVAL,
    WORLD_SIZE.y / WAVE_INTERVAL
  )
  val WAVES_PER_SCREEN = Vector2(
    CANVAS_SIZE.x / WAVE_INTERVAL,
    CANVAS_SIZE.y / WAVE_INTERVAL
  )

  val CAMERA_PROJ_OFFSET = Vector2(
    CANVAS_SIZE.x * 0.8,
    CANVAS_SIZE.y * 0.4
  )

  val STANDARD_UNIT = Vector3(30,30,30)
}
