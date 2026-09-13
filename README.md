# eternal-flame-text-rpg

Eternal Flame is a text-based RPG built in Java where the player names their hero and sets out on an adventure to save the kingdom from doom. The journey unfolds across four mini missions, where each one a combat encounter that tests the player's strategy before fighting the boss. Along the way, players can loot enemies for resources, stock up at the shop, and build their character up for the final fight.

---

## 🛠️ Tech Stack

- **Language:** Java
- **OOP Concepts:** Encapsulation, Inheritance, Polymorphism, Abstraction
- **Design Principles:** SOLID Principles
- **Design Pattern:** Strategy Pattern

---

## ✨ Features

- 4 mini combat encounters leading up to a final boss battle
- Loot system — collect drops from defeated enemies
- Potion shop — purchase items between missions to prepare for what's ahead

---

## ⌨️ Shortcuts


 `skip` : Skip the story narration sequence   

---

## 🧠 Development Process

Planning came first. Before writing a single line of code, the main game loop was mapped out — what sequence of events the player would experience, which features were needed, and which parts of the game logic would be repeated and needed to be reused. From there, concrete classes were designed with inheritance and abstraction in mind, and the Strategy pattern was identified early as a good fit for swappable combat behaviors. Once the core was working, the focus shifted to cleanup: reducing redundant code, trimming bloated interfaces, and getting a second opinion from Claude on best practices and anything that might have been missed.

---

## 📚 What I Learned

- How to recognize areas in existing code that can be strengthened, rather than just getting it to work and moving on
- The skill of reading code and identifying where a design pattern can cleanly replace a large function
- How to apply the Strategy pattern to swap behaviors at runtime without rewriting large blocks of logic
- The value of planning class hierarchies before writing code, a clear structure upfront saved a lot recodding 

---

## 🔧 What Can Be Improved

- **In-combat HUD:** Currently the player doesn't see live HP values during a fight — both the hero's and the enemy's HP should be visible at all times *(in progress)*
- **Code efficiency:** There are still areas to revisit for cleaner, more concise logic
- **Save/load system:** Players currently have to start from the beginning each session — a save state would improve the experience significantly
- **Character classes:** Introducing archetypes like Warrior, Mage, or Rogue with different stat builds would add meaningful player choice

---

## ▶️ How to Run

1. Clone or download the repository
2. Open the project in your preferred Java IDE
3. Run **`Main.java`** located at: 'eternal-flame/src/main/java/textrpg/game/Main.java'

## Demo