package com.turnfly.algorithm.practice;


import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class TimeMap {
    TreeMap<Integer, HashMap<String, String>> cacheMaps = new TreeMap<>(Comparator.comparingLong(o -> o));

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        HashMap temp = new HashMap<String, String>();
        temp.put(key, value);
        cacheMaps.put(timestamp, temp);
    }

    public String get(String key, int timestamp) {
        return getIndex(key, timestamp, 0, cacheMaps.keySet().size() - 1);
    }

    public String getIndex(String key, int timestamp, int l , int r) {
        while (l <= r) {
            List<Integer> temList = new ArrayList<>(cacheMaps.keySet());
            int mid = r - (r - l) / 2;
            if (temList.get(mid) == timestamp) {
                return cacheMaps.get(timestamp).getOrDefault(key, "");
            }

            if (temList.get(mid) < timestamp) {
                String res = cacheMaps.get(temList.get(mid)).getOrDefault(key, "");

                if (mid + 1 <= r && temList.get(mid + 1) > timestamp) {
                    while ("".equals(res) && mid > 0) {
                        mid--;
                        res = cacheMaps.get(temList.get(mid)).getOrDefault(key, "");
                    }
                    return res;
                } else {
                    if (mid + 1 > r) {
                        while ("".equals(res) && mid > 0) {
                            mid--;
                            res = cacheMaps.get(temList.get(mid)).getOrDefault(key, "");
                        }
                        return res;
                    }
                    l = mid + 1;
                }
            }
            if (temList.get(mid) > timestamp) {
                if (mid - 1 > 0 && temList.get(mid - 1) <= timestamp) {
                    String res = cacheMaps.get(temList.get(mid - 1)).getOrDefault(key, "");
                    mid --;
                    while ("".equals(res) && mid > 0) {
                        mid--;
                        res = cacheMaps.get(temList.get(mid)).getOrDefault(key, "");
                    }
                    return res;
                } else {
                    r = mid - 1;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("foo","bar",1);
        System.out.println(obj.get("foo", 1));
        System.out.println(obj.get("foo", 3));

        obj.set("foo","bar4",4);
        System.out.println(obj.get("foo", 4));
        System.out.println(obj.get("foo", 5));

    }


}



