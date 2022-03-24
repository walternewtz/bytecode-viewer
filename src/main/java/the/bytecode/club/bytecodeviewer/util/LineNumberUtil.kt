package the.bytecode.club.bytecodeviewer.util

import the.bytecode.club.bytecodeviewer.decompilers.bytecode.PrefixedStringBuilder

object LineNumberUtil {
    fun getLineNumber(sb: PrefixedStringBuilder): Int {
        return sb.toString().split("\n").size
    }
}