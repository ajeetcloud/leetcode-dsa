class Solution {
    public int mostExpensiveItem(int primeOne, int primeTwo) {
      int max = primeOne * primeTwo;
      int storage[] = new int[max];
      storage[0] = 0;
      int maxValue = 0; // 0 - cant be bought
      for (int i = 1; i < storage.length; i++) {
        if (i < primeOne && i < primeTwo) {
          storage[i] = 0;
          maxValue = Math.max(maxValue, i);
        } else if (i == primeOne || i == primeTwo) {
          storage[i] =  1;
        } else {
          int index1 = i - primeOne;
          int index2 = i - primeTwo;
          if (index1 >= 0 && storage[index1] == 1) {
            storage[i] =  1;
          } else if (index2 >= 0 && storage[index2] == 1) {
            storage[i] =  1;
          } else {
            storage[i] =  0;
            
          }
        }
      }
       return maxValue; 
    }
}