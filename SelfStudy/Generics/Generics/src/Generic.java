public class Generic <T, K, V> {
    private T var1;
    private K var2;
    private V var3;

    public Generic(T var1, K var2, V var3) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
    }

    public T getVar1() {
        return var1;
    }

    public K getVar2() {
        return var2;
    }

    public V getVar3() {
        return var3;
    }

    private void getClassesOfAllFields () {
        System.out.println(var1.getClass());
        System.out.println(var2.getClass());
        System.out.println(var3.getClass());
    }
}
