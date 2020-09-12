# Checkers Game

UPDATE: Modifications to the program will be added again on September 12th, 2020 on Saturday. The GUI interface programming will come later (in approximately 3 weeks from September 12th). I added more and different text to the written plans section


I decided to take the initiative to build my own software project. My first endeavor is a game that allows you to play against an AI algorithm that will either always win or tie the game. There are more updates coming soon to this ReadMe file and I will put program files here too. The ReadMe file will contain the specifications of the program, my thought-process about why I chose certain programming concepts instead of others, and the difficulties I faced programming this game. When code files are submitted, please feel free to make suggestions (if you are an experienced programmer) for improvements of my code (especially if there are improvements for the running-time and space-complexity). my ultimate goal is to implement a nice looking GUI for the checkers game.<br /><br />
# Technical Specifications
Integrated Development Environment Used: Netbeans 8.2<br />
Programming Language Used: Java 7
# Written Plans
Before writing the program in my IDE, I needed to plan what data structures I am going to use to represent different parts of the game. I also needed to figure out what 
was the best programming language to use. I decided to use java because although I am familiar with C++, I haven't used it in a few semesters and currently in school I am most 
acquainted with java. Also, java has many graphics libraries I can use to implement the GUI. I learned the minimax algorithm from the classic artificial intelligence textbook: Artificial Intelligence, A Modern Approach by Stuart Russell and Peter Norvig. For the AI player, I am using a modified version of the minimax algorithm. The minimax algorithm is a useful tool that allows the computer to play perfectly against a human by assuming that the human will always play perfectly against it. I turned the raw minimax algorithm into code (with alpha-beta pruning). So far, I've come to the conclusion that the game tree for checkers is a rooted tree of height that is approximately log_7(n) where each node has 7 children and n is the total number of game states possible. This forces me to modify the minimax algorithm I wrote to accomodate approximately 7 children on each level and I also have to modify my for-loops from 0 to 6 to perform alhpa-beta pruning. If the depth of the search tree created by the minimax algorithm is m and there are b nodes on each level of the tree, then the worst case running-time is O(b^m). This is a very poor running-time for games with either many game states or a deep depth. 
# Testing the Code and Bugs I faced
So far I haven't faced any bugs because the program is simplistic enough. There will be more updates with regards to bug issues when I modify the minimax algorithm to work on checkers such that it works with the other funtions I listed above. 
# Graphic User Interface (GUI) Programming 
