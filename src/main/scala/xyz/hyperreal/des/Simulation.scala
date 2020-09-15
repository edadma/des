package xyz.hyperreal.des

object Simulation {

  private var agenda: List[Event] = Nil
  private var curtime = 0

  private[des] def insert(time: Int, action: => Unit) = {
    val item = Event(time, () => action)

    def insert(ag: List[Event]): List[Event] =
      ag match {
        case first :: rest if first.time <= item.time => first :: insert(rest)
        case _                                        => item :: ag
      }

    insert(agenda)
  }

  def currentTime: Int = curtime

  @scala.annotation.tailrec
  private def loop(): Unit =
    agenda match {
      case first :: rest =>
        agenda = rest
        curtime = first.time
        first.action()
        loop()
      case Nil =>
    }

  def run(): Unit = {
    afterDelay(0) { println(s"*** simulation started, time = $curtime ***") }
    loop()
  }

}
