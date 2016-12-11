package apps.biz.skini.udacity

/**
  * Created by skinibizapps on 12/18/16.
  */
object Ex02 extends App {

  /*
  # Find Eulerian Tour
  #
  # Write a function that takes in a graph
  # represented as a list of tuples
  # and return a list of nodes that
  # you would follow on an Eulerian Tour
  #
  # For example, if the input graph was
  # [(1, 2), (2, 3), (3, 1)]
  # A possible Eulerian tour would be [1, 2, 3, 1]
   */
  def find_eulerian_tour(graph: ((Int, Int), (Int, Int), (Int, Int))): List[Int] = {
    val edge1 = graph._1
    val edge2 = graph._2
    val edge3 = graph._3
    val nodes = Set(edge1._1, edge1._2, edge2._1, edge2._2, edge3._1, edge3._2)

    print(nodes)
    return List()
  }

  find_eulerian_tour((1, 2), (2, 3), (1, 1))

}
