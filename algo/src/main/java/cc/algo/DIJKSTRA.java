package cc.algo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class DIJKSTRA {

  private String _solution = "";
  
  final private LinkedHashMap<Vertex, List<Vertex>> _vertices = new LinkedHashMap<>();

  public DIJKSTRA(String[] lines) {

    init(lines);
  }

  public boolean solve() {
    
    return false;
  }
  
  public String solution() {
    
    return _solution;
  }
 
  public String grid() {
    
    StringBuilder buffer = new StringBuilder();
    
    buffer.append("{\n");
    
    for (Vertex u : _vertices.keySet()) {

      buffer.append(u.toString());
      
      buffer.append(" -> ");

      buffer.append("[");

      for (Vertex v : _vertices.get(u)) {
        
        buffer.append(" " + v.name());
      }
            
      buffer.append(" ]");

      buffer.append("\n");
    }

    buffer.append("}");

    return buffer.toString();
  }

  private void init(String[] lines) {
    
    LinkedHashMap<Character, Vertex> mapper = 
        new LinkedHashMap<>();
        
    for (String line : lines) {
      
      Vertex vertex = new Vertex(line.charAt(0), 
          Vertex.COLOR.UNKNOWN);
      
      _vertices.put(vertex, new ArrayList<>());
      
      mapper.put(vertex.name(), vertex);
    }

    for (String line : lines) {

      if (line.length() < 2) {
        
        continue;
      }
      
      for (int c : line.substring(1).chars().sorted().toArray()) {
        
        _vertices.get(mapper.get(line.charAt(0))).add(
            mapper.get((char) c));
      }
    }
  }  
}
