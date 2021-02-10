public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]
        char [][] chessBoard = new char[size][size];
        for(int i = 0; i < size; i++) {
            if(i == size-1-i) chessBoard[j] = symbol; {
                System.out.print(symbol);
                continue;
            }
            int temp = chessBoard[i][i];
            chessBoard[i][i] = chessBoard[i][size-1-i];
            chessBoard[i][size-1-i] = (char) temp;
            System.out.println();
        }

       return chessBoard;
    }

}