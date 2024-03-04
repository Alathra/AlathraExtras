# AlathraExtras Verison 1.1.0
## A pack of random add-ons and bugfixes for AlathraMC

### Custom Voting Listener
A voting listener that checks if a player has voted on ALL vote links for the day. The server will broadcast when a player has voting on all sites instead of for each one or no broadcasts at all.

### Essentials tpa cooldown fix
When a player does not have enough money to use tpa it STILL invokes the cooldown. This listener checks player's balances and cancels the command before the cooldown can be invoked

### Free Op Command
Adds the  /freeop command to the server. The command makes the player say some funnies in the chat instead

### Rotten flesh to leather recipes
Allows players to smelt rotten flesh into "Recycled Leather"

### New death message for players killed by invisible players
Changes the death message to "player has been assassinated by an invisible player"

### Clearing ruined Towns
When a Towny town falls into ruin this features scans each chunk in the town for signs and deletes them. This is so protected chests and playershops are automatically removed when a town gets disbanded

### Tutorial Book
Adds various tutorial book events. Hooks into InteractiveBooks by executing appropriate commands through console.

### Roll
Adds the /roll command to the server. Command can be used to roll dice with modifiers and checks. '/roll 1d6+1>2 to hit' rolls 1 6-sided-die with a modifier of +1 and checks if the value is >2. Returns success or failure regarding the action.

### New Consumables
Adds new consumables being the uncharged silver melon and charged silver melon. They both give Nightvision, Haste, and Weakness at different lengths and levels. 
