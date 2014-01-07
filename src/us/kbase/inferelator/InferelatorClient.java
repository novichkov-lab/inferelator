package us.kbase.inferelator;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import us.kbase.auth.AuthToken;
import us.kbase.common.service.JsonClientCaller;
import us.kbase.common.service.JsonClientException;
import us.kbase.common.service.UnauthorizedException;

/**
 * <p>Original spec-file module name: Inferelator</p>
 * <pre>
 * Module KBaseInferelator version 1.0
 * This module provides a set of methods for work with cMonkey biclustering tool.
 * Data types summary
 * Input data types:
 * GeneList - list of regulatory genes
 * ExpressionSeries represents a list of expression data samples that serve as an input of cMonkey.
 * CmonkeyRunResult data generated by a single run of cMonkey (run_infos table of cMonkey results)
 * Output data types:
 * InferelatorRunResult - contains a list of Inferelator hits
 * Methods summary
 * find_interactions_with_inferelator - Starts Inferelator server run with given parameters and  workspace ID where final results will be saved and returns job ID of the run
 * </pre>
 */
public class InferelatorClient {
    private JsonClientCaller caller;
    private static URL DEFAULT_URL = null;
    static {
        try {
            DEFAULT_URL = new URL("http://kbase.us/services/inferelator");
        } catch (MalformedURLException mue) {
            throw new RuntimeException("Compile error in client - bad url compiled");
        }
    }

    public InferelatorClient() {
       caller = new JsonClientCaller(DEFAULT_URL);
    }

    public InferelatorClient(URL url) {
        caller = new JsonClientCaller(url);
    }

    public InferelatorClient(URL url, AuthToken token) throws UnauthorizedException, IOException {
        caller = new JsonClientCaller(url, token);
    }

    public InferelatorClient(URL url, String user, String password) throws UnauthorizedException, IOException {
        caller = new JsonClientCaller(url, user, password);
    }

    public InferelatorClient(AuthToken token) throws UnauthorizedException, IOException {
        caller = new JsonClientCaller(DEFAULT_URL, token);
    }

    public InferelatorClient(String user, String password) throws UnauthorizedException, IOException {
        caller = new JsonClientCaller(DEFAULT_URL, user, password);
    }

	public void setConnectionReadTimeOut(Integer milliseconds) {
		this.caller.setConnectionReadTimeOut(milliseconds);
	}

    public boolean isAuthAllowedForHttp() {
        return caller.isAuthAllowedForHttp();
    }

    public void setAuthAllowedForHttp(boolean isAuthAllowedForHttp) {
        caller.setAuthAllowedForHttp(isAuthAllowedForHttp);
    }

    /**
     * <p>Original spec-file function name: find_interactions_with_inferelator</p>
     * <pre>
     * Starts cMonkey server run for a series of expression data stored in workspace and returns ID of the run result object
     * string ws_id - workspace id where run result would be written
     * InferelatorRunParameters params - run parameters 
     * string job_id - identifier of job object
     * </pre>
     * @param   wsId   instance of String
     * @param   params   instance of type {@link us.kbase.inferelator.InferelatorRunParameters InferelatorRunParameters}
     * @return   parameter "job_id" of String
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public String findInteractionsWithInferelator(String wsId, InferelatorRunParameters params) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(wsId);
        args.add(params);
        TypeReference<List<String>> retType = new TypeReference<List<String>>() {};
        List<String> res = caller.jsonrpcCall("Inferelator.find_interactions_with_inferelator", args, retType, true, true);
        return res.get(0);
    }
}
