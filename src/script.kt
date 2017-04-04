import google.maps.GoogleMap
import org.w3c.dom.Element
import kotlin.browser.document
import kotlin.js.json


internal class MapOptions {
    lateinit var center: LatitudeLongitude
    var zoom: Byte = 1
    fun center(init: LatitudeLongitude.() -> Unit) {
        center = LatitudeLongitude().apply(init)
    }
    fun toJson() = json("center" to center.toJson(), "zoom" to zoom)
}

internal class LatitudeLongitude() {
    var latitude: Double = 0.0
    var longitude: Double = 0.0
    fun toJson() = json("lat" to latitude, "lng" to longitude)
}

internal class KotlinGoogleMap(element: Element?) : GoogleMap(element) {
    fun options(init: MapOptions.() -> Unit) {
        val options = MapOptions().apply(init)
        setOptions(options = options.toJson())
    }
}

internal fun kotlinGoogleMap(element: Element?, init: KotlinGoogleMap.() -> Unit) = KotlinGoogleMap(element).apply(init)

fun initMap() {
    val div = document.getElementById("map")
    kotlinGoogleMap(div) {
        options {
            zoom = 6
            center {
                latitude = 46.2050836
                longitude = 6.1090691
            }
        }
    }
}