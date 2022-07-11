package com.automation.api.stepDefinitions;

import com.automation.api.helpers.ApiHelper;
        import com.automation.api.helpers.WebServiceHelper;
        import com.automation.api.utilities.CommonUtils;
        import io.cucumber.datatable.DataTable;
        import io.cucumber.java.en.Given;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
        import java.io.IOException;
        import java.util.HashMap;

/**
 * @author dinudonney
 * @Date 06/07/22
 */
public class StepDefinitions {
    HashMap<String, String> requestFields=new HashMap<>();
    WebServiceHelper WebServiceHelper=new WebServiceHelper();
    ApiHelper apiHelper=new ApiHelper();
    String [] tempArray;

    @Given("^Create a \"([^\"]*)\" request for \"([^\"]*)\" API using below data$")
    public void createARequestForAPIUsingBelowData(String methodType, String endPoint, DataTable dataTable) throws Throwable {
        requestFields= convertDataTabletoRequestMap(dataTable);
        System.out.println("got request fields:"+requestFields);
        WebServiceHelper.createRequest(endPoint,methodType,requestFields,dataTable);
    }

    HashMap<String, String>convertDataTabletoRequestMap(DataTable dataTable){
        HashMap <String, String> fieldsMap=new HashMap<>();
        for(String field :dataTable.asMaps().get(0).keySet()){
            fieldsMap.put(field,dataTable.asMaps().get(0).get(field));
        }
        return fieldsMap;
    }

    @When("Invoke the {string} method for {string} api using endpoint {string}")
    public void invokeTheMethodForApiUsingEndpoint(String methodType, String section, String resource) throws IOException {
        WebServiceHelper.setEndPointUrl(resource,CommonUtils.getDatafromConfig("TEST_URL"));
        WebServiceHelper.submitRequest(resource,methodType,null,apiHelper,section);
    }

    @Then("Verify the response status code is {string}")
    public void verifyTheResponseStatusCodeIs(String code) throws IOException {
        WebServiceHelper.verifyResponseCode(code,apiHelper);
    }


    @When("Store {string} for validation")
    public void storeForValidation(String values) {
        tempArray = values.split(";");
        com.automation.api.helpers.WebServiceHelper.tempArray =this.tempArray;
    }

    @When("Invoke the {string} method for {string} api using endpoint {string} for {string}")
    public void submitRequestForOrders(String methodType, String section, String resource, String sectionType) throws IOException {
        WebServiceHelper.setEndPointUrl(resource,CommonUtils.getDatafromConfig("TEST_URL"));
        WebServiceHelper.submitRequestForOrders(resource,methodType,null,apiHelper,sectionType);
    }

    @When("Invoke the {string} method for {string} api using endpoint {string} for {string} as users")
    public void submitRequestForUsers(String methodType, String section, String resource, String sectionType) throws IOException {
        WebServiceHelper.setEndPointUrl(resource,CommonUtils.getDatafromConfig("TEST_URL"));
        WebServiceHelper.submitRequestForUers(resource,methodType,null,apiHelper,sectionType);
    }
}
