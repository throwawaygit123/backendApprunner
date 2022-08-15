package com.quanbio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SecondDerivative {
	private double[] secondDeriv;
	private double meanHeatRate;
	private double meanSystolicBP;
	private double meanDiastolicBP;
	private double meanSpo2;
	private double meanMicrocirculation;
	

}
