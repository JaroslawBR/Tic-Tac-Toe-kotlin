# PL: Kółko i krzyżyk

Program jest implementacja klasycznej gry Kółko i krzyżyk w języku Kotlin. Pozwala dwóm graczom na rozgrywkę na planszy o wymiarach 3x3.

## Opis

1. Gra rozpoczyna się od wyświetlenia pustej planszy 3x3.
2. Gracze na zmianę podają współrzędne komórki, którą chcą zaznaczyć. Współrzędne powinny być podane jako dwie liczby oddzielone spacją, reprezentujące numer wiersza i kolumny (liczone od 1).
3. Pierwszy gracz używa znaku 'X' jako swojego symbolu, a drugi gracz używa znaku 'O'.
4. Gra kończy się, gdy jeden z graczy zdobywa trzy swoje symbole w jednym rzędzie, kolumnie lub przekątnej, lub gdy wszystkie komórki są zapełnione i nie ma zwycięzcy (remis).

# EN: Tic-tac-toe
The program is an implementation of the classic Tic Tac Toe game in Kotlin. Allows two players to play on a 3x3 board.

## Description
The game begins with an empty 3x3 board displayed.
Players take turns entering the coordinates of the cell they want to mark. The coordinates should be given as two numbers separated by a space, representing the row and column number (counted from 1).
The first player uses 'X' as his symbol and the second player uses 'O'.
The game ends when one of the players gets three of their symbols in one row, column or diagonal, or when all cells are filled and there is no winner (tie).
```shell
---------
|       |
|       |
|       |
---------
> 1 1
---------
| X     |
|       |
|       |
---------
> 1 2
---------
| X O   |
|       |
|       |
---------
> 2 1
---------
| X O   |
| X     |
|       |
---------
> 3 1
---------
| X O   |
| X     |
| O     |
---------
> 2 2
---------
| X O   |
| X X   |
| O     |
---------
> 2 3
---------
| X O   |
| X X O |
| O     |
---------
> 3 3
---------
| X O   |
| X X O |
| O   X |
---------
X wins
```
