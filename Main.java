import java.util.Random;
import java.util.Scanner;

class Main {

  public static final int SIZE = 8;

  public static void main(String[] args) {

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    int[][] colors = new int[SIZE][SIZE];
    int[][] rotatedColors = new int[SIZE][SIZE];

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        colors[i][j] = random.nextInt(256);
      }
    }
    printMatrix(colors);

    while (true) {
      printDelimiter();
      System.out.println("Введите угол поворота матрицы кратный 90. Для выхода введите end");
      String input = scanner.nextLine();
      if (input.equals("end")) {
        break;
      } else {
        int operation = Integer.parseInt(input);
        switch (operation) {
          case 90:
            printDelimiter();
            turn90Degrees(colors, rotatedColors);
            printMatrix(rotatedColors);
            copyMatrix(colors, rotatedColors);
            break;
          case 180:
            printDelimiter();
            turn180Degrees(colors, rotatedColors);
            printMatrix(rotatedColors);
            copyMatrix(colors, rotatedColors);
            break;
          case 270:
            printDelimiter();
            turn270Degrees(colors, rotatedColors);
            printMatrix(rotatedColors);
            copyMatrix(colors, rotatedColors);
            break;
        }
      }
    }
  }

  public static void printMatrix(int[][] colors) {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.format("%4d", colors[i][j]);
      }
      System.out.println();
    }
  }

  public static void turn90Degrees(int[][] colors, int[][] rotatedColors) {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        rotatedColors[j][SIZE - 1 - i] = colors[i][j];
      }
    }
  }

  public static void turn180Degrees(int[][] colors, int[][] rotatedColors) {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        rotatedColors[SIZE - 1 - i][SIZE - 1 - j] = colors[i][j];
      }
    }
  }

  public static void turn270Degrees(int[][] colors, int[][] rotatedColors) {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        rotatedColors[SIZE - 1 - j][i] = colors[i][j];
      }
    }
  }

  public static void copyMatrix(int[][] colors, int[][] rotatedColors) {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        colors[i][j] = rotatedColors[i][j];
      }
    }
  }

  public static void printDelimiter() {
    System.out.println("  ^^^^^^^^^^^^^^^^^^^^^^^^");
  }
}