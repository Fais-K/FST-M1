import random

play = True

while play==True:
    print("Rock, paper, scissors!\n")


    options = ["Rock", "Paper", "Scissors"]

    player1 = random.choice(options)

    print("Player 1: " + player1)

    player2 = random.choice(options)

    print("Player 2: " + player2)

    if (player1 == "Rock" and player2 == "Scissors") or (player1 == "Scissors" and player2 == "Paper") or (player1 == "Paper" and player2 == "Rock"):
        print("Player 1 won!")
    elif player1 == player2:
        print("It's a tie!")
    else:
        print("Player 2 won!")

    while True:
        decision = input("Do you want to play again? Yes/No ").lower()

        if decision == "yes":
            play = True
            break
        elif decision == "no":
            print("Thanks for playing!")
            play = False
            break
        else:
            print("Invalid option. Try again!")

