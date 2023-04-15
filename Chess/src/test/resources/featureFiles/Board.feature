Feature: Board

  @tag1
  Scenario: Board setup
    Given a game with an empty board
    When the board is setup
    Then row 0 has white pieces
    And row 1 has white pawns
    And row 6 has black pawns
    And row 7 has black pieces
    

