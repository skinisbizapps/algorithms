package apps.biz.skini.ch01

/**
  * Created by skinibizapps on 11/28/16.
  * Analysis => This algorithm works well for lower node count but is slower as the node count goes up.
  * for each union, we have to loop through the list and replace the items to match one of the nodes
  * O(n) = n => the performance linearly decreases as the node count goes up
  * find on the other hand is very quick.
  *
  * This is an eager approach to algorithm design. why?
  */
object QuickFind extends App {

  val nArray = initialize(15)
  val newArray = union(7, 0, union(5, 1, union(0, 1, nArray)))
  val newArray1 = union(1, 2, union(2, 3, union(6, 4, newArray)))

  //nodes can be represented by an array of integers with each node corresponds to the value stored in the respective index
  def initialize(nodeCount: Int): Array[Int] = {
    var totalNodes = nodeCount
    val array = Array.range(0, totalNodes, 1)
    println(s"initializing array of size $nodeCount ${array.toList}")
    array
  }

  def union(n1: Int, n2: Int, nodes: Array[Int]): Array[Int] = {
    if (n1.>=(nodes.length) || n2.>=(nodes.length)) nodes
    var nodesLcl = nodes
    val nodeValuen1 = nodesLcl(n1)
    val nodeValuen2 = nodesLcl(n2)
    println(s"n1 = $n1 and n2 = $n2")
    println(s"input array to union ${nodesLcl.toList}")
    val result = if (nodesLcl(n2) != nodesLcl(n1)) {
      for (node <- nodesLcl) yield if (node.==(nodeValuen2)) {
        nodeValuen1
      } else {
        node
      }
    } else {
      nodesLcl
    }
    println(s"Array after union is ${result.toList}")
    result
  }

  def find(n1: Int, n2: Int, nodes: Array[Int]): Boolean = {
    println(s"fining a link bweetwen n1 = $n1 and n2 = $n2")
    println(s"input array to find ${nodes.toList}")
    println(s"comparing ${nodes(n1)} and ${nodes(n2)}")
    nodes(n1) == nodes(n2)
  }

  println(find(1, 7, newArray1)) //true
  println(find(0, 3, newArray1)) //true
  println(find(1, 6, newArray1)) //false
  println(find(4, 6, newArray1)) //true
  println(find(1, 4, newArray1)) //false
}
