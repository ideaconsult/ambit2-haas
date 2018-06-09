<#if custom_structurequery??>
<#assign custom_structurequery=custom_structurequery?url('UTF-8')>
</#if>
<ul id='smartmenu' class="sm sm-mint">
   <li><a href="#" title="Home">Home</a></li>
   <li>
      <a href="${ambit_root}/algorithm" title="HEAPPE">Algorithms</a>
      <#include "/menu/profile/default/algorithm_menu.ftl">
   </li>
   <li>
      <a href="${ambit_root}/model" title="">Models</a>
      <#include "/menu/profile/default/model_menu.ftl">
   </li>
   <li>
      <a href="${ambit_root}/help">Help</a>
      <#include "/menu/profile/excape/help_menu.ftl">
   </li>
</ul>