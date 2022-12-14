package com.nighthawk.spring_portfolio.mvc.lightboard1;

import javax.swing.JOptionPane;

import lombok.Data;

@Data // Annotations to simplify writing code (ie constructors, setters)
public class LightBoard {
    private Light[][] lights;

    /* Initialize LightBoard and Lights */
    public LightBoard(int numRows, int numCols) {
        this.lights = new Light[numRows][numCols];
        // 2D array nested loops, used for initialization
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                lights[row][col] = new Light(); // each cell needs to be constructed
            }
        }
    }

    /* Output is intended for API key/values */
    public String toString() {
        String outString = "[";
        // 2D array nested loops, used for reference
        for (int row = 0; row < lights.length; row++) {
            for (int col = 0; col < lights[row].length; col++) {
                outString +=
                        // data
                        "{" +
                                "\"row\": " + row + "," +
                                "\"column\": " + col + "," +
                                "\"light\": " + lights[row][col] + // extract toString data
                                "},";
            }
        }
        // remove last comma, newline, add square bracket, reset color
        outString = outString.substring(0, outString.length() - 1) + "]";
        return outString;
    }

    /* Output is intended for Terminal, effects added to output */
    public String toTerminal() {
        String outString = "[";
        // 2D array nested loops, used for reference
        for (int row = 0; row < lights.length; row++) {
            for (int col = 0; col < lights[row].length; col++) {
                outString +=
                        // reset
                        "\033[m" +

                        // color
                                "\033[38;2;" +
                                lights[row][col].getRed() + ";" + // set color using getters
                                lights[row][col].getGreen() + ";" +
                                lights[row][col].getBlue() + ";" +
                                lights[row][col].getEffect() + "m" +
                                // data, extract custom getters
                                "{" +
                                "\"" + "RGB\": " + "\"" + lights[row][col].getRGB() + "\"" +
                                "," +
                                "\"" + "Effect\": " + "\"" + lights[row][col].getEffectTitle() + "\"" +
                                "}," +
                                // newline
                                "\n";
            }
        }
        // remove last comma, newline, add square bracket, reset color
        outString = outString.substring(0, outString.length() - 2) + "\033[m" + "]";
        return outString;
    }

    /* Output is intended for Terminal, draws color palette */
    public String toColorPalette() {
        // block sizes
        final int ROWS = 5;
        final int COLS = 10;

        // Build large string for entire color palette
        String outString = "";
        // find each row
        for (int row = 0; row < lights.length; row++) {
            // repeat each row for block size
            for (int i = 0; i < ROWS; i++) {
                // find each column
                for (int col = 0; col < lights[row].length; col++) {
                    // repeat each column for block size
                    for (int j = 0; j < COLS; j++) {
                        // print single character, except at midpoint print color code
                        String c = (i == (int) (ROWS / 2) && j == (int) (COLS / 2))
                                ? lights[row][col].getRGB()
                                : (j == (int) (COLS / 2)) // nested ternary
                                        ? " ".repeat(lights[row][col].getRGB().length())
                                        : " ";

                        outString +=
                                // reset
                                "\033[m" +

                                // color
                                        "\033[38;2;" +
                                        lights[row][col].getRed() + ";" +
                                        lights[row][col].getGreen() + ";" +
                                        lights[row][col].getBlue() + ";" +
                                        "7m" +

                                        // color code or blank character
                                        c +

                                        // reset
                                        "\033[m";
                    }
                }
                outString += "\n";
            }
        }
        // remove last comma, newline, add square bracket, reset color
        outString += "\033[m";
        return outString;
    }

    public void userColor() {
        String rowString = JOptionPane.showInputDialog("Row Value");
        int row = Integer.parseInt(rowString);
        String colString = JOptionPane.showInputDialog("Col Value");
        int col = Integer.parseInt(colString);
        String inp1 = JOptionPane.showInputDialog("Red Value(0-255");
        Short redValue = Short.valueOf(inp1);
        String inp2 = JOptionPane.showInputDialog("Blue Value(0-255");
        Short blueValue = Short.valueOf(inp2);
        String inp3 = JOptionPane.showInputDialog("Green Value(0-255");
        Short greenValue = Short.valueOf(inp3);
        lights[row][col].setRGB(redValue, blueValue, greenValue);
    }

    static public void main(String[] args) {
        // create and display LightBoard
        LightBoard lightBoard = new LightBoard(7, 7);
        System.out.println(lightBoard); // use toString() method
        System.out.println(lightBoard.toTerminal());
        System.out.println(lightBoard.toColorPalette());
        lightBoard.userColor();
        System.out.println(lightBoard.toColorPalette());
    }
}
