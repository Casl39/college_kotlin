fun createEmptyField(size: Int = 10): Array<CharArray> {
    return Array(size) { CharArray(size) { '.' } }
}

fun printBothFields(player: Player, enemy: Player) {
    println("=== Поле игрока ${player.name} ===              === Поле игрока ${enemy.name} ===")
    print("   ")
    for (c in 0..9) print ("$c ")
    print ("     ")
    print("      ")
    for (c in 0 .. 9) print("$c ")
    println()
    for (r in 0 .. 9){
        print("$r   ")
        for (c in 0 .. 9) print("${player.field[r][c]} ")
        print("      ")
        print("$r   ")
        for (c in 0 .. 9) print("${enemy.field[r][c]} ")
        println()
    }
}

fun main(){
    val player = Player()
    val enemy = Player()
    // Имя
    player.name = "Вы"
    enemy.name = "Компьютер"


    val playerfield = createEmptyField()
    val enemyField = createEmptyField()
    player.field[3][2] = '#'
    player.field[3][3] = '#'
    player.field[3][4] = '#'
    player.field[3][5] = '#'

    enemy.field[5][7] = '#'
    enemy.field[6][7] = '#'
    enemy.field[7][7] = '#'
    printBothFields(player, enemy)
    // Вывод
    player.printField()
    player.printStarts()


    player.registerShot(true)    // попал
    player.registerShot(false)   // промах
    player.registerShot(true)    // попал

    println(player.status())
    // Игрок Вы: палуб осталось 20, выстрелов 3, попаданий 2, точность 66.7%

    player.takeDamage()
    player.takeDamage()
    println(player.shipsLeft)    // 18
    println(player.isAlive())    // true

    player.reset()
    println(player.status())
}