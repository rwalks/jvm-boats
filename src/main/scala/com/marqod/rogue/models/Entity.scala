package com.marqod.rogue.models

import com.marqod.rogue.art.ArtType
import com.marqod.rogue.utils.{EntityPosition, EntityRotation, Vector2}

import scala.collection.mutable.ArrayBuffer

/**
  * Created by ryan.walker on 10/29/16.
  */
abstract class Entity(val position: EntityPosition) {
  val rotation: EntityRotation
  val dimensions: Vector2
  val artType: ArtType.Value
  val velocity: Vector2 = new Vector2(1,0)
}

case class EntityReturn(alive: Boolean, wakes: ArrayBuffer[Wake])

class PlayerEntity(position: EntityPosition) extends Entity(position) {
  val artType = ArtType.PLAYER_ART
  val controlState = ControlState()
  val rotation: EntityRotation = new EntityRotation(0)
  val dimensions = Vector2(10,26)
  val dVelocity = Vector2(0,0)

  def update(): EntityReturn = {
    dVelocity.set(0,0)
    applyControlState()
    updateRudder()

    val wakes = generateWake()
    EntityReturn(true, wakes)
  }

  def generateWake(): ArrayBuffer[Wake] = {
    val wakes = ArrayBuffer[Wake]()
    if ( controlState.up && Math.random() < 0.4) {
      wakes.append(new Wake(this))
    }
    wakes
  }

  def applyControlState(): Unit = {
    //v
    if ( controlState.up ) { dVelocity.move(Vector2(0,-1).rotate(rotation.theta)) }
    if ( controlState.down ) { dVelocity.move(Vector2(0,1).rotate(rotation.theta)) }
    //rotation
  }

  def updateRudder() = {
    val dRudder = 0.01 + (velocity.magnitude() * 0.05)
    if ( controlState.left ) { rotation.rotate(-dRudder) }
    if ( controlState.right ) { rotation.rotate(dRudder) }
  }

}

case class ControlState(
                         var up: Boolean = false,
                         var down: Boolean = false,
                         var left: Boolean = false,
                         var right: Boolean = false
                       )
