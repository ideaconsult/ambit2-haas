	
<div class='row remove-bottom'>
<div class="twelve columns">	
	<div class='row remove-bottom'>
		<label class='five columns alpha' for="alg_title">Name</label>
		<span class='eight columns alpha half-bottom' id='alg_title'></span>
		<div class='three columns omega'></div>
	</div>
<!--
	<div class='row remove-bottom'>
		<label class='five columns alpha' for="alg_implementation">Implementation of <a href='#' class='chelp himpl'>?</a></label>
		<a class='eleven columns alpha half-bottom' target=_blank href='#' id='alg_implementation'></a>
	</div>
-->		
	<div class='row remove-bottom'>
		<label class='five columns alpha' for="alg_requires">Requires <a href='#' class='chelp dtypes'>?</a></label>
		<span class='eight columns alpha half-bottom' id='alg_requires'></span>
		<div class='three columns omega'></div>
	</div>		

	<div class='row remove-bottom'>
		<label class='five columns alpha' for="alg_type">Type <a href='#' class='chelp halgtypes'>?</a></label>
		<span class='eight columns alpha half-bottom' id='alg_type'></span>
		<div class='three columns omega'></div>
	</div>	
		
	<div class='row remove-bottom'  id='predictsEndpoint'>
		<label class='five columns alpha' for="alg_endpoint">Predicts endpoint <a href='#' class='chelp hendpoint'>?</a></label>
		<span class='eight columns alpha half-bottom' id='alg_endpoint'></span>
		<div class='three columns omega'></div>
	</div>	
			
	<div class='row remove-bottom'>
		<label class='five columns alpha' for="alg_dataset">Action <a href='#' class='chelp dtypes'>?</a></label>
		<span class='eight columns alpha half-bottom' id='alg_dataset'></span>
		<div class='three columns omega help' id='help_action'></div>
	</div>		
	
	
<#switch algid>
 
  <#case 'haasexnetstats'>  
    <div id='haasexnetstats'>
	<div class='row remove-bottom' >
		<label class='five columns alpha' for="model_uri">Exnet model URI</label>
		<input class='eight columns alpha half-bottom' type="text" id='model_uri' value='' name='model_uri' title='Exnet model URI'>
		<div class='three columns omega'><a href='#' class='chelp hexnetstats'>?</a></div>
	</div>	
	</div>  
   <#break>
  <#case 'haasexnet'>  
  <#case 'haasexnettest'>
    <div id='haasexnettest'>
	<div class='row remove-bottom' >
		<label class='five columns alpha' for="network_layout_list">Network Layout (1st network)</label>
		<input class='eight columns alpha half-bottom' type="text" id='network_layout_list' value='2048, 2048' name='network_layout_list' title='Network layout'>
		<div class='three columns omega'><a href='#' class='chelp hexnet'>?</a></div>
	</div>	      
	<div class='row remove-bottom' >
		<label class='five columns alpha' for="network_layout_list">Network Layout (2nd network)</label>
		<input class='eight columns alpha half-bottom' type="text" id='network_layout_list' value='' name='network_layout_list' title='Network layout'>
		<div class='three columns omega'><a href='#' class='chelp hexnet'>?</a></div>
	</div>	  	
	<div class='row remove-bottom' >
		<label class='five columns alpha' for="learning_rate_list">Learning rate</label>
		<input class='eight columns alpha half-bottom' type="text" id='learning_rate_list' value='0.1, 1' name='learning_rate_list' title='Learning rate'>
		<div class='three columns omega'><a href='#' class='chelp hexnet'>?</a></div>
	</div>	    	
	<div class='row remove-bottom' >
		<label class='five columns alpha' for="momentum_list">Momentum</label>
		<input class='eight columns alpha half-bottom' type="text" id='momentum_list' value='0.1' name='momentum_list' title='Momentum'>
		<div class='three columns omega'><a href='#' class='chelp hexnet'>?</a></div>
	</div>	  
	<div class='row remove-bottom' >
		<label class='five columns alpha' for="dropout_keep_rate_list">Dropout keep rate</label>
		<input class='eight columns alpha half-bottom' type="text" id='dropout_keep_rate_list' value='0.5' name='dropout_keep_rate_list' title='Dropout keep rate'>
		<div class='three columns omega'><a href='#' class='chelp hexnet'>?</a></div>
	</div>	  
	<div class='row remove-bottom' >
		<label class='five columns alpha' for="input_dropout_keep_rate_list">Input dropout keep rate</label>
		<input class='eight columns alpha half-bottom' type="text" id='input_dropout_keep_rate_list' value='0.5' name='input_dropout_keep_rate_list' title='Input dropout keep rate'>
		<div class='three columns omega'><a href='#' class='chelp hexnet'>?</a></div>
	</div>	  
	<div class='row remove-bottom' >
		<label class='five columns alpha' for="affinity_level_list">Affinity levels</label>
		<input class='eight columns alpha half-bottom' type="text" id='affinity_level_list' value='6' name='affinity_level_list' title='Affinity levels'>
		<div class='three columns omega'><a href='#' class='chelp hexnet'>?</a></div>
	</div>	  
	<div class='row remove-bottom' >
		<label class='five columns alpha' for="sample_index_list">Sample index</label>
		<input class='eight columns alpha half-bottom' type="text" id='sample_index_list' value='1' name='sample_index_list' title='Sample index'>
		<div class='three columns omega'><a href='#' class='chelp hexnet'>?</a></div>
	</div>	  
	<div class='row remove-bottom' >
		<label class='five columns alpha' for="outer_fold_index_list">Outer fold index</label>
		<input class='eight columns alpha half-bottom' type="text" id='outer_fold_index_list' value='1' name='outer_fold_index_list' title='Outer fold index'>
		<div class='three columns omega'><a href='#' class='chelp hexnet'>?</a></div>
	</div>
	<div class='row remove-bottom' >
		<label class='five columns alpha' for="inner_fold_index_list">Inner fold index</label>
		<input class='eight columns alpha half-bottom' type="text" id='inner_fold_index_list' value='1' name='inner_fold_index_list' title='Inner fold index'>
		<div class='three columns omega'><a href='#' class='chelp hexnet'>?</a></div>
	</div>
	<div class='row remove-bottom' >
		<label class='five columns alpha' for="max_epochs">Max epochs</label>
		<input class='eight columns alpha half-bottom' type="text" id='max_epochs' value='1' name='max_epochs' title='Max epochs'>
		<div class='three columns omega'><a href='#' class='chelp hexnet'>?</a></div>
	</div>	
	</div>
    <#break>
 
  <#default>
	
	<div class='row remove-bottom' id='requiresDataset'>
		<label class='five columns alpha' for="dataset_uri">Enter a dataset URI </label>
		<input class='eight columns alpha half-bottom dataseturi' type="text" id='dataset_uri' value='' name='dataset_uri' title='Enter dataset uri'>
		<div class='three columns omega'><a href='#' class='chelp hdataset'>?</a></div>
	</div>		
	
	<div class='row remove-bottom' id='requiresTarget'>
		<label class='five columns alpha' for="prediction_feature">Enter URI of the target variable</label>
		<input class='eight columns alpha half-bottom featureuri' type="text" id='prediction_feature' value='' name='prediction_feature' title='Enter feature uri'>
		<div class='three columns omega'><a href='#' class='chelp htarget'>?</a></div>
	</div>
	
			
</#switch>

	
	<div class='row'>
		<label class='five columns alpha'>&nbsp;</label>
		<input class='three columns alpha submit' type='submit' value='Run'>
		<div class='eight columns omega'></div>
	</div>

</div>
<div class="four columns">
	<div class='row half-bottom chelp' style='padding:0;margin:0;' id='pagehelp'></div>
	<div class='row remove-bottom chelp' style='padding:0;margin:0;font-weight:bold;' id='keytitle'></div>
	<div class='row half-bottom chelp' style='padding:0;margin:0;' id='keycontent'></div>	
</div>
</div>
