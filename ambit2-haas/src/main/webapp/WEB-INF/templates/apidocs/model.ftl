{
	<#include "/apidocs/version.ftl" >
    "produces": [
                 "application/json",
                 "text/n3",
                 "application/rdf+xml",
                 "text/uri-list",
                 "application/ld+json"
             ],		
    "resourcePath": "/model",
	"apis": [
     	{
            "path": "/model",
            "operations": [
                {
                    "method": "GET",
                    "summary": "Get a list of all available models",
		            "notes": "Returns list of models <a href='http://opentox.org/dev/apis/api-1.2/Model' target='opentox'>OpenTox Model API</a>",                    
                    "type": "Model",
                    "nickname": "getModels",
                    <#include "/apidocs/authz.ftl" >
                    "parameters": [
						{
						    "name": "search",
						    "description": "Model name (partial search)",
						    "required": false,
						    "type": "string",
						    "paramType": "query",
						    "allowMultiple": false					    
						},  
						{
						    "name": "algorithm",
						    "description": "Find all models built with Algorithm URI. See Algorithm service for valid Algorithm URIs",
						    "required": false,
						    "type": "string",
						    "paramType": "query",
						    "allowMultiple": false,
						    "defaultValue": "${ambit_root}/algorithm/haasexnet"						    
						},    						
                       <#include "/apidocs/parameters_page.ftl" >                                   
                    ],
                    "responseMessages": [
                        {
                            "code": 200,
                            "message": "Model(s) found"
                        },                                         
                        {
                            "code": 404,
                            "message": "Models not found"
                        },
						<#include "/apidocs/error_aa.ftl" >,
						<#include "/apidocs/error_500.ftl" >                        
                    ]
                }
            ]
     	},
    	{
		    "path": "/model/{id}",
		    "operations": [
		        {
		            "method": "GET",
		            "summary": "Returns model representation",
		            "notes": "Returns model representation <a href='http://opentox.org/dev/apis/api-1.2/Model' target='opentox'>OpenTox Model API</a>",
		            "type": "Model",
		            "nickname": "getModelByID",
		            <#include "/apidocs/authz.ftl" >
		            "parameters": [
						{
						    "name": "id",
						    "description": "Model ID",
						    "required": true,
						    "type": "int",
						    "paramType": "path",
						    "allowMultiple": false,
						    "defaultValue": "1",
						    "minimum": "1"
						} 		            
		            ],
		            "responseMessages": [
		         		{
		        	        "code": 200,
		        	        "message": "Model found"
		        		},		                                 
		                {
		                    "code": 404,
		                    "message": "Model not found"
		                },
		                {
		                    "code": 400,
		                    "message": "Invalid model identifier"
		                },		                
						<#include "/apidocs/error_aa.ftl" >,
						<#include "/apidocs/error_500.ftl" >												                
		            ]
		        },
		        {
                    "method": "POST",
                    "summary": "Apply the model. Returns a task.",
		            "notes": "Applies the model to a dataset and returns a task with the result (a dataset) <a href='http://opentox.org/dev/apis/api-1.2/Model' target='opentox'>OpenTox Model API</a>. See the Task service how to query the task.",
                    "type": "Task",
                    "nickname": "applyModel",
                    "consumes": [
                        "application/x-www-form-urlencoded"
                    ],
                    <#include "/apidocs/authz.ftl" >
                    "parameters": [
                        {
                            "name": "id",
                            "description": "Model ID",
                            "required": true,
                            "type": "int",
                            "paramType": "path",
                            "allowMultiple": false
                        },
                        {
                            "name": "dataset_uri",
                            "description": "The dataset to be processed. Mandatory parameter (See Dataset service)",
                            "required": true,
                            "type": "string",
                            "paramType": "form",
                            "allowMultiple": false,
                            "defaultValue": "${ambit_root}/dataset/1?pagesize=3"
                        },
                        {
                            "name": "dataset_service",
                            "description": "A Dataset service URI. A new dataset with predicted feature values will be created. (see Dataset service)",
                            "required": false,
                            "type": "string",
                            "paramType": "form",
                            "allowMultiple": false
                        },
                        {
                            "name": "result_dataset",
                            "description": "result_datasetURI, pointing to a resulting dataset.  This dataset will be updated with the predicted feature values.",
                            "required": false,
                            "type": "string",
                            "paramType": "form",
                            "allowMultiple": false
                        }	                        
                    ],
                    "responseMessages": [

	                    <#include "/apidocs/error_task.ftl" >,	
             			 {
            			    "code": 404,
            			    "message": "Model not found"
            			 },
             			 {
	            			"code": 400,
	            			"message": "Bad request"
	            	    },	 		                    
            			<#include "/apidocs/error_aa.ftl" >,
            			<#include "/apidocs/error_500.ftl" >	
                    ]
                },
                {
                    "method": "DELETE",
                    "summary": "Deletes the model. Returns a task",
		            "notes": "Deletes the model <a href='http://opentox.org/dev/apis/api-1.2/Model' target='opentox'>OpenTox Model API</a>. See the Task service how to query the task.",
                    "type": "Task",
                    "nickname": "deleteModel",
                    "consumes": [
                         "application/x-www-form-urlencoded"                                 
                    ],
                    <#include "/apidocs/authz.ftl" >
                    "parameters": [
                        {
                            "name": "id",
                            "description": "Model ID",
                            "required": true,
                            "type": "int",
                            "paramType": "path",
                            "allowMultiple": false
                        }                       
                    ],
                    "responseMessages": [

	                    <#include "/apidocs/error_task.ftl" >,	
             			 {
            			    "code": 404,
            			    "message": "Model not found"
            			 },
             			 {
	            			"code": 400,
	            			"message": "Bad request"
	            	    },	 		                    
            			<#include "/apidocs/error_aa.ftl" >,
            			<#include "/apidocs/error_500.ftl" >	
                    ]
                }		                
		    ]
		}

			
		
    ],
    "models" : {
      "Model" : <#include "/apidocs/json_schema_model.ftl" >,
      "Task" : <#include "/apidocs/json_schema_task.ftl" >,
      "Feature" : <#include "/apidocs/json_schema_feature.ftl" >
    },      
	<#include "/apidocs/profile/${menu_profile}/info.ftl" >  
}