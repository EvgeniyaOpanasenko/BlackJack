# BlackJack

Write a Spring MVC Java web application that simulates the following simplified blackjack game. For each game two cards will be drawn for the player (you) and the dealer from four new decks (52 cards per deck) that needs to be shuffled. The program will deal two cards face up for the player and deal one card face up and one card face down (hidden card) for the dealer. Whenever the sum of the displayed cards for the player is less than 21, the player can decide whether they will hit (receive another card). The hand continues until the player decides to stand (not receive another card) or they bust (their sum is over 21). After that, if the player has not busted, the dealer must hit until the sum of the cards is 17 or more. The player wins by not busting and having a total higher than the dealer's. The dealer loses by busting or having a lesser total than the player. If you and the dealer have the same total, it is considered a push and it is a tie. If the player busts, the dealer wins and they do not need to draw any cards.

The player must play at least one game and can decide before each game if they want to play another game or if they would like to stop playing.

Blackjack Rules:

Use the following rules to calculate the score (total):

- Ace : +1 or +11 (The dealer’s ace is always counted as 11. However, if the Ace makes the dealer’s total over 21, it is counted as 1.)

- 10, jack, queen, king : +10

- 2 to 9 : + its value.

This simplified blackjack game has no splitting, no doubling down, and no insurance.

The GUI component to the application should be a simple view that displays:

    The player's cards with the total score
    The dealer's cards with the total score
    A button for the player to stand (if possible)
    A button for the player to hit (if possible)
    The outcome of the game once completed
    A button to start a new game (if possible)
