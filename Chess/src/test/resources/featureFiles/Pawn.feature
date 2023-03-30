Feature: Pawn

  Scenario: White pawn moves 1
    Given a game with an empty board
    And a white pawn on the board at (5, 5)
    When the pawn moves forward 1
    Then the pawn is at position (5, 6)
    And there is no piece at (5, 5)
    
	Scenario: Black pawn moves 1
    Given a game with an empty board
    And a black pawn on the board at (5, 5)
    When the pawn moves forward 1
    Then the pawn is at position (5, 4)
    And there is no piece at (5, 5)

  Scenario: White pawn moves 2 at start of game
    Given a game with an empty board
    And a white pawn on the board at initial position (2, 1)
    When the pawn moves forward 2
    Then the pawn is at position (2, 3)
    And there is no piece at (2, 1)
      
	Scenario: Black pawn moves 2 at start of game
    Given a game with an empty board
    And a black pawn on the board at initial position (2, 6)
    When the pawn moves forward 2
    Then the pawn is at position (2, 4)
    And there is no piece at (2, 6)
    
   Scenario: White pawn takes a piece
    Given a game with an empty board
    And a white pawn on the board at (5, 5)
    And a black piece on the board at (6, 6)
    When the pawn takes the piece at (6, 6)
    Then the pawn is at position (6, 6)
    And the black piece is not longer at (6, 6)
    
   Scenario: Black pawn takes a piece
    Given a game with an empty board
    And a black pawn on the board at (5, 5)
    And a white piece on the board at (4, 4)
    When the pawn takes the piece at (4, 4)
    Then the pawn is at position (4, 4)
    And the white piece is not longer at (4, 4)
    
   Scenario: white pawn tries to take white piece
    Given a game with an empty board
    And a white pawn on the board at (5, 5)
    And a white piece on the board at (6, 6)
    When the pawn takes the piece at (6, 6)
    Then the pawn is still at position (5, 5)
    And the white piece is still at (6, 6)
    
   Scenario: black pawn tries to take black piece
    Given a game with an empty board
    And a black pawn on the board at (5, 5)
    And a black piece on the board at (4, 4)
    When the pawn takes the piece at (4, 4)
    Then the pawn is still at position (5, 5)
    And the black piece is still at (4, 4)
    
    
    