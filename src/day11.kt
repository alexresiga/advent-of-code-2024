private val cache = mutableMapOf<Pair<Long, Int>, Long>()
fun main() = day(true, "--- Day 11: Plutonian Pebbles ---") { part, lines ->
    val numbers = lines.first().split(" ").map { it.toLong() }.toMutableList()
    val blinks = if (part.isOne) 25 else 75
    numbers.sumOf { number -> f(number, blink = blinks) }.println()
}

private fun f(number: Long, blink: Int): Long {
    if (blink == 0) return 1L
    cache[number to blink]?.let { return it }
    if (number == 0L) return f(1, blink - 1)
    val string = number.toString()
    val length = string.length
    if (length % 2 != 0) return f(number * 2024, blink - 1)
    val before = string.subSequence(0, length / 2).toString().toLong()
    val after = string.subSequence(length / 2, length).toString().toLong()
    val result = f(before, blink - 1) + f(after, blink - 1)
    cache[number to blink] = result
    return result
}