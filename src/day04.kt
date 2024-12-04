fun main() = day(true, "--- Day 4: Ceres Search ---") { part, lines ->
    val grid = lines.grid
    var res = 0
    for (i in lines.indices) {
        for (j in lines[i].indices) {
            when (part) {
                Part.One -> {
                    val word = "XMAS"
                    for (d in DIRS) {
                        var ok = true
                        for (k in 0..3) {
                            val x = i + d.first * k
                            val y = j + d.second * k
                            if (grid[x to y] != word[k]) {
                                ok = false
                                break
                            }
                        }
                        if (ok) res++
                    }
                }

                Part.Two -> {
                    if (grid[i to j] == 'A') {
                        val diag1 = listOf((-1 to -1), (1 to 1)).mapNotNull { (x, y) -> grid[i + x to j + y] }.toSet()
                        val diag2 = listOf((-1 to 1), (1 to -1)).mapNotNull { (x, y) -> grid[i + x to j + y] }.toSet()
                        if (diag1 == setOf('S', 'M') && diag2 == setOf('S', 'M')) res++
                    }
                }
            }
        }
    }
    res.println()
}