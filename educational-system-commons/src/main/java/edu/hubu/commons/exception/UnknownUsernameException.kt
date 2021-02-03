package edu.hubu.commons.exception

import java.lang.RuntimeException

/**
 * @author moonlan
 * date 2020/10/8 15:28
 */
class UnknownUsernameException : RuntimeException {
    constructor(message: String?) : super(message) {}
    constructor(message: String?, cause: Throwable?) : super(message, cause) {}
}