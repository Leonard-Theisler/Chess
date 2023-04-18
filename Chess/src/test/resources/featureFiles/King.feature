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
    
  Scenario: King tries to go to threatened square
  	Given a game with an empty board
    And a black king on the board at (5, 5)
    And a white rook on the board at (3, 6)
    When the king moves to (6, 6)
    And the king is at (5, 5)
    
    
  Scenario: King tries to take protected piece
  	Given a game with an empty board
    And a black king on the board at (5, 5)
    And a white pawn on the board at (6, 6)
    And a white rook on the board at (3, 6)
    When the king moves to (6, 6)
    And the king is at (5, 5)
    And the pawn is at position (6, 6)
    
   
  Scenario: Black king short castle
  	Given a game with an empty board
    And a black king on the board at (4, 7)
    And a black rook on the board at (7, 7)
    When the king moves to (6, 7)
    Then the king is at (6, 7)
    And the rook is at (5, 7)
    
  Scenario: Black king long castle
  	Given a game with an empty board
    And a black king on the board at (4, 7)
    And a black rook on the board at (0, 7)
    When the king moves to (2, 7)
    Then the king is at (2, 7)
    And the rook is at (3, 7)
    
 Scenario: White king short castle
  	Given a game with an empty board
    And a white king on the board at (4, 0)
    And a white rook on the board at position (7, 0)
    When the king moves to (6, 0)
    Then the king is at (6, 0)
    And the rook is at (5, 0)
    
  Scenario: White king long castle
  	Given a game with an empty board
    And a white king on the board at (4, 0)
    And a white rook on the board at position (0, 0)
    When the king moves to (2, 0)
    Then the king is at (2, 0)
    And the rook is at (3, 0)
    
  Scenario: White king attempts illegal long castle
  	Given a game with an empty board
    And a white king on the board at (4, 0)
    And a white rook on the board at position (0, 0)
    And a white knight on the board at position(1, 0)
    When the king tries to move to (2, 0)
    Then the king is at (4, 0)
    And the rook is at (0, 0)
    And the knight is at (1, 0)
    
  Scenario: Black king attempts illegal short castle
  	Given a game with an empty board
    And a black king on the board at (4, 7)
    And a black rook on the board at position (7, 7)
    And a black knight on the board at position(6, 7)
    When the king tries to move to (6, 7)
    Then the king is at (4, 7)
    And the rook is at (7, 7)
    And the knight is at (6, 7)
    
  Scenario: Black king attempts short castle when threatened
  	Given a game with an empty board
    And a black king on the board at (4, 7)
    And a black rook on the board at position (7, 7)
    And a white knight on the board at position(2, 6)
    When the king tries to move to (6, 7)
    Then the king is at (4, 7)
    And the rook is at (7, 7)
    And the knight is at (2, 6)
    
  Scenario: White king attempts short castle when threatened
  	Given a game with an empty board
    And a white king on the board at (4, 0)
    And a white rook on the board at position (7, 0)
    And a black knight on the board at position(2, 1)
    When the king tries to move to (6, 0)
    Then the king is at (4, 0)
    And the rook is at (7, 0)
    And the knight is at (2, 1)
    
  
    
  
    
    


