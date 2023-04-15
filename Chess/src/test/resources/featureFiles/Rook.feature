Feature: Rook


Scenario: Rook moves
    Given a game with an empty board
    And a rook on the board at (5, 5)
    When the rook moves to (1, 5)
    Then the rook is at (1, 5)
    And there is no piece at (5, 5)


Scenario: Rook attempts illegal move
    Given a game with an empty board
    And a rook on the board at (5, 5)
    When the rook tries to move to (7, 7)
    Then there is no piece on the new square
    And the rook is still at the old position
    
Scenario: White rook tries to move to an occupied square
    Given a game with an empty board
    And a white rook on the board at (5, 5)
    And a white pawn on the board at (1, 7)
    When the rook tries to move to (1, 7)
    Then the white pawn is still at (1, 7)
    And the rook is at (5, 5)
    
Scenario: White rook takes black piece
    Given a game with an empty board
    And a white rook on the board at (5, 7)
    And a black pawn on the board at (1, 7)
    When the rook moves to (1, 7)
    And the rook is at (1, 7)
    And the black pawn is no longer at (1, 7)