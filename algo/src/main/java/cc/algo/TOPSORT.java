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

  private boolean topological_sort(List<Vertex> buffer) {
      
    if (!dfs(buffer)) {

      return false;
    }
    
    return true;
  }

  private boolean dfs(List<Vertex> buffer) {
    
    for (Vertex v : _vertices.keySet()) {
      
      v.color(Vertex.COLOR.WHITE);
      
      v.pi(null);
    }
    
    _time = 0;

    System.out.println("grid: " + grid());

    for (Vertex v : _vertices.keySet()) {
      
      if (v.color() == Vertex.COLOR.WHITE) {
        
        if (!dfs_visit(v, buffer)) {
          
          return false;
        }
      }
    }
    
    return true;
  }

  private boolean dfs_visit(Vertex u, List<Vertex> buffer) {
    
    _time++;
    
    u.start_time(_time);

    System.out.println("grid[" + _time + "]: name:" + u.name() + " " + grid());

    u.color(Vertex.COLOR.GRAY);
    
    for (Vertex v : _vertices.get(u)) {
      
      if (v.color() == Vertex.COLOR.WHITE) {
        
        v.pi(u);
        
        if (!dfs_visit(v, buffer)) {
          
          return false;
        }
      }
    }

    u.color(Vertex.COLOR.BLACK);
    
    buffer.add(0, u);
    
    _time++;

    u.end_time(_time);
    
    return true;
  }

  public boolean solve() {

    List<Vertex> vertices = new ArrayList<>();
    
    StringBuilder buffer = new StringBuilder();

    boolean result = topological_sort(vertices);
    
    buffer.append("{\n");
    
    for (Vertex u : vertices) {

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
    
    _solution = buffer.toString();
    
    return result;
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