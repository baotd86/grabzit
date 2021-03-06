/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.grabz.grabzit.parameters;

import it.grabz.grabzit.enums.Country;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 3.0
 * @author GrabzIt
 */
public abstract class BaseOptions {
    private String customId;
    private Country country;
    protected int delay;

    public BaseOptions()
    {
        this.delay = 0;
        this.customId = "";
        this.country = Country.DEFAULT;
    }
    
    /**
     * @return the custom identifier that you are passing through to the web service.
     */
    public String getCustomId() {
        return customId;
    }

    /**
     * @param customId a custom identifier that you can pass through to the web service. This will be returned with the callback URL you have specified.
     */
    public void setCustomId(String customId) {
        this.customId = customId;
    }

    /**
     * @return the country the capture should be created from.
     */
    public Country getCountry() {
        return country;
    }

    /**
     * @param country set the country the capture should be created in. Default is the fastest location.
     */
    public void setCountry(Country country) {
        this.country = country;
    }
    
    protected HashMap<String, String> createParameters(String applicationKey, String sig, String callBackURL, String dataName, String dataValue) throws UnsupportedEncodingException
    {
        HashMap<String, String> params = new HashMap<String, String>(); 
        params.put("key", ParameterUtility.encode(applicationKey));
        params.put("country", this.country.getValue());
        params.put("customid", ParameterUtility.encode(this.customId));
        params.put("callback", ParameterUtility.encode(ParameterUtility.nullCheck(callBackURL)));
        params.put("sig", ParameterUtility.encode(sig));
        params.put(dataName, ParameterUtility.encode(ParameterUtility.nullCheck(dataValue)));
        
        return params;
    }
    
    public HashMap<String, String> _getParameters(String applicationKey, String sig, String callBackURL, String dataName, String dataValue) throws UnsupportedEncodingException
    {
        return new HashMap<String, String>();
    }
    
    public String _getSignatureString(String applicationSecret, String callBackURL, String url)
    {
        return "";
    }
    
    public String _getQueryString(String applicationKey, String sig, String callBackURL, String dataName, String dataValue) throws UnsupportedEncodingException
    {
        HashMap<String, String> params = _getParameters(applicationKey, sig, callBackURL, dataName, dataValue);
        StringBuilder sb = new StringBuilder();
        
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (sb.length() > 0)
            {
                sb.append('&');
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
        }
        
        return sb.toString();
    }
    
    public int _startDelay()
    {
        return this.delay;
    }
}
