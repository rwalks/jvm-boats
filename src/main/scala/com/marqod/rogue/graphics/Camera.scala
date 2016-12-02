package com.marqod.rogue.graphics

import com.marqod.rogue.models.ControlState
import com.marqod.rogue.utils._

/**
  * Created by ryan.walker on 10/29/16.
  */
class Camera extends Config{
  val position = Vector3(0,0,0)

  def update(controls: ControlState): Unit = {
    if ( controls.up ) {position.z += 1}
    if ( controls.down ) {position.z -= 1}
  }

}
