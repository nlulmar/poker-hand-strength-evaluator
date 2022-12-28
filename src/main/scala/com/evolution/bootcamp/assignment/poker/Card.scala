package com.evolution.bootcamp.assignment.poker

case class Card(card: String) {
  def rank: String = card(0).toString
  def suit: String = card(1).toString
  def value: Int = Card.value(rank)
}

object Card {

  private val cardValues: Map[String, Int] = Map(
    "2" -> 2,
    "3" -> 3,
    "4" -> 4,
    "5" -> 5,
    "6" -> 6,
    "7" -> 7,
    "8" -> 8,
    "9" -> 9,
    "10" -> 10,
    "J" -> 11,
    "Q" -> 12,
    "K" -> 13,
    "A" -> 14
  )
  private def value(card: String): Int = cardValues(card)
}
