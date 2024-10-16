package cc.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class TOPSORT {

  public class Vertex {

    public enum COLOR { COLOR_WHITE, COLOR_BLACK };
    
    final private Character _name;

    private Vertex _PI = null;
    
    private COLOR _color;

    private Integer _start_time = 0;
    
    private Integer _end_time = 0;
    
    public Vertex(char name, COLOR color) {
      
      _name = name;
      
      _color = color;
    }
    
    public Character name() {
      
      return _name;
    }
  }
  
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
    
    _adjacents.keySet().forEach(key->{
      buffer.append(key.name());
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
          Vertex.COLOR.COLOR_WHITE);
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

  /*
  public int M() {
    
    return _M;
  }
  
  public int n() {
    
    return _n;
  }

  public String V() {
    
    return Common.fold(_V);
  }
  
  public String W() {
    
    return Common.fold(_W);
  }
  
  public boolean solve() {

    int[] optimal = valuation(0, _n);

    _solution = "(value, weight, count) = (" + optimal[0] + "," + optimal[1] + "," + optimal[2] + ")";
    
    return optimal[0] != Integer.MIN_VALUE && optimal[1] != Integer.MAX_VALUE;
  }

  public int[] valuation(int i, int j) {

    String key = "" + i + "-" + j;
       
    if (_memory.containsKey(key)) {
      
      return _memory.get(key);
    }

    if (i == j) {
    
      int[] value = new int[] { 0, 0, 0 };
      
      if (value[1] > _M) {
      
        value = _default;       
      } 
            
      _memory.put(key, value);
      
      return value;
    }

    if ((j-i) == 1) {
            
      int[] value = new int[] { _V[i], _W[i], 1 };

      if (value[1] > _M) {
        
        value = _default;       
      } 

      _memory.put(key, value);

      return value;
    }

    int[] result = _default;
    
    for (int k = i; k < j; k++) {

      int[] lhs = valuation(i, k);
      
      int[] rhs = valuation(k + 1, j);

      _memory.put("" + i + "-" + k, lhs);

      _memory.put("" + (k+1) + "-" + j, rhs);

      if (lhs[1] <= _M && rhs[1] <= _M) {

        if ((lhs[1] + rhs[1]) <= _M &&
            (lhs[0] + rhs[0]) > result[0]) {

          result = new int[] { lhs[0] + rhs[0], lhs[1] + rhs[1], lhs[2] + rhs[2]};
        }
      } 
    }
    
    return result;
  }
      */
  
}