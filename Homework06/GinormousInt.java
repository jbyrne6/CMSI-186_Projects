public class GinormousInt{
  public static final GinormousInt ZERO = new GinormousInt("0");
  public static final GinormousInt ONE = new GinormousInt("1");
  public static final GinormousInt TEN = new GinormousInt("10");
  private String gStr;
  private int gInt;
  private String sign = "";
  private int[] intArray;
  private boolean isGreaterThan = false;
  private boolean isLessThan = false;
  private int equalCounter = 0;
  private String intString = "";
  private String intToString;
  char[] charArrayNoSign;
  private String myNumber = "";
  private String reversed = "";
  private byte[] a        = null;
  private byte[] b        = null;

  //Constructor
  public GinormousInt(String value){
    //System.out.println("Value: " + value);
    //get rids of spaces
    gStr = value.trim();
    //creates character array
    char[] charArray = gStr.toCharArray();
    if(charArray[0] == '+' || charArray[0] == '-'){
      //gets the sign
      sign = String.valueOf(charArray[0]);
      //deletes sign
      gStr = gStr.substring(1,charArray.length);
      charArrayNoSign = gStr.toCharArray();
      //split string into parts
      intArray = new int[charArrayNoSign.length];
      for(int i=0; i<intArray.length;i++){
        intArray[i] = Character.getNumericValue(charArrayNoSign[i]);
        intString = intString + Character.toString(charArrayNoSign[i]);
      }
    }else{
      charArrayNoSign = gStr.toCharArray();
      intArray = new int[charArrayNoSign.length];
      for(int n=0; n<intArray.length; n++){
        intArray[n] = Character.getNumericValue(charArrayNoSign[n]);
        intString = intString + Character.toString(charArrayNoSign[n]);
      }
    }
  }

  public int compareTo(GinormousInt value){
/*
    if(intArray.length<value.intArray.length){
      return -1;
    }else if(intArray.length>value.intArray.length){
      return 1;
    }else if(intArray.length == value.intArray.length){
      for(int i=0;i<intArray.length;i++){
        if(intArray[i] == value.intArray[i]){
          return 0;
        }else if(intArray[i]>value.intArray[i]){
          isGreaterThan = true;
        }else if(intArray[i]<value.intArray[i]){
          isLessThan = true;
        }
      }
    }
    if(isLessThan == true){
      return -1;
    }
    if(isGreaterThan == true){
      return 1;
    }
*/
    int var = intString.compareTo(value.intString);
    if(intString.compareTo(value.intString) == 4){
      var = 1;
    }else if(intString.compareTo(value.intString) == -4){
      var = -1;
    }
    return var;
    //throw new UnsupportedOperationException("Not working yet.");
  }


  public boolean equals(GinormousInt x){
    if(intArray.length != x.intArray.length){
      return false;
    }else{
      for(int i=0;i<intArray.length;i++){
        if(intArray[i] == x.intArray[i]){
          equalCounter += 1;
        }else{
          equalCounter = equalCounter;
        }
      }
      if(equalCounter == intArray.length){
        return true;
      }else{
        return false;
      }
    }
    //throw new UnsupportedOperationException("Not working yet.");
  }

//  g1.add(g2)

  public GinormousInt add(GinormousInt value){;
    int addCarry = 0;
    int piece = 0;
    String pieceString = "";
    String addAnswerString = "";
    if(intString.length() > value.intString.length()){
      for(int i=0;i<charArrayNoSign.length-value.charArrayNoSign.length;i++){
        value.intString = "0" + value.intString;
      }
    }else if(intString.length() < value.intString.length()){
      for(int i=0;i<value.charArrayNoSign.length-charArrayNoSign.length;i++){
        intString  = "0" + intString;
      }
    }
    String[] intStringArray1 = intString.split("");
    String[] intStringArray2 = value.intString.split("");

    for(int k=0;k<intStringArray1.length;k++){
      piece = addCarry + Integer.parseInt(intStringArray1[intStringArray1.length-(k+1)]) + Integer.parseInt(intStringArray2[intStringArray2.length-(k+1)]);
      pieceString = Integer.toString(piece);
      addCarry = 0;
      if(pieceString.length() > 1){
        String[] parts = pieceString.split("");
        addCarry = Integer.parseInt(parts[0]);
        piece = Integer.parseInt(parts[1]);
        pieceString = parts[1];
      }
      addAnswerString = pieceString + addAnswerString;
      System.out.println("Piece String " + pieceString);
      System.out.println("Carry " + addCarry);
      System.out.println("piece "  + piece);
    }
    System.out.println(sign);

    return new GinormousInt(sign + addAnswerString);

    //throw new UnsupportedOperationException("Not working yet.");
  }

  public GinormousInt subtract(GinormousInt value){
    int piece = 0;
    String pieceString = "";
    String subAnswerString = "";
    if(intString.length() > value.intString.length()){
      for(int i=0;i<charArrayNoSign.length-value.charArrayNoSign.length;i++){
        value.intString = "0" + value.intString;
      }
    }else if(intString.length() < value.intString.length()){
      for(int i=0;i<value.charArrayNoSign.length-charArrayNoSign.length;i++){
        intString  = "0" + intString;
      }
    }
    //System.out.println("IS : " + intString);
    //System.out.println("VIS: " + value.intString);
    String[] intStringArrayTop;
    String[] intStringArrayBot;
    if(compareTo(value) > 0){
      intStringArrayTop = intString.split("");
      intStringArrayBot = value.intString.split("");
    }else if(compareTo(value) < 0){
      intStringArrayTop = value.intString.split("");
      intStringArrayBot = intString.split("");
    }else{
      intStringArrayTop = intString.split("");
      intStringArrayBot = value.intString.split("");
    }
    for(int i=0; i<intStringArrayTop.length;i++){
      if(Integer.parseInt(intStringArrayTop[intStringArrayTop.length-(i+1)]) < Integer.parseInt(intStringArrayBot[intStringArrayBot.length-(i+1)])){
        intStringArrayTop[intStringArrayTop.length-(i+2)] = Integer.toString(Integer.parseInt(intStringArrayTop[intStringArrayTop.length-(i+2)]) - 1);
        intStringArrayTop[intStringArrayTop.length-(i+1)] = Integer.toString(Integer.parseInt(intStringArrayTop[intStringArrayTop.length-(i+1)]) + 10);
      }
      piece = Integer.parseInt(intStringArrayTop[intStringArrayTop.length-(i+1)]) - Integer.parseInt(intStringArrayBot[intStringArrayBot.length-(i+1)]);
      pieceString = Integer.toString(piece);
      subAnswerString = pieceString + subAnswerString;
    }

    return new GinormousInt(sign + subAnswerString);
    //throw new UnsupportedOperationException("Not working yet.");
  }

  public GinormousInt multiply(GinormousInt value){
    throw new UnsupportedOperationException("Not working yet.");
  }

  public GinormousInt divide(GinormousInt value){
    throw new UnsupportedOperationException("Not working yet.");
  }

  public GinormousInt remainder(GinormousInt value){
    throw new UnsupportedOperationException("Not working yet.");
  }
  // Constructor in reverse
  // change int array to a string
  public String toString(){
    //throw new UnsupportedOperationException("Not working yet.");
    intToString = Integer.toString(intArray[0]);
    for(int i=1;i<intArray.length;i++){
      intToString = intToString + Integer.toString(intArray[i]);
    }
    if(intToString.length() == charArrayNoSign.length){
      intToString = sign + intToString;
    }
    return intToString;
  }

  public static GinormousInt valueOf(long value){
    String longString;
    longString = String.valueOf(value);
    return new GinormousInt(longString);
    //String[] lsParts = longString.split("");
    //throw new UnsupportedOperationException("Not working yet.");
  }

  public String halve( String input ) {

    // declare and initialize the variables
     int          j        = 0;
     String       result_s = null;
     StringBuffer result   = null;

     myNumber = input;
     reversed = new String( new StringBuffer( myNumber ).reverse() );
     a = new byte[myNumber.length() + 1];   // extra place to handle "carry"
     b = new byte[myNumber.length()];

    // assign the values to the byte array
     for( int i = 0; i < a.length - 1; i++ ) {
        a[i] = (byte)((int)(myNumber.charAt(i)) - 48);         // NOTE: only works for ASCII
     }

    // do the division
     for( int i = 0; i < b.length; i++ ) {
        b[i] = (byte)((int)a[i] / 2);
        if( 1 == ((int)a[i] - ((int)b[i] * 2)) ) {
           a[i+1] = (byte)((int)a[i+1] + 10);
        }
     }

    // build the result string to pass back
     result = new StringBuffer();
     for( int i = 0; i < a.length - 1; i++ ) {
        if( 0 == b[i] ) {
           continue;
        }
        result = result.append( (int)b[i] );
     }
     return new String( result );

  }
}
