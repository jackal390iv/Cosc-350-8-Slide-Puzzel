Jonathan Butler
Puzzel Search Project
Cosc-350
========
Users Guide & Read Me:
________________________________

This project is a coded representation of an 8 piece sliding puzzel. How this program operates is through use of the tester.java class in combination with the node.java class and the puzzel.java class, please run the tester class through the command line, or and ide. From here you will see a brief example of how the program should operate at all times; giving an example of a small, successful search. afte its search it will print the dirrect set of move you could perform from its start state to its finish state; however this print statement is inacurate as the link from child to parent is not coroperating... Then it will then correctly print the full list of moves made by the program in its search. After it has cuncluded its example puzzel it will ask the user to input there own start state and end state, perform a search, and print out the dirrect moves set and the entire search tree. 


Testing:
________________________________

I've tested this code several times; mostly by using the brute force method of print statements and handdrawing logic and algorithms. Every method was tested to work successfully and if possible was improved to run recursively. I created a testing method within the puzzel class, and assigned controled values for the start and end states to change manually in my method testing. I seperated some code into multiple methods, some never used in production, just for testing purposes. However, the link between parent and child node was difficult, and I've also encountered a similar problem on past assignments.. I believe that link and possible an issue with my recussion node creation method "search" is the cause of most of the problems in my code solution. 
