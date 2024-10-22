import java.util.*;
import java.io.*;

class Frequency_Array_Retrieval {
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(input.readLine().trim());
        
        while (t-- > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            int[] freqArray = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            boolean isValid = true;

            Map<Integer, Integer> frequencyCount = new HashMap<>();
            for (int freq : freqArray) {
                frequencyCount.put(freq, frequencyCount.getOrDefault(freq, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : frequencyCount.entrySet()) {
                if (entry.getValue() % entry.getKey() != 0) {
                    output.write("-1\n");
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                Map<Integer, Integer[]> valueTracker = new HashMap<>();
                int nextValue = 1;
                List<Integer> resultArray = new ArrayList<>();

                for (int freq : freqArray) {
                    if (valueTracker.containsKey(freq) && valueTracker.get(freq)[1] > 0) {
                        valueTracker.get(freq)[1]--;
                        resultArray.add(valueTracker.get(freq)[0]);
                    } else {
                        valueTracker.put(freq, new Integer[]{nextValue, freq - 1});
                        resultArray.add(nextValue);
                        nextValue++;
                    }
                }

                for (int value : resultArray) {
                    output.write(value + " ");
                }
                output.write("\n");
            }
        }
        
        output.flush();
    }
}