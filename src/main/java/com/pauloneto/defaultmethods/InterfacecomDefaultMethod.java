package com.pauloneto.defaultmethods;

public interface InterfacecomDefaultMethod<T> {

	default void imprimeString(T s) {
		System.out.println(s);
	}
}
