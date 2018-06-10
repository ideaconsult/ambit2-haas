<div class='helptitle' style='font-weight:bold;'>Help: Algorithm service</div>
<div class='helpcontent'>
What is Algorithm service<a href='#' class='chelp hwhat'>?</a> |
Algorithm types<a href='#' class='chelp halgtypes'>?</a> |
<a href="http://ambit.sourceforge.net/api_algorithm.html" target=_blank title='Application Programming interface'>API</a>

</div>

<div id="keys" style="display:none;">
  <ul>
    <li><a href="#hdataset">Dataset</a></li>
    <li><a href="#hdatasetservice">Dataset service</a></li>
    <li><a href="#hdescriptor">Descriptors</a></li>
    <li><a href="#hfeature">Features</a></li>
    <li><a href="#htarget">Dependent variable</a></li>
    <li><a href="#halgtypes">Algorithm types</a></li>
    <li><a href="#hlearning">Learning algorithm</a></li>
    <li><a href="#hmodel">Models</a></li>
    <li><a href="#hwhat"> </a></li>
    <li><a href="#hexnet"> </a></li>
    <li><a href="#hexnetstats"> </a></li>
    <li><a href="#hendpoint"> </a></li>
    <li><a href="#himpl"> </a></li>
    <li><a href="#dtypes"> </a></li>
  </ul>
  <div id="hdataset">
    Dataset or compound URI as in <a href="${ambit_root}/dataset?max=100" target=_blank>Datasets list</a>.
    Either enter/paste the URI, or search for dataset by name, by entering first few letters. The field supports autocomplete
    and will show a list of dataset names, if there is a match. The dataset names are case sensitive! 
  </div>
  <div id="hdatasetservice">
  	Dataset service (<a href="http://ambit.sourceforge.net/api_dataset.html" target=_blank>API</a>) determines where the results will be written.
  	Optional, will use the default <a href='${ambit_root}/dataset' target=_blank>${ambit_root}/dataset</a> if not specified.
  </div>
  <div id="hdescriptor">
  	URI of a <a href='${ambit_root}/algorithm?type=DescriptorCalculation' target=_blank>Descriptor calculation</a>  algorithm.
  </div>
  <div id="hfeature">
    Feature URI as in <a href="${ambit_root}/feature?max=100" target=_blank>Features list</a>.
    Either enter/paste the URI, or search for a feature by name, by entering first few letters. The field supports autocomplete
    and will show a list of feature names, if there is a match. The features are basically columns in datasets.
  </div>  
  <div id="htarget">
    Feature URI as in <a href="${ambit_root}/feature?max=100" target=_blank>Features list</a>.
    Either enter/paste the URI, or search for a feature by name, by entering first few letters. The field supports autocomplete
    and will show a list of feature names, if there is a match. The features are basically columns in datasets, and selecting a feature 
    in this page means selecting a variable to predict.
  </div>    
  <div id="halgtypes">
  	<ul>
	<li>
	<a href='${ambit_root}/algorithm?ttype=DescriptorCalculation'>Algorithms generating certain values, based on chemical structure (Descriptor calculation)</a>
	</li><li>
	Data preprocessing (e.g. Principal component analysis, feature selection)
	</li><li>
	<a href="${ambit_root}/algorithm?type=Structure">Structure processing (e.g. structure optimization)</a>
	</li><li>
	Algorithms, relating set of structures to another set of structures (e.g. similarity search or metabolite generation)
	</li><li>
	Machine learning algorithms
	<ul>
	<li>
	<a href="${ambit_root}/algorithm?type=Supervised">Supervised</a>  (e.g.
		<a href="${ambit_root}/algorithm?type=Regression">Regression</a>, 
		<a href="${ambit_root}/algorithm?type=Classification">Classification</a> )   
	</li><li>
	<a href="${ambit_root}/algorithm?type=UnSupervised">Unsupervised</a>  (e.g. <a href="${ambit_root}/algorithm?type=Clustering">Clustering</a> )
	</li><li>
	</ul></li>
	<a href="${ambit_root}/algorithm?type=Rules">Prediction algorithms, defined by experts</a> (e.g. series of structural alerts, defined by human experts , not derived by learning algorithms)
	</li><li>
	<a href="${ambit_root}/algorithm?type=AppDomain">Applicability domain algorithms</a>
	</li></ul>
  </div>
  <div id="hwhat">
    Algorithm services accept a dataset URI in order to build a model or to process the dataset (e.g.  descriptor values).
    </br>
    Once a model is built, it is assigned a model URI and can be applied to datasets and compounds.
  </div>
  <div id="hlearning">
  		machine learning algorithm, e.g. <a href='${ambit_root}/algorithm?type=Regression' target=_blank>Regression</a>,
		<a href='${ambit_root}/algorithm?type=Classification' target=_blank>Classification</a>.
  		If no learning algorithm specified, the result will be a dataset with all the descriptors.
  </div>
  <div id="hmodel">
  Once a model is built, it is assigned a model URI (as in <a href='${ambit_root}/model?max=100' target=_blank>Models</a>) 
  and can be applied to <a href='${ambit_root}/dataset?max=100' target=_blank>datasets</a> and <a href='${ambit_root}/compound?max=100' target=_blank>compounds</a>.
  </div>
  <div id="hexnet" >
<b>Exnet</b> tbd
  </div>
  <div id="hexnetstats" >
<b>Exnet stats</b> tbd
  </div>  
  
  <div id="hendpoint">
	Endpoint is taken from the owl:sameAs , assigned to the dependent variable of the model. If the corresponding feature does not have assigned endpoint
	ontology entry, this field will be empty. 
  </div>
  <div id="himpl">
  The list of algorithms are defined in http://ambit.sourceforge.net/descriptors.owl
  </div>
   <div id="dtypes">
  <ul>
  <li>D : Processes a dataset</li>
  <li>M : Builds a model</li>
  <li>I : Requires input dataset</li>
  <li>T : Requires target variable</li>
  <li>R : Requires property | structure [see the tooltip]</li>
  </ul>
  </div>
</div>      