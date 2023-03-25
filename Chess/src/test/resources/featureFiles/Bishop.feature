Feature: Bishop

  @tag1
  Scenario: Bishop moving
    Given a game with an empty board
    And a bishop on the board at (5, 5)
    When the bishop makes a valid move
    Then the bishop is on a new square


