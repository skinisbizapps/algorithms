package apps.biz.skini.ch03

/**
  * Created by skinibizapps on 12/3/16.
  */


object StackExample extends App {

  var firstItem: Node = Node(None, None)

  def push(item: String): Unit = {
    val oldNode: Node = firstItem
    firstItem = Node(Some(item), Some(oldNode))
  }

  def pop(): Option[String] = {
    val poppedItem = if (!isEmpty()) {
      val item: Option[String] = firstItem.item
      firstItem = firstItem.next.getOrElse(Node(None, None))
      item
    } else {
      None
    }
    poppedItem
  }

  def isEmpty(): Boolean = {
    firstItem == null
  }

  case class Node(item: Option[String], next: Option[Node])


  push("Hello")
  push("How")
  push("are")
  push("you?")
  (0 to 7).foreach(i => print(pop()))
  print(isEmpty())
  push("abcd")

}
