package edu.ustc.mix.multithread;

class PrimeRun implements Runnable {
	
	long minPrime;
	
	PrimeRun(long minPrime) {
		this.minPrime = minPrime;
	}
	
	public void run() {
		// compute primes larger than minPrime
		System.out.println("implements runnable, compute primes larger than minPrime, minPrime is " + minPrime);
	}
}
