package cc.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class TOPSORT {
  
  final private LinkedHashMap<Vertex, List<Vertex>> _vertices = new LinkedHashMap<>();

  private String _solution = "";

  public TOPSORT(String[] lines) {

    init(lines);
  }

  private boolean topological_sort() {
    
    if (!dfs()) {

      return false;
    }
    
    return true;
  }

  private boolean dfs() {
    
    return true;
  }

  private boolean dfs_visit() {
    
    return true;
  }

  public boolean solve() {

    return topological_sort();
  }
  
  public String solution() {
    
    return _solution;
  }

  public String grid() {
    
    StringBuilder buffer = new StringBuilder();
    
    buffer.append("{");
    buffer.append("\n");
    
    for (Vertex vertex : _vertices.keySet()) {

      buffer.append(vertex.toString());
      buffer.append(" -> ");

      _vertices.get(vertex).forEach(v->{
        buffer.append(v.name());
      });
      
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
      
      for (int c : line.substring(1).chars().sorted().
          toArray()) {
        
        _vertices.get(mapper.get(line.charAt(0))).add(
            mapper.get((char) c));
      }
    }
  }  
}