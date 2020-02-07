package hyperskill.corutine

import kotlinx.coroutines.delay

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    for (i in 0..1000 step 200) {
        launch {
            delay(1000L - i)
            print(i)
        }
    }
}