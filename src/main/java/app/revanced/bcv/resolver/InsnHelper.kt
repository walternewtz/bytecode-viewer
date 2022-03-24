package app.revanced.bcv.resolver

import app.revanced.bcv.signature.Signature

object InsnHelper {
    // Checks if the signature is unique.
    // If not, tries to generate a signature that is unique.
    fun findUniquePattern(sig: Signature): Signature? {
        if (MethodResolver(sig).resolve()) {
            println("Pattern not unique, retrying with modified sig..")



            return findUniquePattern(uniquePattern(sig) ?: return null)
        }
        println("Found unique pattern!")
        return sig
    }

    private fun uniquePattern(sig: Signature): Signature? {
        if (sig.opcodes.size() <= 1) return null // not possible to find a unique pattern anymore
        sig.opcodes.remove(sig.opcodes.last)
        return sig
    }
}