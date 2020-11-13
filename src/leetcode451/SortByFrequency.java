package leetcode451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class SortByFrequency {
	
	// Using bucket sort with hashmap, O(n) time
	public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char letter : s.toCharArray()){
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
						
        List<Character>[] bucket = new List[s.length() + 1];
        
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            
            if (bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
                
            bucket[frequency].add(key);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
                for(char letter : bucket[i]){
                    for(int j = 0; j < i; j++){
                        sb.append(letter);
                    }
                }
            }
        }
        
        return sb.toString();
    }
	
	// Using Priority Queue with O(nlogn) time
    public String frequencySort2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
						
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        pq.addAll(map.entrySet());
				
        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()) {
            Entry<Character, Integer> e = pq.poll();
            for (int i = 0; i < (int)e.getValue(); i++)
            {
                sb.append(e.getKey());
            }
        }
        
        return sb.toString();
    }
}
