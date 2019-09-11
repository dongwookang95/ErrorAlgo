class Solution {

    public static long checkAmount(int inputLength){
        long pamount = 0;
        for(int i = 1; i <= pamount + inputLength; i++){
            if(i > 0 && ((i & (i - 1)) == 0)){
                pamount++;
            }
        }
        return pamount;
    }


    public static boolean checkParity(long input){
        return ((input !=0) && ((input &(input -1)) == 0));
    }



    public static boolean checkBit(long check){
        return ((check & 1) > 0);
    }


    public static boolean checkCurrent(long a, long b) {
        return ((a&b)>0);
    }

    public static long calcHamming(long bitSequence, int inputLength, boolean isEvenParity){
        long pointer = 1;
        long pointerAdd = 1;
        long result = 0;
        long totalLength = checkAmount(inputLength) + inputLength;
        for (long i = pointer; i<=totalLength; i++ ){

            if (checkParity(i) == true){
                System.out.println("Parity bit: " + i);
                long inPoint = i + 1;
                long count = 0L;

                for (long j = inPoint; j<=totalLength; j++){
                    if (checkParity(j) == false){
                        if(checkCurrent(j, i) == true){
                            long tempCount = 0;

                            for(long k = j; k > 0; k--){
                                if (checkParity(k) == false){
                                    tempCount++;
                                }
                            }
                            long check = bitSequence >> (inputLength - tempCount);
                            if (checkBit(check) == true){
                                count ++;
                            }
                        }
                    }
                }

                if (isEvenParity) {
                    if ((count % 2) != 0) {
                        result = result | 1;
                    }
                } else {
                    if ((count % 2) == 0) {
                        result = result | 1;
                    }
                }

            }
            else{
                long check = bitSequence >>(inputLength - pointerAdd);
                if (checkBit(check) == true){
                    result = result | 1;
                }
                pointerAdd++;
            }
            result = result<<1;
            pointer++;
        }
        return result>>1;
    }




  /**
   * Returns the corrected (if needed) hamming code of the given bit sequence.
   *
   * @param bitSequence The Hamming code bit sequence
   * @param inputLength The length of the input bit sequence (including possible leading zeros)
   * @param isEvenParity Boolean indicating if the hamming algorithm should use even parity or not
   * @return The correct Hamming code sequence
   */
  public static long checkHamming(long bitSequence, int inputLength, boolean isEvenParity) {
  
        long result = 0;

        for(long i = inputLength; i>= 1 ; i--){
            if (checkParity(i) == true) {
                long point = i;
                long count = 0;

                for (long j = point; j <= inputLength; j++) {
                    if (checkCurrent(i, point) == true) {
                        long check = bitSequence >> (inputLength - point);

                        if (checkBit(check) == true) {
                            count++;
                        }
                    }
                    point++;
                }

                if (isEvenParity) {
                    if (count % 2 != 0) {
                        result = result | 1;
                    }
                } else {
                    if (count % 2 == 0) {
                        result = result | 1;
                    }
                }
                result = result << 1;
            }


        }
        result = result >> 1;

        long finalResult = 0;
        long k = 1;
        while (k <=inputLength){
            if(k == result){
                finalResult = finalResult|1;
            }
            finalResult = finalResult<<1;
            k++;
        }
    return bitSequence ^ (finalResult >> 1);





    }

    }