package apps.biz.skini.cs.ch03

/**
  * Created by skinibizapps on 3/30/17.
  */
object DeckOfCards extends App {

  val ranks = Seq("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A")
  val suits = Seq("♠", "♦", "❤︎", "♣")
  val deck = for (suit <- suits; rank <- ranks) yield {
    rank + suit
  }

  print(deck)
}
