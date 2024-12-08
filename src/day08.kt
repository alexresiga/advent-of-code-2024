fun main() = day(true, "--- Day 8: Resonant Collinearity ---") { part, lines ->
    val grid = lines.grid
    val antidotes = mutableSetOf<Pair<Int, Int>>()
    val grouped = grid.entries.filter { it.value != '.' }.groupBy { it.value }
    grouped.forEach { (_, antennas) ->
        antennas.permutations().forEach { (first, second) ->
            val (dx, dy) = first.key.first - second.key.first to first.key.second - second.key.second
            when (part) {
                Part.One -> {
                    if (first.key.first + dx to first.key.second + dy in grid.keys) {
                        antidotes.add(first.key.first + dx to first.key.second + dy)
                    }
                }
                Part.Two -> {
                    var r = 0
                    while (first.key.first + r * dx to first.key.second + r * dy in grid.keys) {
                        antidotes.add(first.key.first + r * dx to first.key.second + r * dy)
                        r++
                    }
                }
            }
        }
    }
    println(antidotes.size)
}

fun <T> List<T>.permutations(): Sequence<Pair<T, T>> = sequence {
    forEach { first ->
        forEach { second ->
            if (first != second) yield(first to second)
        }
    }
}
