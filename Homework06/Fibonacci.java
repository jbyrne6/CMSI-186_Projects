/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  Fibonacci.java
 * Purpose    :  Find the fibonacci number at a specified place n
 * @author    :  James Byrne
 * Date       :  2017-04-20
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-20  James Byrne  Initial writing and release
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Fibonacci{
  private static GinormousInt answer = new GinormousInt("0");
  private static GinormousInt twoBack = GinormousInt.ZERO;
  private static GinormousInt oneBack = GinormousInt.ONE;

  public static GinormousInt getNum(int n){
    if(n == 1){
      return twoBack;
    }else if(n == 2){
      return oneBack;
    }else{
      for(int i=2;i<n;i++){
        answer = twoBack.add(oneBack);
        twoBack = oneBack;
        oneBack = answer;
      }
    }
    return answer;
  }
  public static void main(String args[]){
    System.out.println(getNum(Integer.parseInt(args[0])));
  }
}
