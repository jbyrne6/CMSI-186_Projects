public class GinormousInt{
  public static final GinormousInt ZERO = new GinormousInt("0");
  public static final GinormousInt ONE = new GinormousInt("1");
  public static final GinormousInt TEN = new GinormousInt("10");
  private String gStr;
  private int gInt;
  private String sign;
  private int[] intArray;
  private boolean isGreaterThan = false;
  private boolean isLessThan = false;
  private int equalCounter = 0;
  private String intString;
  private String intToString;

  //Constructor
  public GinormousInt(String value){
    //get rids of spaces
    gStr = value.trim();
    //creates character array
    char[] charArray = gStr.toCharArray();
    if(charArray[0] == '+' || charArray[0] == '-'){
      //gets the sign
      String sign = String.valueOf(charArray[0]);
      //deletes sign
      gStr = gStr.substring(1,charArray.length);
      char[] charArrayNoSign = gStr.toCharArray();
      //split string into parts
      intArray = new int[charArrayNoSign.length];
      for(int i=0; i<intArray.length;i++){
        intArray[i] = Character.getNumericValue(charArrayNoSign[i]);
        intString = intString + Character.toString(charArrayNoSign[i]);
      }
    }else{
      String[] gStrParts = gStr.split("");
      intArray = new int[gStrParts.length];
      for(int i=0; i<gStrParts.length; i++){
        intArray[i] = Integer.parseInt(gStrParts[i]);
      }
    }
  }

  public int compareTo(GinormousInt value){
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
    throw new UnsupportedOperationException("Not working yet.");
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

  public GinormousInt add(GinormousInt value){
    int addCarry = 0;
    int piece = 0;
    String pieceString = "";
    String answerString = "";
    if(intArray.length > value.intArray.length){
      for(int i=0;i<intArray.length-value.intArray.length;i++){
        value.intString = "0" + value.intString;
      }
    }else if(intArray.length < value.intArray.length){
      for(int i=0;i<value.intArray.length-intArray.length;i++){
        intString  = "0" + intString;
      }
    }else{

    }
    String[] intStringArray1 = intString.split("");
    String[] intStringArray2 = value.intString.split("");
    //for(int j=0;j<intStringArray1.length;j++){
    //  intArray[j] = Integer.parseInt(intStringArray1[j]);
    //  value.intArray[j] = Integer.parseInt(intStringArray2[j]);
    //}
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
      answerString = pieceString + answerString;
    }
    if(addCarry != 0){
      answerString = Integer.toString(addCarry) + answerString;
    }
    return new GinormousInt(answerString);

    //throw new UnsupportedOperationException("Not working yet.");
  }

  public GinormousInt subtract(GinormousInt value){
    throw new UnsupportedOperationException("Not working yet.");
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
    return intToString;
  }

  public static GinormousInt valueOf(long value){
    String longString;
    longString = String.valueOf(value);
    return new GinormousInt(longString);
    //String[] lsParts = longString.split("");
    //throw new UnsupportedOperationException("Not working yet.");
  }
}
