{
    "apiVersion":  "${ambit_version_short}",
    "swaggerVersion": "1.2",
    "apis": [
     
        {
            "path": "/algorithm",
            "description": "Algorithms service"
        },
        {
            "path": "/model",
            "description": "Prediction Models service"
        },
        {
            "path": "/task",
            "description": "Task service (asynchronous jobs)"
        }
      
        
                                 
    ],
	<#include "/apidocs/authz.ftl" >
	<#include "/apidocs/profile/${menu_profile}/info.ftl" >  
}