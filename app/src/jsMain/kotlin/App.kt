import com.prasanth.kmmjsapp.Greeting
import com.prasanth.kmmjsapp.Item
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

external fun require(module:String):dynamic
fun main(){
    println("Hello JavaScript!")

    val http = require("http")
    val hostname = "127.0.0.1"
    val port = 3000

    println("Server will try to run at http://${hostname}:${port}/")

    val server = http.createServer{req, res ->
        if (req.url.equals("/items")) {
            res.statusCode = 200
            res.setHeader("Content-Type", "application/json")
            val items = listOf(
                Item("1","soap",20.56),
                Item("2","comb",50.25)
            )
            res.end(Json.encodeToString(items))
        } else {
            res.statusCode = 200
            res.setHeader("Content-Type", "text/plain")
            res.end(Greeting().greet())
        }
    }

    server.listen(port, hostname, fun() {
        println("Server running at http://${hostname}:${port}/")
    })
}