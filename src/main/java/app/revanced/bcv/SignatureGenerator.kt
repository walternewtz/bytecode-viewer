package app.revanced.bcv

import app.revanced.bcv.signature.Signature
import app.revanced.bcv.util.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonObject

object SignatureGenerator {
    private val json: Gson = GsonBuilder().setPrettyPrinting().create()
    private var index = 0

    fun createSignature(sig: Signature): String {
        val o = JsonObject()
        index++

        o["name"] = "func$index"
        o["returns"] = sig.returns.toJson()

        val accessors = JsonArray()
        sig.accessors.getModifiers().forEach { accessors.add(it) }
        o["accessors"] = accessors

        val parameters = JsonArray()
        sig.parameters.forEach { parameters.add(it.toJson()) }
        o["parameters"] = parameters

        val opcodes = JsonArray()
        sig.opcodes.stripLabels().forEach { opcodes.add(it.opcode.toOpcodeName()) }
        o["opcodes"] = opcodes

        return json.toJson(o)
    }
}
