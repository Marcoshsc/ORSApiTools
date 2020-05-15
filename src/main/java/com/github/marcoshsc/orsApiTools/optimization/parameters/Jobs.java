package com.github.marcoshsc.orsApiTools.optimization.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.interfaces.JSONBodyParameter;
import com.github.marcoshsc.orsApiTools.optimization.helperclasses.Job;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

/**
 * Array of job objects describing the places to visit. For a detailed object description visit the VROOM api description
 * https://github.com/VROOM-Project/vroom/blob/master/docs/API.md#jobs
 *
 * @author Marcos Henrique
 */
public class Jobs implements JSONBodyParameter<JSONArray> {

    private static final String name = ORSEnum.JOBS_BODY_PARAM.toString();
    /**
     * List of jobs to be made
     */
    private List<Job> jobs;

    public Jobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    /**
     *
     * @return the name of the parameter.
     */
    @Override
    public String getKey() {
        return name;
    }

    /**
     *
     * @return an array of job objects.
     * @throws JSONException if some JSON parsing exception happened.
     */
    @Override
    public JSONArray getValue() throws JSONException {
        return getJobsJSONArray(jobs);
    }

    public List<Job> getJobs() {
        return jobs;
    }

    private JSONArray getJobsJSONArray(List<Job> jobs) throws JSONException {
        JSONArray array = new JSONArray();
        for(Job j : jobs)
            array.put(j.getJSONRepresentation());
        return array;
    }
}
