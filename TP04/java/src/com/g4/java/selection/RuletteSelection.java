package com.g4.java.selection;

import java.util.ArrayList;
import java.util.List;

import com.g4.java.model.Individual;
import com.g4.java.util.RandomGenerator;

public class RuletteSelection implements Selection {

	protected int toSelect;

	public RuletteSelection(final int toSelect) {
		this.toSelect = toSelect;
	}

	protected double filterFitness(double fitness) {
		return fitness;
	}

	@Override
	public List<Individual> select(List<Individual> population, int generation) {
		return select(population, generation, this.toSelect);
	}

	@Override
	public List<Individual> select(List<Individual> population, int generation,
			int ggToSelect) {
		List<Individual> newGeneration = new ArrayList<Individual>(ggToSelect);
		double fitnessSum = 0;
		for (int i = 0; i < population.size(); i++) {
			fitnessSum += filterFitness(population.get(i).getApptitude());
		}

		while (newGeneration.size() < ggToSelect) {
			double r = fitnessSum * RandomGenerator.getDouble();
			int j = 0;
			double f = 0;
			Individual individual = null;
			do {
				if (j >= population.size()) {
					break;
				}

				individual = population.get(j++);
				f += filterFitness(individual.getApptitude());
			} while (f < r);
			newGeneration.add(individual);
		}

		return newGeneration;
	}
}
