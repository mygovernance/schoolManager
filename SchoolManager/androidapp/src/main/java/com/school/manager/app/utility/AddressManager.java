package com.school.manager.app.utility;

import com.school.manager.app.Address;
import com.school.manager.app.Student;
import com.school.manager.app.UpdateUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by saddam on 15/3/18.
 */

public class AddressManager {
private final String TAG="AddressManager";
private static  AddressManager instance;
private Map<String,Address> addressMap;
private AddressManager(){}
public static AddressManager getInstance(){
    if(instance==null)
        instance=new AddressManager();
    return instance;
}
public void getAddress(int node_id_of_address, final UpdateUI updateUI){
    ResponseManager responseManager=new ResponseManager(URLManager.getStudentListURL() + node_id_of_address, new ProcessFinish() {
        @Override
        public void onResponseReceived(String response) {
            List<Address> addressList=createAddress(response);
            if(addressList!=null && addressList.size()>0)
            updateUI.updateUI(addressList);
            else updateUI.updateUI(null);
        }
    });

}
    public void getAddressList(final UpdateUI updateUI){
        ResponseManager responseManager=new ResponseManager(URLManager.getAddressURL(), new ProcessFinish() {
            @Override
            public void onResponseReceived(String response) {
                List<Address> addressList=createAddress(response);
                    updateUI.updateUI(addressList);
            }
        });

    }

private List<Address> createAddress(String response){
List<Address> addressList=new ArrayList<>();
try{
    JSONArray json  =  new JSONArray(response);
    int n=json.length();
    for(int i=0;i<n;i++){
     int node_id,state_id,country_id;
     String address_line_1,address_line_2,pinccode,city;
        JSONObject object=json.getJSONObject(i);
        node_id=Integer.parseInt(object.getString("node_id"));
        state_id=Integer.parseInt(object.getString("state_id"));
        country_id=Integer.parseInt(object.getString("country_id"));
        address_line_1=object.getString("address_line_1");
        address_line_2=object.getString("address_line_2");
        pinccode=object.getString("pincode");
        city=object.getString("city");
        Address address=new Address(node_id,state_id,country_id,address_line_1,address_line_2,pinccode,city);
        addressList.add(address);
        address.print();

    }

}catch (JSONException e){MyLog.d(TAG,"Error " + e.toString());}
return  addressList;
}
}
