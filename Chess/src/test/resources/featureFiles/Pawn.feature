Feature: Pawn

  @tag1
  Scenario: White pawn moves 1
    Given a game with an empty board
    And a white pawn on the board at (5, 5)
    When the pawn moves forward 1
    Then the pawn is at position (5, 6)
    
    
  @tag1  
	Scenario: Black pawn moves 1
    Given a game with an empty board
    And a black pawn on the board at (5, 5)
    When the pawn moves forward 1
    Then the pawn is at position (5, 4)

  @tag1
  Scenario: White pawn moves 2 at start of game
    Given a game with an empty board
    And a white pawn on the board at initial position (2, 1)
    When the pawn moves forward 2
    Then the pawn is at position (2, 3)
    
    
  @tag1  
	Scenario: Black pawn moves 2 at start of game
    Given a game with an empty board
    And a black pawn on the board at initial position (2, 6)
    When the pawn moves forward 2
    Then the pawn is at position (2, 4)