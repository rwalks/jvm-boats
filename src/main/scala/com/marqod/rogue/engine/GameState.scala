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

  val water: Array[Array[Double]] = generateWater()

  def getDrawTargets(offset: Vector2): List[Entity] = {
    List(player)
  }

  def generateWater(): Array[Array[Double]] = {
    Array.range(0,WAVE_COUNT.x.toInt).map( _ =>
      Array.range(0,WAVE_COUNT.y.toInt).map(_ => 0.0)
    )
  }

}
