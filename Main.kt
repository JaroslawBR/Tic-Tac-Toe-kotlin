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

fun setValue(listTwoD: MutableList<MutableList<Char>>, firstCord: Int, secondCord: Int) {
    listTwoD[firstCord][secondCord] = 'X'
    printGame(listTwoD)
} // set new value in list

fun main() {
    val list = input() //create empty list 3x3
    while (true) {
        val (firstCord, secondCord) = read(list)
        setValue(list, firstCord, secondCord)
    }
}


