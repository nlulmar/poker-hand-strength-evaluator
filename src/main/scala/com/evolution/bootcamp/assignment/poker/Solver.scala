package com.evolution.bootcamp.assignment.poker

object Solver {
  // TODO: implement correct solution logic
  def parseBoard(board: String): List[Card] = board
    .grouped(2)
    .toList
    .map(Card.apply)
  def process(line: String): String = {
    val ErrorPrefix = "Error: "

    line.split("\\s+").toList match {
      case "texas-holdem" :: board :: hands   =>
        val boardCards = parseBoard(board).combinations(2).map(Hand.apply).toList
        val handList = hands.map(Card.apply).combinations(2).map(Hand.apply).toList
        val texasHoldem = TexasHoldem(boardCards, handList)
        texasHoldem.toString
      case "omaha-holdem" :: board :: hands   => ErrorPrefix + "The solution doesn't support Omaha Hold'em"
      case "five-card-draw" :: hands          =>
        val handList = hands.map(Card.apply).combinations(5).map(Hand.apply).toList
        val fiveCardDraw = FiveCardDraw(handList)
        fiveCardDraw.toString
      case x :: _                             => ErrorPrefix + "Unrecognized game type"
      case _                                  => ErrorPrefix + "Invalid input"
    }
  }
}
