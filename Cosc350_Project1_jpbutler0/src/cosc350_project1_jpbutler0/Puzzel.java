package cosc350_project1_jpbutler0;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Reaper
 */
public class Puzzel {

    int treeSize = 0;
    boolean val = true;
    int childrens = 0;
    ArrayList<Node> theTree = new ArrayList<Node>();
    ArrayList<Node> theSolution = new ArrayList<Node>();
    String base = "";
    char v1 = '1';
    char v2 = '2';
    char v3 = '3';
    char v4 = '4';
    char v5 = '5';
    char v6 = '6';
    char v7 = '7';
    char v8 = '8';
    char v_ = '_';
    Node startState = new Node(v1, v2, v3, v4, v5, v6, v7, v8, v_, null);
    Node endState = new Node(v1, v2, v3, v4, v_, v6, v7, v5, v8, null);

    public Puzzel() {
    }

    /**
     * asks user for a start state and an end state and creates those nodes
     */
    public void startEndState() {

        boolean valid = false;
        Scanner input = new Scanner(System.in);
        String state;
        System.out.println("Welcome, please enter a combination of the following characters as a start state for your puzzel;"
                + "\n"
                + "1,2,3,4,5,6,7,8, and _ (as your blank space): ");
        do {
            state = input.nextLine();
            state.replaceAll(",", "");
            state.replaceAll(" ", "");
            state.toLowerCase();

            valid = validate(state);

            if (valid == false) {
                System.out.println("I am sorry, but the start state you have entered is invalid, please try again: ");
            }

        } while (valid == false);

        Node temp1 = new Node(state.charAt(0), state.charAt(1),
                state.charAt(2), state.charAt(3), state.charAt(4),
                state.charAt(5), state.charAt(6), state.charAt(7),
                state.charAt(8), null);

        startState = temp1;

        //startState.printNode();
        valid = false;
        System.out.println("Thank you, now please enter an end state for your puzzel;"
                + "\n"
                + "using any combination of the the characters you used for your start state: ");
        do {
            state = input.nextLine();
            state.replaceAll(",", "");
            state.replaceAll(" ", "");
            state.toLowerCase();

            valid = validate(state);

            if (valid == false) {
                System.out.println("I am sorry, but the end state you have entered is invalid, please try again: ");
            }

        } while (valid = false);

        Node temp2 = new Node(state.charAt(0), state.charAt(1),
                state.charAt(2), state.charAt(3), state.charAt(4),
                state.charAt(5), state.charAt(6), state.charAt(7),
                state.charAt(8), null);
        endState = temp2;

        //endState.printNode();
        System.out.println("Thank you.");
        theTree.add(startState);
        solver(startState);

    }

    /**
     * checks to see if user input is valid
     *
     * @param state
     * @return
     */
    private boolean validate(String state) {

        boolean valid = false;
        if (state.length() == 9) {
            if (((state.indexOf("1")) != -1) && ((state.indexOf("2")) != -1)
                    && ((state.indexOf("3")) != -1)
                    && ((state.indexOf("4")) != -1)
                    && ((state.indexOf("5")) != -1)
                    && ((state.indexOf("6")) != -1)
                    && ((state.indexOf("7")) != -1)
                    && ((state.indexOf("8")) != -1)
                    && ((state.indexOf("_")) != -1)) {
                valid = true;
            }
        }
        return valid;
    }

    /**
     * checks to see if the current node is equivalent to the end state that the
     * user specified
     *
     * @param currentState
     * @return
     */
    public boolean endChecker(Node currentState) {
        val = false;
        if ((currentState.state[0][0] == endState.state[0][0]) && (currentState.state[0][1] == endState.state[0][1]) && (currentState.state[0][2] == endState.state[0][2])
                && (currentState.state[1][0] == endState.state[1][0]) && (currentState.state[1][1] == endState.state[1][1]) && (currentState.state[1][2] == endState.state[1][2])
                && (currentState.state[2][0] == endState.state[2][0]) && (currentState.state[2][1] == endState.state[2][1]) && (currentState.state[2][2] == endState.state[2][2])) {
            val = true;

        }
        return val;
    }

    /**
     * checks to see if the current node is equivalent to the start state that
     * the user specified
     *
     * @param currentState
     */
    public boolean notInTree(Node currentState, int loc) {
        val = true;
        if (loc < theTree.size()) {
            if (!((currentState.state[0][0] == theTree.get(loc).state[0][0]) && (currentState.state[0][1] == theTree.get(loc).state[0][1]) && (currentState.state[0][2] == theTree.get(loc).state[0][2])
                    && (currentState.state[1][0] == theTree.get(loc).state[1][0]) && (currentState.state[1][1] == theTree.get(loc).state[1][1]) && (currentState.state[1][2] == theTree.get(loc).state[1][2])
                    && (currentState.state[2][0] == theTree.get(loc).state[2][0]) && (currentState.state[2][1] == theTree.get(loc).state[2][1]) && (currentState.state[2][2] == theTree.get(loc).state[2][2]))) {
                notInTree(currentState, loc + 1);
            } else {
                val = false;
            }
        }
        return val;
    }

    /**
     * prints the search tree
     *
     * @param loc
     */
    public void printTheTree(int loc) {
        if (loc < theTree.size()) {
            theTree.get(loc).printNode();
            printTheTree(loc + 1);
        }
    }

    /**
     * returns how many real children the node has
     *
     * @param currentState
     * @return
     */
    public int numberOfRealKids(Node currentState) {
        int kids = 0;
        if (currentState.getFirstChild() != null) {
            kids++;
        }
        if (currentState.getSecondChild() != null) {
            kids++;
        }
        if (currentState.getThirdChild() != null) {
            kids++;
        }
        if (currentState.getFourthChild() != null) {
            kids++;
        }
        return kids;
    }

    /**
     * compares node children
     *
     * @param currentState
     * @param cha
     * @return
     */
    public boolean compareChildren(Node currentState, String cha) {
        boolean valid = true;
        if (currentState.getFirstChild() != null) {
            if (currentState.getFirstChild().getMove().endsWith(cha)) {
                valid = false;
            }
        }
        if (currentState.getSecondChild() != null) {
            if (currentState.getSecondChild().getMove().endsWith(cha)) {
                valid = false;
            }
        }
        if (currentState.getThirdChild() != null) {
            if (currentState.getThirdChild().getMove().endsWith(cha)) {
                valid = false;
            }
        }
        if (currentState.getFourthChild() != null) {
            if (currentState.getFourthChild().getMove().endsWith(cha)) {
                valid = false;
            }
        }
        return valid;
    }

    /**
     * a tester method I used for short hand testing
     */
    public void testing() {
        theTree.add(startState);
        solver(startState);
    }

    public void workingTree() {
        if (treeSize < theTree.size()) {
            solver(theTree.get(treeSize));
        } else {
            System.out.println("Sequence Not Found, soulution imposible");
            //printTheTree(0);
        }
    }

    /**
     * searches the puzzel
     *
     * @param currentState
     */
    public void solver(Node currentState) {

        //System.out.println("NEW LOOP: ");
        //currentState.printNode();
        currentState.findBlank();
        currentState.setBlankLoc();

        if (endChecker(currentState) == false) {
            Node temp = new Node(currentState.state[0][0], currentState.state[0][1],
                    currentState.state[0][2], currentState.state[1][0], currentState.state[1][1],
                    currentState.state[1][2], currentState.state[2][0], currentState.state[2][1],
                    currentState.state[2][2], currentState);

            if ((currentState.getChildren() == 2) && (((currentState.theUpEX() == false) && (currentState.theDownEX() == true) && (currentState.theLeftEX() == true) && (currentState.theRightEX() == false))
                    || ((currentState.theUpEX() == false) && (currentState.theDownEX() == true) && (currentState.theLeftEX() == false) && (currentState.theRightEX() == true))
                    || ((currentState.theUpEX() == true) && (currentState.theDownEX() == false) && (currentState.theLeftEX() == true) && (currentState.theRightEX() == false))
                    || ((currentState.theUpEX() == true) && (currentState.theDownEX() == false) && (currentState.theLeftEX() == false) && (currentState.theRightEX() == true)))) {
                currentState.finishedWithKids();
                //System.out.println("2 children");
                treeSize++;
                workingTree();

            } else if ((currentState.getChildren() == 3) && (((currentState.theUpEX() == false) && (currentState.theDownEX() == true) && (currentState.theLeftEX() == true) && (currentState.theRightEX() == true))
                    || ((currentState.theUpEX() == true) && (currentState.theDownEX() == false) && (currentState.theLeftEX() == true) && (currentState.theRightEX() == true))
                    || ((currentState.theUpEX() == true) && (currentState.theDownEX() == true) && (currentState.theLeftEX() == false) && (currentState.theRightEX() == true))
                    || ((currentState.theUpEX() == true) && (currentState.theDownEX() == true) && (currentState.theLeftEX() == true) && (currentState.theRightEX() == false)))) {
                currentState.finishedWithKids();
                //System.out.println("3 children");
                treeSize++;
                workingTree();
            } else if ((currentState.getChildren() == 4) && (((currentState.theUpEX() == true) && (currentState.theDownEX() == true) && (currentState.theLeftEX() == true) && (currentState.theRightEX() == true)))) {
                currentState.finishedWithKids();
                //System.out.println("4 children");
                treeSize++;
                workingTree();
            } else if ((currentState.theUpEX()) && (compareChildren(currentState, "U")) == true) {
                int originalv = currentState.getblankLoc();
                int modv = originalv % 10;
                int secondv = modv - 1;
                int firstv = ((originalv - modv) - 10) / 10;
                temp.setMove(currentState.getMove(), "U");
                temp.incrementDepth(currentState.getDepth() + 1);
                temp.state[firstv][secondv] = currentState.state[firstv - 1][secondv];
                temp.state[firstv - 1][secondv] = currentState.state[firstv][secondv];
                temp.childNumChange(currentState.getChildren() + 1);
                currentState.addChild();
                val = true;
                if (notInTree(temp, 0) == true) {
                    currentState.settingChildren(temp);
                    theTree.add(temp);
                    if (endChecker(temp) == true) {
                        solver(temp);
                    }
                    //temp.printNode();
                }
                solver(currentState);
            } else if ((currentState.theDownEX()) && (compareChildren(currentState, "D") == true)) {
                int originalv = currentState.getblankLoc();
                int modv = originalv % 10;
                int secondv = modv - 1;
                int firstv = ((originalv - modv) - 10) / 10;
                temp.setMove(currentState.getMove(), "D");
                temp.incrementDepth(currentState.getDepth() + 1);
                temp.state[firstv][secondv] = currentState.state[firstv + 1][secondv];
                temp.state[firstv + 1][secondv] = currentState.state[firstv][secondv];
                temp.childNumChange(currentState.getChildren() + 1);
                currentState.addChild();
                val = true;
                if (notInTree(temp, 0) == true) {
                    currentState.settingChildren(temp);
                    theTree.add(temp);
                    if (endChecker(temp) == true) {
                        solver(temp);
                    }
                    //temp.printNode();
                }
                solver(currentState);
            } else if ((currentState.theLeftEX()) && (compareChildren(currentState, "L")) == true) {

                int originalv = currentState.getblankLoc();
                int modv = originalv % 10;
                int secondv = modv - 1;
                int firstv = ((originalv - modv) - 10) / 10;
                temp.setMove(currentState.getMove(), "L");
                temp.incrementDepth(currentState.getDepth() + 1);
                temp.state[firstv][secondv] = currentState.state[firstv][secondv - 1];
                temp.state[firstv][secondv - 1] = currentState.state[firstv][secondv];
                temp.childNumChange(currentState.getChildren() + 1);
                currentState.addChild();
                val = true;
                if (notInTree(temp, 0) == true) {
                    currentState.settingChildren(temp);
                    theTree.add(temp);
                    if (endChecker(temp) == true) {
                        solver(temp);
                    }
                    //temp.printNode();
                }
                solver(currentState);
            } else if ((currentState.theRightEX()) && (compareChildren(currentState, "R")) == true) {
                int originalv = currentState.getblankLoc();
                int modv = originalv % 10;
                int secondv = modv - 1;
                int firstv = ((originalv - modv) - 10) / 10;
                temp.setMove(currentState.getMove(), "R");
                temp.incrementDepth(currentState.getDepth() + 1);
                temp.state[firstv][secondv] = currentState.state[firstv][secondv + 1];
                temp.state[firstv][secondv + 1] = currentState.state[firstv][secondv];
                temp.childNumChange(currentState.getChildren() + 1);
                currentState.addChild();
                val = true;
                if (notInTree(temp, 0) == true) {
                    currentState.settingChildren(temp);
                    theTree.add(temp);
                    if (endChecker(temp) == true) {
                        solver(temp);
                    }
                    //temp.printNode();
                }
                solver(currentState);
            } else {

                System.out.println("NOPE$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                printTheTree(0);
            }

        } else {
            endGame(currentState);
        }
    }

    /**
     * after thew end state is found this method prints the direct solution and
     * the varbose solution
     *
     * @param currentState
     */
    public void endGame(Node currentState) {
        System.out.println("Solution Found!");
        currentState.printNode();
        System.out.println("To directly solve this puzzel you should make the following moves (Warning: the parent to child conection is having issues..): ");
        setSolution(currentState);
        for (int i = theSolution.size() - 1; i < 0; i--) {
            theSolution.get(i).printNode();
        }
        System.out.println("However if you would like to see how the code searches: ");
        printTheTree(0);
    }

    /**
     * this method puts the dirrect solution into an arraylist
     *
     * @param currentState
     */
    public void setSolution(Node currentState) {
        theSolution.add(currentState);
        if (currentState.getParent() != null) {
            setSolution(currentState.getParent());
        }
    }
}
