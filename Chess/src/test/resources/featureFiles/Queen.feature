Feature: Queen

  @tag1
  Scenario: Queen makes a valid move
    Given a game with an empty board
    And a queen on the board at (5, 5)
    When the queen moves to (6, 6)
    Then the queen is at (6, 6)
    And there is no piece at (5, 5)
    
  @tag2
  Scenario: Queen attempts an illegal move
    Given a game with an empty board
    And a queen on the board at (5, 5)
    When the queen tries to move to (7, 6)
    Then there is no piece on the new square
    And the queen is still at the old position
    
  Scenario: queen tries to move to occupied square
    Given a game with an empty board
    And a white queen on the board at (5, 5)
    And a white pawn on the board at (7, 7)
    When the queen tries to move to (7, 7)
    Then the white pawn is still at (7, 7)
    And the queen is at (5, 5)
    
  Scenario: White queen takes black piece
    Given a game with an empty board
    And a white queen on the board at (5, 5)
    And a black pawn on the board at (7, 7)
    When the queen moves to (7, 7)
    And the queen is at (7, 7)
    And the black pawn is no longer at (7, 7)