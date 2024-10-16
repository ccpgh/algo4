package cc.algo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class TOPSORT {
  
  final private LinkedHashMap<Vertex, List<Vertex>> _vertices = new LinkedHashMap<>();

  private String _solution = "";
  
  private int _time = 0;

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
    
    for (Vertex v : _vertices.keySet()) {
      
      v.color(Vertex.COLOR.WHITE);
      
      v.pi(null);
    }
    
    _time = 0;

    System.out.println("grid: " + grid());

    for (Vertex v : _vertices.keySet()) {
      
      if (v.color() == Vertex.COLOR.WHITE) {
        
        if (!dfs_visit(v)) {
          
          return false;
        }
      }
    }
    
    return true;
  }

  private boolean dfs_visit(Vertex u) {
    
    _time++;
    
    u.start_time(_time);

    System.out.println("grid: " + u.name() + " " + _time + " " + grid());

    u.color(Vertex.COLOR.GRAY);
    
    for (Vertex v : _vertices.get(u)) {
      
      if (v.color() == Vertex.COLOR.WHITE) {
        
        v.pi(u);
        
        if (!dfs_visit(v)) {
          
          return false;
        }
      }
    }

    u.color(Vertex.COLOR.BLACK);
    
    _time++;

    u.end_time(_time);
    
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
      
      for (int c : line.substring(1).chars().sorted().
          toArray()) {
        
        _vertices.get(mapper.get(line.charAt(0))).add(
            mapper.get((char) c));
      }
    }
  }  
}