Feature: Knight
  
  @tag1
  Scenario: Knight makes a valid move
    Given a game with an empty board
    And a knight on the board at (3, 3)
    When the knight moves to (5, 4)
    Then the knight is at (5, 4)
    And there is no piece at (3, 3)
    
  @tag2
  Scenario: Knight attempts an illegal move
    Given a game with an empty board
    And a knight on the board at (3, 3)
    When the knight tries to move to (3, 4)
    Then there is no piece on the new square
    And the knight is still at the old position
    
  Scenario: Knight tries to move to occupied square
    Given a game with an empty board
    And a white knight on the board at (3, 3)
    And a white pawn on the board at (5, 4)
    When the knight tries to move to (5, 4)
    Then the white pawn is still at (5, 4)
    And the knight is at (3, 3)
    
