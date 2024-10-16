package cc.algo;

public class Runner {

  public void runTOPSORT() {

    String[] _ts_v1 = new String[] { 
        "mxqr",
        "noqu",
        "ors",
        "posz",
        "qt",
        "ruy",
        "sr",
        "t",
        "ut",
        "vxw",
        "wz",
        "x",
        "y",
        "z"
    };

    TOPSORT ts = new TOPSORT(_ts_v1);

    System.out.println("start grid: " + ts.grid());

    if (!ts.solve()) {

      System.out.println("status: failed");

    } else {

      System.out.println("final grid: " + ts.grid());

      System.out.println("solution: " + ts.solution());

      System.out.println("status:   ok");
    }
  }
  
  public void run() {

    runTOPSORT();
  }  

  public static void main(String[] args) {

    System.out.println("start.");

    Runner runner = new Runner();

    runner.run();

    System.out.println("fini.");
  }
  
}
