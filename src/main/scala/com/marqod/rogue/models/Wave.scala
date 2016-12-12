package com.marqod.rogue.models

import com.marqod.rogue.art.ArtType
import com.marqod.rogue.utils.{EntityPosition, EntityRotation, Vector2, Vector3}

/**
  * Created by ryan.walker on 11/12/16.
  */
class Wave(pos: EntityPosition, wind: Wind) extends Entity(pos) {

  val artType = ArtType.WAVE_ART
  val rotation: EntityRotation = new EntityRotation(wind.rotation.theta)
  val maxWidth = 10 + (Math.random() * 30)
  var dWidth = 0.1
  override val dimensions: Vector3 = Vector3(
    1,
    2,
    0
  )
  velocity.set(Vector2(0,wind.magnitude).rotate(rotation.theta))

  def update(): Boolean = {
    this.position.move(velocity)
    dimensions.x += dWidth
    if ( dimensions.x >= maxWidth) {
     dWidth = -dWidth
    }
    dimensions.x > 0 && !this.position.onBorder()
  }

}

class Wake(entity: Entity) extends Entity(entity.position.clone()) {

  val artType = ArtType.WAVE_ART
  val rotation: EntityRotation = new EntityRotation(entity.rotation.theta)
  val maxWidth = 60
  var dWidth = entity.velocity.magnitude() / 4
  override val dimensions: Vector3 = Vector3(
    entity.dimensions.x / 2,
    2,
    0
  )
  val boatBack = new Vector2(0, entity.dimensions.y / 2)
  position.move(boatBack.rotate(entity.rotation.theta))

  def update(): Boolean = {
    dimensions.x += dWidth
    dimensions.x <= maxWidth
  }
}
