**Snake And Ladder Game**

**Domain Objects** 
- Game
- Board
- Ladder
- Snake
- Player

**Implementation details**

- Modelled the board as 10x10 grid, for visualizing the game and simulation
representing each position in the grid in following pattern

[(position)(S:snakePositons)(L:ladderPositions)(players)]

position - position on the board
snakes - snakes at the position
ladder - ladder at the position
players - player at that position 

Sample Board for reference:

[(91)] [(92)] [(93)] [(94)] [(95)] [(96)] [(97)] [(98)] [(99)] [(100)]
[(81)] [(82)] [(83)] [(84)] [(85)] [(86)] [(87)] [(88)(L:27->88)] [(89)(L:74->89)] [(90)]
[(71)] [(72)] [(73)] [(74)(S:74->58)(L:74->89)] [(75)] [(76)] [(77)] [(78)] [(79)] [(80)(L:39->80)]
[(61)] [(62)] [(63)] [(64)] [(65)(S:65->10)(L:65->70)] [(66)] [(67)] [(68)(L:12->68)] [(69)] [(70)(L:65->70)]
[(51)] [(52)] [(53)] [(54)] [(55)] [(56)] [(57)] [(58)(S:74->58)] [(59)] [(60)]
[(41)] [(42)] [(43)] [(44)] [(45)] [(46)] [(47)] [(48)] [(49)] [(50)]
[(31)] [(32)(S:35->32)] [(33)] [(34)] [(35)(S:35->32)] [(36)] [(37)] [(38)] [(39)(L:39->80)] [(40)]
[(21)] [(22)] [(23)] [(24)] [(25)] [(26)] [(27)(L:27->88)] [(28)] [(29)] [(30)]
[(11)] [(12)(L:12->68)] [(13)] [(14)(S:14->7)] [(15)] [(16)] [(17)] [(18)] [(19)] [(20)]
[(1)(S:5->1)] [(2)] [(3)(JC,)] [(4)] [(5)(S:5->1)] [(6)] [(7)(S:14->7)] [(8)] [(9)] [(10)(S:65->10)]

- Also printing the board after each turn to easily visualize the game progress

- Made the board generation config based, a board would be generated randomly based on input config and multiple games can be played on the board.

- No of players, no of snakes, no of ladders, no of games in a simulation are configurable,

- Captured all the required stats at game level (game stats) and aggregating them across all the games in the simulation.

- Using the random dice in actual simulation and fake dice (a test double) to generate a predefined dice sequence in case of tests.


