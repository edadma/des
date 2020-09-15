package xyz.hyperreal.des

object Component {

  import Gate._

  def halfAdder(a: Wire, b: Wire, sum: Wire, carry: Wire): Unit = {
    val s, noCarry = new Wire

    or(a, b, s)
    and(a, b, carry)
    not(carry, noCarry)
    and(s, noCarry, sum)
  }

  def fullAdder(a: Wire, b: Wire, cin: Wire, sum: Wire, carry: Wire): Unit = {
    val s, c1, c2 = new Wire

    halfAdder(b, cin, s, c1)
    halfAdder(a, s, sum, c2)
    or(c1, c2, carry)
  }

}
