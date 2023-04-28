package tictactoe

import kotlin.IllegalArgumentException

fun printGame(listTwoD: MutableList<MutableList<Char>>) {

    println("---------")
    for (i in 0..2) println("| ${listTwoD[i].joinToString(" ")} |")
    println("---------")
}

fun main() {
    val list = input()
    val (firstCord, secondCord) = read(list)
    setValue(list, firstCord, secondCord)
}

fun input(): MutableList<MutableList<Char>> {
    val inputStart = readln()
    val flatList =  inputStart.toList().map { if (it == '_') ' ' else it }
    val listTwoD = flatList.chunked(3).map { it.toMutableList() }.toMutableList()
    printGame(listTwoD)
    return listTwoD
}

fun setValue(listTwoD: MutableList<MutableList<Char>>, firstCord: Int, secondCord: Int) {
    listTwoD[firstCord][secondCord] = 'X'
        printGame(listTwoD)
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
        read()
    }
}



fun catchList(listTwoD: MutableList<MutableList<Char>>, firstCord: Int, secondCord: Int) {
    if (listTwoD[firstCord][secondCord] == 'X' || listTwoD[firstCord][secondCord] == 'O') throw IllegalStateException("This cell is occupied! Choose another one!")
    }

fun catchSize(firstCord:Int, secondCord: Int) {
    if (firstCord < 0 || firstCord > 2 || secondCord < 0 || secondCord > 2) throw UnsupportedOperationException ("Coordinates should be from 1 to 3!")
}

/*
 win(flatList)
fun win(flatList: List<Char>) {
    val x = flatList.count { it == 'X' }
    val o = flatList.count { it == 'O' }
    var countX = 0
    var countO = 0
    var winX = 0
    var winO = 0
    if (x == o || x + 1 == o || o + 1 == x) {
        for (i in 0..2) {
            if (flatList[i] == 'X') {
                countX += 1
            } else {
                countX = 0
                break
            }
        }
        if (countX == 3 ) {
            winX = 1
        } else for (i in 3..5) {
            if (flatList[i] == 'X') {
                countX += 1; println(countX)
            } else {
                countX = 0
                break
            }
        }
        if (countX == 3 && winX == 0) {
            winX += 1
        } else for (i in 6..8) {
            if (flatList[i] == 'X') {
                countX += 1
            } else {
                countX = 0
                break
            }
        }
        if (countX == 3 && winX == 0) {
            winX += 1
        }

        for (i in 0..2) {
            if (flatList[i] == 'O') {
                countO += 1
            } else {
                countO = 0
                break
            }
        }
        if (countO == 3) {
            winO += 1
        } else for (i in 3..5) {
            if (flatList[i] == 'O') {
                countO += 1
            } else {
                countO = 0
                break
            }
        }
        if (countO == 3 && winO == 0) {
            winO += 1
        } else for (i in 6..8) {
            if (flatList[i] == 'O') {
                countO += 1
            } else {
                countO = 0
                break
            }
        }
        if (countO == 3 && winO == 0) {
            winO += 1
        }




        for (i in 0..6 step 3) {
            if (flatList[i] == 'X') {
                countX += 1
            } else {
                countX = 0
                break
            }
        }
        if (countX == 3 &&  winX == 0) {
            winX += 1
        } else for (i in 1..7 step 3) {
            if (flatList[i] == 'X') {
                countX += 1
            } else {
                countX = 0
                break
            }
        }
        if (countX == 3  &&  winX == 0) {
            winX += 1
        } else for (i in 2..8 step 3) {
            if (flatList[i] == 'X') {
                countX += 1
            } else {
                countX = 0
                break
            }
        }
        if (countX == 3 &&  winX == 0) {
            winX = +1
        }

        for (i in 0..6 step 3) {
            if (flatList[i] == 'O') {
                countO += 1
            } else {
                countO = 0
                break
            }
        }
        if (countO == 3 &&  winO == 0) {
            winO = +1
        } else for (i in 1..7 step 3) {
            if (flatList[i] == 'O') {
                countO += 1
            } else {
                countO = 0
                break
            }
        }
        if (countO == 3 &&  winO == 0) {
            winO = +1
        } else for (i in 2..8 step 3) {
            if (flatList[i] == 'O') {
                countO += 1
            } else {
                countO = 0
                break
            }
        }
        if (countO == 3 &&  winO == 0) {
            winO = +1
        }


        for (i in 0..8 step 4) {
            if (flatList[i] == 'X') countX += 1 else {
                countX = 0
                break
            }
        }
        if (countX == 3 &&  winX == 0) {
            winX += 1
        } else for (i in 2..6 step 2) {
            if (flatList[i] == 'X') {
                countX += 1
            } else {
                countX = 0
                break
            }
        }
        if (countX == 3  &&  winX == 0) {
            winX += 1
        }

        for (i in 0..8 step 5) {
            if (flatList[i] == 'O') {
                countO += 1
            } else {
                countO = 0
                break
            }
        }
        if (countO == 3 &&  winO == 0) {
            winO = +1
        } else for (i in 2..6 step 2) {
            if (flatList[i] == 'O') {
                countO += 1
            } else {
                countO = 0
                break
            }
        }
        if (countO == 3 &&  winO == 0) {
            winO = +1
        }


        if (winO > 1 || winX > 1) {
            println("Impossible")
        } else if (winX == 1 && winO == 1) {
            println("Impossible")
        } else if (winX == 1) println("X wins") else if (winO == 1) println("O wins") else if (x + o != 9) println("Game not finished")
        else println("Draw")
    } else println("Impossible")
} //soo ugly
*/

