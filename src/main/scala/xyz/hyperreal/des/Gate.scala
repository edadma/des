package xyz.hyperreal.des

object Gate {

  val NOT_GATE_DELAY = 5
  val AND_GATE_DELAY = 5

  def or(a: Wire, b: Wire, out: Wire): Unit = {}

  def and(a: Wire, b: Wire, out: Wire): Unit =
    a addAction (() => afterDelay(AND_GATE_DELAY) { out setSignal a.getSignal && b.getSignal })

  def not(a: Wire, out: Wire): Unit =
    a addAction (() => afterDelay(NOT_GATE_DELAY) { out setSignal !a.getSignal })

  def nand(a: Wire, b: Wire, out: Wire): Unit = {
    val o = new Wire

    and(a, b, o)
    not(o, out)
  }

  def nor(a: Wire, b: Wire, out: Wire): Unit = {
    val o = new Wire

    or(a, b, o)
    not(o, out)
  }

  def xor(a: Wire, b: Wire, out: Wire): Unit = {
    val na, nb, a1, a2 = new Wire

    not(b, nb)
    and(a, nb, a1)
    not(a, na)
    and(na, b, a2)
    or(a1, a2, out)
  }

  def xnor(a: Wire, b: Wire, out: Wire): Unit = {
    val na, nb, a1, a2 = new Wire

    and(a, b, a1)
    not(a, na)
    not(b, nb)
    and(na, nb, a2)
    or(a1, a2, out)
  }

}
