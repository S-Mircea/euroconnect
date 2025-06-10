import java.io.File

fun main() {
    val graph = Graph()

    println("Welcome to the EuroConnect Telecommunications Network")
    println("Please enter the path to the file containing the distances between European capitals:")

    val filePath = readLine()
    if (filePath != null) {
        try {
            graph.loadGraphFromFile(filePath)
            println("Graph loaded successfully.")
            
            // Calculate and display the MST
            val mst = graph.calculateMST()
            println("Minimum Spanning Tree:")
            mst.edges.forEach {
                println("${it.start} - ${it.end}: ${it.weight}")
            }
            println("Total cable length required: ${mst.totalWeight}")
        } catch (e: Exception) {
            println("Error loading file: ${e.message}")
        }
    } else {
        println("File path is invalid.")
    }
}
