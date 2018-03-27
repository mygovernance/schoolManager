package com.example.aquibjawed.schoolmanager.utility;

import com.example.aquibjawed.schoolmanager.UpdateUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by saddam on 18/3/18.
 */

public class TermsManager {
    private static TermsManager instance;
    private Map<String,String> m_map;
    private TermsManager(){}
    public static TermsManager getInstance(){
        if(instance==null)
            instance=new TermsManager();
        return instance;
    }
public String getValue(int term_id){
        MySharedPreferences pref=MySharedPreferences.getInstance();
       if(this.m_map.get(term_id+"")==null)
       {   if(pref.get(pref.TERMS_RESPONSE)!=null){
              createTerms(pref.TERMS_RESPONSE);
       }
       else {
           loadTerms(new UpdateUI() {
               @Override
               public void updateUI(Object object) {

               }
           });
       }
       }
return m_map.get(term_id+"");
}
private void createTerms(String response){
    try {
        JSONArray json = new JSONArray(response);
        int n=json.length();
        for(int i=0;i<n;i++){
            String key,value;
            JSONObject object=json.getJSONObject(i);
            key=object.getString("id");
            value=object.getString("value");
            m_map.put(key,value);
        }
    }catch (JSONException e){}
//save response for terms in sharedpreference so that no need to load again
 MySharedPreferences pref=MySharedPreferences.getInstance();
    pref.set(pref.TERMS_RESPONSE,response);
}
private  void loadTerms(final UpdateUI updateUI){
    ResponseManager responseManager=new ResponseManager(URLManager.getTermsURL(), new ProcessFinish() {
        @Override
        public void onResponseReceived(String response) {
                  createTerms(response);
                  updateUI.updateUI(null);
        }
    });
}
}
