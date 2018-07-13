{
	<#include "/apidocs/version.ftl" >
    "produces": [
        "application/json",
        "text/n3",
        "application/rdf+xml",
        "text/uri-list",
        "application/ld+json"
    ],	
    "resourcePath": "/algorithm",
    "apis": [
			{
			    "path": "/algorithm",
			    "operations": [
			        {
			            "method": "GET",
			            "summary": "List algorithms",
			            "notes": "Returns all algorithms <a href='http://opentox.org/dev/apis/api-1.2/Algorithm' target='opentox'>OpenTox Algorithm API</a>",
			            "type": "Algorithm",
			            "nickname": "getAllAlgorithms",
			            <#include "/apidocs/authz.ftl" >
			            "parameters": [
							{
							    "name": "search",
							    "description": "Algorithm name (starts with)",
							    "required": false,
							    "type": "string",
							    "paramType": "query",
							    "allowMultiple": false
							},    			            
							{
							    "name": "type",
							    "description": "Algorithm type",
							    "required": false,
							    "type": "string",
							    "paramType": "query",
							    "allowMultiple": false,
							    "defaultValue": "ExternalModels",
	                            "enum": [
	                            	"ExternalModels",
	                                "Regression",
	                                "Supervised",
	                                "UnSupervised",
	                                "SingleTarget",	  
	                                "MultipleTarget",
	                                "EagerLearning",
	                                "Mockup"	                                	                                                              
	                            ]							    
							},			            
							<#include "/apidocs/parameters_page.ftl" >			            
			            ],
			            "responseMessages": [
			                {
			                    "code": 404,
			                    "message": "Algorithms not found"
			                },
							<#include "/apidocs/error_aa.ftl" >,
							<#include "/apidocs/error_500.ftl" >												                
			            ]
			        }
			    ]
			},
			{
			    "path": "/algorithm/{algorithm_id}",
			    "operations": [
			        {
			            "method": "GET",
			            "summary": "Returns algorithm representation",
			            "notes": "Returns algorithm representation <a href='http://opentox.org/dev/apis/api-1.2/Algorithm' target='opentox'>OpenTox Algorithm API</a>",
			            "type": "Algorithm",
			            "nickname": "getAlgorithmByID",
			            <#include "/apidocs/authz.ftl" >
			            "parameters": [
							{
							    "name": "algorithm_id",
							    "description": "Algorithm ID",
							    "required": false,
							    "type": "string",
							    "paramType": "path",
							    "allowMultiple": false,
							    "defaultValue": "haasexample"
							} 		            
			            ],
			            "responseMessages": [
			         		{
			        		   "code": 400,
			        		   "message": "Invalid algorithm identifier"
			        		},				                                 
			                {
			                    "code": 404,
			                    "message": "Algorithm not found"
			                },
							<#include "/apidocs/error_aa.ftl" >,
							<#include "/apidocs/error_500.ftl" >												                
			            ]
			        },
			        {
	                    "method": "POST",
	                    "summary": "Apply the algorithm. Returns a task.",
			            "notes": "Applies the algorithm to a dataset and returns a task with the result (dataset or model) <a href='http://opentox.org/dev/apis/api-1.2/Algorithm' target='opentox'>OpenTox Algorithm API</a>. See the Task service how to query the task.",
	                    "type": "void",
	                    "nickname": "applyAlgorithm",
	                    "consumes": [
	                        "application/x-www-form-urlencoded"
	                    ],
	                    <#include "/apidocs/authz.ftl" >
	                    "parameters": [
	                        {
	                            "name": "algorithm_id",
	                            "description": "Algorithm ID",
	                            "required": true,
	                            "type": "int",
	                            "paramType": "path",
	                            "allowMultiple": false,
	                            "defaultValue": "haasexample"
	                        },
	                        {
	                            "name": "parameter",
	                            "description": "contains all the algorithm specific parameters.",
	                            "required": false,
	                            "type": "string",
	                            "paramType": "form",
	                            "allowMultiple": true
	                        }		                        
	                    ],
	                    "responseMessages": [

		                    <#include "/apidocs/error_task.ftl" >,	
	             			 {
	            			    "code": 404,
	            			    "message": "Algorithm not found"
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
      "Task" : <#include "/apidocs/json_schema_task.ftl" >,
      "Feature" : <#include "/apidocs/json_schema_feature.ftl" >,
	  "Model" : <#include "/apidocs/json_schema_model.ftl" >
    },     
	<#include "/apidocs/profile/${menu_profile}/info.ftl" >  
}