val ops: List<(Long, Long) -> Long> = listOf({ a, b -> a * b }, { a, b -> a + b }, { a, b -> "$a$b".toLong() })
fun main() = day(true, "--- Day 7: Bridge Repair ---") { part, lines ->
    lines.sumOf { line ->
        val (value, eq) = line.split(": ")
        val elements = eq.split(" ").map { it.toLong() }
        var temp = listOf(elements.first())
        for (elem in elements.drop(1)) {
            temp = temp.flatMap { t ->
                val partOps = if (part.isOne) ops.dropLast(1) else ops
                partOps.map { op -> op(t, elem) } }
        }
        if (value.toLong() in temp) value.toLong() else 0
    }.println()
}