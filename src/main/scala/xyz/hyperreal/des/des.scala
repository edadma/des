package xyz.hyperreal

package object des {

  type Action = () => Unit

  case class Event(time: Int, action: Action)

  def afterDelay(delay: Int)(action: => Unit): Unit =
    Simulation.insert(Simulation.currentTime + delay, () => action)

}
