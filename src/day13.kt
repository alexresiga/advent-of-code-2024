fun main() = day(true, "--- Day 13: Claw Contraption ---") { part, _ ->
    java.io.File("src/data.in").bufferedReader().readText().split("\n\n").sumOf { claw ->
        var (x1, y1, x2, y2, x, y) = Regex("\\d+").findAll(claw).map { it.value.toDouble() }.toList()
        if (part.isTwo) {
            x += 10000000000000
            y += 10000000000000
        }
        val (a, b) = (x * y2 - y * x2) / (x1 * y2 - y1 * x2) to (y * x1 - x * y1) / (x1 * y2 - y1 * x2)
        if (kotlin.math.abs(a) % 1.0 < 1e-5 && kotlin.math.abs(b) % 1.0 < 1e-5) (3 * a + b).toLong() else 0L
    }.println()
}

private operator fun <E : Any> List<E>.component6(): Double = get(5) as Double