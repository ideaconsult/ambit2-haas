<#if custom_structurequery??>
	<#assign custom_structurequery=custom_structurequery?url('UTF-8')>
</#if>

<ul id='smartmenu' class="sm sm-mint">
<li>
	<a href="#" title="Find chemical substances">Search</a>
	<ul>
		<li><a href="${ambit_root}/ui/_search?search=${custom_structurequery!'phenol'}" title="Chemical structure search">Search structures and associated data</a></li>
	</ul>
</li>


			<li>
			<a href="${ambit_root}/algorithm" title="Descriptor calculations, model building and data processing algorithms">Algorithms</a>
			<#include "/menu/profile/default/algorithm_menu.ftl">
			</li>
			<li>
			<a href="${ambit_root}/model" title="Regression, classification, clustering, structural alerts, applicability domain, structure optimisation.">Models</a>
			<#include "/menu/profile/default/model_menu.ftl">
			</li>


		
<li>
	<a href="${ambit_root}/help">Help</a>
	<#include "/menu/profile/default/help_menu.ftl">
</li>		


</ul>


