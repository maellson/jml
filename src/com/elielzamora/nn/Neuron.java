package com.elielzamora.nn;

public class Neuron {
	/** weight array */
	private float[] w;
	public Neuron(float[] weights){
		this.w = weights;
	}
	public Neuron(int i){
		assert i > 0;
		this.w = new float[i+1];
		this.init();
	}
	public float bias (){
		return this.w[0];
	}
	public void init(){
		for(int i =0; i < w.length; i++){
			w[i] = (float)(0.05 * (Math.random()-0.5)); 
		}
	}
	public float feed(float[] x){
		assert x.length == w.length-1;
		return sig(dot(w,x));
	}
	public float sig(float x){
		return (float) (1/(1+Math.pow(Math.E,-x)));
	}
	/** custom dot product for neuron */
	public float dot(float[] w, float[] x){
		float total = 0;
		for(int i = 0; i < w.length; i++){
			if(i == 0) total += -1 * w[0];
			else total += w[i] * x[i-1];
		}
		return total;
	}
	/**
	 * unit test individual Neuron
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
