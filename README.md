Adventure Game

This is a simple text-based adventure game implemented in Java. The game involves a player character navigating through various locations, battling monsters, and collecting items. The player can choose different character classes, each with unique attributes, and can equip weapons and armor to improve their chances of survival.

Project Structure

The project is organized into the following files and classes:

Main Classes
Main.java: The entry point of the game. This class initializes the game and starts the game loop.
Game.java: This class manages the overall game flow, including the main game loop and interactions between the player and locations.

Player and Characters

Player.java: Represents the player character. It includes attributes such as health, damage, and inventory management.
GameCharacter.java: An abstract class that serves as the base for different game characters.
Archer.java, Knight.java, Samurai.java: Subclasses of GameCharacter, each representing a different player class with unique attributes.

Inventory and Items

Inventory.java: Manages the player's inventory, including weapons and armor.
Weapon.java: Represents weapons that the player can equip.
Armor.java: Represents armor that the player can equip.

Locations and Battles

Location.java: An abstract class that serves as the base for different game locations.
NormalLocation.java: A subclass of Location representing non-combat locations.
BattleLocation.java: A subclass of Location representing combat locations.
SafeHouse.java: A safe location where the player can rest and recover health.
ToolStore.java: A location where the player can buy weapons and armor.

Specific Locations

Cave.java, Forest.java, River.java: Subclasses of BattleLocation, each representing a different location with unique monsters and challenges.
Monsters
Monster.java: An abstract class that serves as the base for different monsters.
Bear.java, Vampire.java, Zombie.java: Subclasses of Monster, each representing a different type of enemy with unique attributes.
Miscellaneous
BattleLocation.java: Handles battles between the player and monsters.
.gitignore: Specifies files and directories to be ignored by Git.
AdventureGame.iml: IntelliJ IDEA module file.
How to Play
Clone the repository to your local machine.
Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
Compile and run the Main.java class to start the game.
Follow the on-screen instructions to create your character, explore locations, battle monsters, and collect items.

Character Classes

Archer: High agility and ranged attack capabilities.
Knight: Balanced attributes with strong defense.
Samurai: High damage output and critical hit chance.

Locations

Safe House: Rest and recover health.
Tool Store: Buy weapons and armor.
Cave: Battle bears.
Forest: Battle vampires.
River: Battle zombies.
Monsters
Bear: Strong and durable, found in caves.
Vampire: Agile and elusive, found in forests.
Zombie: Slow but resilient, found in rivers.

License

This project is licensed under the MIT License. See the LICENSE file for details.

Contributions
Contributions are welcome! Please fork the repository and submit pull requests for any improvements or bug fixes.

Contact
For any questions or support, please contact the project maintainer.

Enjoy the game and happy adventuring!
