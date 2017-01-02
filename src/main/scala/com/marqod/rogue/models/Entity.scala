package com.marqod.rogue.models

import com.marqod.rogue.utils.{EntityPosition, EntityRotation, Vector2, Vector3}

import scala.collection.mutable.ArrayBuffer

/**
  * Created by ryan.walker on 10/29/16.
  */
abstract class Entity(val position: EntityPosition) {
  val rotation: EntityRotation
  val dimensions: Vector3 = Vector3(30,30,30)
  val velocity: Vector2 = new Vector2(1,0)
}

case class EntityReturn(alive: Boolean, wakes: ArrayBuffer[Wake])

