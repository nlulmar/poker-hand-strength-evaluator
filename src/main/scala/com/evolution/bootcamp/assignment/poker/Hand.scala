package com.evolution.bootcamp.assignment.poker

case class Hand(cards: List[Card]) {
  private def sortCards: List[Card] = cards.sortWith(_.value < _.value)
  private def groupCards(size: Int): Map[String, List[Card]] = cards
    .groupBy(_.rank)
    .filter { case (_, trueValues) => trueValues.length == size }

  private def isPair: Boolean = groupCards(2).size == 1
  private def isTwoPairs: Boolean = groupCards(2).size == 2
  private def isThreeOfAKind: Boolean = groupCards(3).size == 1
  private def isStraight: Boolean = {
    val sortedValues: List[Int] = sortCards.map(_.value)
    sortedValues.zip(sortedValues.drop(1)).forall {
      case (a, b) =>
        if (b == 14) sortedValues.last == 13 || sortedValues.head == 2
        else b == a + 1
    }
  }
  private def isFlush: Boolean = cards.map(_.suit).toSet.size == 1
  private def isFullHouse: Boolean = isPair && isThreeOfAKind
  private def isFourOfAKind: Boolean = groupCards(4) == 1
  private def isStraightFlush: Boolean = isFlush && isStraight
  def value: Int = {
    if (isStraightFlush) 9
    else if (isFourOfAKind) 8
    else if (isFullHouse) 7
    else if (isFlush) 6
    else if (isStraight) 5
    else if (isThreeOfAKind) 4
    else if (isTwoPairs) 3
    else if (isPair) 2
    else 1
  }
}
object Hand {
  def bestHand(cards: List[Card]): Hand = {
    val hands = cards.combinations(5).map(Hand.apply).toList
    hands.maxBy(_.value)
  }
}
