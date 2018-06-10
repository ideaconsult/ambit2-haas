package net.idea.ambit.algorithm.exnet;

public class ExnetParam {


	public Double[] getLearning_rate_list() {
		return learning_rate_list;
	}

	public void setLearning_rate_list(Double[] learning_rate_list) {
		this.learning_rate_list = learning_rate_list;
	}

	public Double[] getMomentum_list() {
		return momentum_list;
	}

	public void setMomentum_list(Double[] momentum_list) {
		this.momentum_list = momentum_list;
	}


	public Double[] getDropout_keep_rate_list() {
		return dropout_keep_rate_list;
	}

	public void setDropout_keep_rate_list(Double[] dropout_keep_rate_list) {
		this.dropout_keep_rate_list = dropout_keep_rate_list;
	}

	public Double[] getInput_dropout_keep_rate_list() {
		return input_dropout_keep_rate_list;
	}

	public void setInput_dropout_keep_rate_list(Double[] input_dropout_keep_rate_list) {
		this.input_dropout_keep_rate_list = input_dropout_keep_rate_list;
	}

	public Integer[] getAffinity_level_list() {
		return affinity_level_list;
	}

	public void setAffinity_level_list(Integer[] affinity_level_list) {
		this.affinity_level_list = affinity_level_list;
	}

	public Integer[] getSample_index_list() {
		return sample_index_list;
	}

	public void setSample_index_list(Integer[] sample_index_list) {
		this.sample_index_list = sample_index_list;
	}

	public Integer[] getOuter_fold_index_list() {
		return outer_fold_index_list;
	}

	public void setOuter_fold_index_list(Integer[] outer_fold_index_list) {
		this.outer_fold_index_list = outer_fold_index_list;
	}

	public Integer[] getInner_fold_index_list() {
		return inner_fold_index_list;
	}

	public void setInner_fold_index_list(Integer[] inner_fold_index_list) {
		this.inner_fold_index_list = inner_fold_index_list;
	}
	Double[] learning_rate_list = new Double[] {};
	Double[] momentum_list = new Double[] {};
	Integer[][] network_layout_list = new Integer[][] {};
	public Integer[][] getNetwork_layout_list() {
		return network_layout_list;
	}

	public void setNetwork_layout_list(Integer[][] network_layout_list) {
		this.network_layout_list = network_layout_list;
	}
	Double[] dropout_keep_rate_list = new Double[] {};
	Double[] input_dropout_keep_rate_list = new Double[] {};
	Integer[] affinity_level_list = new Integer[] {};
	Integer[] sample_index_list = new Integer[] {};
	Integer[] outer_fold_index_list = new Integer[] {};
	Integer[] inner_fold_index_list = new Integer[] {};
	Integer max_epochs;

	public Integer getMax_epochs() {
		return max_epochs;
	}

	public void setMax_epochs(Integer max_epochs) {
		this.max_epochs = max_epochs;
	}

}
