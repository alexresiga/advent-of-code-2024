fun main() = day(true, name = "--- Day 1: Historian Hysteria ---") { part, lines ->
    val first = mutableListOf<Int>()
    val second = mutableListOf<Int>()
    lines.forEach { line ->
        val (f, s) = line.split("   ").map { it.toInt() }
        first.add(f)
        second.add(s)
    }
    when (part) {
        Part.One -> first.sorted().zip(second.sorted()).sumOf { (f, s) -> kotlin.math.abs(f - s) }.println()
        Part.Two -> first.sumOf { f -> f * second.count { it == f } }.println()
    }
}