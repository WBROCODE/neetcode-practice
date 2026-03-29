static class Singleton {
    String str;

    private Singleton() {
        this.str = null;
    }
    private static Singleton instance;

    public static Singleton getInstance() {
        if(instance == null){
            instance = new Singleton();
            return instance;
        }else return instance;
    }

    public String getValue() {
        return str;
    }

    public void setValue(String value) {
        this.str = value;
    }
    
}
