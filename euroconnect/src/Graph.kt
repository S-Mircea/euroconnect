import java.io.File

data class Edge(val start: String, val end: String, val weight: Double)

class Graph {
    private val edges = mutableListOf<Edge>()
    private val vertices = mutableSetOf<String>()

    fun addEdge(start: String, end: String, weight: Double) {
        edges.add(Edge(start, end, weight))
        vertices.add(start)
        vertices.add(end)
    }

    fun loadGraphFromFile(filePath: String) {
        File(filePath).forEachLine { line ->
            if (line.startsWith("Distance") || line.isBlank()) {
                return@forEachLine
            }

            try{
            val parts = line.split(",")
            if (parts.size == 3) {
                val start = parts[0].trim()
                val end = parts[1].trim()
                val weight = parts[2].trim().toDouble()
                addEdge(start, end, weight)
            }
        }
        catch(e: NumberFormatException){
            println("Invalid number format in line: $line")
        }
        }
    }

    fun calculateMST(): MSTResult {
        return KruskalAlgorithm.findMST(vertices, edges)
    }
}

data class MSTResult(val edges: List<Edge>, val totalWeight: Double)
