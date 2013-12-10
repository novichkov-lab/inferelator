package us.kbase.inferelator;

import java.util.List;
import us.kbase.auth.AuthToken;
import us.kbase.common.service.JsonServerMethod;
import us.kbase.common.service.JsonServerServlet;

//BEGIN_HEADER
//END_HEADER

/**
 * <p>Original spec-file module name: Inferelator</p>
 * <pre>
 * Module KBaseInferelator version 1.0
 * This module provides a set of methods for work with cMonkey biclustering tool.
 * Data types summary
 * Input data types: 
 * ExpressionDataSeries represents a list of expression data samples that serve as an input of cMonkey.
 * ExpressionDataSample data type represents a sample of expression data for a single condition.
 * ExpressionDataPoint data type represents a relative expression value for a single gene.
 * Output data types:
 * CmonkeyRun data type represents data generated by a single run of cMonkey (run_infos table of cMonkey results)
 * CmonkeyNetwork data type represents bicluster network
 * CmonkeyCluter data type represents a single bicluster from cMonkey network, with links to genes, experimental conditions and motifs
 * CmonkeyMotif data type represents a single motif identifed for a bicluster
 * Methods summary
 * build_cmonkey_network - Starts cMonkey server run for a series of expression data and returns job ID of the run 
 * build_cmonkey_network_from_ws - Starts cMonkey server run for a series of expression data stored in workspace and returns job ID of the run
 * build_cmonkey_network_job_from_ws - Starts cMonkey server run for a series of expression data stored in workspace and returns job ID of the run
 * </pre>
 */
public class InferelatorServer extends JsonServerServlet {
    private static final long serialVersionUID = 1L;

    //BEGIN_CLASS_HEADER
    //END_CLASS_HEADER

    public InferelatorServer() throws Exception {
        super("Inferelator");
        //BEGIN_CONSTRUCTOR
        //END_CONSTRUCTOR
    }

    /**
     * <p>Original spec-file function name: find_interactions_with_inferelator</p>
     * <pre>
     * Starts cMonkey server run for a series of expression data stored in workspace and returns ID of the run result object
     * string ws_id - workspace id
     * string series_id - kbase id of expression data series
     * string cmonkey_result_id - kbase id of cMonkey run result
     * list <string> factors - list of transcription factors
     * string inferelator_run_job_id - identifier of cMonkey job
     * </pre>
     * @param   wsId   instance of String
     * @param   seriesId   instance of String
     * @param   cmonkeyResultId   instance of String
     * @param   factors   instance of list of String
     * @return   parameter "inferelator_run_job_id" of String
     */
    @JsonServerMethod(rpc = "Inferelator.find_interactions_with_inferelator")
    public String findInteractionsWithInferelator(String wsId, String seriesId, String cmonkeyResultId, List<String> factors, AuthToken authPart) throws Exception {
        String returnVal = null;
        //BEGIN find_interactions_with_inferelator
        //END find_interactions_with_inferelator
        return returnVal;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: <program> <server_port>");
            return;
        }
        new InferelatorServer().startupServer(Integer.parseInt(args[0]));
    }
}
