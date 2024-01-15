# Few gotchas

1. Iterating through a char[] is faster than iterating through a String.
2. Iterating through 2 char[]s in separate loops is faster than using the same loop.
3. For counting characters in a String, use a int[] rather than a HashMap.
4. If you need to pre-initialize some values in a HashMap, do it outside the function, using an static block.
5. In arrays, iterating through indexes is usually faster than iterating through values.
6. If you are iterating, and you have already found a solution, returning the solution immediately is often faster than
   breaking out of the loop, and returning the solution later.
7. When converting numbers to Strings, use String.valueOf() than Integer.toString();
8. When concatenating strings, use a StringBuilder rather than formatting or addition.