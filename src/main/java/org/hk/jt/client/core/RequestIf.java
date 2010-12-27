package org.hk.jt.client.core;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import org.hk.jt.client.Config;

import org.apache.http.NameValuePair;
import org.json.JSONException;

public interface RequestIf<T> {

	T getResponse(final String response) throws JSONException;

	Map<String, String> getPostParameters() throws UnsupportedEncodingException;

	List<NameValuePair> getFiles();

	String getUrl();

	SortedMap<String, String> getAuthParameter();
	
	Config getConfig();
	
	Method getMethod();
	
	public enum Method{
		GET("GET"),POST("POST"),DELETE("DELETE"),PUT("PUT");
		private String method;
		private Method(String method){
			this.method = method;
		}
		public String stringValue(){
			return this.method;
		}
	}

        public enum Params{
            SINCE_ID("since_id"), MAX_ID("max_id"), COUNT("count"), SCREEN_NAM(
				"screen_name"), INCLUDE_RTS("include_rts"), USER_A("user_a"), USER_B(
				"user_b"), FOLLOW("follow"),USER("user"),TEXT("text"),STATUS("status");
            private String params;
            private Params(String params){
                this.params = params;
            }
            @Override
            public String toString(){
                return this.params;
            }
        }
}
