package edu.ustc.mix.multithread;

class PrimeThread extends Thread {
	
	long minPrime;
	
	PrimeThread(long minPrime) {
		this.minPrime = minPrime;
	}
	
	public void run() {
		// compute primes larger than minPrime
		System.out.println("extends thread, compute primes larger than minPrime, minPrime is " + minPrime);
	}
}
