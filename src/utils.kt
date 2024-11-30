import kotlin.io.path.Path
import kotlin.io.path.readLines

enum class Part {
    One, Two;

    val isOne: Boolean
        get() = this == One
    val isTwo: Boolean
        get() = this == Two
}

inline fun <reified T> T.println(): T = also { println(it) }

inline fun day(done: Boolean = false, name: String = "", block: (part: Part, input: List<String>) -> Any?) {
    val input = Path("src/data.in").readLines()
    name.takeIf { it.isNotBlank() }?.let { println(it) }
    when (done) {
        false -> block(Part.One, input)
        true -> {
            Part.entries.forEachIndexed { index, part ->
                print("part ${index + 1}: ")
                block(part, input)
            }
        }
    }
}
