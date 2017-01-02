package com.marqod.rogue.engine

import com.marqod.rogue.models._
import com.marqod.rogue.utils.{Config, EntityPosition, Vector2}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * Created by ryan.walker on 10/29/16.
  */
class GameState extends Config {

  val player = new PlayerEntity(new EntityPosition(50,50))
  val wind = new Wind()
  var waves: ArrayBuffer[Wave] = ArrayBuffer[Wave]()
  var wakes: ArrayBuffer[Wake] = ArrayBuffer[Wake]()
  var islands: ArrayBuffer[Island] = ArrayBuffer[Island]()
//
  islands += new Island(new EntityPosition(100,100))

  def getDrawTargets(offset: Vector2): List[Entity] = {
    List(player)
  }

}
