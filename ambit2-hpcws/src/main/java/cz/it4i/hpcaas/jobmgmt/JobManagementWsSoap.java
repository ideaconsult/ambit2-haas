
package cz.it4i.hpcaas.jobmgmt;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "JobManagementWsSoap", targetNamespace = "http://hpcaas.it4i.cz/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface JobManagementWsSoap {


    /**
     * 
     * @param sessionCode
     * @param specification
     * @return
     *     returns cz.it4i.hpcaas.jobmgmt.SubmittedJobInfoExt
     */
    @WebMethod(operationName = "CreateJob", action = "http://hpcaas.it4i.cz/CreateJob")
    @WebResult(name = "CreateJobResult", targetNamespace = "http://hpcaas.it4i.cz/")
    @RequestWrapper(localName = "CreateJob", targetNamespace = "http://hpcaas.it4i.cz/", className = "cz.it4i.hpcaas.jobmgmt.CreateJob")
    @ResponseWrapper(localName = "CreateJobResponse", targetNamespace = "http://hpcaas.it4i.cz/", className = "cz.it4i.hpcaas.jobmgmt.CreateJobResponse")
    public SubmittedJobInfoExt createJob(
        @WebParam(name = "specification", targetNamespace = "http://hpcaas.it4i.cz/")
        JobSpecificationExt specification,
        @WebParam(name = "sessionCode", targetNamespace = "http://hpcaas.it4i.cz/")
        String sessionCode);

    /**
     * 
     * @param sessionCode
     * @param createdJobInfoId
     * @return
     *     returns cz.it4i.hpcaas.jobmgmt.SubmittedJobInfoExt
     */
    @WebMethod(operationName = "SubmitJob", action = "http://hpcaas.it4i.cz/SubmitJob")
    @WebResult(name = "SubmitJobResult", targetNamespace = "http://hpcaas.it4i.cz/")
    @RequestWrapper(localName = "SubmitJob", targetNamespace = "http://hpcaas.it4i.cz/", className = "cz.it4i.hpcaas.jobmgmt.SubmitJob")
    @ResponseWrapper(localName = "SubmitJobResponse", targetNamespace = "http://hpcaas.it4i.cz/", className = "cz.it4i.hpcaas.jobmgmt.SubmitJobResponse")
    public SubmittedJobInfoExt submitJob(
        @WebParam(name = "createdJobInfoId", targetNamespace = "http://hpcaas.it4i.cz/")
        long createdJobInfoId,
        @WebParam(name = "sessionCode", targetNamespace = "http://hpcaas.it4i.cz/")
        String sessionCode);

    /**
     * 
     * @param submittedJobInfoId
     * @param sessionCode
     * @return
     *     returns cz.it4i.hpcaas.jobmgmt.SubmittedJobInfoExt
     */
    @WebMethod(operationName = "CancelJob", action = "http://hpcaas.it4i.cz/CancelJob")
    @WebResult(name = "CancelJobResult", targetNamespace = "http://hpcaas.it4i.cz/")
    @RequestWrapper(localName = "CancelJob", targetNamespace = "http://hpcaas.it4i.cz/", className = "cz.it4i.hpcaas.jobmgmt.CancelJob")
    @ResponseWrapper(localName = "CancelJobResponse", targetNamespace = "http://hpcaas.it4i.cz/", className = "cz.it4i.hpcaas.jobmgmt.CancelJobResponse")
    public SubmittedJobInfoExt cancelJob(
        @WebParam(name = "submittedJobInfoId", targetNamespace = "http://hpcaas.it4i.cz/")
        long submittedJobInfoId,
        @WebParam(name = "sessionCode", targetNamespace = "http://hpcaas.it4i.cz/")
        String sessionCode);

    /**
     * 
     * @param submittedJobInfoId
     * @param sessionCode
     */
    @WebMethod(operationName = "DeleteJob", action = "http://hpcaas.it4i.cz/DeleteJob")
    @RequestWrapper(localName = "DeleteJob", targetNamespace = "http://hpcaas.it4i.cz/", className = "cz.it4i.hpcaas.jobmgmt.DeleteJob")
    @ResponseWrapper(localName = "DeleteJobResponse", targetNamespace = "http://hpcaas.it4i.cz/", className = "cz.it4i.hpcaas.jobmgmt.DeleteJobResponse")
    public void deleteJob(
        @WebParam(name = "submittedJobInfoId", targetNamespace = "http://hpcaas.it4i.cz/")
        long submittedJobInfoId,
        @WebParam(name = "sessionCode", targetNamespace = "http://hpcaas.it4i.cz/")
        String sessionCode);

    /**
     * 
     * @param sessionCode
     * @return
     *     returns cz.it4i.hpcaas.jobmgmt.ArrayOfSubmittedJobInfoExt
     */
    @WebMethod(operationName = "ListJobsForCurrentUser", action = "http://hpcaas.it4i.cz/ListJobsForCurrentUser")
    @WebResult(name = "ListJobsForCurrentUserResult", targetNamespace = "http://hpcaas.it4i.cz/")
    @RequestWrapper(localName = "ListJobsForCurrentUser", targetNamespace = "http://hpcaas.it4i.cz/", className = "cz.it4i.hpcaas.jobmgmt.ListJobsForCurrentUser")
    @ResponseWrapper(localName = "ListJobsForCurrentUserResponse", targetNamespace = "http://hpcaas.it4i.cz/", className = "cz.it4i.hpcaas.jobmgmt.ListJobsForCurrentUserResponse")
    public ArrayOfSubmittedJobInfoExt listJobsForCurrentUser(
        @WebParam(name = "sessionCode", targetNamespace = "http://hpcaas.it4i.cz/")
        String sessionCode);

    /**
     * 
     * @param submittedJobInfoId
     * @param sessionCode
     * @return
     *     returns cz.it4i.hpcaas.jobmgmt.SubmittedJobInfoExt
     */
    @WebMethod(operationName = "GetCurrentInfoForJob", action = "http://hpcaas.it4i.cz/GetCurrentInfoForJob")
    @WebResult(name = "GetCurrentInfoForJobResult", targetNamespace = "http://hpcaas.it4i.cz/")
    @RequestWrapper(localName = "GetCurrentInfoForJob", targetNamespace = "http://hpcaas.it4i.cz/", className = "cz.it4i.hpcaas.jobmgmt.GetCurrentInfoForJob")
    @ResponseWrapper(localName = "GetCurrentInfoForJobResponse", targetNamespace = "http://hpcaas.it4i.cz/", className = "cz.it4i.hpcaas.jobmgmt.GetCurrentInfoForJobResponse")
    public SubmittedJobInfoExt getCurrentInfoForJob(
        @WebParam(name = "submittedJobInfoId", targetNamespace = "http://hpcaas.it4i.cz/")
        long submittedJobInfoId,
        @WebParam(name = "sessionCode", targetNamespace = "http://hpcaas.it4i.cz/")
        String sessionCode);

}