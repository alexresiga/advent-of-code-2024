fun main() = day(true, name = "--- Day 1: Historian Hysteria ---") { part, lines ->
    val (first, second) = lines.map { line ->
        val (f, s) = line.split("   ").map { it.toInt() }
        f to s
    }.unzip()
    when (part) {
        Part.One -> first.sorted().zip(second.sorted()).sumOf { (f, s) -> kotlin.math.abs(f - s) }.println()
        Part.Two -> first.sumOf { f -> f * second.count { it == f } }.println()
    }
}