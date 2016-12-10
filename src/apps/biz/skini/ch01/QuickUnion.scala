package apps.biz.skini.ch01

/**
  * Created by skinibizapps on 11/28/16.
  */
object QuickUnion extends App {
  val startTime = System.currentTimeMillis
  val nArray = initialize(15000)
  val newArray = union(7, 5, union(5, 1, union(0, 1, nArray)))
  val newArray1 = union(8, 7, union(5, 3, union(6, 4, newArray)))
  val endTime = System.currentTimeMillis

  //nodes can be represented by an array of integers with each node corresponds to the value stored in the respective index
  def initialize(nodeCount: Int): Array[Int] = {
    var totalNodes = nodeCount
    val array = Array.range(0, totalNodes, 1)
    println(s"initializing array of size $nodeCount ${array.toList}")
    array
  }

  def root(node: Int, nodes: Array[Int]): Int = {
    val rootNode = if (node != nodes(node)) {
      println(s"Getting the parent for node at index $node")
      root(nodes(node), nodes)

    } else node
    println(s"root node for node at index $node in array ${nodes.toList} is $rootNode")
    rootNode
  }

  def union(n1: Int, n2: Int, nodes: Array[Int]): Array[Int] = {
    val n1root = root(n1, nodes)
    val n2root = root(n2, nodes)
    nodes(n1root) = nodes(n2root)
    println(s"array ${nodes.toList} after union between nodes at index $n1 and $n2 is ${nodes.toList}")
    nodes
  }

  println(find(1, 7, newArray1)) //true
  println(find(0, 3, newArray1)) //true
  println(find(1, 6, newArray1)) //false
  println(find(4, 6, newArray1)) //true
  println(find(1, 4, newArray1)) //false

  def find(n1: Int, n2: Int, nodes: Array[Int]): Boolean = {
    println(s"finding a link between nodes $n1 and $n2 in array ${nodes.toList}")
    root(n1, nodes) == root(n2, nodes)
  }

  println(s"execution time is ${endTime - startTime}")
}
