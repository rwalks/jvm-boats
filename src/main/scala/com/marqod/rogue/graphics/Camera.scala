package com.marqod.rogue.graphics

import com.marqod.rogue.utils.{Config, EntityPosition, Utils, Vector2}

/**
  * Created by ryan.walker on 10/29/16.
  */
class Camera extends Config{
  val offset = new Vector2(CANVAS_SIZE.x/2,-CANVAS_SIZE.y/2)

  def update(playerPos: EntityPosition): Unit = {
    offset.set(
      playerPos.x - CAMERA_PROJ_OFFSET.x,
      playerPos.y - CAMERA_PROJ_OFFSET.y
    )
  }

}
