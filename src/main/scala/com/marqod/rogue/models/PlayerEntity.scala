package com.marqod.rogue.models

import com.marqod.rogue.art.ArtType
import com.marqod.rogue.engine.GameState
import com.marqod.rogue.utils.{EntityPosition, EntityRotation, Vector2, Vector3}

import scala.collection.mutable.ArrayBuffer

/**
  * Created by ryan.walker on 11/22/16.
  */

class PlayerEntity(position: EntityPosition) extends Entity(position) {
  val controlState = ControlState()
  val rotation: EntityRotation = new EntityRotation(0)
  val dVelocity = Vector2(0,0)

  def update(gameState: GameState): EntityReturn = {
    dVelocity.set(0,0)
    applyControlState()
    updateRudder()
    applyForces()
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

  def applyForces(): Unit = {
    velocity.move(dVelocity)
    velocity.scale(0.9)
    position.move(velocity)
  }

  def applyControlState(): Unit = {
    //v

    if ( controlState.up ) { dVelocity.move(Vector2(0,-0.1).rotate(rotation.theta)) }
    if ( controlState.down ) { dVelocity.move(Vector2(0,0.1).rotate(rotation.theta)) }
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
