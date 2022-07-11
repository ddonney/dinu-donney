package com.automation.api.helpers;

import com.automation.api.dto.requests.*;
import com.automation.api.utilities.CommonUtils;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.automation.api.helpers.FieldValueHelper.assertFields;

/**
 * @author dinudonney
 * @Date 07/07/22
 */
public class WebServiceHelper {
    String endPointUrl=null;
    String responseString=null;
    HashMap <String, String> requestParams=null;
    ObjectMapper objectMapper=new ObjectMapper();
    PetsGetListRequestDTO petsGetListRequestDTO =new PetsGetListRequestDTO();
    PetsAddListRequestDTO petsAddListRequestDTO =new PetsAddListRequestDTO();
    PetsDeleteRequestDTO petsDeleteRequestDTO= new PetsDeleteRequestDTO();
    OrdersGetRequestDTO ordersGetRequestDTO =new OrdersGetRequestDTO();
    OrdersAddRequestDTO ordersAddRequestDTO=new OrdersAddRequestDTO();
    OrdersDeleteRequesrDTO ordersDeleteRequestDTO =new OrdersDeleteRequesrDTO();
    UsersAddRequestDTO usersAddRequestDTO=new UsersAddRequestDTO();
    UserGetRequestDTO userGetRequestDTO=new UserGetRequestDTO();
    public static String [] tempArray;

    public void createRequest(String endPoint, String method, HashMap<String, String> requestFields, DataTable dataTable) throws JsonProcessingException {
        requestParams=requestFields;
        List<Map<String,String>> list=dataTable.asMaps(String.class,String.class);
        switch(endPoint){
            case "PetsGet":
                petsGetListRequestDTO.setStatus(list.get(0).get("status"));
                break;
            case "GetOrderById":
                ordersGetRequestDTO.setOrderId(list.get(0).get("orderId"));
                break;
            case "GetUserByName":
                userGetRequestDTO.setUsername(list.get(0).get("username"));
                break;
            case "PetsGetbyTags":
                petsGetListRequestDTO.setTags(list.get(0).get("tags"));
                break;

            case "PetsGetbyID":
                petsGetListRequestDTO.setID(list.get(0).get("ID"));
                break;

            case "AddNewPetTostore":
                petsAddListRequestDTO.setId(list.get(0).get("id"));
                petsAddListRequestDTO.setName(list.get(0).get("name"));
                petsAddListRequestDTO.setStatus(list.get(0).get("status"));
                System.out.println("requestPayload"+objectMapper.writeValueAsString(petsAddListRequestDTO));
                break;

            case "AddNewOrder":
                ordersAddRequestDTO.setId(Integer.parseInt(list.get(0).get("id")));
                ordersAddRequestDTO.setPetId(Integer.parseInt(list.get(0).get("petId")));
                ordersAddRequestDTO.setQuantity(Integer.parseInt(list.get(0).get("quantity")));
                ordersAddRequestDTO.setShipDate(list.get(0).get("shipDate"));
                ordersAddRequestDTO.setStatus(list.get(0).get("status"));
                ordersAddRequestDTO.setComplete(Boolean.parseBoolean(list.get(0).get("complete")));
                break;

            case "AddUser":
                usersAddRequestDTO.setId(Integer.parseInt(list.get(0).get("id")));
                usersAddRequestDTO.setUsername(list.get(0).get("username"));
                usersAddRequestDTO.setFirstName(list.get(0).get("firstName"));
                usersAddRequestDTO.setLastName(list.get(0).get("lastName"));
                usersAddRequestDTO.setEmail(list.get(0).get("email"));
                usersAddRequestDTO.setPassword(list.get(0).get("password"));
                usersAddRequestDTO.setPhone(list.get(0).get("phone"));
                usersAddRequestDTO.setUserStatus(Integer.parseInt(list.get(0).get("userStatus")));
                break;

            case "updatePet":
                petsAddListRequestDTO.setId(list.get(0).get("id"));
                petsAddListRequestDTO.setName(list.get(0).get("name"));
                petsAddListRequestDTO.setStatus(list.get(0).get("status"));
                System.out.println("requestPayload"+objectMapper.writeValueAsString(petsAddListRequestDTO));
                break;

            case "DeletePetById":
                petsDeleteRequestDTO.setId(list.get(0).get("id"));

            case "DeleteOrderById":
                ordersDeleteRequestDTO.setId(list.get(0).get("id"));
            case "DeleteUserByUsername":
                usersAddRequestDTO.setUsername(list.get(0).get("username"));

        }
    }

    public void setEndPointUrl(String resource,String endpoint){
        endPointUrl= CommonUtils.getEndPointUrl(resource,endpoint);
    }

    public void submitRequest (String endPoint,String method,HashMap <String,String> params,ApiHelper apiHelper, String section) throws IOException {
        objectMapper=new ObjectMapper();
        if(method.equals("GET")){
            responseString=apiHelper.submitGetRequest(endPointUrl,"");
        }
        if(method.equals("POST")){
            responseString=apiHelper.submitPostRequest(endPointUrl,petsAddListRequestDTO);
        }
        if(method.equals("PUT")){
            responseString=apiHelper.submitPutRequest(endPointUrl,petsAddListRequestDTO,String.valueOf(tempArray[0]));
        }
        if(method.equals("DELETE")){
            responseString=apiHelper.submitDeleteRequest(endPointUrl,String.valueOf(tempArray[0]));
        }
    }

    public void submitRequestForOrders (String endPoint,String method,HashMap <String,String> params,ApiHelper apiHelper, String section) throws IOException {
        objectMapper=new ObjectMapper();
        if(method.equals("GET")){
            responseString=apiHelper.submitGetRequest(endPointUrl,"");
        }
        if(method.equals("POST")){
            responseString=apiHelper.submitPostRequest(endPointUrl,ordersAddRequestDTO);
        }
        if(method.equals("DELETE")){
            responseString=apiHelper.submitDeleteRequest(endPointUrl,String.valueOf(tempArray[0]));
        }
    }

    public void submitRequestForUers (String endPoint,String method,HashMap <String,String> params,ApiHelper apiHelper, String section) throws IOException {
        objectMapper=new ObjectMapper();
        if(method.equals("GET")){
            responseString=apiHelper.submitGetRequest(endPointUrl,"");
        }
        if(method.equals("POST")){
            responseString=apiHelper.submitPostRequest(endPointUrl,usersAddRequestDTO);
        }
        if(method.equals("DELETE")){
            responseString=apiHelper.submitDeleteRequest(endPointUrl,String.valueOf(tempArray[0]));
        }
    }


    public void verifyResponseCode(String code, ApiHelper apiHelper) throws IOException {
        assertFields("equals","ResponseCode",code,String.valueOf(apiHelper.httpURLConnection.getResponseCode()));
    }
}
