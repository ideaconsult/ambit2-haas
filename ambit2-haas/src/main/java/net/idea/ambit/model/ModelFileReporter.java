package net.idea.ambit.model;

import java.io.File;
import java.util.Iterator;

import org.restlet.Request;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.representation.FileRepresentation;
import org.restlet.resource.ResourceException;

import ambit2.core.data.model.ModelQueryResults;
import net.idea.modbcum.p.batch.ListReporter;

public class ModelFileReporter extends ListReporter<ModelQueryResults, FileRepresentation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1470164118404153388L;
	protected String resultFolder;
	protected MediaType mediaType;

	public ModelFileReporter(Request request, String resultFolder, MediaType mediaType) {
		super();
		this.resultFolder = resultFolder;
		this.mediaType = mediaType;
	}

	@Override
	public void processItem(ModelQueryResults model, FileRepresentation output) {
		try {
			File file = new File(ModelResourceHaas.getModelPathZip(new File(resultFolder), model));
			setOutput(new FileRepresentation(file, mediaType));

		} catch (Exception x) {
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, x.getMessage());
		}
	}

	@Override
	public void header(FileRepresentation output, Iterator<ModelQueryResults> query) {
		// TODO Auto-generated method stub

	}

	@Override
	public void footer(FileRepresentation output, Iterator<ModelQueryResults> query) {
		// TODO Auto-generated method stub

	}
	

}
