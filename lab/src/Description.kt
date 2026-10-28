class Description(val i: String, val a: String, val u: Int, var y: Genre, var t: BookStatus) {
    private val _name: String = i
    private val _author: String = a
    private val _year: Int = u
    val name: String
        get() = _name
    val author: String
        get() = _author
    val year: Int
        get() = _year
}