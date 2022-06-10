package BackEnd;

import java.io.Serializable;

/*
 * Figure
 * Class describing a figure to be added in the field.
 */
public class Figure implements Serializable {
    String whereToGo;
    int xOffSet = 0;
    int yOffSet = 0;

    /**
     * Sets whereToGo parameter to a generated figure. Char's meanings:
     * s - start drawing from 0.0 coordinate
     * r - go right and start drawing
     * l - go left and start drawing
     * d - go down and start drawing
     * u - go up and start drawing
     * b - go to the bottom (two times down) and start drawing
     * @param number number from 0 to 30 corresponding to one of the figures to generate.
     */
    public Figure(int number) {
        switch (number) {
            /*  ■ ■ .
                ■ . .
                ■ . .  */
            case 0 -> whereToGo = "srldd";


            /*  ■ . .
                ■ ■ ■
                . . .  */
            case 1 -> whereToGo = "sdrr";


            /*  . ■ .
                . ■ .
                ■ ■ .  */
            case 2 -> whereToGo = "rddl";


            /*  ■ ■ ■
                . . ■
                . . .  */
            case 3 -> whereToGo = "srrd";


            /*  ■ ■ .
                . ■ .
                . ■ .  */
            case 4 -> whereToGo = "srdd";


            /*  . . ■
                ■ ■ ■
                . . .  */
            case 5 -> whereToGo = "drru";


            /*  ■ . .
                ■ . .
                ■ ■ .  */
            case 6 -> whereToGo = "sddr";


            /*  ■ ■ ■
                ■ . .
                . . .  */
            case 7 -> whereToGo = "durr";


            /*  ■ . .
                ■ ■ .
                . ■ .  */
            case 8 -> whereToGo = "sdrd";


            /*  . ■ ■
                ■ ■ .
                . . .  */
            case 9 -> whereToGo = "drur";


            /*  . ■ .
                ■ ■ .
                ■ . .  */
            case 10 -> whereToGo = "rdld";


            /*  ■ ■ .
                . ■ ■
                . . .  */
            case 11 -> whereToGo = "srdr";



            /*  . . ■
                . . ■
                ■ ■ ■  */
            case 12 -> whereToGo = "brruu";


            /*  ■ . .
                ■ . .
                ■ ■ ■  */
            case 13 -> whereToGo = "sddrr";


            /*  ■ ■ ■
                ■ . .
                ■ . .  */
            case 14 -> whereToGo = "rrlldd";


            /*  ■ ■ ■
                . . ■
                . . ■  */
            case 15 -> whereToGo = "srrdd";


            /*  . ■ .
                . ■ .
                ■ ■ ■  */
            case 16 -> whereToGo = "rddlrr";


            /*  ■ ■ ■
                . ■ .
                . ■ .  */
            case 17 -> whereToGo = "srrldd";


            /*  ■ . .
                ■ ■ ■
                ■ . .  */
            case 18 -> whereToGo = "sddurr";


            /*  . . ■
                ■ ■ ■
                . . ■  */
            case 19 -> whereToGo = "drrudd";


            /*  ■ ■ ■
                . . .
                . . .  */
            case 20 -> whereToGo = "srr";


            /*  ■ . .
                ■ . .
                ■ . .  */
            case 21 -> whereToGo = "sdd";


            /*  ■ . .
                . . .
                . . .  */
            case 22 -> whereToGo = "s";


            /*  ■ ■ .
                ■ . .
                . . .  */
            case 23 -> whereToGo = "srld";


            /*  ■ ■ .
                . ■ .
                . . .  */
            case 24 -> whereToGo = "srd";


            /*  . ■ .
                ■ ■ .
                . . .  */
            case 25 -> whereToGo = "dru";


            /*  ■ . .
                ■ ■ .
                . . .  */
            case 26 -> whereToGo = "sdr";


            /*  ■ . .
                ■ ■ .
                ■ . .  */
            case 27 -> whereToGo = "sddur";


            /*  ■ ■ ■
                . ■ .
                . . .  */
            case 28 -> whereToGo = "srrld";


            /*  . ■ .
                ■ ■ .
                . ■ .  */
            case 29 -> whereToGo = "rdlrd";


            /*  . ■ .
                ■ ■ ■
                . . .  */
            case 30 -> whereToGo = "rdlrr";
        }
    }

    /**
     * @return A string with drawing directions.
     */
    public String getWhereToGo() {
        return whereToGo;
    }

    /**
     * @return An x offset from the top-left corner where dragging started.
     */
    public int getXOffSet() {
        return xOffSet;
    }

    /**
     *  Sets an x offset from the top-left corner where dragging started.
     */
    public void setXOffSet(int xOffSet) {
        this.xOffSet = xOffSet;
    }

    /**
     * @return y offset from the top-left corner where dragging started.
     */
    public int getYOffSet() {
        return yOffSet;
    }

    /**
     *  Sets y offset from the top-left corner where dragging started.
     */
    public void setYOffSet(int yOffSet) {
        this.yOffSet = yOffSet;
    }
}
