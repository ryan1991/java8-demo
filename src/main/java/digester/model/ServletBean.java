package digester.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ServletBean {
    private String servletName;
    private String servletClass;
    private Map<String, String> initParams = new HashMap<>();
    public void addInitParam(String paramName, String paramValue){
        initParams.put(paramName, paramValue);
    }

}
