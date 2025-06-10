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

        fun find(vertex: String): String {
            if (parent[vertex] != vertex) {
                parent[vertex] = find(parent[vertex]!!)
            }
            return parent[vertex]!!
        }

        fun union(vertex1: String, vertex2: String) {
            val root1 = find(vertex1)
            val root2 = find(vertex2)
            if (root1 != root2) {
                if (rank[root1]!! > rank[root2]!!) {
                    parent[root2] = root1
                } else if (rank[root1]!! < rank[root2]!!) {
                    parent[root1] = root2
                } else {
                    parent[root2] = root1
                    rank[root1] = rank[root1]!! + 1
                }
            }
        }

        sortedEdges.forEach { edge ->
            val root1 = find(edge.start)
            val root2 = find(edge.end)

            if (root1 != root2) {
                mstEdges.add(edge)
                totalWeight += edge.weight
                union(root1, root2)
            }
        }

        return MSTResult(mstEdges, totalWeight)
    }
}
