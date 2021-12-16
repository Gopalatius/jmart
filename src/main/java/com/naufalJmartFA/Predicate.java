package com.naufalJmartFA;

/**
 * An interface to do lambda expression of predicate
 * @param <T> generic parameter
 * @author Muhammad Naufal Faza
 */
public interface Predicate <T> {
    /**
     * To check whether the parameter is true if applied to the predicate.
     * @param arg the variable that wants to be checked.
     * @return true if the variables is true according to the predicate given in the lambda expression later.
     */
    boolean predicate (T arg);
}
