package com.kennycason.genetic.draw.gene

import com.kennycason.genetic.draw.gene.mutate.Mutator
import java.util.*

/**
 * Created by kenny on 5/30/16.
 */
class CrossOver {
    val random = Random()

    // probability 1-100
    fun perform(pair: Pair<Individual, Individual>, mutator: Mutator, mutationProbability: Float) : Individual {
        val dnaLength = pair.first.dna.size
        val genes = mutableListOf<Gene>()
        (0..dnaLength-1).forEach { i ->
            if (random.nextDouble() > .5) {
                genes.add(mutator.mutate(pair.first.dna.get(i), mutationProbability))
            } else {
                genes.add(mutator.mutate(pair.second.dna.get(i), mutationProbability))
            }
        }
        return Individual(genes, Double.MAX_VALUE)
    }
}