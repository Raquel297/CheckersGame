# Checkers Game
I decided to take the initiative to build my own software project. My first endeavor is a game that allows you to play against an AI algorithm that will either always win or tie the game. There are more updates coming soon to this ReadMe file and I will put program files here too. The ReadMe file will contain the specifications of the program, my thought-process about why I chose certain programming concepts instead of others, and the difficulties I faced programming this game. When code files are submitted, please feel free to make suggestions (if you are an experienced programmer) for improvements of my code (especially if there are improvements for the running-time and space-complexity). <br /><br />
UPDATE: I will have to take a 2 week hiatus due to software internship programming assessments. When I am finished with studying for and completing my assessments, I will add more methods to this program. <br /><br />

I am expected to write other game functions (besides the minimax algorithm) that the game will need such as: isGameOver(), evaluation(), getMoves(), makeAMove(). My ultimate ambition is to implement a nice looking GUI (graphic user Interface) for my game. 
# Technical Specifications
Integrated Development Environment Used: Netbeans 8.2<br />
Programming Language Used: Java
# Written Plans
Before writing the program in my IDE, I needed to plan what data structures I am going to use to represent different parts of the game. I also needed to figure out what 
was the best programming language to use. I decided to use java because although I am familiar with C++, I haven't used it in a few semesters and currently in school I am most 
acquainted with java. Also, java has many graphics libraries I can use to implement the GUI. For the AI player, I am using a modified version of the minimax algorithm. The minimax algorithm is a useful tool that allows the computer to play perfectly against a human by assuming that the human will always play perfectly against it. I currently only drew a board (which will be modified when I implement graphics programming). I plan to turn the raw minimax algorithm into code (with alpha-beta pruning), but I won't code the finalized modified version until I am finished learning/figuring-out how to do it. So far, I've come to the conclusion that the game tree for checkers is a rooted tree of height log_9(n) where each node has 9 children and n is the total number of game states possible. This forces me to modify the minimax algorithm I wrote to accomodate 9 children on each level and I also have to modify my for-loops from 0 to 9 to perform alhpa-beta pruning. 
# Testing the Code and Bugs I faced
So far I haven't faced any bugs because the program is simplistic enough. There will be more updates with regards to bug issues when I modify the minimax algorithm to work on checkers such that it works with the other funtions I listed above. 
# Graphic User Interface (GUI) Programming 
