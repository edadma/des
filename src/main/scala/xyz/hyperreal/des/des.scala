package xyz.hyperreal

package object des {

  type Action = () => Unit

  case class Event(time: Int, action: Action)

  def afterDelay(delay: Int)(action: => Unit): Unit =
    Simulation.insert(currentTime + delay, () => action)

  def currentTime: Int = Simulation.curtime

  def probe(name: String, wire: Wire): Unit =
    wire addAction (() => println(s"$name $currentTime value = ${wire getSignal}"))

}
