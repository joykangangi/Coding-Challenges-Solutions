# Coding-Challenges-Solutions
Various solutions to coding challenges that I find interesting/need serious thinking.
Below are links to the projects' solutions with description of how I understood the problem and came up with the solution.

### [ConnectFour](https://github.com/joykangangi/Coding-Challenges-Solutions/tree/main/ConnectFour).
The project is from the [Jetbrains Academy](https://hyperskill.org/projects/202).
##### About 
Connect Four is a fun game for two players. The players place discs on a vertical board that is 7 columns wide and 6 rows tall. The goal of the game is to be the first to form a horizontal, vertical, or diagonal line of four discs. In this project, you will develop this game with a number of improvements.
Kotlin concepts covered are: 
- data structures
- conditions 
-  loops
It has five main stages listed below.
#### [Stage One](https://github.com/joykangangi/Coding-Challenges-Solutions/blob/main/ConnectFour/Stage%20One%20Solution)
The input can be either empty,i.e. the default dimension or typed by a user.
The typed input can:
1. match regex 
    ``` val regex = buildString {
    append("[5-9].?x.?[5-9]")
    }.toRegex()
    ```
2. Not match the above regex- when it does not match the regex the errors can be:-
      1. Wrong Row, e.g. 1 x 6.
      2. Wrong Column, e.g. 7 x 15.
      3. Wrong Format, e.g. 12 k 5 or 6X.
  
 Any wrong format or another undefined input will display an error of 'Invalid input'.
 For easy processing of input, once the input is read, extra whitespace at the start and end are trimmed, then converted to lowercase and finally if there is another double whitespace in the input it will be converted to a single whitespace.
 ```
 var dimInput = readLine()
    dimInput = dimInput!!.trim().lowercase().replace("\\s+".toRegex(), " ")
 ```
    
