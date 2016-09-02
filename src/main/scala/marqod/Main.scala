import org.newdawn.slick._
import geom._

object Main extends App {

  val app = new AppGameContainer(new SimpleGame)
  app.setDisplayMode(800, 600, false)
  app.start()

}

class SimpleGame extends BasicGame("marqod") {

  var objects = Vector.empty[Circle]
  var current = new Circle(0, 0, 0)
  var everPressed = false
  def init(gc: GameContainer) {}
  def render(gc: GameContainer, g: Graphics) {
    g.setColor(Color.red)
    objects foreach { x =>
      g.draw(x)
    }
    g.setColor(Color.yellow)
    g.draw(current)
  }

  def update(gc: GameContainer, delta: Int) {
    val input = gc.getInput

    val x = input.getMouseX()
    val y = input.getMouseY()

    if (input.isMouseButtonDown(0)) {
      everPressed = true
      if (current.getX() != 0 && current.getY() != 0) {
        val cx = current.getX()
        val cy = current.getY()
        val radius = scala.math.sqrt(scala.math.pow(x - cx, 2) + scala.math.pow(y - cy, 2))
        current.setRadius(radius.toFloat)
      } else {
        current.setX(x)
        current.setY(y)
        current.setRadius(0)
      }
    } else if(everPressed == true) {
      objects = objects :+ current
      current = new Circle(0, 0, 0)
      everPressed = false
    }
  }

}
