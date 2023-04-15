Feature: King

  @tag1
  Scenario: King makes a valid move
    Given a game with an empty board
    And a king on the board at (5, 5)
    When the king moves to (6, 6)
    Then the king is at (6, 6)
    And there is no piece at (5, 5)
    
  @tag2
  Scenario: King attempts an illegal move
    Given a game with an empty board
    And a king on the board at (5, 5)
    When the king tries to move to (5, 7)
    Then there is no piece on the new square
    And the king is still at the old position
    
  Scenario: king tries to move to occupied square
    Given a game with an empty board
    And a white king on the board at (5, 5)
    And a white pawn on the board at (6, 6)
    When the king tries to move to (6, 6)
    Then the white pawn is still at (6, 6)
    And the king is at (5, 5)
    
  Scenario: White king takes black piece
    Given a game with an empty board
    And a white king on the board at (5, 5)
    And a black pawn on the board at (6, 6)
    When the king moves to (6, 6)
    And the king is at (6, 6)
    And the black pawn is no longer at (6, 6)
    
   
    
    
    
  
    
    


