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
  
  public void runSCC() {

    String[] _scc_v1 = new String[] { 
        "qstw",
        "ruy",
        "sv",
        "txy",
        "uy",
        "vw",
        "ws",
        "xz",
        "yq",
        "zx"
    };

    SCC scc1 = new SCC(_scc_v1);

    {
      System.out.println("start grid: " + scc1.grid());

      if (!scc1.solve()) {

        System.out.println("status: failed");

      } else {

        System.out.println("final grid: " + scc1.grid());

        System.out.println("starts grid: " + scc1.solution_starts());

        System.out.println("stops grid: " + scc1.solution_stops());

        System.out.println("solution:   " + scc1.solution());

        System.out.println("status:   ok");
      }
    }

    {
      String order = scc1.solution().replaceAll("\\s", "");

      String[] _scc_v2 = Common.reorder(Common.transpose(_scc_v1), order);

      SCC scc2 = new SCC(_scc_v2);

      System.out.println("start grid: " + scc2.grid());

      if (!scc2.solve()) {

        System.out.println("status: failed");

      } else {

        System.out.println("final grid: " + scc2.grid());

        System.out.println("starts grid: " + scc2.solution_starts());

        System.out.println("stops grid: " + scc2.solution_stops());

        System.out.println("solution:   " + scc2.solution());

        System.out.println("status:   ok");
      }
    }
  }
  
  public void run() {

    runSCC();
  }  

  public static void main(String[] args) {

    System.out.println("start.");

    Runner runner = new Runner();

    runner.run();

    System.out.println("fini.");
  }
  
}
