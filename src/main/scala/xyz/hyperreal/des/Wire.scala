package xyz.hyperreal.des

class Wire {

  private var signal = false
  private var actions: List[Action] = Nil

  def getSignal: Boolean = signal

  def setSignal(sig: Boolean): Unit =
    if (sig != signal) {
      signal = sig
      actions foreach (_())
    }

  def addAction(a: Action): Unit = {
    actions = a :: actions
    a()
  }

}
