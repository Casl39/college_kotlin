enum class BookStatus (val i: String) {
    LOST("Потеряна"),
    AVAILABLE("В библеотеке, доступна"),
    BORROWED("Выдана читателю"),
    RESERVED("Зарезервированна"),
    ARCHIVED("В архиве");
}
