Feature: Pawn

  @tag1
  Scenario: White pawn moves 1
    Given a game with an empty board
    And a white pawn on the board at (5, 5)
    When the pawn moves forward 1
    Then the pawn is at position (5, 6)

