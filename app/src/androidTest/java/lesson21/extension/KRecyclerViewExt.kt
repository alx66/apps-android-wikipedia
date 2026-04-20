package lesson21.extension

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import lesson18.getName
import lesson18.name
import org.apache.commons.lang3.function.FailableFunction.function
import kotlin.math.min

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.invokeAtIndexAndClass(
    index: Int,
    startWith: Int,
    limit: Int,
    clazz: Class<out View>,
    name: String = "$index",
    fnc: T.() -> Unit
) {
    val recycler = this
    val numberOfElements = recycler.getSize()
    val lastIndex = min(limit, numberOfElements - 1)
    val firstIndex = min(startWith, lastIndex)
    var counter = 0
    for (i in firstIndex..lastIndex) {
        childAt<T>(i) {
            val isElementWithClass = hasClassOrChildWithClass(clazz)
            if (isElementWithClass && counter++ == index) {
                name(recycler.getName().withParent(name))
                fnc()
                return
            }
        }
    }
}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndexAndResId(
    index: Int,
    resourceIdContains: Int,
    limit: Int = 10,
    skipItems: Int,
    name: String = "$index",
    function: T.() -> Unit
) {
    val recycler = this
    var currentIndex = 0
    var isElementFoundByIndex = false
    val lastIndex = (limit + skipItems).coerceAtMost(getSize()) - 1
    val firstIndex = skipItems.coerceAtMost(lastIndex)
    for (i in firstIndex..lastIndex) {
        childAt<T>(i) {
            val isElementContainsView = this.hasIdOrChildWithId(resourceIdContains)
            if (isElementContainsView && index == currentIndex++) {
                isElementFoundByIndex = true
                name(recycler.getName().withParent(name))
                function()
            }
        }
        if (isElementFoundByIndex) break
    }
    if (!isElementFoundByIndex) {
        throw IllegalStateException("Элемент с индексом $index в пределах ${lastIndex + 1} элементов не найден")
    }
}