import java.util.Scanner;

public class JogoDoGalo {
   public static void main(String[] args) {
      char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
      char currentPlayer = 'X';
      boolean gameEnded = false;
      Scanner input = new Scanner(System.in);
      
      while (!gameEnded) {
         System.out.println("Jogador " + currentPlayer + ", é sua vez. Insira a linha (1-3) e coluna (1-3) separados por espaço:");
         int row = input.nextInt() - 1;
         int col = input.nextInt() - 1;
         
         if (board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            if (currentPlayerWins(board, currentPlayer)) {
               System.out.println("Parabéns, jogador " + currentPlayer + ", você ganhou!");
               gameEnded = true;
            } else if (isBoardFull(board)) {
               System.out.println("Empate!");
               gameEnded = true;
            } else {
               currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
         } else {
            System.out.println("Essa posição já está ocupada. Tente novamente.");
         }
      }
      input.close();
   }
   
   // Verifica se o jogador atual ganhou
   public static boolean currentPlayerWins(char[][] board, char currentPlayer) {
      for (int i = 0; i < 3; i++) {
         if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
            return true;
         } else if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
            return true;
         }
      }
      if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
         return true;
      } else if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
         return true;
      }
      return false;
   }
   
   // Verifica se o tabuleiro está completamente preenchido
   public static boolean isBoardFull(char[][] board) {
      for (int row = 0; row < 3; row++) {
         for (int col = 0; col < 3; col++) {
            if (board[row][col] == ' ') {
               return false;
            }
         }
      }
      return true;
   }
}