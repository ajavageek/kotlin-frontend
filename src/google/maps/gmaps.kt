@file:JsQualifier("google.maps")

package google.maps

import org.w3c.dom.Element
import kotlin.js.*

@JsName("Map")
external open class GoogleMap(element: Element?) {
    fun setOptions(options: Json)
}