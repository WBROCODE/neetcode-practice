class Logger {
    int limit = 10;
    Map<String, Integer> map;
    public Logger() {
        this.map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            int oldTime = map.get(message);
            if(timestamp - oldTime < limit) return false;
            else{
                map.put(message, timestamp);
                return true;
            }
        }else{
            map.put(message, timestamp);
            return true;
        }
      
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
