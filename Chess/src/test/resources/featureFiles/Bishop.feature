Feature: Bishop

  @tag1
  Scenario: Bishop makes a valid move
    Given a game with an empty board
    And a bishop on the board at (5, 5)
    When the bishop moves to (6, 6)
    Then the bishop is at (6, 6)
    And there is no piece at (5, 5)
    
  @tag2
  Scenario: Bishop attempts an illegal move
    Given a game with an empty board
    And a bishop on the board at (5, 5)
    When the bishop tries to move to (5, 7)
    Then there is no piece on the new square
    And the bishop is still at the old position
    
  Scenario: Bishop tries to move to occupied square
    Given a game with an empty board
    And a white bishop on the board at (5, 5)
    And a white pawn on the board at (7, 7)
    When the bishop tries to move to (7, 7)
    Then the white pawn is still at (7, 7)
    And the bishop is at (5, 5)
    
  Scenario: White bishop takes black piece
    Given a game with an empty board
    And a white bishop on the board at (5, 5)
    And a black pawn on the board at (7, 7)
    When the bishop moves to (7, 7)
    And the bishop is at (7, 7)
    And the black pawn is no longer at (7, 7)
    
   
    
    
    
  
    
    


