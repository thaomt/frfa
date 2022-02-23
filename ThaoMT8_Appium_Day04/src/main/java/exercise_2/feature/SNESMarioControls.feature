Feature: SNES Mario Controls
Scenario: Mario jumps
 Given a level is started
 When the player pushes the "A" button Or the player pushes the "B" button
 Then Mario jumps straight up
Scenario Outline: Mario jumps
 Given a level is started
 When the player pushes the "<letter>" button
 Then Mario jumps straight up

 Examples: Buttons
 | letter |
 | A |
 | B |