package cc.algo;

public class Vertex {

  public enum COLOR { UNKNOWN, BLACK, WHITE, GRAY };
  
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

  public void color(COLOR color) {
    
    _color = color;
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
    
    buffer.append("{ ");
    buffer.append(_name);
    buffer.append(" color: ");
    
    switch (_color) {

    case BLACK:
      buffer.append("BLACK");
      break;

    case GRAY:
      buffer.append("GRAY ");
      break;

    case WHITE:
      buffer.append("WHITE");
      break;

    case UNKNOWN:
      buffer.append("     ");
      break;

    default:
      buffer.append(_color);
    } 

    buffer.append(" ts[");
    
    buffer.append(String.format("%2d", start_time()));
    
    buffer.append("-");
    
    buffer.append(String.format("%-2d", end_time()));

    buffer.append("]");

    buffer.append(" pi: ");
    
    buffer.append(_PI != null ? _PI.name() : " ");
    
    buffer.append(" }");    
    
    return buffer.toString();
  }
}
