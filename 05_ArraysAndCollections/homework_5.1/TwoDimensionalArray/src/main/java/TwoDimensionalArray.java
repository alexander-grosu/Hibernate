public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {
        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]
        char[][] chessBoard = new char[size][size];

        for (int a = 0; a < chessBoard.length; a++) {
            for (int b = 0; b < chessBoard[0].length; b++) {
                if (a == b) {
                    chessBoard[a][b] = symbol;
                } else if (a == chessBoard[0].length - 1 - b) {
                    chessBoard[a][b] = symbol;
                } else {
                    chessBoard[a][b] = ' ';
                }
            }
        }
        System.out.println();
        return chessBoard;
    }
}