package app.revanced.bcv.util

import java.lang.reflect.Modifier

enum class Accessors(val check: (i: Int) -> Boolean) {
    PUBLIC(Modifier::isPublic),
    PRIVATE(Modifier::isPrivate),
    PROTECTED(Modifier::isProtected),
    STATIC(Modifier::isStatic),
    FINAL(Modifier::isFinal),
    SYNCHRONIZED(Modifier::isSynchronized),
    VOLATILE(Modifier::isVolatile),
    NATIVE(Modifier::isNative),
    INTERFACE(Modifier::isInterface),
    ABSTRACT(Modifier::isAbstract),
    SYNTHETIC({ false }); // Synthetic is not yet in public API

    companion object {
        fun checkInt(i: Int): List<Accessors> = buildList {
            values().forEach {
                if (it.check(i)) this.add(it)
            }
        }
    }
}