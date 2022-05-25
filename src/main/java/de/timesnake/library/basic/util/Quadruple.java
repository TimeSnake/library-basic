package de.timesnake.library.basic.util;

import java.util.Objects;

public class Quadruple<A, B, C, D> {

    private A a;
    private B b;
    private C c;
    private D d;

    public Quadruple(A a, B b, C c, D d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }

    public D getD() {
        return d;
    }

    public void setD(D d) {
        this.d = d;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Quadruple<?, ?, ?, ?>)) return false;
        if (this == obj) return true;
        return Objects.equals(this.getA(), ((Tuple<?, ?>) obj).getA()) && Objects.equals(this.getB(),
                ((Tuple<?, ?>) obj).getB()) && Objects.equals(this.getC(), ((Triple<?, ?, ?>) obj).getC()) && Objects.equals(this.getD(), ((Quadruple<?, ?, ?, ?>) obj).getD());

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.a, this.b, this.c, this.d);
    }
}
