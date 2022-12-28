package com.evolution.bootcamp.assignment.poker

case class FiveCardDraw(hands: List[Hand]){
  def sortedHands: List[Hand] = {
    hands.sortBy(_.value)(Ordering[Int].reverse)
  }
  override def toString: String = {
    sortedHands.map(_.toString).mkString(" ")
  }
}