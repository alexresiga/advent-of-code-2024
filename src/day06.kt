fun main() = day(true, "--- Day 6: Guard Gallivant ---") { part, lines ->
    val grid = lines.grid
    var (i, j) = grid.entries.first { it.value == '^' }.key
    val path = mutableSetOf<Pair<Int, Int>>(i to j)
    val dirs = listOf((-1 to 0), (0 to 1), (1 to 0), (0 to -1))
    var tick = 0
    outer@ while (true) {
        while (grid[i + dirs[tick].first to j + dirs[tick].second] != '#') {
            if (grid[i + dirs[tick].first to j + dirs[tick].second] == null) break@outer
            i += dirs[tick].first
            j += dirs[tick].second
            path.add(i to j)
        }
        tick = (tick + 1) % 4
    }

    var res = 0
    val (startI, startJ) = grid.entries.first { it.value == '^' }.key
    path.forEach { (a, b) ->
        val copy = grid.toMutableMap()
        val seen = mutableSetOf<Triple<Int, Int, Int>>()
        tick = 0
        copy[a to b] = '#'
        var (ii, jj) = startI to startJ
        while ((ii to jj) in copy && Triple(ii, jj, tick) !in seen) {
            seen.add(Triple(ii, jj, tick))
            if (copy[ii + dirs[tick].first to jj + dirs[tick].second] == '#') {
                tick = (tick + 1) % 4
            } else {
                ii += dirs[tick].first
                jj += dirs[tick].second
            }
            if (Triple(ii, jj, tick) in seen) res += 1
        }
    }
    println(if (part.isOne) path.size else res)
}