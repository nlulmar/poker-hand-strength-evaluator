package com.evolution.bootcamp.assignment.poker

case class TexasHoldem(board: List[Hand], hands: List[Hand]){
  def sortedHands: List[Hand] = {
    (board ++ hands).sortBy { hand => (hand.value, Hand.bestHand(hand.cards).value)
    }(Ordering.Tuple2(Ordering[Int].reverse, Ordering[Int]))
  }
  override def toString: String = {
    sortedHands.map(_.toString).mkString(" ")
  }
}