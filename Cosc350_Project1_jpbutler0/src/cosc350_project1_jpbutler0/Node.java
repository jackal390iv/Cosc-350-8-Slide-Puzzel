package cosc350_project1_jpbutler0;

/**
 *
 * @author Reaper
 */
public class Node {

    char[][] state = new char[3][3];
    int depth;
    Node parent;
    String move = "Move: ";
    int childNumber;
    int blankLocation;
    boolean rightex;
    boolean leftex;
    boolean upex;
    boolean downex;
    boolean allChildren;
    int children;
    Node firstChild = null;
    Node secondChild = null;
    Node thirdChild = null;
    Node fourthChild = null;

    /**
     * creates the node
     *
     * @param row1col1
     * @param row1col2
     * @param row1col3
     * @param row2col1
     * @param row2col2
     * @param row2col3
     * @param row3col1
     * @param row3col2
     * @param row3col3
     * @param p
     * @param d
     * @param m
     * @param ch
     */
    public Node(char row1col1, char row1col2, char row1col3, char row2col1,
            char row2col2, char row2col3, char row3col1, char row3col2,
            char row3col3, Node p) {

        state[0][0] = row1col1;
        state[0][1] = row1col2;
        state[0][2] = row1col3;

        state[1][0] = row2col1;
        state[1][1] = row2col2;
        state[1][2] = row2col3;

        state[2][0] = row3col1;
        state[2][1] = row3col2;
        state[2][2] = row3col3;

    }

    /**
     * this method finds the nodes blank spot
     */
    public void findBlank() {
        char v_ = '_';
        blankLocation = 11;
        if (this.state[0][1] == v_) {
            blankLocation = 12;
        } else if (this.state[0][2] == v_) {
            blankLocation = 13;
        } //-----------------------------------------------
        else if (this.state[1][0] == v_) {
            blankLocation = 21;
        } else if (this.state[1][1] == v_) {
            blankLocation = 22;
        } else if (this.state[1][2] == v_) {
            blankLocation = 23;
        } //-----------------------------------------------
        else if (this.state[2][0] == v_) {
            blankLocation = 31;
        } else if (this.state[2][1] == v_) {
            blankLocation = 32;
        } else if (this.state[2][2] == v_) {
            blankLocation = 33;
        }
    }

    /**
     * this method sets a value to the nodes blank spot
     */
    public void setBlankLoc() {
        if (blankLocation == 11) {
            downex = true;
            rightex = true;
        } else if (blankLocation == 12) {
            downex = true;
            rightex = true;
            leftex = true;
        } else if (blankLocation == 13) {
            downex = true;
            leftex = true;
        } else if (blankLocation == 21) {
            downex = true;
            upex = true;
            rightex = true;
        } else if (blankLocation == 22) {
            downex = true;
            rightex = true;
            leftex = true;
            upex = true;
        } else if (blankLocation == 23) {
            downex = true;
            upex = true;
            leftex = true;
        } else if (blankLocation == 31) {
            upex = true;
            rightex = true;
        } else if (blankLocation == 32) {
            upex = true;
            rightex = true;
            leftex = true;
        } else if (blankLocation == 33) {
            upex = true;
            leftex = true;
        }
    }

    /**
     * this method places the nodes children in their proper place
     *
     * @param c
     */
    public void settingChildren(Node c) {
        if (children == 1) {
            setFirstChild(c);
        } else if (children == 2) {
            setSecondChild(c);
        } else if (children == 3) {
            setThirdChild(c);
        } else if (children == 4) {
            setFourthChild(c);
        }
    }

    /**
     * this methos sets a node as the first child
     *
     * @param c
     */
    public void setFirstChild(Node c) {
        firstChild = c;
    }

    /**
     * this methos sets a node as the second child
     *
     * @param c
     */
    public void setSecondChild(Node c) {
        secondChild = c;
    }

    /**
     * this methos sets a node as the third child
     *
     * @param c
     */
    public void setThirdChild(Node c) {
        thirdChild = c;
    }

    /**
     * this methos sets a node as the fourth child
     *
     * @param c
     */
    public void setFourthChild(Node c) {
        fourthChild = c;
    }

    /**
     * this method returns the nodes first child
     *
     * @return
     */
    public Node getFirstChild() {
        return firstChild;
    }

    /**
     * this method returns the nodes second child
     *
     * @return
     */
    public Node getSecondChild() {
        return secondChild;
    }

    /**
     * this method returns the nodes third child
     *
     * @return
     */
    public Node getThirdChild() {
        return thirdChild;
    }

    /**
     * this method returns the nodes fourth child
     *
     * @return
     */
    public Node getFourthChild() {
        return fourthChild;
    }

    /**
     * returns true if a right move is possible
     *
     * @return
     */
    public boolean theRightEX() {
        return rightex;
    }

    /**
     * returns true if a left move is possible
     *
     * @return
     */
    public boolean theLeftEX() {
        return leftex;
    }

    /**
     * returns true if a up move is possible
     *
     * @return
     */
    public boolean theUpEX() {
        return upex;
    }

    /**
     * returns true if a down move is possible
     *
     * @return
     */
    public boolean theDownEX() {
        return downex;
    }

    /**
     * sets all children to true, the node has completed making its children
     */
    public void finishedWithKids() {
        allChildren = true;
    }

    /**
     * returns true the node has all its children
     *
     * @return
     */
    public boolean hasAllChildren() {
        return allChildren;
    }

    /**
     * returns the location of the blank space
     *
     * @return
     */
    public int getblankLoc() {
        return blankLocation;
    }

    /**
     * sets the parent node
     *
     * @param p
     */
    public void setParent(Node p) {
        parent = p;
    }

    /**
     * changes the childNumber
     *
     * @param childNum
     */
    public void childNumChange(int childNum) {
        childNumber = childNum;
    }

    /**
     * returns the child number
     *
     * @return
     */
    public int getchildNum() {
        return childNumber;
    }

    /**
     * returns the number of children
     *
     * @return
     */
    public int getChildren() {
        return children;
    }

    /**
     * increments children
     */
    public void addChild() {
        children++;
    }

    /**
     * returns the move string
     *
     * @return
     */
    public String getMove() {
        return move;
    }

    /**
     * returns the parent node
     *
     * @return
     */
    public Node getParent() {
        return parent;
    }

    /**
     * adds to the node string
     *
     * @param d
     */
    public void setMove(String parentMove, String childMove) {
        move = parentMove + childMove;
    }

    /**
     * returns the depth
     *
     * @return
     */
    public int getDepth() {
        return depth;
    }

    /**
     * increments the depth
     */
    public void incrementDepth(int d) {
        depth = d;
    }

    /**
     * prints a representation of the node, its depth, and its moves
     */
    public void printNode() {
        System.out.println("\n" + "-------------------------" + "\n");
        System.out.print(state[0][0]);
        System.out.print(state[0][1]);
        System.out.print((state[0][2]) + "\n");
        System.out.print(state[1][0]);
        System.out.print(state[1][1]);
        System.out.print((state[1][2]) + "\n");
        System.out.print(state[2][0]);
        System.out.print(state[2][1]);
        System.out.print(state[2][2]);
        System.out.println("\n");

        System.out.println("Node Depth: " + depth);
        System.out.println("Node " + move);
        //System.out.println("Node Number of Children: " + children);
        //System.out.println("Current Node Child Number: " + childNumber);
        System.out.println("-------------------------" + "\n");
    }
}
