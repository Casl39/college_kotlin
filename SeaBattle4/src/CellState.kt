enum class CellState {
    EMPTY,
    SHIP,
    HIT,
    MISS;

    fun toChar(): Char{
        return when (this) {
            EMPTY -> '.'
            SHIP -> '#'
            HIT -> 'X'
            MISS -> 'O'
        }
    }
}
enum class ShipType(val size: Int){
    BATTLESHIP(4),
    CRUISER(3),
    DESTROYER(2),
    BOAT(1);

    fun isBig(): Boolean = size >= 3
}

enum class GameState {
    PLACING, PLAYER_TURN, ENEMY_TURN, FINISHED;

    fun describe(): String{
        return when (this) {
            PLACING -> "Расстановка кораблей"
            PLAYER_TURN -> "Ваш ход"
            ENEMY_TURN -> "Ход компьютера"
            FINISHED -> "Игра окончена"
        }
    }
}