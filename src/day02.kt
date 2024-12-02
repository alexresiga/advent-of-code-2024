fun main() = day(true, "--- Day 2: Red-Nosed Reports ---") { part, lines ->
    lines.count { line ->
        val levels = line.split(" ").map { it.toInt() }
        when (part) {
            Part.One -> levels.isValid()
            Part.Two -> levels.isValid() || levels.all().any { it.isValid() }
        }
    }.println()
}

private fun List<Int>.isValid(): Boolean =
    with(zipWithNext { a, b -> a - b }) { all { kotlin.math.abs(it) in 1..3 } && (all { it < 0 } || all { it > 0 }) }

private fun List<Int>.all() =
    sequence { indices.forEach { yield(filterIndexed { index, _ -> index != it }) } }