package edu.hubu.commons.exception

import java.lang.RuntimeException

/**
 * @author moonlan
 * date 2020/10/8 15:29
 */
class WrongUsernameOrPasswordException : RuntimeException {
    constructor() {}
    constructor(message: String?) : super(message) {}
    constructor(message: String?, cause: Throwable?) : super(message, cause) {}
    constructor(cause: Throwable?) : super(cause) {}
    constructor(
        message: String?, cause: Throwable?, enableSuppression: Boolean,
        writableStackTrace: Boolean
    ) : super(message, cause, enableSuppression, writableStackTrace) {
    }
}