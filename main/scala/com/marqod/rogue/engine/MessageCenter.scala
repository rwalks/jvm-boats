package com.marqod.rogue.engine

import scala.collection.mutable

/**
  * Created by ryan.walker on 10/29/16.
  */
class MessageCenter {

  var queue = new mutable.Queue[GameMessage]()

  def keyPress(ch: Int): Unit = {
    ControlInput.get(ch) match {
      case Some(input: ControlInput.Value) =>
        queue += InputMessage(input, true)
      case None => {}
    }
  }

  def keyRelease(ch: Int): Unit = {
    ControlInput.get(ch) match {
      case Some(input: ControlInput.Value) =>
        queue += InputMessage(input, false)
      case None => {}
    }
  }

}
