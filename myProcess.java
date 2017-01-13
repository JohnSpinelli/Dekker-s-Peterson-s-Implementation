import java.util.concurrent.Semaphore;
import java.util.Random;

class myProcess extends Thread {
  
  private int id;
  static volatile int turn = 0;
  static volatile boolean [] flag = new boolean[2]; 
  
  private Random rand = new Random();
  
  public myProcess(int i) {
    id = i;
  }
  
  
  
  public void run() {
    
    int pID = this.id; 
    
    for (int i = 0; i < 5; i++) {
      
      System.out.println("Thread " + this.id + " is starting iteration " + i);
      
      setSleep(20);
      
      System.out.println("We hold these truths to be self-evident, that all men are created equal,");
      
      setSleep(20);
      
      System.out.println("that they are endowed by their Creator with certain unalienable Rights,");
      
      setSleep(20);
      
      System.out.println("that among these are Life, Liberty and the pursuit of Happiness.");
      
      setSleep(20);
      
      System.out.println("Thread " + this.id + " is done with iteration " + i); 
      
      
      
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
    myProcess[] p = new myProcess[N];
    
    for (int i = 0; i < N; i++) {
      p[i] = new myProcess(i);
      p[i].start();
    }
  }
}