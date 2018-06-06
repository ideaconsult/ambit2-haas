package net.idea.ambit.app;

import java.util.logging.Level;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.Reference;
import org.restlet.routing.Router;
import org.restlet.routing.Template;

import ambit2.base.config.AMBITConfig;
import ambit2.rest.AmbitFreeMarkerApplication;
import ambit2.rest.admin.SimpleGuard;
import ambit2.rest.admin.SimpleGuard.SimpleGuards;
import ambit2.rest.algorithm.MLResources;
import ambit2.rest.help.HelpResource;
import ambit2.rest.routers.APIDocsRouter;
import ambit2.rest.routers.TaskRouter;
import ambit2.rest.task.TaskResource;
import ambit2.rest.task.WarmupTask;
import ambit2.rest.ui.UIResourceBase;
import net.idea.ambit.algorithm.AlgorithmRouterHaas;
import net.idea.ambit.algorithm.ModelRouterHaas;
import net.idea.ambit.app.router.UIRouter;
import net.idea.restnet.c.routers.MyRouter;

public class HaaSApp extends AmbitFreeMarkerApplication<Object> {
	protected static final String HAAS_HOME = "HAAS_HOME";

	public HaaSApp() {
		this(false);
	}

	public HaaSApp(boolean standalone) {
		super(standalone);

	}

	public synchronized String getdHaasHome() {
		try {
			return getProperty(HAAS_HOME, ambitProperties);
		} catch (Exception x) {
			return null;
		}
	}

	@Override
	public Restlet createInboundRoot() {
		Restlet root = initInboundRoot();

		SimpleGuards guard = isSimpleGuardEnabled();

		if (!standalone && warmupEnabled) // only servlets are lazy
			addTask("warmup", new WarmupTask("warmup", openToxAAEnabled), new Reference("riap://component"), "guest");

		if (guard != null) {
			logger.log(Level.INFO, String.format("Property %s set, %s guard enabled.", GUARD_ENABLED, guard));
			String[] allowed = getGuardListAllowed();
			StringBuilder b = new StringBuilder();
			for (String ip : allowed) {
				b.append(ip);
				b.append(" ");
			}
			logger.log(Level.INFO,
					String.format("Property %s set, %s list allowed %s", GUARD_LIST, guard, b.toString()));
			SimpleGuard theguard = guard.getGuard(allowed, logger);
			theguard.setNext(root);
			return theguard;
		} else
			return root;

	}

	public Restlet initInboundRoot() {
		initFreeMarkerConfiguration();

		String usersdbname = getProperty(AMBITConfig.Database.name(), configProperties);
		if (usersdbname == null)
			usersdbname = "ambit_users";
		getContext().getParameters().add(AMBITConfig.users_dbname.name(), usersdbname);

		Router router = new MyRouter(this.getContext()) {
			public void handle(Request request, Response response) {
				// to use within riap calls
				String rootUrl = getContext().getParameters().getFirstValue(BASE_URL);
				if ((rootUrl == null) && request.getRootRef().toString().startsWith("http")) {
					rootUrl = request.getRootRef().toString();
					getContext().getParameters().set(BASE_URL, rootUrl, true);
				}
				super.handle(request, response);
			};
		};
		router.attach("/", UIResourceBase.class);
		router.attach("", UIResourceBase.class);
		router.attach("/api-docs", new APIDocsRouter(getContext()));
		/** /algorithm */
		router.attach(MLResources.algorithm, new AlgorithmRouterHaas(getContext()));
		/** /model */
		router.attach(MLResources.model_resource, new ModelRouterHaas(getContext()));
		/** /task */
		router.attach(TaskResource.resource, new TaskRouter(getContext()));
		router.attach("/ui", new UIRouter(getContext()));

		attachStaticResources(router);

		router.attach("/chelp", HelpResource.class);
		router.attach("/chelp/{key}", HelpResource.class);

		router.setDefaultMatchingMode(Template.MODE_STARTS_WITH);
		router.setRoutingMode(Router.MODE_BEST_MATCH);

		return router;
	}
}
