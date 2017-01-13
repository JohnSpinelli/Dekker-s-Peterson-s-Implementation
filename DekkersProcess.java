import java.util.concurrent.Semaphore;
import java.util.Random;

class DekkersProcess extends Thread {
  
  private int id;
  static volatile int turn = 0;
  static volatile boolean [] flag = new boolean[2]; 
  
  private Random rand = new Random();
  
  public DekkersProcess(int i) {
    id = i;
  }
  
  
  public int switchP(int i) {
    if (i == 1) {
      return 0;
    } else {
      return 1;
    }
  }
  
  public void run() {
    
    int pID = this.id; 
    
    for (int i = 0; i < 5; i++) {
      flag[pID] = true;
      while (flag[switchP(pID)]) {
        if (turn == switchP(pID)) {
          flag[pID] = false;
          while (flag[switchP(pID)] == true) {};
          flag[pID] = true;
        }
      }
      
             
    System.out.println("Thread " + this.id + " is starting iteration " + i);
    
    setSleep(20);
    
    System.out.println("We hold these truths to be self-evident, that all men are created equal,");
    
    setSleep(20);
    
    System.out.println("that they are endowed by their Creator with certain unalienable Rights,");
    
    setSleep(20);
    
    System.out.println("that among these are Life, Liberty and the pursuit of Happiness.");
    
    setSleep(20);
    
    System.out.println("Thread " + this.id + " is done with iteration " + i); 
    
    turn = switchP(pID);
    flag[pID] = false;
    
  }
  }
  
  public void setSleep(int time) {
    try {Thread.sleep(rand.nextInt(time));}
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
  
  public static void main(String[] args) {
     
    final int N = 2;
    DekkersProcess[] p = new DekkersProcess[N];
    
    for (int i = 0; i < N; i++) {
      p[i] = new DekkersProcess(i);
      p[i].start();
    }
  }
}