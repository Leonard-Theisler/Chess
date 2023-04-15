Feature: Knight
  
  @tag1
  Scenario: Knight makes a valid move
    Given a game with an empty board
    And a knight on the board at (3, 3)
    When the knight moves to (6, 6)
    Then the knight is at (6, 6)
    And there is no piece at (5, 5)
    
  @tag2
  Scenario: Knight attempts an illegal move
    Given a game with an empty board
    And a knight on the board at (5, 5)
    When the knight tries to move to (7, 6)
    Then there is no piece on the new square
    And the knight is still at the old position
    
  Scenario: Knight tries to move to occupied square
    Given a game with an empty board
    And a white knight on the board at (5, 5)
    And a white pawn on the board at (7, 7)
    When the knight tries to move to (7, 7)
    Then the white pawn is still at (7, 7)
    And the knight is at (5, 5)
    
  Scenario: White knight takes black piece
    Given a game with an empty board
    And a white knight on the board at (5, 5)
    And a black pawn on the board at (7, 7)
    When the knight moves to (7, 7)
    And the knight is at (7, 7)
    And the black pawn is no longer at (7, 7)