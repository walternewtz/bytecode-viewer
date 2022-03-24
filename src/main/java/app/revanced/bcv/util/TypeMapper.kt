package app.revanced.bcv.util

import org.objectweb.asm.Type
import org.objectweb.asm.Type.*

internal fun Type.toJson(): String = when (sort) {
    VOID -> "V"
    BOOLEAN -> "Z"
    CHAR -> "C"
    BYTE -> "B"
    SHORT -> "S"
    INT -> "I"
    FLOAT -> "F"
    LONG -> "J"
    DOUBLE -> "D"
    OBJECT -> "O"
    ARRAY -> "[".repeat(dimensions) + elementType.toJson()
    else -> throw Exception("Don't have a JSON variant for type: $this")
}

internal fun Int.getModifiers(): List<String> =
    Accessors.checkInt(this@getModifiers).
    map(Accessors::toString)
