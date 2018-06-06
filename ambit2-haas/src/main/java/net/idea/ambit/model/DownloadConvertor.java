package net.idea.ambit.model;

import java.io.IOException;

import org.restlet.data.MediaType;
import org.restlet.representation.FileRepresentation;
import org.restlet.representation.Representation;

import net.idea.modbcum.i.exceptions.AmbitException;
import net.idea.modbcum.i.reporter.Reporter;
import net.idea.restnet.c.RepresentationConvertor;

public class DownloadConvertor<T, Q, R extends Reporter<Q, FileRepresentation>> extends RepresentationConvertor<T, Q, FileRepresentation, R> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2575809146485789933L;

	public DownloadConvertor(R reporter, MediaType mediaType) {
		this(reporter, mediaType, null);
	}

	public DownloadConvertor(R reporter, MediaType mediaType, String fileNamePrefix) {
		super(reporter, mediaType, fileNamePrefix);
	}

	
	@Override
	public Representation process(Q query) throws Exception {
		try {
			FileRepresentation rep = reporter.process(query);
			setDisposition(rep);
			return rep;
		} catch (IOException x) {
			throw new AmbitException(x);
		} finally {
			try {
				reporter.close();
			} catch (Exception x) {
			}
		}

	};

	@Override
	public void open() throws Exception {

	}
}
