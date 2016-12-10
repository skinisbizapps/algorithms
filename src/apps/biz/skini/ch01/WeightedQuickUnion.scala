package apps.biz.skini.ch01

/**
  * Created by skinibizapps on 11/28/16.
  */
object WeightedQuickUnion extends App {

  lazy val nodeArray = fNode(10)
  lazy val nodeDepth = fNodeDepth(nodeArray.length)
  val fNode = (size: Int) => Array.range(0, size, 1)
  println(nodeArray.toList)
  println(nodeArray.length)
  val fNodeDepth = (size: Int) => Array.fill(size) {
    1
  }
  println(nodeDepth.toList)
  println(nodeArray.length)
  val startTime = System.currentTimeMillis
  val expectedNodeArray = List(6, 2, 6, 4, 6, 6, 6, 2, 4, 4)
  val endTime = System.currentTimeMillis

  def root(childNode: Int): Int = if (childNode != nodeArray(childNode)) root(nodeArray(childNode)) else childNode

  union(4, 3);
  union(3, 8);
  union(9, 4)

  assert(find(4, 9), "nodes 4 and 9 are connected and must be true") //true
  assert(find(4, 8), "nodes 4 and 8 are connected and must be true") //true
  assert(find(8, 9), "nodes 8 and 9 are connected and must be true") //true
  assert(!find(6, 8), "nodes 6 and 8 are not connected and must return false") //false
  assert(!find(6, 9), "nodes 6 and 9 are not connected and must return false") //false

  union(6, 5);
  union(5, 0)
  println(find(0, 5)) //true
  println(find(4, 6)) //false


  union(2, 1);
  union(7, 2)
  println(find(1, 7)) //true
  println(find(4, 6)) //false
  println(find(2, 6)) //false
  println(find(2, 4)) //false

  union(6, 1);
  union(7, 3)
  println(find(1, 7)) //true
  println(find(0, 3)) //true
  println(find(1, 6)) //true
  println(find(4, 6)) //true
  println(find(1, 4)) //true

  def union(node1: Int, node2: Int): Unit = {
    println(s"union($node1,$node2)")
    val rootNodeNode1 = root(node1)
    val rootNodeNode2 = root(node2)
    if (rootNodeNode1 != rootNodeNode2) {
      //only connect if the root nodes are not already connected
      if (nodeDepth(rootNodeNode1) < nodeDepth(rootNodeNode2)) {
        nodeArray(rootNodeNode1) = nodeArray(rootNodeNode2)
        nodeDepth(rootNodeNode2) = nodeDepth(rootNodeNode2) + nodeDepth(rootNodeNode1)
      } else {
        nodeArray(rootNodeNode2) = nodeArray(rootNodeNode1)
        nodeDepth(rootNodeNode1) = nodeDepth(rootNodeNode2) + nodeDepth(rootNodeNode1)
      }
    }
    println(nodeArray.toList)
    println(nodeDepth.toList)
  }

  assert(nodeArray.toList == expectedNodeArray, s"${nodeArray.toList} must be equal to the $expectedNodeArray but is not")

  def find(node1: Int, node2: Int): Boolean = {
    val result = root(node1) == root(node2)
    println(s"find($node1, $node2) is $result")
    result
  }

  println(s"execution time is ${endTime - startTime}")

}
