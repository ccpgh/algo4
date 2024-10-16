package cc.algo;

public class Vertex {

  public enum COLOR { UNKNOWN, BLACK, WHITE };
  
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
  
  public COLOR color() {
    
    return _color;
  }

  public int start_time() {
    
    return _start_time;
  }

  public void start_time(int time) {
    
    _start_time = time;
  }

  public int end_time() {
    
    return _end_time;
  }
  
  public void end_time(int time) {
    
    _end_time = time;
  }

  public void pi(Vertex PI) {
    
    _PI = PI;
  }
  
  public Vertex pi() {
    
    return _PI;
  }

  public String toString() {
    
    StringBuilder buffer = new StringBuilder();
    
    buffer.append("{");
    buffer.append(_name);
    buffer.append(" color: ");
    buffer.append(_color);
    if (_PI != null) {
      buffer.append(" parent: ");
      buffer.append(_PI.name());
    }
    buffer.append("}");    
    
    return buffer.toString();
  }
}
