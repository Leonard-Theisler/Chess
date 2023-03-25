Feature: Bishop

  @tag1
  Scenario: Bishop makes a valid move
    Given a game with an empty board
    And a bishop on the board at (5, 5)
    When the bishop moves to (6, 6)
    Then the bishop is at position (6, 6)
    
  @tag2
  Scenario: Bishop makes attempts an illegal move
    Given a game with an empty board
    And a bishop on the board at (5, 5)
    When the bishop tries to move to (5, 7)
    Then the bishop is at position (5, 5)
    
    


