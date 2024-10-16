package cc.algo;

public class Runner {

  public void runTOPSORT() {

    String[] _ts_v1 = new String[] { 
        "mqrx",
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
        "yv",
        "z"
    };

    @SuppressWarnings("unused")
    String[] _ts_v2 = new String[] { 
        "145",
        "25",
        "3",
        "456",
        "5",
        "69",
        "768",
        "89",
        "9"
    };

    @SuppressWarnings("unused")
    String[] _ts_v3 = new String[] { 
        "768",
        "145",
        "25",
        "3",
        "456",
        "5",
        "69",
        "89",
        "9"
    };

    TOPSORT ts = new TOPSORT(_ts_v1);

    System.out.println("start grid: " + ts.grid());

    if (!ts.solve()) {

      System.out.println("status: failed");

    } else {

      System.out.println("final grid: " + ts.grid());

      System.out.println("starts grid: " + ts.solution_starts());

      System.out.println("stops grid: " + ts.solution_stops());

      System.out.println("solution:   " + ts.solution());

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
