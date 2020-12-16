package Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
	/**
	 * 
	 * @author viral
	 * Long running task which is candidates for asynchronous processing and the future interface.
	 */
public class CallableFutureExample {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        
        List<Future<Integer>> resultList = new ArrayList<>();
         
        Random random = new Random();
         
        for (int i=0; i<4; i++)
        {
            Integer number = random.nextInt(10);
            FactorialCalculator calculator  = new FactorialCalculator(2);
            Future<Integer> result = executor.submit(calculator);
            try {
            	result.get(500, TimeUnit.MILLISECONDS);
            }catch(Exception e) {
            	System.out.println("Task should be required to complete in time");
            }
            
            resultList.add(result);
        }
         
        for(Future<Integer> future : resultList)
        {
              try
              {
                  System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
              }
              catch (InterruptedException | ExecutionException e)
              {
                  e.printStackTrace();
              }
          }
          //shut down the executor service now
          executor.shutdown();
	}
}


class FactorialCalculator implements Callable<Integer>
{
 
    private Integer number;
 
    public FactorialCalculator(Integer number) {
        this.number = number;
    }
 
    @Override
    public Integer call() throws Exception {
        int result = 1;
        if ((number == 0) || (number == 1)) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(20000);
            }
        }
        System.out.println("Result for number - " + number + " -> " + result);
        return result;
    }
}