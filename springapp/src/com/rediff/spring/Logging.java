package com.rediff.spring;

import org.aspectj.lang.JoinPoint;

public class Logging {
	/**
	 * This is the method which I would like to execute before a selected method
	 * execution.
	 */
	public void beforeAdvice(JoinPoint jp, String name) {
		System.out.println("Going to setup student profile :: " + name + " :: " + jp);
	}

	/**
	 * This is the method which I would like to execute after a selected method
	 * execution.
	 */
	public void afterAdvice(JoinPoint jp, String name) {
		System.out.println("Student profile has been setup :: " + name + " :: " + jp);
	}

	/**
	 * This is the method which I would like to execute when any method returns.
	 */
	public void afterReturningAdvice(Object retVal) {
		System.out.println("Returning:" + retVal.toString());
	}

	/**
	 * This is the method which I would like to execute if there is an exception
	 * raised.
	 */
	public void AfterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("There has been an exception: " + ex.toString());
	}
}
