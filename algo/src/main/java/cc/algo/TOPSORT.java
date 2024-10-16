package cc.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class TOPSORT {
  
  final private LinkedHashMap<Vertex, List<Vertex>> _adjacents = new LinkedHashMap<>();

  final private String[] _ts;
  
  private String _solution = "";

  public TOPSORT(String[] ts) {

    _ts = ts;
    
    init();
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
    
    _adjacents.keySet().forEach(key->{
      buffer.append(key.toString());
      buffer.append(" -> ");
      _adjacents.get(key).forEach(v->{
        buffer.append(v.name());
      });
      buffer.append("\n");
    });

    buffer.append("}");

    return buffer.toString();
  }

  private void init() {
    
    LinkedHashMap<Character, Vertex> mapper = 
        new LinkedHashMap<>();
        
    Arrays.asList(_ts).forEach(line->{
      Vertex vertex = new Vertex(line.charAt(0), 
          Vertex.COLOR.WHITE);
      _adjacents.put(vertex, new ArrayList<>());
      mapper.put(vertex.name(), vertex);
    });

    Arrays.asList(_ts).forEach(line->{
      if (line.length() > 1) {
        line.substring(1).chars().sorted().forEach(c->{        
          _adjacents.get(mapper.get(line.charAt(0))).add(mapper.get((char) c));
        });
      }
    });
  }  
}