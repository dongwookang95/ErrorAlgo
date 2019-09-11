class Solution {

    /**
     * Calculates the CRC check value, or -1 if it cannot be calculated.
     *
     * @param bitSequence The input bit sequence
     * @param inputLength The length of the input bit sequence (including possible leading zeros)
     * @param generatorSequence The generator bit sequence
     * @return The CRC check value
     */
    public static long calculateCRC(long bitSequence, int inputLength, long generatorSequence) {
      if(inputLength<=0 || inputLength < calcLength(generatorSequence)) {
        return -1;
      }
      long crcBitResult = bitSequence<<calcLength(generatorSequence)-1;
      long crcGenResult = generatorSequence << calcLength(crcBitResult) - calcLength(generatorSequence);
      while(calcLength(crcBitResult)>calcLength(generatorSequence)-1){
        if(calcLength(crcBitResult) == calcLength(crcGenResult)){
          crcBitResult = crcBitResult^crcGenResult;
          crcGenResult = crcGenResult>>calcLength(crcGenResult)-calcLength(crcBitResult);
        }
      }
    return crcBitResult;
    }
  
  
    public static int calcLength(long a){
      int result = (int)Math.floor(Math.log(a)/Math.log(2)+1);
      return result;
    }
    /**
     * Checks the correctness of the bit sequence.
     *
     * @param bitSequence The CRC bit sequence including the CRC check value
     * @param inputLength The length of the input bit sequence (including possible leading zeros)
     * @param generatorSequence The generator bit sequence used
     * @param checkSequence The CRC check value to check against
     * @return true if the sequence is correct, false otherwise
     */
    public static boolean checkCRC(long bitSequence, int inputLength, long generatorSequence, long checkSequence) {
      long resultCRC = calculateCRC(bitSequence, inputLength, generatorSequence);
      boolean result = false;
      if(checkSequence == resultCRC){
        result = true;
      }
      return result;
    }
  }