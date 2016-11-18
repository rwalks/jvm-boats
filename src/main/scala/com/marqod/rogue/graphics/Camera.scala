package com.marqod.rogue.graphics

import com.marqod.rogue.utils.{Config, EntityPosition, Utils, Vector2}

/**
  * Created by ryan.walker on 10/29/16.
  */
class Camera extends Config{
  val offset = new EntityPosition(0,0)

  def update(playerPos: EntityPosition): Unit = {
    offset.set(
      playerPos.x - (CANVAS_SIZE.x / 2),
      playerPos.y - (CANVAS_SIZE.y / 2)
    )
  }

}
