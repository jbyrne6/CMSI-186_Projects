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
