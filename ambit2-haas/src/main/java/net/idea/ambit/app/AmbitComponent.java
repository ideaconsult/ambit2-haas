package net.idea.ambit.app;

import org.restlet.Application;
import org.restlet.Context;

import ambit2.rest.RESTComponent;

/**
 * This is used as a servlet component instead of the core one, to be able to attach protocols 
 * @author nina
 *
 */
public class AmbitComponent extends RESTComponent {


		public AmbitComponent() {
			this(null);
		}
		public AmbitComponent(Context context,Application[] applications) {
			super(context,applications);
			
		
		}
		public AmbitComponent(Context context,boolean standalone) {
			this(context,new Application[]{new HaaSApp(true)});
		}
		public AmbitComponent(Context context) {
			this(context,new Application[]{new HaaSApp()});
		}
		
		

}
