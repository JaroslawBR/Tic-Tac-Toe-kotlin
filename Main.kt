package tictactoe

import kotlin.IllegalArgumentException

fun input(): MutableList<MutableList<Char>> {
    val listTwoD = MutableList(3) {MutableList(3) {' '}}
    printGame(listTwoD)
    return listTwoD
}
fun printGame(listTwoD: MutableList<MutableList<Char>>) {

    println("---------")
    for (i in 0..2) println("| ${listTwoD[i].joinToString(" ")} |")
    println("---------")
}

fun catchList(listTwoD: MutableList<MutableList<Char>>, firstCord: Int, secondCord: Int) {
    if (listTwoD[firstCord][secondCord] == 'X' || listTwoD[firstCord][secondCord] == 'O') throw IllegalStateException("This cell is occupied! Choose another one!")
}

fun catchSize(firstCord:Int, secondCord: Int) {
    if (firstCord < 0 || firstCord > 2 || secondCord < 0 || secondCord > 2) throw UnsupportedOperationException ("Coordinates should be from 1 to 3!")
}

fun read(list: MutableList<MutableList<Char>> = mutableListOf() ): Pair<Int, Int> {
    val inputGame = readln()
    return try {
        val (firstCord, secondCord) = inputGame.split(" ").map { it.toInt() - 1 }
        catchSize(firstCord, secondCord)
        catchList(list, firstCord, secondCord)
        return Pair(firstCord, secondCord)
    } catch (e: IllegalArgumentException) {
        println("You should enter numbers!")
        read(list)
    } catch (e: UnsupportedOperationException) {
        println(e.message)
        read(list)
    } catch (e: IllegalStateException) {
        println(e.message)
        read(list)
    } catch (e : Exception) {
        println("You have to add to 2 numbers")
        read(list)
    }
} //read input

fun setValue(listTwoD: MutableList<MutableList<Char>>, firstCord: Int, secondCord: Int, turn: Int = 1) {
    var tick = 'X'
    if (turn % 2 == 0)  tick = 'O'
    listTwoD[firstCord][secondCord] = tick
    printGame(listTwoD)
} // set new value in list

fun main() {
    var turn = 0
    val list = input() //create empty list 3x3
    while (true) {
        val (firstCord, secondCord) = read(list)
        turn += 1
        setValue(list, firstCord, secondCord, turn)
        when (checkGameCondition(list)) {
            1 -> { println("O wins"); break }
            2 -> { println("X wins"); break }
        }
        if (turn == 9) {println("Draw"); break}




    }
}

fun checkGameCondition(list: MutableList<MutableList<Char>> = mutableListOf()): Int{
    var rowX = 0
    var rowO = 0
    var verticalX = 0
    var verticalO = 0
    var diagonalX = 0
    var diagonalO = 0
    var diagonalzX = 0
    var diagonalzO = 0
    for (x in 0..2) {
        if (rowO == 3  || rowX == 3) break
        rowO = 0
        rowX = 0
        for (i in 0..2) {
            when (list[x][i]) {
                'X' -> rowX += 1
                'O' -> rowO += 1
                else -> {
                    rowO = 0
                    rowX = 0
                    break
                }
            }
        }
    }
    for (x in 0..2) {
        if (verticalO == 3  || verticalX == 3) break
        verticalO = 0
        verticalX = 0
        for (i in 0..2) {
            when (list[i][x]) {
                'X' -> verticalX += 1
                'O' -> verticalO += 1
                else -> {
                    verticalO = 0
                    verticalX = 0
                }
            }
        }
    }
    diagonalX = 0
    diagonalO = 0
    for (i in 0..2) {
        if (diagonalO == 3  || diagonalX == 3) break
        when (list[i][i]) {
            'X' -> diagonalX += 1
            'O' -> diagonalO += 1
            else -> {
                diagonalX = 0
                diagonalO = 0
                break
            }
        }
    }
        for (i in 0..2) {
            if (diagonalzX == 3 || diagonalzO == 3) break
            when (list[i][2 - i]) {
                'X' -> diagonalzX += 1
                'O' -> diagonalzO += 1
                else -> {
                    diagonalzX = 0
                    diagonalzO = 0
                    break
                }
            }
        }

    return when {
        rowO == 3 || verticalO == 3 || diagonalO == 3 || diagonalzO == 3 -> { 1 }
        rowX == 3 || verticalX == 3 || diagonalX == 3 || diagonalzX == 3 -> { 2 }
        else -> 0
    }


}


fun draw(list: MutableList<MutableList<Char>> = mutableListOf()): Boolean{
    var empty = false
    for (i in list) {
        empty = ' ' in i
    }
    return empty
}