class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    /**
           k   v     time      
    set    foo bar   1      
    get    foo          ->bar 


     */
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k->new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> values = map.get(key);
        
        int l = 0, r = values.size() - 1;

        if(timestamp < values.get(l).getTime()) return "";
        int index = -1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(values.get(m).getTime() <= timestamp){
                index = m;
                l = m + 1;
            }else{
                r = m - 1;
            }
        }


        return values.get(index).getVal();
    }
}

class Pair{
    int time;
    String value;

    public Pair(int time, String value){
        this.time = time;
        this.value = value;
    }

    public int getTime(){
        return time;
    }

    public String getVal(){
        return value;
    }

}