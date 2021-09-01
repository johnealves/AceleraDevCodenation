package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;

public class CalculadorDeClasses implements Calculavel, Comparable<BigDecimal> {

    @Override
    public BigDecimal somar(Object objeto) throws InvocationTargetException, IllegalAccessException {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal value = BigDecimal.ZERO;
        for (Field atributos: objeto.getClass().getDeclaredFields()) {
            for (Method metodo:objeto.getClass().getDeclaredMethods()) {
                if (atributos.getDeclaredAnnotation(Somar.class) != null
                        && metodo.getName().toUpperCase().contains("GET" + atributos.getName().toUpperCase())) {
                    value = (BigDecimal) metodo.invoke(objeto);
                    result = result.add(value);
                }
            }
        }

        return result;
    }

    @Override
    public BigDecimal subtrair(Object objeto) throws InvocationTargetException, IllegalAccessException {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal value = BigDecimal.ZERO;
        for (Field atributos: objeto.getClass().getDeclaredFields()) {
            for (Method metodo:objeto.getClass().getDeclaredMethods()) {
                if (atributos.getDeclaredAnnotation(Subtrair.class) != null
                        && metodo.getName().toUpperCase().contains("GET" + atributos.getName().toUpperCase())) {
                    value = (BigDecimal) metodo.invoke(objeto);
                    result = result.add(value);
                }
            }
        }
        return result;
    }

    @Override
    public BigDecimal totalizar(Object objeto) throws InvocationTargetException, IllegalAccessException {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal value = BigDecimal.ZERO;
        result = somar(objeto).subtract(subtrair(objeto));
//
        return result;
    }

    @Override
    public int compareTo(BigDecimal o) {
        return 0;
    }
}
