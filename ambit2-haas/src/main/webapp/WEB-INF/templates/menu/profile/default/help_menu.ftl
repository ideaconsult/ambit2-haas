<ul>
	<li><a href="${ambit_root}/admin">Admin</a>
		<#if openam_token??>
			<#if menu_profile??>
				<#include "/menu/profile/${menu_profile}/admin_menu.ftl">
			<#else>
				<#include "/menu/profile/default/admin_menu.ftl">
			</#if>
		</#if>
	</li>		
	<li><a href="#">About</a>
		<ul>
		<li><a href="#">Version</a>
			<ul class="mega-menu">
			<li>
				<div style="width:400px;max-width:100%;">
	          		<div style="padding:5px 24px;">
						<div class='h6' style='color:#729203;' title='${ambit_version_long}'>AMBIT v${ambit_version_short}</div>
					</div>
				</div>		
			</li>
			</ul>
		</li>
		<li><a href="http://www.ideaconsult.net/" title="Developed by IdeaConsult Ltd.">IdeaConsult</a>
		
		</li>		
		</ul>
	</li>

</ul>