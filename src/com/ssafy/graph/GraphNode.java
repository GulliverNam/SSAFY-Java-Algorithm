package com.ssafy.graph;

public class GraphNode {
	public int vertex;
	public GraphNode link;
	public GraphNode() {}
	public GraphNode(int vertex, GraphNode link) {
		this.vertex = vertex;
		this.link = link;
	}
	@Override
	public String toString() {
		String linkStr = link == null ? "" : link.toString();
		return new StringBuilder(linkStr.length()+3).append(vertex)
		      .append(" -> ").append(linkStr).toString();
	}
}
