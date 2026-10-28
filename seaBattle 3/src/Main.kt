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
        for (c in 0 .. 9) print("${player.field()[r][c]} ")
        print("      ")
        print("$r   ")
        for (c in 0 .. 9) print("${enemy.field()[r][c]} ")
        println()
    }
}

fun main(){
    val player = Player("Вы")
    val enemy = Player("Компьютер")


    val playerfield = createEmptyField()
    val enemyField = createEmptyField()
    player.placeShip(3,2)
    val f = player.field()
    printBothFields(player, enemy)
    // Вывод
    player.printField()
    player.printStarts()


    player.registerShot(true)    // попал
    player.registerShot(false)   // промах
    player.registerShot(true)    // попал

    player.status()
    // Игрок Вы: палуб осталось 20, выстрелов 3, попаданий 2, точность 66.7%

    player.takeDamage()
    player.takeDamage()
    println(player.shipsLeft)    // 18
    println(player.isAlive())    // true

    player.reset()
    player.status()
    player.markShot(3, 3, true)
    player.markShot(4, 4, false)
    printBothFields(player, enemy)
}