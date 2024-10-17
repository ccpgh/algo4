package cc.algo;

import java.util.LinkedHashMap;

public class DIJKSTRA {

  private String _solution = "";
  
  final private LinkedHashMap<Vertex, LinkedHashMap<Vertex, Integer>> _vertices = new LinkedHashMap<>();

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
      
      LinkedHashMap<Vertex, Integer> children = _vertices.get(u);
      
      for (Vertex v : children.keySet()) {
        
        buffer.append(" " + v.name() + "(" + children.get(v) + ")");
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

      String[] splits = line.split("\\.");
      
      if (splits[0].length() != 1) {
        
        throw new IllegalArgumentException("bad parameter");
      }
      
      Vertex vertex = new Vertex(splits[0].charAt(0), 
          Vertex.COLOR.UNKNOWN);
      
      _vertices.put(vertex, new LinkedHashMap<>());
      
      mapper.put(vertex.name(), vertex);
    }

    for (String line : lines) {

      String[] splits = line.split("\\.");

      if (splits.length < 2) {
        
        continue;
      }

      for (int i = 1; i < splits.length; i++) {
        
        String[] pair = splits[i].split("/"); // v.name and directional weight 
        
        if (pair.length != 2) {
          
          throw new IllegalArgumentException("bad parameter");
        }
        
        LinkedHashMap<Vertex, Integer> map = _vertices.get(mapper.get(splits[0].charAt(0)));
        
        Vertex v = mapper.get(pair[0].charAt(0));
        
        Integer w = Integer.parseInt(pair[1]);
        
        map.put(v, w);
      }
    }
  }  
}
