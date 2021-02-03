package edu.hubu.commons.exception

import java.lang.RuntimeException

/**
 * @author moonlan
 * date 2020/10/8 15:26
 */
class PermissionDeniedException : RuntimeException {
    constructor(msg: String?) : super(msg) {}
    constructor(msg: String?, t: Throwable?) : super(msg, t) {}
}