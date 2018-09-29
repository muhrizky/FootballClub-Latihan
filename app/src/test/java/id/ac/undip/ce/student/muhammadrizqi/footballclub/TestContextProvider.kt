package id.ac.undip.ce.student.muhammadrizqi.footballclub

import id.ac.undip.ce.student.muhammadrizqi.footballclub.util.CoroutineContextProvider
import kotlinx.coroutines.experimental.Unconfined
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Created by root on 3/1/18.
 */
class TestContextProvider : CoroutineContextProvider() {
    override val main: CoroutineContext = Unconfined
}