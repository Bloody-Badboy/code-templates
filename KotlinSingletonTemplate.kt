#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME}#end

class ${NAME} private constructor() {
    companion object {
        @Volatile
        private var INSTANCE: ${NAME}? = null
        private val LOCK = Any()

        operator fun invoke(): ${NAME} {
            return INSTANCE
                ?: synchronized(LOCK) {
                    INSTANCE
                        ?: ${NAME}()
                            .also { INSTANCE = it }
                }
        }
    }
 }