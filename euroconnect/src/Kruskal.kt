object KruskalAlgorithm {
    fun findMST(vertices: Set<String>, edges: List<Edge>): MSTResult {
        val sortedEdges = edges.sortedBy { it.weight }
        val parent = mutableMapOf<String, String>()
        val rank = mutableMapOf<String, Int>()
        val mstEdges = mutableListOf<Edge>()
        var totalWeight = 0.0

        vertices.forEach { vertex ->
            parent[vertex] = vertex
            rank[vertex] = 0
        }