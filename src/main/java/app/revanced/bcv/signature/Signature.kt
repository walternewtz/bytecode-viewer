package app.revanced.bcv.signature

import org.objectweb.asm.Type
import org.objectweb.asm.tree.InsnList

@Suppress("ArrayInDataClass")
data class Signature(
    val returns: Type,
    val accessors: Int,
    val parameters: Array<Type>,
    val opcodes: InsnList
)
