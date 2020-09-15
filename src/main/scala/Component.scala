package des

object Component {

  def halfAdder(a: Wire, b: Wire, sum: Wire, carry: Wire): Unit = {
    val s, noCarry = new Wire

    Gate.or(a, b, s)
    Gate.and(a, b, carry)
    Gate.not(carry, noCarry)
    Gate.and(s, noCarry, sum)
  }

}
