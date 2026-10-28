val formatTemplate = "%-4s %-30s %-15s %-6s %-12s %-10s"
val bases = mutableListOf<Description>()
fun out(){
    var index: Int = 1
    println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
    bases.forEach {
        println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
        index += 1
    }
}

fun StatisticsBook() {
    var num: Int = 0; var LostG: Int = 0; var ARCHIVEDg: Int = 0; var AVAILABLEg: Int = 0; var BORROWEDg: Int = 0; var RESERVEDg: Int = 0
    for (n in bases) {
        if (n.t == BookStatus.LOST) {LostG += 1; num +=1}
        else if (n.t == BookStatus.ARCHIVED) {ARCHIVEDg += 1; num +=1}
        else if (n.t == BookStatus.AVAILABLE) {AVAILABLEg += 1; num +=1}
        else if (n.t == BookStatus.BORROWED) {BORROWEDg += 1; num +=1}
        else if (n.t == BookStatus.RESERVED) {RESERVEDg += 1; num +=1}
    }
    var LostY = LostG * 100 / num
    var ARCHIVEDy = ARCHIVEDg * 100 / num
    var AVAILABLEy = AVAILABLEg * 100 / num
    var BORROWEDy = BORROWEDg * 100 / num
    var RESERVEDy = RESERVEDg * 100 / num
    print("Доступно: $AVAILABLEg ($AVAILABLEy %)\n" + "Выдано: $BORROWEDg ($BORROWEDy %)\n" + "Потеряно: $LostG ($LostY %)\n" + "Зарезервированна: $RESERVEDg ($RESERVEDy %)\n" + "В архиве: $ARCHIVEDg ($ARCHIVEDy %)\n")
}

fun StatisticsGenre(){
    var num = 0
    var FICTIONg: Int = 0; var SCIENTIFICg: Int = 0; var FANTASYg: Int = 0
    var DETECTIVEg: Int = 0; var BIOGRAPHYg: Int = 0; var CHILDRENg: Int = 0
    for (n in bases) {
        if (n.y == Genre.FICTION) { FICTIONg += 1; num +=1 }
        else if (n.y == Genre.SCIENTIFIC) { SCIENTIFICg += 1; num +=1}
        else if (n.y == Genre.FANTASY) { FANTASYg += 1; num +=1 }
        else if (n.y == Genre.DETECTIVE) { DETECTIVEg += 1; num +=1 }
        else if (n.y == Genre.BIOGRAPHY) {BIOGRAPHYg += 1; num +=1 }
        else if (n.y == Genre.CHILDREN) {CHILDRENg += 1; num +=1 }
    }
    var FICTIONy = FICTIONg * 100 / num
    var SCIENTIFICy = SCIENTIFICg * 100 / num
    var FANTASYy = FANTASYg * 100 / num
    var DETECTIVEy = DETECTIVEg * 100 / num
    var BIOGRAPHYy = BIOGRAPHYg * 100 / num
    var CHILDRENy = CHILDRENg * 100 / num
    print("Художественная литература: $FICTIONg ($FICTIONy %)\n" + "Научная литература: $SCIENTIFICg ($SCIENTIFICy %)\n" + "Фантастика: $FANTASYg ($FANTASYy %)\n" + "Детектив: $DETECTIVEg ($DETECTIVEy %)\n" + "Биография: $BIOGRAPHYg ($BIOGRAPHYy %)\n" + "Детская литература: $CHILDRENg ($CHILDRENy %)\n")
}
fun OldYoungBook(){
    var yuong = bases.minOfOrNull { it.u }
    var old = bases.maxOfOrNull { it.u }

    val youngBook = bases.find { it.u == old }
    val oldBook = bases.find { it.u == yuong }
    println("Название старой книги: ${youngBook?.name}, " + "Год издания: $yuong" )
    println("Название новой книги: ${oldBook?.name}, " + "Год издания: $old")

}
fun AveregeYour(){
    var avg = bases.map{ it.u}.average()
    println("Средний год: "+"%.0f".format(avg))
}

fun FilterStatus(){
    var index: Int = 1
    println("По какому статусу книги в библеотеке вы хотите отсортировать? (1 - Потеряна, 2 - Архив, 3 - Доступна, 4 - Зарезервированна, 5 - Выдана)")
    var user = readln().toInt()
    if (user == 1) {
        println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
        bases.filter { it.t == BookStatus.LOST }.forEach { println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
            index += 1 }
    }
    else if (user == 2) {
        println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
        bases.filter { it.t == BookStatus.ARCHIVED}.forEach { println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
            index += 1 }
    }
    else if (user == 3) {
        println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
        bases.filter { it.t == BookStatus.AVAILABLE}.forEach { println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
            index += 1 }
    }
    else if (user == 4) {
        println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
        bases.filter { it.t == BookStatus.RESERVED}.forEach { println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
            index += 1 }
    }
    else if (user == 5) {
        println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
        bases.filter { it.t == BookStatus.BORROWED}.forEach { println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
            index += 1 }
    }

}

fun FilterGenre() {
    var index: Int = 1
    println("По какому статусу книги в библеотеке вы хотите отсортировать? (1 - Детская литература, 2 - Биография, 3 - Детектив, 4 - Научная литература, 5 - Фантастика, 6 - Художественная литература)")
    var user = readln().toInt()
    if (user == 1) {
        println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
        bases.filter { it.y == Genre.CHILDREN }.forEach { println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
            index += 1 }
    }
    else if (user == 2) {
        println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
        bases.filter { it.y == Genre.BIOGRAPHY }.forEach { println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
            index += 1 }
    }
    else if (user == 3) {
        println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
        bases.filter { it.y == Genre.DETECTIVE }.forEach { println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
            index += 1 }
    }
    else if (user == 4) {
        println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
        bases.filter { it.y == Genre.SCIENTIFIC }.forEach { println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
            index += 1 }
    }
    else if (user == 5) {
        println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
        bases.filter { it.y == Genre.FANTASY }.forEach { println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
            index += 1 }
    }
    else if (user == 6) {
        println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
        bases.filter { it.y == Genre.FICTION }.forEach { println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
            index += 1 }
    }
}

fun FilterYear(){
    var index: Int = 1
    println("От какого года вы хотите ивидеть книги?")
    var user = readln().toInt()
     println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
        bases.filter { it.u > user}.forEach { println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
            index += 1 }
}
fun EditData(){
    var index: Int = 1
    println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
    bases.forEach { println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
        index += 1 }
    println("Статус какой книги вы хотети поменять? (Введите номер)")
    val book = readln().toInt() - 1
    println("На какой статус вы хотите поменять? (1 - Потеряна, 2 - Архив, 3 - Доступна, 4 - Зарезервированна, 5 - Выдана)")
    val num = readln().toInt()

    if (num == 1){
        if (book in bases.indices) {
            index = 1
            bases[book].t = BookStatus.LOST
            println("Изменение данных:")
            println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
            bases.forEach { println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
                index += 1 }
        }
        else println("Введите правильный № книги")
    }
    else if (num == 2){
        if (book in bases.indices) {
            index = 1
            bases[book].t = BookStatus.ARCHIVED
            println("Изменение данных:")
            println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
            bases.forEach {
                println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
                index += 1
            }
        }
        else println("Введите правильный № книги")
    }
    else if (num == 3){
        if (book in bases.indices) {
        index = 1
        bases[book].t = BookStatus.AVAILABLE
        println("Изменение данных:")
        println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
        bases.forEach { println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
            index += 1 }
        }
        else println("Введите правильный № книги")
    }
    else if (num == 4){
        if (book in bases.indices) {
        index = 1
        bases[book].t = BookStatus.RESERVED
        println("Изменение данных:")
        println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
        bases.forEach { println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
            index += 1 }
        }
        else println("Введите правильный № книги")
    }
    else if (num == 5){
        if (book in bases.indices) {
        index = 1
        bases[book].t = BookStatus.BORROWED
        println("Изменение данных:")
        println(String.format(formatTemplate, "№", "Название", "Автор", "Год", "Жанр", "Статус"))
        bases.forEach { println(String.format(formatTemplate, index, it.i, it.a, it.u, it.y, it.t))
            index += 1 }
        }
        else println("Введите правильный № книги")
    }

}
fun Othet(){
    var aou: Int = 0
    for (n in bases) aou += 1
    println("=== ОТЧЕТ ПО КАТАЛОГУ ===")
    println("Всего книг: $aou")
    println()
    println("По жанрам:")
    StatisticsGenre()
    println()
    println("По статусу:")
    StatisticsBook()
    println()
    OldYoungBook()
    AveregeYour()
}
fun main() {
    bases.add(Description("Мастер и маргарита", "Булгаков", 1967, Genre.FANTASY, BookStatus.AVAILABLE))
    bases.add(Description("У лукоморья дуб зелёный", "Пушкин", 2028, Genre.CHILDREN, BookStatus.LOST))
    bases.add(Description("Принцесса людмила", "Пушкин", 1488, Genre.CHILDREN, BookStatus.ARCHIVED))
    bases.add(Description("Гарри Поттер", "Роулинг", 1997, Genre.FANTASY, BookStatus.AVAILABLE))
    bases.add(Description("Властелин колец", "Толкин", 1954, Genre.FANTASY, BookStatus.AVAILABLE))
    bases.add(Description("Хроники Нарнии", "Льюис", 1950, Genre.FANTASY, BookStatus.ARCHIVED))
    bases.add(Description("Шерлок Холмс", "Дойл", 1892, Genre.DETECTIVE, BookStatus.AVAILABLE))
    bases.add(Description("Убийство в Восточном экспрессе", "Кристи", 1934, Genre.DETECTIVE, BookStatus.LOST))
    bases.add(Description("Маленький принц", "Экзюпери", 1943, Genre.CHILDREN, BookStatus.AVAILABLE))
    bases.add(Description("Приключения Буратино", "Толстой", 1936, Genre.CHILDREN, BookStatus.AVAILABLE))
    bases.add(Description("Стив Джобс", "Айзексон", 2011, Genre.BIOGRAPHY, BookStatus.AVAILABLE))
    bases.add(Description("Краткая история времени", "Хокинг", 1988, Genre.SCIENTIFIC, BookStatus.AVAILABLE))
    bases.add(Description("Эгоистичный ген", "Докинз", 1976, Genre.SCIENTIFIC, BookStatus.ARCHIVED))
    bases.add(Description("Космос", "Саган", 1980, Genre.SCIENTIFIC, BookStatus.LOST))

    while (true){
        println("Что вы хотите сделать? 1 - Вывести все книги, 2 - Фильтр, 3 - Самая старая и новая книга, 4 - Отчет, 5 - изменить статус, 6 - Вывести стастику, 7 - Средний год, 0 - выход")
        var h: String = readln()
        if (h == "1") out()
        else if (h == "2"){
            println("Как вы хотите отсортировать? 1 - По статусу, 2 - По жанру, 3 - По году, Enter - назад")
            var e = readln()
            if (e == "1") FilterStatus()
            else if (e == "2") FilterGenre()
            else if (e == "3") FilterYear()
        }
        else if (h == "3") OldYoungBook()
        else if (h == "4") Othet()
        else if (h == "5") EditData()
        else if (h == "6"){
            println("Какую вы хотите статистику? 1 - По статусу книг, 2 - По жанрам, Enter - назад")
            var t = readln()
            if (t == "1") StatisticsBook()
            else if (t == "2") StatisticsGenre()
        }
        else if (h == "7") AveregeYour()
        else if (h == "0") return
    }

}

