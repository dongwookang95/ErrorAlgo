# ErrorAlgo
All made without using Arraylist since error-detecting and correcting should be done at the low level, meaning that 
least amount of memory spaces are used by that.

Based on Java

## Hamming distance
The error-detecting and error-correcting properties of a code depend on its Hamming distance.
The error detecting code
Count the distance based on XOR operation.

## Cyclic redundancy checks
The error detecting code
Moving each bit to leftside until it is reached at the end of the bits. 
And check whether it has remainder or not.
If it has, error is detected. Otherwise, it is error-free


## Hamming Correction
The error correction code.
There are some pointers that are looking for each of bits to check whether it is parity bit or not.


