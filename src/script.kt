import google.maps.GoogleMap
import kotlin.browser.document
import kotlin.js.json


internal class MapOptions(val center: LatitudeLongitude, val zoom: Byte)
internal class LatitudeLongitude(val latitude: Double, val longitude: Double)

internal fun LatitudeLongitude.toJson() = json("lat" to latitude, "lng" to longitude)
internal fun MapOptions.toJson() = json("center" to center.toJson(), "zoom" to zoom)

fun initMap() {
    val div = document.getElementById("map")
    val latLng = LatitudeLongitude(latitude = -34.397, longitude = 150.644)
    val options = MapOptions(center = latLng, zoom = 8)
    GoogleMap(element = div, options = options.toJson())
}