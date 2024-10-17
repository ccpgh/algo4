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

      for (Vertex v : _vertices.get(u).keySet()) {
        
        buffer.append(" " + v.nameI());
      }
            
      buffer.append(" ]");

      buffer.append("\n");
    }

    buffer.append("}");

    return buffer.toString();
  }

  private void init(String[] lines) {
    
    LinkedHashMap<Integer, Vertex> mapper = 
        new LinkedHashMap<>();
        
    for (String line : lines) {

      String[] splits = line.split("\\.");
      
      System.out.println("splits " + splits.length + " from '" + line + "'");

      Vertex vertex = new Vertex((char) (Integer.parseInt(splits[0])), 
          Vertex.COLOR.UNKNOWN, true);
      
      _vertices.put(vertex, new LinkedHashMap<>());
      
      mapper.put(vertex.nameI(), vertex);
    }

    for (String line : lines) {

      String[] splits = line.split("\\.");

      if (splits.length < 2) {
        
        continue;
      }

      for (int i = 1; i < splits.length; i++) {
        
        String[] pair = splits[i].split("/"); // v.nameI and directional weight 
        
        if (pair.length != 2) {
          
          throw new IllegalArgumentException("bad configuration");
        }
        
        LinkedHashMap<Vertex, Integer> map = _vertices.get(mapper.get(Integer.parseInt(splits[0])));
        
        Vertex v = mapper.get(Integer.parseInt(pair[0]));
        
        Integer w = Integer.parseInt(pair[1]);
        
        System.out.println(map.toString());

        System.out.println(v.toString());

        System.out.println(w);
        
        map.put(v, w);
      }
    }
  }  
}
