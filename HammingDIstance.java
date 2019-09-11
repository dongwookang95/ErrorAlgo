import java.util.List;

class Solution {

  /**
   * Calculates the hamming distance of the given code, or returns -1 if it cannot be calculated.
   *
   * @param code The code
   * @return The hamming distance of the given code , or -1 if it cannot be calculated
   */
   
  
  public static long calculate(List<Long> code) {
      if(code == null || code.size() == 0 || code.size() == 1){
        return -1;
      }
      long m;
      long hammingDistance = 9999;
      for(int i = 0; i< code.size(); i++){
        for(int j = i+1; j<code.size(); j++){
          long testResult = calcCRC(code.get(i), code.get(j));
          m = Long.bitCount(testResult);
          while(m<hammingDistance){
            hammingDistance = m;
          }
          }
         
        }
        	return hammingDistance;

  }
      public static long calcCRC(Long a, Long b){
        long calcResult = a^b;
        return calcResult;
      }
 
		}
  
