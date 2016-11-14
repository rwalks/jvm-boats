package com.marqod.rogue.engine

/**
  * Created by ryan.walker on 10/29/16.
  */
abstract class GameMessage()
case class InputMessage(input: ControlInput.Value, active: Boolean) extends GameMessage

object ControlInput extends Enumeration {
  val UP,
  LEFT,
  RIGHT,
  DOWN = Value

  def get(ch: Int): Option[ControlInput.Value] = {
    ch match {
      case 37 => Some(ControlInput.LEFT)
      case 38 => Some(ControlInput.UP)
      case 39 => Some(ControlInput.RIGHT)
      case 40 => Some(ControlInput.DOWN)
      case _ => None
    }
  }
}

