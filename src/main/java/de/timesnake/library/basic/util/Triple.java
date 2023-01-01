/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.basic.util;

import java.util.Objects;

public class Triple<A, B, C> {

    private A a;
    private B b;
    private C c;

    public Triple(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Triple<?, ?, ?>)) return false;
        if (this == obj) return true;
        return Objects.equals(this.getA(), ((Tuple<?, ?>) obj).getA()) && Objects.equals(this.getB(),
                ((Tuple<?, ?>) obj).getB()) && Objects.equals(this.getC(), ((Triple<?, ?, ?>) obj).getC());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.a, this.b, this.c);
    }
}
