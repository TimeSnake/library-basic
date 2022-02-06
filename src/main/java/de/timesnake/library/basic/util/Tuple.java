package de.timesnake.library.basic.util;

import java.util.Map;
import java.util.Objects;

public class Tuple<A, B> {

    private A a;
    private B b;

    public Tuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public Tuple(Map.Entry<A, B> entry) {
        this.a = entry.getKey();
        this.b = entry.getValue();
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Tuple<?, ?>)) return false;
        if (this == obj) return true;
        return this.getA().equals(((Tuple<?, ?>) obj).getA()) && this.getB().equals(((Tuple<?, ?>) obj).getB());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.a, this.b);
    }
}
