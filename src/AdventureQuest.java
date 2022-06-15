import java.util.Scanner;

public class AdventureQuest {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");

        String playerName = scanner.nextLine();

        int playerHP = 10;
        int playerAtk = 3;
        int playerCoins = 0;

        String playerWeapon = "dumb bell";
        System.out.println("");

        while (true) {
            System.out.println("Hi " + playerName);
            System.out.println("Your current HP: " + playerHP);
            System.out.println("Your current weapon: " + playerWeapon);
            System.out.println("Your current attack: " + playerAtk);
            System.out.println("Your current coins: " + playerCoins);
            System.out.println("");

            System.out.println("Where do you want to go?");
            System.out.println("1. Castle");  // King (Kill/ask for his stuff)
            System.out.println("2. Valley");  // Shop
            System.out.println("3. River");   // Dragon
            System.out.println("4. Exit");   // Exit
            System.out.print("action: ");
            int action = scanner.nextInt();
            System.out.println("");
            
            // Castle
            if (action == 1) {
                // Scenario 1
                System.out.println("You see the king on his throne. He asks you what you want.");
                System.out.println("1. Asks for his sword.");
                System.out.println("2. Attack him !!!!.");
                System.out.println("3. Leave");
                System.out.print("action: ");
                action = scanner.nextInt();
                System.out.println("");

                if (action == 1) {
                    System.out.println("He is not very keen to give you his sword. You can try to persuade him.");
                    System.out.print("Try your luck: Pick a number from [1-3] ");
                    int number = scanner.nextInt();
                    int rnd = (int)(Math.random() * 3 + 1);
                    System.out.println("");

                    if (number == rnd) {
                        System.out.println("You got it correct. You managed to persuade the king.");
                        System.out.println("He gives you his sword and some coins");
                        playerCoins += 20;
                        playerWeapon = "sword";
                    } else {
                        System.out.println("Out of luck. You did not managed to persuade him.");
                    }
                } else if (action == 2) {
                    System.out.println("You went up to the throne and try to use your rusty dumb bell to threaten him.");
                    System.out.print("Try your luck: Pick a number from [1-3] ");
                    int number = scanner.nextInt();
                    int rnd = (int)(Math.random() * 6 + 1);
                    
                    System.out.println("");
                    if (number == rnd) {
                        System.out.println("You got it correct. You managed to threaten the king.");
                        System.out.println("He gives you his sword and some coins");
                        playerCoins += 10;
                        playerWeapon = "sword";
                    } else {
                        System.out.println("You did not get it correct. The guards hit you and you lose some health");
                        playerHP -= 2;
                    }
                }
                System.out.println("");
                System.out.println("You now leave the castle.");
                System.out.println("");
            } else if (action == 2) {
                // Valley
                System.out.println("You entered the valley, you saw a shopkeeper. He welcomes you.");
                System.out.println("Your current weapon: " + playerWeapon);
                System.out.println("Your current attack: " + playerAtk);
                System.out.println("Your current coins: " + playerCoins);

                System.out.println("He shows you his items, you can pick one");
                System.out.println("1. Bar bell sword - 19 coins, atk: 100");
                System.out.println("2. Magic wand     - 12 coins, atk: 25");
                System.out.println("3. Wooden spear   - 2 coins, atk: 10");
                System.out.print("action: ");
                action = scanner.nextInt();

                if (action == 1) {
                    if (playerCoins >= 6) {
                        System.out.println("Got the bar bell sword");
                        playerCoins -= 6;
                        playerAtk = 100;
                        playerWeapon = "Bar bell sword";
                    } else {
                        System.out.println("You do not have enough money");
                    }
                }
                else if (action == 2) {
                    if (playerCoins >= 3) {
                        System.out.println("Got the magic wand");
                        playerCoins -= 3;
                        playerAtk = 25;
                        playerWeapon = "Magic wand";
                    } else {
                        System.out.println("You do not have enough money");
                    }
                }
                else if (action == 3) {
                    if (playerCoins >= 2) {
                        System.out.println("Got the wooden spear");
                        playerCoins -= 2;
                        playerAtk = 10;
                        playerWeapon = "Wooden spear";
                    } else {
                        System.out.println("You do not have enough money");
                    }
                }
                System.out.println("");
            } else if (action == 3) {
                // River
                System.out.println("You walk along the river. In front of you, you see a pile of bones.");
                System.out.println("You walk further ahead, you see a dragon flying right above you.");
                System.out.println("Prepare yourself for battle. Draw your weapons.");

                int dragonHealth = 10;
                int dragonAttack = 1;

                // Battle mode
                while (true) {
                    System.out.println("Player Health: " + playerHP + ", Attack: " + playerAtk);
                    System.out.println("Dragon Health: " + dragonHealth + ", Attack: " + dragonAttack);
                    System.out.println("");

                    // How the battle works:
                    // Fighting (1 dmg): 
                    // * 1-3 Miss - 1 dmg
                    // * 4-6 Hit - deal 1 dmg
                    // Escape
                    // * Even number Success
                    // * Odd number take 1 dmg

                    // Fight, there is a chance to inflict damage
                    // Dodge, there is a chance to not lose health
                    // Escape, there is a chance to escape
                    System.out.println("1. Fight");
                    System.out.println("2. Escape");
                    System.out.println("action: ");
                    action = scanner.nextInt();
                    System.out.println("");

                    int rnd = (int)(Math.random() * 6 + 1);

                    if (action == 1) {
                        // Fight
                        if (rnd >= 1 && rnd <= 3) {
                            // Miss
                            System.out.println("You missed, you took " + dragonAttack + " dmg.");
                            playerHP = playerHP - dragonAttack;

                            if (playerHP <= 0) {
                                System.out.println("You died. Game over. ");
                                break;
                            }
                        } else if (rnd >= 4 && rnd <= 6) {
                            // Hit
                            System.out.println("You hit the dragon, it took " + playerAtk + " dmg.");
                            dragonHealth = dragonHealth - playerAtk;

                            if (dragonHealth <= 0) {
                                System.out.println("The dragon died. You win the game");
                                break;
                            }
                        }

                    } else if (action == 2) {
                        // Escape
                        if (rnd % 2 == 1) {
                            System.out.println("You did not escape successfully. Dragon deal " + dragonAttack + " dmg.");
                            playerHP = playerHP - dragonAttack;
                            if (playerHP <= 0) {
                                System.out.println("You died. Game over. ");
                                break;
                            }
                        } else {
                            System.out.println("You have escaped from the dragon.");
                            System.out.println("");
                            break;
                        }
                    }
                    System.out.println("");
                }

            } else if (action == 4) {
                System.out.println("You exit the game.");
                break;
            }
        }
        scanner.close();
    }
}
