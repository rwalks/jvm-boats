package com.marqod.rogue.engine

import com.marqod.rogue.models.{PlayerEntity, Wave}
import com.marqod.rogue.utils._

/**
  * Created by ryan.walker on 10/29/16.
  */
class GameEngine extends Config{
  val gameState = new GameState()

  def update(messenger: MessageCenter): Unit = {
    messenger.queue.dequeueAll(_ => true).foreach {
      case msg: InputMessage => setPlayerInput(msg)
      case _ =>
    }
    updateWaves()
    updateWakes()
    updatePlayer(gameState.player)
  }

  def setPlayerInput(msg: InputMessage): Unit = {
    msg.input match {
      case ControlInput.UP => gameState.player.controlState.up = msg.active
      case ControlInput.DOWN => gameState.player.controlState.down = msg.active
      case ControlInput.LEFT => gameState.player.controlState.left = msg.active
      case ControlInput.RIGHT => gameState.player.controlState.right = msg.active
      case _ =>
    }
  }

  def updatePlayer(p: PlayerEntity) = {
    val playerUpdate = p.update()
    gameState.wakes = gameState.wakes ++ playerUpdate.wakes
  }

  def updateWaves() = {
    gameState.waves = gameState.waves.filter { w =>
      w.update() == true
    }
    if (Math.random() < gameState.wind.magnitude) {
      val oX = Math.max(gameState.player.position.x - (CANVAS_SIZE.x/2), 0)
      val oY = Math.max(gameState.player.position.y - (CANVAS_SIZE.y/2), 0)
      gameState.waves += new Wave(
        new EntityPosition(
          oX + (Math.random() * CANVAS_SIZE.x),
          oY + (Math.random() * CANVAS_SIZE.y)
        ),
        gameState.wind
      )
    }
  }

  def updateWakes() = {
    gameState.wakes = gameState.wakes.filter { w =>
      w.update() == true
    }
  }

}
