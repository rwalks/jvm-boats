package com.marqod.rogue.models

import com.marqod.rogue.utils.{EntityPosition, EntityRotation, Vector2, Vector3}

/**
  * Created by ryan.walker on 12/26/16.
  */
class Island(pos: EntityPosition) extends Entity(pos) {

  val rotation: EntityRotation = EntityRotation(0)
  override val dimensions: Vector3 = Vector3(100, 100, 0)

  val geo: List[Vector2] = List(
    Vector2(0,0),
    Vector2(100,0),
    Vector2(100,100),
    Vector2(0,100)
  )

  def update(): Boolean = {
    true
  }

}
