fun main() = day(true, "--- Day 3: Mull It Over ---") { part, lines ->
    val regex = Regex("mul\\((\\d+,\\d+)\\)|(do\\(\\))|(don't\\(\\))")
    var res = 0
    var enabled = 1

    lines.forEach { line ->
        regex.findAll(line).forEach { match ->
            when (match.value) {
                "don't()" -> enabled = 0
                "do()" -> enabled = 1
                else -> {
                    val (a, b) = match.groups[1]!!.value.split(",").map { it.toInt() }
                    res += when (part) {
                        Part.One -> a * b
                        Part.Two -> a * b * enabled
                    }
                }
            }
        }
    }
    println(res)
}