package com.marqod.rogue.models

import com.marqod.rogue.utils.{EntityPosition, EntityRotation, Vector3}

/**
  * Created by ryan.walker on 12/26/16.
  */
class Island(pos: EntityPosition) extends Entity(pos) {

  val rotation: EntityRotation = EntityRotation(0)
  override val dimensions: Vector3 = Vector3(1, 2, 0)

  def update(): Boolean = {
    true
  }

}
