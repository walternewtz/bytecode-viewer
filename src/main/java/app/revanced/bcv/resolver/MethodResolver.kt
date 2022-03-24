package app.revanced.bcv.resolver

import app.revanced.bcv.signature.Signature
import org.objectweb.asm.Type
import org.objectweb.asm.tree.InsnList
import org.objectweb.asm.tree.MethodNode
import the.bytecode.club.bytecodeviewer.BytecodeViewer

// Stripped version of MethodResolver from revanced-patcher
class MethodResolver(private val signature: Signature) {
    fun resolve(): Boolean {
        var found = false

        BytecodeViewer.getResourceContainers().forEach { container ->
            container.resourceClasses.values.forEach { cn ->
                cn.methods.forEach { mn ->
                    if (cmp(mn)) {
                        if (found) return true
                        found = true
                    }
                }
            }
        }

        return false
    }

    private fun cmp(method: MethodNode): Boolean {
        if (signature.returns != Type.getReturnType(method.desc)) return false
        if (signature.accessors != method.access) return false
        if (!signature.parameters.contentEquals(Type.getArgumentTypes(method.desc))) return false
        if (!method.instructions.scanFor(signature.opcodes)) return false

        return true
    }
}

private fun InsnList.scanFor(pattern: InsnList): Boolean {
    for (i in 0 until this.size()) {
        var occurrence = 0
        while (i + occurrence < this.size()) {
            if (this[i + occurrence].opcode != pattern[occurrence].opcode) break
            if (++occurrence >= pattern.size()) {
                return true
            }
        }
    }

    return false
}