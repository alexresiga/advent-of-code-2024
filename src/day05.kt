fun main() = day(true, "--- Day 5: Print Queue ---") { part, _ ->
    val (rules, updates) = java.io.File("src/data.in").bufferedReader().readText().split("\n\n")
    val order = rules.split('\n').map {
        val (a, b) = it.split("|").map { it.toInt() }
        a to b
    }
    var res = 0
    updates.split('\n').forEach {
        val list = it.split(",").map { it.toInt() }.toMutableList()
        var ok = true
        for (i in 0..<list.size - 1) {
            for (j in i + 1..<list.size) {
                if (list[j] to list[i] in order) ok = false
            }
        }
        when (part) {
            Part.One -> {
                if (ok) res += list[list.size / 2]
            }
            Part.Two -> {
                if (!ok) {
                    list.sortWith { o1, o2 -> if (Pair(o1, o2) in order) -1 else 1 } // cool trick!
                    res += list[list.size / 2]
                }
            }
        }
    }
    println(res)
}