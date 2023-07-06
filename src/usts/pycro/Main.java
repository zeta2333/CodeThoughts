package usts.pycro;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-21 6:05 PM
 */
public class Main {
    public static void main(String[] args) {
        A a = new B();
        
    }
}

class A {
    static {
        System.out.println("static code block of A");
    }

    protected String name;

    public A(String str) {
        System.out.println("A init with arg: " + str);
    }

    protected void eat() {
        System.out.println("A eat");
    }
}

class B extends A {
    static {
        System.out.println("static code block of B");
    }

    protected String name;

    protected B() {
        this(null);
    }

    protected B(String str) {
        super("oneArgConstructor");
        System.out.println("B init with arg: " + str);
    }

    // @Override
    protected void eat() {
        System.out.println("B eat");
    }

    private void drink() {
        super.eat();
        System.out.println("B drink");
    }
}