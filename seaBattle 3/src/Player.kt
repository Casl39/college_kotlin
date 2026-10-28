class Player (val name: String ) {
    private var _shots: Int = 0
    private var _hits: Int = 0
    private var _field: Array<CharArray> = Array(10) { CharArray(10){ '.' } }

    fun field(): Array<CharArray> = _field

    fun placeShip(row: Int, col: Int){
        if (row in 0..9 && col in 0..9) _field[row][col] = '#'
    }
    val shots: Int
        get() = _shots
    val hits: Int
        get() = _hits

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
            for (c in 0..9) print("${_field[r][c]} ")
            println()
        }
    }
    fun markShot(row: Int, col: Int, hit: Boolean) {
        if (row in 0..9 && col in 0..9) {
            _field[row][col] = if (hit) 'X' else 'O'
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
        _shots += 1
        if (hit) _hits += 1
        accuracy()

    }

    // Сброс
    fun reset(){
        for (c in 0..9) print("$c ")
        println()
        for (r in 0 .. 9){
            print("$r ")
            for (c in 0..9) {
                _field[r][c] = '.'
                print("${_field[r][c]} ")
            }
            println()
        }
        shipsLeft = 20
        _shots = 0
        _hits = 0
        felicity = 0.0
    }

    fun printStarts() {
        println("Игрок $name: выстрелов $shots, попаданий $hits")
    }
}