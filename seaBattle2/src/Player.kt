class Player {
    var name: String = ""
    var field: Array<CharArray> = Array(10) { CharArray(10){ '.' } }

    var shots: Int = 0
    var hits: Int = 0

    var shipsLeft: Int = 20

    // Метод победы
    fun isAlive(): Boolean{
        if (shipsLeft > 0) return true
        else return false
    }
    var felicity: Double = 0.0
    // % попаданий
    fun accuracy(){
        if (shots == 0) felicity = 0.0
        else {
            felicity = (hits).toDouble() * 100 / (shots).toDouble()
        }
    }

    // Состояние игрока
    fun status(){
        println("Игрок $name: палуб осталось $shipsLeft, выстрелов: $shots попаданий $hits, точность ${String.format("%.1f", felicity)} %")
    }
    fun printField() {
        println("=== Поле игрока $name ===")
        print("  ")
        for (c in 0..9) print("$c ")
        println()
        for (r in 0 .. 9){
            print("$r ")
            for (c in 0..9) print("${field[r][c]} ")
            println()
        }
    }

    // попадания
    fun takeDamage(): Boolean{
        shipsLeft -= 1
        if (isAlive() == true) return true
        else return false
    }

    // выстрел
    fun registerShot(hit: Boolean) {
        shots += 1
        if (hit == true) {
            hits += 1
        }
        accuracy()

    }

    // Сброс
    fun reset(){
        for (c in 0..9) print("$c ")
        println()
        for (r in 0 .. 9){
            print("$r ")
            for (c in 0..9) {
                field[r][c] = '.'
                print("${field[r][c]} ")
            }
            println()
        }
        shipsLeft = 20
        shots = 0
        hits = 0
        felicity = 0.0
    }

    fun printStarts() {
        println("Игрок $name: выстрелов $shots, попаданий $hits")
    }
}