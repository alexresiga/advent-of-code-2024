fun main() = day(true, "--- Day 10: Hoof It ---") { part, lines ->
    val grid = lines.grid.entries.associate { it.key to if (it.value.isDigit()) it.value.digitToInt() else -1 }
    grid.filter { it.value == 0 }.keys.sumOf { head ->
        val stack = mutableListOf(head)
        val res: MutableCollection<Pair<Int, Int>> = if (part.isOne) mutableSetOf() else mutableListOf()
        while (stack.isNotEmpty()) {
            val current = stack.removeLast()
            if (grid[current] == 9) res.add(current)
            DIRS2.forEach {
                val (x, y) = current.first + it.first to current.second + it.second
                if (grid.containsKey(x to y) && grid[x to y]!! - grid[current]!! == 1) stack.add(x to y)
            }
        }
        res.size
    }.println()
}